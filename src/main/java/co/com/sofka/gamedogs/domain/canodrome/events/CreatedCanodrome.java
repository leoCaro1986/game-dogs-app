package co.com.sofka.gamedogs.domain.canodrome.events;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class CreatedCanodrome extends DomainEvent {

    private Integer goal;
    private String gameId;
    private String nameCanodromo;

    public CreatedCanodrome(Integer goal, String gameId, String nameCanodromo) {
        super("sofkau.canodrome.createdcanodrome");
        this.goal = goal;
        this.gameId = gameId;
        this.nameCanodromo = nameCanodromo;
    }

    public Integer getGoal() {
        return goal;
    }

    public String getGameId() {
        return gameId;
    }

    public String getNameCanodromo() {
        return nameCanodromo;
    }
}
