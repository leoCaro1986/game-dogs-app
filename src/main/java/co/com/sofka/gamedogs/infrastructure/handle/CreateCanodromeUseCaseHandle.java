package co.com.sofka.gamedogs.infrastructure.handle;

import co.com.sofka.gamedogs.domain.canodrome.command.AddCanodromeCommand;
import co.com.sofka.gamedogs.infrastructure.generic.UseCaseHandle;
import co.com.sofka.gamedogs.usecase.CreateCanodromeUseCase;
import io.quarkus.vertx.ConsumeEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateCanodromeUseCaseHandle extends UseCaseHandle {

    private final CreateCanodromeUseCase createCanodromeUseCase;

    public CreateCanodromeUseCaseHandle(CreateCanodromeUseCase createCanodromeUseCase) {
        this.createCanodromeUseCase = createCanodromeUseCase;
    }

    @ConsumeEvent(value="sofkau.canodrome.createcanodrome")
    void consume(AddCanodromeCommand command){
        System.out.println("handle command" + command.getGameId());
        var events = createCanodromeUseCase.apply(command);
        System.out.println(events.size());
        saveCanodrome(command.getId(), events);
    }

}
