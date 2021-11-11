package co.com.sofka.gamedogs.domain.dog.event;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

public class AddedPlayer extends DomainEvent {

    private String nickName;
    private String document;

    public AddedPlayer(String nickName, String document) {
        super("sofkau.gamedogs.addedplayer");
        this.nickName = nickName;
        this.document = document;
    }

    public String getNickName() {
        return nickName;
    }

    public String getDocument() {
        return document;
    }
}
