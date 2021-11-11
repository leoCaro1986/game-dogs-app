package co.com.sofka.gamedogs.domain.game.commands;

import co.com.sofka.gamedogs.domain.generic.Command;

public class AddPlayerCommand extends Command {

    private String gameId;
    private String document;
    private String nickName;

    public AddPlayerCommand(String gameId, String document, String nickName) {
        this.gameId = gameId;
        this.document = document;
        this.nickName = nickName;
    }

    public AddPlayerCommand() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
