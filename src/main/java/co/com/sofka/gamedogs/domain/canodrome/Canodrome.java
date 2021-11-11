package co.com.sofka.gamedogs.domain.canodrome;

import co.com.sofka.gamedogs.domain.generic.AggregateRoot;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;
import co.com.sofka.gamedogs.domain.generic.EventChange;
import co.com.sofka.gamedogs.domain.canodrome.events.CreatedCanodrome;

import java.util.List;

public class Canodrome extends AggregateRoot implements EventChange {

    private String dogId;
    private String gameId;
    private Integer positionCurrent;
    private Integer goal;
    private Boolean finaldisplacement;
    private String nameCanodrome;

    public Canodrome(String id, String gameId, Integer goal, String nameCanodrome) {
        super(id);
        appendChange(new CreatedCanodrome(goal, gameId, nameCanodrome)).apply();
    }

    private Canodrome(String entityId) {
        super(entityId);
        subscribe(this);

        listener((CreatedCanodrome event) -> {
            this.goal = event.getGoal();
            this.gameId = event.getGameId();
            this.finaldisplacement = false;
            this.positionCurrent = 0;

        });
    }

    public static Canodrome from(String entityId, List<DomainEvent> eventList) {
        var canodrome = new Canodrome(entityId);
        eventList.forEach(canodrome::applyEvent);
        return canodrome;
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

    public String getNameCanodrome() {
        return nameCanodrome;
    }
}
