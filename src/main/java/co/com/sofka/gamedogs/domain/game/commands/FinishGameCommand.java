package co.com.sofka.gamedogs.domain.game.commands;

import co.com.sofka.gamedogs.domain.generic.Command;


public class FinishGameCommand extends Command {

    private String gameId;

    public FinishGameCommand(String gameId) {
        this.gameId = gameId;
    }

    public FinishGameCommand() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

}
