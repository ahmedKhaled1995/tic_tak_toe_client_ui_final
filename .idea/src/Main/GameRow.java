package Main;

public class GameRow {

    private int gameNumber;
    private String playerOneName;
    private String playerTwoName;

    public GameRow(int gameNumber, String playerOneName, String playerTwoName) {
        this.gameNumber = gameNumber;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public void setPlayerOneName(String playerOneName) {
        this.playerOneName = playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public void setPlayerTwoName(String playerTwoName) {
        this.playerTwoName = playerTwoName;
    }
}
