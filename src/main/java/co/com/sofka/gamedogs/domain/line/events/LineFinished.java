package co.com.sofka.gamedogs.domain.line.events;

import co.com.sofka.domain.generic.Incremental;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class LineFinished extends DomainEvent implements Incremental {

    private String playerId;
    private String gameId;

    public LineFinished(String playerId, String gameId) {
        super("sofkau.line.linefinished");
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
