package co.com.sofka.gamedogs.domain.canodrome.command;

import co.com.sofka.gamedogs.domain.generic.Command;

public class AddCanodromeCommand extends Command {

    private String id;
    private String gameId;
    private String nameCanodrome;

    public AddCanodromeCommand() {
    }

    public AddCanodromeCommand(String id, String gameId, String nameCanodrome) {
        this.id = id;
        this.gameId = gameId;
        this.nameCanodrome = nameCanodrome;
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

    public String getNameCanodrome() {
        return nameCanodrome;
    }

    public void setNameCanodrome(String nameCanodrome) {
        this.nameCanodrome = nameCanodrome;
    }
}
