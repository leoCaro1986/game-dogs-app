package co.com.sofka.gamedogs.domain.game.events;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;

import java.time.LocalDateTime;


public class StartedGame extends DomainEvent {

    private LocalDateTime date;
    private Boolean state;

    public StartedGame() {
        super("sofkau.game.startedGame");
        this.date = LocalDateTime.now();
        this.state = true;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Boolean getState() {
        return state;
    }
}
