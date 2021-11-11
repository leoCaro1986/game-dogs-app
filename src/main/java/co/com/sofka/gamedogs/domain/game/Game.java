package co.com.sofka.gamedogs.domain.game;

import co.com.sofka.gamedogs.domain.game.events.*;
import co.com.sofka.gamedogs.domain.generic.AggregateRoot;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;
import co.com.sofka.gamedogs.domain.generic.EventChange;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game extends AggregateRoot implements EventChange {

    private Map<String, Player> players;
    private Integer distances;
    private Integer numberOfLines;
    private Integer currentFinalPosition;
    private Boolean playing;
    private Podium podium;

    public Game(String id, Integer distances, Integer numberOfLines) {
        super(id);
        appendChange(new CreatedGame(id, distances, numberOfLines)).apply();
        System.out.println(this.getDistances());
    }

    private Game(String id) {
        super(id);
        subscribe(this);

        listener((CreatedGame event) -> {
            this.distances = event.getDistance();
            this.numberOfLines = event.getNumberLines();
            this.playing = false;
            this.players = new HashMap<>();
            this.podium = new Podium();
        });

        listener((AddedPlayer event) -> {
            players.put(event.getDocument(), new Player(event.getNickName(), event.getDocument()));
        });

        listener((AssignedFirstPlace event) -> {
            if (this.playing) {
                Player winner = this.players.get(event.getPlayerId());
                this.podium = this.podium.assignFirstPlace(winner);
            } else {
                throw new IllegalArgumentException("No puede asignar podio porque el juego esta detenido");
            }
        });

        /*listener((SegundoLugarAsignado event) -> {
            if (this.jugando) {
                Jugador jugadorGanador = this.jugadores.get(event.getJugadorId());
                this.podio = this.podio.asignarSegundoLugar(jugadorGanador);
            } else {
                throw new IllegalArgumentException("No puede asignar al podio no esta en marcha el juego");
            }
        });*/

        /*listener((TercerLugarAsignado event) -> {
            if (this.jugando) {
                Jugador jugadorGanador = this.jugadores.get(event.getJugadorId());
                this.podio = this.podio.asignarTercerLugar(jugadorGanador);
            } else {
                throw new IllegalArgumentException("No puede asignar al podio no esta en marcha el juego");
            }
        });*/

        listener((StartedGame event) -> {
            this.playing = true;
        });

        listener((FinishedGame event) -> {
            this.playing = false;
        });
    }

    public static Game from(String gameId, List<DomainEvent> events){
        var game = new Game(gameId);
        events.forEach(game::applyEvent);
        System.out.println("event game " + game.distances);
        return game;
    }

    public void addPlayer(String document, String nickName){
        System.out.println("anadir jugador metodo");
        appendChange(new AddedPlayer(document, nickName)).apply();
        System.out.println(this.getDistances() + " " + this.playing);
    }

    public void setCurrentFinalPosition(Integer currentFinalPosition) {
        this.currentFinalPosition = currentFinalPosition;
    }

    public void startGame() {
        System.out.println("iniciar juego metodo");
        appendChange(new StartedGame()).apply();
    }

    public void finishGame(){
        System.out.println("finalizar juego metodo");
        appendChange(new FinishedGame()).apply();
    }

    public void assignpodium(String playerId, Integer position){
        if (position == 1)
            appendChange(new AssignedFirstPlace(playerId)).apply();
        /*if (position == 2)
            appendChange(new SegundoLugarAsignado(playerId)).apply();
        if (position == 3)
            appendChange(new TercerLugarAsignado(playerId)).apply();*/
    }

    public Integer getCurrentFinalPosition() {
        return currentFinalPosition;
    }

    public Integer getDistances() {
        return distances;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }
}
