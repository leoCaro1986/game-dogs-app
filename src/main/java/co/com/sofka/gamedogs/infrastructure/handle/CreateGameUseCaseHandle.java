package co.com.sofka.gamedogs.infrastructure.handle;

import co.com.sofka.gamedogs.usecase.CreateGameUseCase;
import co.com.sofka.gamedogs.domain.game.commands.CreateGameCommand;
import co.com.sofka.gamedogs.infrastructure.generic.UseCaseHandle;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateGameUseCaseHandle extends UseCaseHandle {

    private final CreateGameUseCase createGameUseCase;

    public CreateGameUseCaseHandle(CreateGameUseCase createGameUseCase) {
        this.createGameUseCase = createGameUseCase;
    }

    @ConsumeEvent(value="sofkau.game.creategame")
    void consume(CreateGameCommand command){
        var events = createGameUseCase.apply(command);
        saveGame(command.getGameId(), events);
    }
}
