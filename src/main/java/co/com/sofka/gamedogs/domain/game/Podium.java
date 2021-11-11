package co.com.sofka.gamedogs.domain.game;

import java.util.Objects;

public class Podium {

    private Player firstPlace;
    private Player secondPlace;
    private Player thirdPlace;

    private Podium(Player firstPlace, Player secondPlace, Player thirdPlace){
        this.firstPlace = firstPlace;
        this.secondPlace = secondPlace;
        this.thirdPlace = thirdPlace;
    }

    public Podium(){
        firstPlace = null;
        secondPlace = null;
        thirdPlace = null;
    }

    public Podium assignFirstPlace(Player player){
        return new Podium(player, secondPlace, thirdPlace);
    }

    public Podium assignSecondPlace(Player player){
        return new Podium(firstPlace, player, thirdPlace);
    }

    public Podium assignThirdPlace(Player player){
        return new Podium(firstPlace, secondPlace, player);
    }

    public Player getFirstPlace() {
        return firstPlace;
    }

    public Player getSecondPlace() {
        return secondPlace;
    }

    public Player getThirdPlace() {
        return thirdPlace;
    }

    public Boolean podiumComplete(){
        return Objects.nonNull(firstPlace) && Objects.nonNull(secondPlace) && Objects.nonNull(thirdPlace);
    }

    public Boolean firstPlaceFree(){
        return Objects.isNull(firstPlace);
    }

    public Boolean secondPlaceFree(){
        return Objects.isNull(secondPlace);
    }

    public Boolean thirdPlaceFree(){
        return Objects.isNull(thirdPlace);
    }
}
