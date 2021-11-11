package co.com.sofka.gamedogs.domain.game.events;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

import java.time.LocalDateTime;


public class FinishedGame extends DomainEvent {

    private LocalDateTime date;
    private Boolean state;

    public FinishedGame() {
        super("sofkau.game.finishedgame");
        this.date = LocalDateTime.now();
        this.state = false;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Boolean getState() {
        return state;
    }
}
