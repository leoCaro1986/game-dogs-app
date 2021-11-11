package co.com.sofka.gamedogs.domain.canodrome.events;

import co.com.sofka.domain.generic.Incremental;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class CanodromeFinished extends DomainEvent implements Incremental {

    private String playerId;
    private String gameId;

    public CanodromeFinished(String playerId, String gameId) {
        super("sofkau.line.canodromefinished");
        this.playerId = playerId;
        this.gameId = gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getGameId() {
        return gameId;
    }
}
