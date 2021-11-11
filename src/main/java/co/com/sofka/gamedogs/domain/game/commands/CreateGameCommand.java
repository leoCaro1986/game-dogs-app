package co.com.sofka.gamedogs.domain.game.commands;

import co.com.sofka.gamedogs.domain.generic.Command;

public class CreateGameCommand extends Command {

    private String gameId;
    private Integer distance;
    private Integer numberLines;

    public CreateGameCommand(String gameId, Integer distance, Integer numberLines) {
        this.gameId = gameId;
        this.distance = distance;
        this.numberLines = numberLines;
    }

    public CreateGameCommand() {
    }

    public Integer getNumberLines() {
        return numberLines;
    }

    public void setNumberLines(Integer numberLines) {
        this.numberLines = numberLines;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

}
