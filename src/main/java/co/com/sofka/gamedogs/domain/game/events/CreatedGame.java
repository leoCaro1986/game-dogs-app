package co.com.sofka.gamedogs.domain.game.events;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class CreatedGame extends DomainEvent {

    private String gameId;
    private Integer distance;
    private Integer numberLines;
    private Integer currentFinalPosition;
    private Boolean state;

    public CreatedGame(String id, Integer distance, Integer numberLines) {
        super("sofkau.game.createdGame");
        this.gameId = id;
        this.distance = distance;
        this.numberLines = numberLines;
        this.currentFinalPosition = 0;
        this.state = false;
    }

    public Integer getCurrentFinalPosition() {
        return currentFinalPosition;
    }

    public String getGameId() {
        return gameId;
    }

    public Boolean getState() {
        return state;
    }

    public Integer getDistance() {
        return distance;
    }

    public Integer getNumberLines() {
        return numberLines;
    }
}
