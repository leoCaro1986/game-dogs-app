package co.com.sofka.gamedogs.domain.game.events;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class AssignedFirstPlace extends DomainEvent {

    private String playerId;
    public AssignedFirstPlace(String playerId) {
        super("sofkau.game.assignedfirstplace");
        this.playerId = playerId;
    }

    public String getPlayerId() {
        return playerId;
    }
}
