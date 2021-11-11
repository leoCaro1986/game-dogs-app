package co.com.sofka.gamedogs.domain.game;

public class Player {

    private final String nickName;
    private final String document;

    public Player(String nickName, String document) {
        this.nickName = nickName;
        this.document = document;
    }

    public String NickName() {
        return nickName;
    }

}
