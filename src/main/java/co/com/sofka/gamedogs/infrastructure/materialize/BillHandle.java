package co.com.sofka.gamedogs.infrastructure.materialize;

import co.com.sofka.gamedogs.domain.game.events.CreatedGame;
import co.com.sofka.gamedogs.domain.game.events.FinishedGame;
import co.com.sofka.gamedogs.domain.game.events.StartedGame;
import co.com.sofka.gamedogs.domain.game.events.AddedPlayer;
import co.com.sofka.gamedogs.domain.canodrome.events.CreatedCanodrome;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.model.Filters;
import io.quarkus.vertx.ConsumeEvent;
import org.bson.Document;

import javax.enterprise.context.ApplicationScoped;
import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class BillHandle {
    private final MongoClient mongoClient;

    public BillHandle(MongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }


    @ConsumeEvent(value = "sofkau.game.createdGame")
    void consumeJuegoCreado(CreatedGame event) {
        System.out.println("materialize bill");
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("distance", event.getDistance());
        document.put("numberoflines", event.getNumberLines());
        document.put("playing", event.getState());
        document.put("currentposition", event.getCurrentFinalPosition());
        mongoClient.getDatabase("queries").getCollection("game")
                .insertOne(new Document(document));
    }

    @ConsumeEvent(value = "sofkau.game.addedplayer")
    void consumeJugadorAnadido(AddedPlayer event) {
        System.out.println("materialize product");
        BasicDBObject document = new BasicDBObject();
        var key = "players."+event.getDocument();
        document.put(key+".document", event.getDocument());
        document.put(key+".nickname", event.getNickName());

        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);
        mongoClient.getDatabase("queries").getCollection("game")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }

    @ConsumeEvent(value = "sofkau.game.addedplayer")
    void consumeJuegoIniciado(StartedGame event) {
        System.out.println("materialize product");
        BasicDBObject document = new BasicDBObject();
        document.put("playing", event.getState());
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);
        mongoClient.getDatabase("queries").getCollection("game")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }


    @ConsumeEvent(value = "sofkau.game.finishedgame")
    void consumeJuegoFinalizado(FinishedGame event) {
        System.out.println("materialize product");
        BasicDBObject document = new BasicDBObject();
        document.put("playing", event.getState());
        BasicDBObject updateObject = new BasicDBObject();
        updateObject.put("$set", document);
        mongoClient.getDatabase("queries").getCollection("game")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }

    @ConsumeEvent(value = "sofkau.canodrome.createdcanodrome")
    void consumeCanodromeCreated(CreatedCanodrome event) {
        System.out.println("materialize canodrome");
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("goal", event.getGoal());
        document.put("gameId", event.getGameId());
        mongoClient.getDatabase("queries").getCollection("canodrome")
                .insertOne(new Document(document));
    }

}