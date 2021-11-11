package co.com.sofka.gamedogs.usecase;

import co.com.sofka.gamedogs.domain.game.Game;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;
import co.com.sofka.gamedogs.domain.game.commands.CreateGameCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateGameUseCase implements Function<CreateGameCommand, List<DomainEvent>> {
    @Override
    public List<DomainEvent> apply(CreateGameCommand command) {
        Game game = new Game(command.getGameId(), command.getDistance(),command.getNumberLines());
        return game.getUncommittedChanges();
    }
}
