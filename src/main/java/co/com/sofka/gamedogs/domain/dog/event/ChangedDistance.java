package co.com.sofka.gamedogs.domain.dog.event;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class ChangedDistance extends DomainEvent {

    private Integer advance;
    private String canodromeId;
    private String gameId;

    public ChangedDistance(Integer advance, String canodromeId, String gameId) {
        super("sofkau.dog.changeddistance");
        this.advance = advance;
        this.canodromeId = canodromeId;
        this.gameId = gameId;
    }

    public Integer getAdvance() {
        return advance;
    }

    public String getCanodromeId() {
        return canodromeId;
    }

    public String getGameId() {
        return gameId;
    }
}
