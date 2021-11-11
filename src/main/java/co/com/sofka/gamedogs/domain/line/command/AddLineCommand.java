package co.com.sofka.gamedogs.domain.line.command;

import co.com.sofka.gamedogs.domain.generic.Command;

public class AddLineCommand extends Command {

    private String id;
    private String gameId;

    public AddLineCommand() {
    }

    public AddLineCommand(String id, String gameId) {
        this.id = id;
        this.gameId = gameId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

}
