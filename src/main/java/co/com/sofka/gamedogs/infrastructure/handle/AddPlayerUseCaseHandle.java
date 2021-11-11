package co.com.sofka.gamedogs.infrastructure.handle;

import co.com.sofka.gamedogs.domain.game.commands.AddPlayerCommand;
import co.com.sofka.gamedogs.infrastructure.generic.UseCaseHandle;
import co.com.sofka.gamedogs.usecase.AddPlayerUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddPlayerUseCaseHandle extends UseCaseHandle {

    private final AddPlayerUseCase addPlayerUseCase;

    public AddPlayerUseCaseHandle(AddPlayerUseCase addPlayerUseCase) {
        this.addPlayerUseCase = addPlayerUseCase;
    }

    @ConsumeEvent(value="sofkau.game.addplayer")
    void consume(AddPlayerCommand command){
        var events = addPlayerUseCase.apply(command);
        saveGame(command.getGameId(), events);
    }
}
