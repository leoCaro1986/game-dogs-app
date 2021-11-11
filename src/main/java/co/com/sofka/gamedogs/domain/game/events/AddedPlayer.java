package co.com.sofka.gamedogs.domain.game.events;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class AddedPlayer extends DomainEvent {

    private String document;
    private String nickName;

    public AddedPlayer(String document, String nickName) {
        super("sofkau.game.addedplayer");
        this.document = document;
        this.nickName = nickName;
    }


    public String getDocument() {
        return document;
    }

    public String getNickName() {
        return nickName;
    }
}
