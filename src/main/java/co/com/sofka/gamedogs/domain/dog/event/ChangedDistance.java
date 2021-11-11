package co.com.sofka.gamedogs.domain.dog.event;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class ChangedDistance extends DomainEvent {

    private Integer advance;
    private String lineId;
    private String gameId;

    public ChangedDistance(Integer advance, String lineId, String gameId) {
        super("sofkau.dog.changeddistance");
        this.advance = advance;
        this.lineId = lineId;
        this.gameId = gameId;
    }

    public Integer getAdvance() {
        return advance;
    }

    public String getLineId() {
        return lineId;
    }

    public String getGameId() {
        return gameId;
    }
}
