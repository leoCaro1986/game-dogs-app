package co.com.sofka.gamedogs.domain.line;

import co.com.sofka.gamedogs.domain.generic.AggregateRoot;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;
import co.com.sofka.gamedogs.domain.generic.EventChange;
import co.com.sofka.gamedogs.domain.line.events.CreatedLine;

import java.util.List;

public class Line extends AggregateRoot implements EventChange {

    private String dogId;
    private String gameId;
    private Integer positionCurrent;
    private Integer goal;
    private Boolean finaldisplacement;

    public Line(String id, String gameId, Integer goal) {
        super(id);
        appendChange(new CreatedLine(goal, gameId)).apply();
    }

    private Line(String entityId) {
        super(entityId);
        subscribe(this);

        listener((CreatedLine event) -> {
            this.goal = event.getGoal();
            this.gameId = event.getGameId();
            this.finaldisplacement = false;
            this.positionCurrent = 0;
        });
    }

    public static Line from(String entityId, List<DomainEvent> eventList) {
        var line = new Line(entityId);
        eventList.forEach(line::applyEvent);
        return line;
    }



    public String getDogId() {
        return dogId;
    }

    public String getGameId() {
        return gameId;
    }

    public Integer getPositionCurrent() {
        return positionCurrent;
    }

    public Integer getGoal() {
        return goal;
    }

    public Boolean getFinaldisplacement() {
        return finaldisplacement;
    }
}
