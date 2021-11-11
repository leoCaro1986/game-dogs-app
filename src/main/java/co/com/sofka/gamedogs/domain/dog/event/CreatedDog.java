package co.com.sofka.gamedogs.domain.dog.event;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class CreatedDog extends DomainEvent {

    private String dogId;
    private String gameId;

    public CreatedDog(String dogId, String gameId) {
        super("sofkau.dog.createddog");
        this.dogId = dogId;
        this.gameId = gameId;
    }

    public String getDogId() {
        return dogId;
    }

    public String getGameId() {
        return gameId;
    }
}
