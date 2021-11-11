package co.com.sofka.gamedogs.domain.dog;

import co.com.sofka.gamedogs.domain.game.Player;
import co.com.sofka.gamedogs.domain.dog.event.CreatedDog;
import co.com.sofka.gamedogs.domain.dog.event.AddedPlayer;
import co.com.sofka.gamedogs.domain.dog.event.ChangedDistance;
import co.com.sofka.gamedogs.domain.generic.AggregateRoot;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;
import co.com.sofka.gamedogs.domain.generic.EventChange;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Dog extends AggregateRoot implements EventChange {

    private Player player;
    private Integer distance;
    private String gameId;

    public Dog(String id, String gameId) {
        super(id);
        appendChange(new CreatedDog(id, gameId)).apply();
    }

    private Dog(String dogId){
        super(dogId);
        subscribe(this);

        listener((CreatedDog event) -> {
            this.distance = 0;
            this.gameId = event.getGameId();
        });

        listener((AddedPlayer event) -> {
            this.player = new Player(event.getNickName(),event.getDocument());
        });

        listener((ChangedDistance event) -> {
            var advance = Objects.requireNonNull(event.getAdvance(), "La distancia del cinodromo no puede ser nulla");
            if (advance <= 0) {
                throw new IllegalArgumentException("No puede ser negativo o cero el valor de la distancia");
            }
            this.distance = this.getDistance() + advance;
        });
    }

    public static Dog from(String dogId, List<DomainEvent> events){
        var dog = new Dog(dogId);
        events.forEach(dog::applyEvent);
        return dog;
    }

    public void addPlayer(String nickName, String document){
        appendChange(new AddedPlayer(nickName, document)).apply();
    }

    public void advanceInLine(String lineId){
        var dice = this.throwDice() * 100;
        appendChange(new ChangedDistance(dice, lineId, gameId)).apply();
    }

    public Integer throwDice(){
        var rn = new Random();
        return 1 + rn.nextInt(6);
    }

    public Player getPlayer() {
        return player;
    }

    public Integer getDistance() {
        return distance;
    }

    public String getGameId() {
        return gameId;
    }
}
