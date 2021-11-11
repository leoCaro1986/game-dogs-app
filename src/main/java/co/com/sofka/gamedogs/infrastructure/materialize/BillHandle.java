package co.com.sofka.gamedogs.infrastructure.materialize;

import co.com.sofka.gamedogs.domain.game.events.CreatedGame;
import co.com.sofka.gamedogs.domain.game.events.FinishedGame;
import co.com.sofka.gamedogs.domain.game.events.StartedGame;
import co.com.sofka.gamedogs.domain.game.events.AddedPlayer;
import co.com.sofka.gamedogs.domain.line.events.CreatedLine;
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


    @ConsumeEvent(value = "sofkau.game.createdgame")
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
        mongoClient.getDatabase("queries").getCollection("juego")
                .updateOne( Filters.eq("_id", event.getAggregateId()), updateObject);
    }

    @ConsumeEvent(value = "sofkau.game.startedgame")
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

    @ConsumeEvent(value = "sofkau.line.createline")
    void consumeCarrilCreado(CreatedLine event) {
        System.out.println("materialize carril");
        Map<String, Object> document = new HashMap<>();
        document.put("_id", event.getAggregateId());
        document.put("goal", event.getGoal());
        document.put("gameId", event.getGameId());
        mongoClient.getDatabase("queries").getCollection("line")
                .insertOne(new Document(document));
    }

}