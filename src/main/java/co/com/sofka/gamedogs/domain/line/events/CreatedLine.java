package co.com.sofka.gamedogs.domain.line.events;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class CreatedLine extends DomainEvent {

    private Integer goal;
    private String gameId;

    public CreatedLine(Integer goal, String gameId) {
        super("sofkau.line.createdline");
        this.goal = goal;
        this.gameId = gameId;
    }

    public Integer getGoal() {
        return goal;
    }

    public String getGameId() {
        return gameId;
    }
}
