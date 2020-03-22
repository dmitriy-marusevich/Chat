package game;

public class GamePlayer {
    private char playerSing; //символ игрока
    private boolean realPlayer = true; // Признок реального игрока

    public GamePlayer(boolean isRealPlayer, char playerSing){
        this.realPlayer = isRealPlayer;
        this.playerSing = playerSing;
    }

    // гетеры для доступа
    public boolean isRealPlayer(){
        return realPlayer;
    }

    public char getPlayerSing(){
        return playerSing;
    }
}
