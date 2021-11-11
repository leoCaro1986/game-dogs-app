package co.com.sofka.gamedogs.infrastructure.handle;

import co.com.sofka.gamedogs.domain.line.events.LineFinished;
import co.com.sofka.gamedogs.infrastructure.generic.UseCaseHandle;
import co.com.sofka.gamedogs.usecase.AddPodiumUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AddPodiumUseCaseHandle extends UseCaseHandle {

    private final AddPodiumUseCase addPodiumUseCase;

    public AddPodiumUseCaseHandle(AddPodiumUseCase addPodiumUseCase) {
        this.addPodiumUseCase = addPodiumUseCase;
    }

    @ConsumeEvent(value="sofkau.line.goalachieved")
    void consume(LineFinished event){
        var events = addPodiumUseCase.apply(event);
        saveGame(event.getGameId(), events);
    }
}
