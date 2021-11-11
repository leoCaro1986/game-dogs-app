package co.com.sofka.gamedogs.infrastructure.generic;

import co.com.sofka.gamedogs.domain.generic.DomainEvent;
import co.com.sofka.gamedogs.domain.generic.EventStoreRepository;
import co.com.sofka.gamedogs.domain.generic.StoredEvent;
import co.com.sofka.gamedogs.infrastructure.MessageService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public abstract class UseCaseHandle {

    @Inject
    private EventStoreRepository repository;

    @Inject
    private MessageService messageService;

    public void saveGame(String juegoID, List<DomainEvent> events) {
        System.out.println("saveGame");
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("game", juegoID, storedEvent));
        events.forEach(messageService::send);
    }

    public void saveCarril(String id, List<DomainEvent> events) {
        System.out.println("saveLine");
        events.stream().map(event -> {
            String eventBody = EventSerializer.instance().serialize(event);
            return new StoredEvent(event.getClass().getTypeName(), new Date(), eventBody);
        }).forEach(storedEvent -> repository.saveEvent("line", id, storedEvent));
        events.forEach(messageService::send);
    }
}
