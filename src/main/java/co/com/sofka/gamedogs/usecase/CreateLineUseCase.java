package co.com.sofka.gamedogs.usecase;

import co.com.sofka.gamedogs.domain.line.Line;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;
import co.com.sofka.gamedogs.domain.generic.EventStoreRepository;
import co.com.sofka.gamedogs.domain.game.Game;
import co.com.sofka.gamedogs.domain.line.command.AddLineCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateLineUseCase implements Function<AddLineCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public CreateLineUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AddLineCommand addLineCommand) {
        var events = repository.getEventsBy("game", addLineCommand.getGameId());
        Game game = Game.from(addLineCommand.getGameId(), events);
        System.out.println(game.getPlayers());

        Line line = new Line(addLineCommand.getId(), addLineCommand.getGameId(), 5*1000);
        return line.getUncommittedChanges();
    }
}
