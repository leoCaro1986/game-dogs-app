package co.com.sofka.gamedogs.infrastructure.handle;

import co.com.sofka.gamedogs.domain.line.command.AddLineCommand;
import co.com.sofka.gamedogs.infrastructure.generic.UseCaseHandle;
import co.com.sofka.gamedogs.usecase.CreateLineUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateLineUseCaseHandle extends UseCaseHandle {

    private final CreateLineUseCase createLineUseCase;

    public CreateLineUseCaseHandle(CreateLineUseCase createLineUseCase) {
        this.createLineUseCase = createLineUseCase;
    }

    @ConsumeEvent(value="sofkau.line.createline")
    void consume(AddLineCommand command){
        System.out.println("handle command" + command.getGameId());
        var events = createLineUseCase.apply(command);
        System.out.println(events.size());
        saveCarril(command.getId(), events);
    }

}
