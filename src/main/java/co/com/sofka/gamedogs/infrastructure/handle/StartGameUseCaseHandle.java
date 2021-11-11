package co.com.sofka.gamedogs.infrastructure.handle;

import co.com.sofka.gamedogs.domain.game.commands.StartGameCommand;
import co.com.sofka.gamedogs.infrastructure.generic.UseCaseHandle;
import co.com.sofka.gamedogs.usecase.StartGameUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StartGameUseCaseHandle extends UseCaseHandle {

    private final StartGameUseCase startGameUseCase;

    public StartGameUseCaseHandle(StartGameUseCase startGameUseCase) {
        this.startGameUseCase = startGameUseCase;
    }

    @ConsumeEvent(value = "sofkau.game.initGame")
    void consume(StartGameCommand command){
        System.out.println(command.getGameId());
        var events = startGameUseCase.apply(command);
        saveGame(command.getGameId(), events);
    }
}
