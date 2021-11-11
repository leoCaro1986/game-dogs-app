package co.com.sofka.gamedogs.usecase;

import co.com.sofka.gamedogs.domain.canodrome.Canodrome;
import co.com.sofka.gamedogs.domain.generic.DomainEvent;
import co.com.sofka.gamedogs.domain.generic.EventStoreRepository;
import co.com.sofka.gamedogs.domain.game.Game;
import co.com.sofka.gamedogs.domain.canodrome.command.AddCanodromeCommand;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.function.Function;

@Dependent
public class CreateCanodromeUseCase implements Function<AddCanodromeCommand, List<DomainEvent>> {

    private final EventStoreRepository repository;

    public CreateCanodromeUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DomainEvent> apply(AddCanodromeCommand addCanodromeCommand) {
        var events = repository.getEventsBy("game", addCanodromeCommand.getGameId());
        Game game = Game.from(addCanodromeCommand.getGameId(), events);
        System.out.println(game.getPlayers());

        Canodrome canodrome = new Canodrome(addCanodromeCommand.getId(), addCanodromeCommand.getGameId(), 5*1000, addCanodromeCommand.getNameCanodrome());
        return canodrome.getUncommittedChanges();
    }
}
