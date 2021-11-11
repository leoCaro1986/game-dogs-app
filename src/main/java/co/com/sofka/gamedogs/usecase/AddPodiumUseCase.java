package co.com.sofka.gamedogs.usecase;

import co.com.sofka.gamedogs.domain.game.Game;
import co.com.sofka.gamedogs.domain.line.events.LineFinished;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;
import co.com.sofka.gamedogs.domain.generic.EventStoreRepository;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class AddPodiumUseCase implements Function<LineFinished, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public AddPodiumUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(LineFinished event) {
        Game game = Game.from(event.getGameId(), repository.getEventsBy("game", event.getGameId()));
        game.setCurrentFinalPosition(game.getCurrentFinalPosition() + 1);
        game.assignpodium(event.getPlayerId(), game.getCurrentFinalPosition());
        return game.getUncommittedChanges();
    }
}
