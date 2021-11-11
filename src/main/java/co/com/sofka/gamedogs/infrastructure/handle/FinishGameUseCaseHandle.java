package co.com.sofka.gamedogs.infrastructure.handle;

import co.com.sofka.gamedogs.domain.game.commands.FinishGameCommand;
import co.com.sofka.gamedogs.infrastructure.generic.UseCaseHandle;
import co.com.sofka.gamedogs.usecase.FinishGameUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FinishGameUseCaseHandle extends UseCaseHandle {

    private final FinishGameUseCase finishGameUseCase;

    public FinishGameUseCaseHandle(FinishGameUseCase finishGameUseCase) {
        this.finishGameUseCase = finishGameUseCase;
    }

    @ConsumeEvent(value = "sofkau.game.finishgame")
    void consume(FinishGameCommand command){
        System.out.println(command.getGameId());
        var events = finishGameUseCase.apply(command);
        saveGame(command.getGameId(), events);
    }
}
