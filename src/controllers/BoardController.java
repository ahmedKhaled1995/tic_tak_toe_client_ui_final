/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Main.EntryPoint;
import Main.Resource;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import popups.ConfirmBox;
import popups.LoserPopUp;
import popups.TiePopUp;
import popups.WinnerPopup;
import util.GameConfig;
import util.SwitchSceneTo;

/**
 *
 * @author Hager
 */
public class BoardController implements Initializable {

    @FXML
    private Pane xplayerpane;

    @FXML
    private ImageView xplayerimage;

    @FXML
    private Pane xpane;

    @FXML
    private ImageView xiamge;

    @FXML
    private Button zone1;

    @FXML
    private Button zone2;

    @FXML
    private Button zone6;

    @FXML
    private Button zone5;

    @FXML
    private Button zone4;

    @FXML
    private Button zone7;

    @FXML
    private Button zone8;

    @FXML
    private Button zone9;

    @FXML
    private Pane opane;

    @FXML
    private ImageView oimage;

    @FXML
    private Button zone3;

    @FXML
    private Pane oplayerpane;

    @FXML
    private ImageView oplayerimage;

    @FXML
    private Label yourscore;

    @FXML
    private Label opponentscore;

    @FXML
    private Label userName;

    @FXML
    private Label opponentName;

    @FXML
    private Button chat;

    @FXML
    private Button send;

    @FXML
    private TextField textmassage;

    @FXML
    private Button newgame;

    @FXML
    private Button mainmeu;

    @FXML
    private Button exit;
    private Button ticTacToeButtons [][];
    private int wins,losses,ties,numOfGames,turn; //first turn x ,2nd turn O o gets 4 turns
    private boolean gameOver = false;
    private boolean aiThinking = false;

    private boolean gameEnd = false; //gameEnd

    private boolean full = false;
    public static boolean playerTurn=true;
    public enum status {X,O,EMPTY};                                /* group of constants (unchangeable variables, like final variables).
                                                                         status that some square can have --> X player O agent*/
    private status boardStat[][]=new status[3][3];

    private Button[] buttons;


    private final int viewIndex = 4;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GameConfig.setCurrentView(viewIndex);
        if(GameConfig.getGameMode() == 2){  // Multiplayer
            /*boolean answer = ConfirmBox.display("Save Game?");
            if(answer){
                EntryPoint.getGameClient().sendAcceptSaveGame();
            }*/
            newgame.setText("Save");
            mainmeu.setDisable(true);
            mainmeu.setVisible(false);
            buttons = new Button[]{zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9};
            EntryPoint.getViewUpdater().setBoardButtons(buttons);
            this.userName.setText(EntryPoint.getGameClient().getUserName());
            this.opponentName.setText(EntryPoint.getGameClient().getOpponentName());
            this.yourscore.setText(String.valueOf(EntryPoint.getGameClient().getScore()));
            this.opponentscore.setText(String.valueOf(EntryPoint.getGameClient().getOpponentScore()));
            if(EntryPoint.getGameClient().getSymbol() == 1){  // x
                this.xplayerimage.setImage(Resource.getXPic().getImage());
                this.oplayerimage.setImage(Resource.getOPic().getImage());
            }else{ // o
                this.xplayerimage.setImage(Resource.getOPic().getImage());
                this.oplayerimage.setImage(Resource.getXPic().getImage());
            }

        }else if(GameConfig.getGameMode() == 1){   // Single player
            ticTacToeButtons = new Button[3][3];
            ticTacToeButtons[0][0] = zone1;
            ticTacToeButtons[0][1] = zone2;
            ticTacToeButtons[0][2] = zone3;
            ticTacToeButtons[1][0] = zone4;
            ticTacToeButtons[1][1] = zone5;
            ticTacToeButtons[1][2] = zone6;
            ticTacToeButtons[2][0] = zone7;
            ticTacToeButtons[2][1] = zone8;
            ticTacToeButtons[2][2] = zone9;
            setData();
            resetGame();
        }else{     // Re-play mode (0)
            this.buttons = new Button[]{zone1, zone2, zone3, zone4, zone5, zone6, zone7, zone8, zone9};
            mainmeu.setDisable(true);
            newgame.setDisable(true);
            newgame.setVisible(false);
            String playerOneName = EntryPoint.getViewUpdater().getReplayPlayerOneName();
            String playerTwoName = EntryPoint.getViewUpdater().getReplayPlayerTwoName();
            this.userName.setText(playerOneName);
            this.opponentName.setText(playerTwoName);
            HashMap<Integer, String> board = EntryPoint.getViewUpdater().getButtonsMap();
            Timeline timeline = new Timeline();
            int i = 0;
            for (Map.Entry<Integer,String> entry : board.entrySet()) {
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.millis((i+1)*1000),
                                e -> this.buttons[entry.getKey()].setText(entry.getValue())
                        )
                );
                i++;
            }
            timeline.getKeyFrames().add(
                    new KeyFrame(Duration.millis((i+1)*1000), (e) -> {
                        System.out.println("Display popup here");
                        mainmeu.setDisable(false);
                    })
            );
            Platform.runLater(()->{
                timeline.play();
            });

        }

    }
    private void setData(){
        //TODO READ FILE
        //IF fILE CAN'T be read set data
        wins=0;
        losses=0;
        ties=0;
        numOfGames=0;
    }
    private void resetGame(){
        this.userName.setText(EntryPoint.getGameClient().getUserName());
        this.opponentName.setText("CPU");
        this.yourscore.setText(String.valueOf(EntryPoint.getGameClient().getScore()));
        this.opponentscore.setText("");
        for(int c = 0; c < 3; c++){
            for(int r =0; r < 3; r++){
                //already instantiated
                //go thro button c=0 r=1 ,r=2 etc and make them all blank ""
                ticTacToeButtons[c][r].setText("");
                boardStat[c][r]=status.EMPTY;

            }
        }
        turn = 0;
        gameOver = false;
        // headerLabel.setText("X's Turn. Click a button to take a spot!");
    }





    private void doButtonAction(ActionEvent event){

        System.out.println("Foo");
        if(!gameOver && !aiThinking){
            Button clickedBtn = (Button)event.getSource();
            //already x or o(spot taken) we exit method
            if(clickedBtn.getText().length() > 0){
                if (turn % 2 !=0){
                    doTurnForAI();
                }
                return;
            }
        /*turns to figure whose turn it is
        if turn =even --> x turn
        if turn = odd --> o turn
        */
            //spot not taken,do logic
            String place;

            if(turn %2 ==0){
                //currently X's turn
                place = "X";
            }else{
                //curently O's turn
                place = "O";
            }
            turn++;

            clickedBtn.setText(place);
            //at6th turn
            if(turn >=5){
                //Todo : check for winner
                if(checkIfWon(place)) {
                    //Todo: Stop Game
                    // headerLabel.setText(String.format("%s Won!", place));
                    Platform.runLater(()->{
                        if(place.equalsIgnoreCase("x")){
                            WinnerPopup winnerPopup = new WinnerPopup();
                            winnerPopup.display();
                        }else{
                            LoserPopUp loserPopUp = new LoserPopUp();
                            loserPopUp.display();
                        }
                    });
                    gameOver = true;
                    return;
                }
            }
            if(turn == 9){
                gameOver = true;
                //headerLabel.setText("Game Over.. Draw! No Winner");
                Platform.runLater(()->{
                    TiePopUp tiePopUp = new TiePopUp();
                    tiePopUp.display();
                });
                return;
            }
            //headerLabel.setText(String.format("%s's turn",turn %2 == 0? "X" : "O"));
            if (turn %2 != 0){
                //AI'S turn
                aiThinking = true;
                Runnable runnable = new Runnable(){
                    @Override
                    public void run(){
                        Platform.runLater(() ->{
                            doTurnForAI();
                        });
                    }
                };
                ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
                service.schedule(runnable, 0, TimeUnit.MILLISECONDS);
            }

        }
    }
    private void doButtonAction2(ActionEvent event){
        System.out.println("shaghala");

        int clickpos[]=getClickPostion(event);

        if(boardStat[clickpos[0]][clickpos[1]]==status.X || boardStat[clickpos[0]][clickpos[1]]==status.O)
        {       System.out.println("Enter in an empty position");

        }
        else if(playerTurn) { //false-agent turn, true-player turn
            int[] clickAgent =new int[2];
            //player turn
            ticTacToeButtons[clickpos[0]][clickpos[1]].setText("O");
            boardStat[clickpos[0]][clickpos[1]] = status.O;
            turn++;				//check game board
            checkGame();
            //agent turn
            clickAgent=agent();
            boardStat[clickAgent[0]][clickAgent[1]] = status.X;
            ticTacToeButtons[clickAgent[0]][clickAgent[1]].setText("X");
            turn++;
            checkGame();

        }
    }
    private int[] getClickPostion(ActionEvent event) { //when the user play this func get his clicked location
        Button sourceButton = (Button)event.getSource(); //sourceButton holds the button that clicked as event

        int[] clicked=new int[2];
        for(int c=0;c<3;c++)
            for(int r=0;r<3;r++) {
                if(sourceButton==ticTacToeButtons[c][r]) {
                    clicked[0]=c;
                    clicked[1]=r;
                    break;
                }
            }
        return clicked; //returns location ex: 00 or 01
    }
    private status checkBord() { //we check every col and row and diagonal if there is a winer

        for(int i=0 ; i<3 ; i++) {
            if(boardStat[0][i] == boardStat[1][i] && boardStat[1][i] == boardStat[2][i] &&  boardStat[2][i]!= status.EMPTY)
                return boardStat[0][i];
        }

        for(int i=0 ; i<3 ; i++) {
            if(boardStat[i][0] == boardStat[i][1] && boardStat[i][1] == boardStat[i][2] &&boardStat[i][2] != status.EMPTY)
                return boardStat[i][0];

        }
        if(boardStat[0][0] == boardStat[1][1] && boardStat[1][1] == boardStat[2][2] && boardStat[2][2] != status.EMPTY)
        {
            return boardStat[0][0];
        }
        if(boardStat[2][0] == boardStat[1][1] && boardStat[1][1] == boardStat[0][2] && boardStat[0][2] != status.EMPTY)
        {
            return boardStat[2][0];
        }

        return status.EMPTY;
    }
    private int[] agent() { //this func uses the board to check which place i need to put the next X with the G and H functions
        int[][] Harr = new int[3][3];
        int[] ret = new int[2];
        int Hmax=0, row = 0, column = 0, flag =0;
        for(int c=0;c<3;c++) {
            for(int r=0;r<3;r++)
            {
                if(boardStat[c][r]==status.EMPTY)  //if the square is empty we calculete: f = h + g
                {
                    Harr[c][r] = g(c,r) + h(c,r);
                    if(Harr[c][r] > Hmax)
                    {
                        Hmax=Harr[c][r];
                        row=c;
                        column=r;
                        flag=1;
                    }
                    if(flag ==0)
                    {
                        row=c;
                        column=r;
                    }
                }

            }

        }
        ret[0] = row;
        ret[1] = column;
        return ret;

    }
    private int g(int row , int column)   // in this function we are give to all empty square the greedy value
    {
        int countO = 0;
        int Fval=0;

        for(int i=0;i<3;i++) { // check row
            if(boardStat[row][i] ==  status.X)
                countO--;
            if(boardStat[row][i] ==  status.O)
                countO++;
        }
        if (countO == 2)
        {
            Fval = 100;
            return Fval;
        }
        countO=0;
        for(int j=0;j<3;j++) { // check column
            if(boardStat[j][column] ==  status.X)
                countO--;
            if(boardStat[j][column] ==  status.O)
                countO++;
        }
        if (countO == 2)
        {
            Fval = 100;
            return Fval;
        }
        countO=0;
        // check diagonals
        if (row == column)
        {
            for(int i=0 ; i<3 ; i++)
            {
                if(boardStat[i][i] ==  status.X)
                    countO--;
                if(boardStat[i][i] ==  status.O)
                    countO++;
            }
            if (countO == 2)
            {
                Fval = 100;
                return Fval;
            }
            countO=0;
        }


        // check second diagonal
        if (row + column == 2)
        {
            for(int i=0, j=2 ; i<3 ; i++ , j--)
            {
                if(boardStat[i][j] ==  status.X)
                    countO--;
                if(boardStat[i][j] ==  status.O)
                    countO++;
            }
            if (countO == 2)
            {
                Fval = 100;
                return Fval;
            }
        }


        return Fval;
    }
    private int h(int row , int column) // in this function we are give to all empty square the huristic value
    {
        int countX = 0;
        int countO= 0;
        int Hval = 0;
        for(int i=0;i<3;i++) { // check row

            if(boardStat[row][i] ==  status.X)
                countX++;
            if(boardStat[row][i] ==  status.O)
                countO++;
        }

        if(countO == 0)
        {
            if (countX == 2)
            {
                Hval+=1000;
                return Hval;
            }
            else {
                Hval++;
            }
        }
        countX = 0;
        countO= 0;

        for(int j=0;j<3;j++) { // check column

            if(boardStat[j][column] ==  status.X)
                countX++;
            if(boardStat[j][column] ==  status.O)
                countO++;
        }

        if(countO == 0)
        {
            if (countX == 2)
            {
                Hval+=1000;
                return Hval;
            }
            else {
                Hval++;
            }
        }
        countX = 0;
        countO= 0;

        // check main diagonal
        if (row == column)
        {
            for(int i=0 ; i<3 ; i++)
            {
                if(boardStat[i][i] ==  status.X)
                    countX++;
                if(boardStat[i][i] ==  status.O)
                    countO++;
            }
            if(countO == 0)
            {
                if (countX == 2)
                {
                    Hval+=1000;
                    return Hval;
                }
                else {
                    Hval++;
                }
            }
            countX = 0;
            countO= 0;
        }



        // check second diagonal
        if (row + column == 2)
        {
            for(int i=0, j=2 ; i<3 ; i++ , j--)
            {
                if(boardStat[i][j] ==  status.X)
                    countX++;
                if(boardStat[i][j] ==  status.O)
                    countO++;
            }
            if(countO == 0)
            {
                if (countX == 2)
                {
                    Hval+=1000;
                    return Hval;
                }
                else {
                    Hval++;
                }
            }
        }

        return Hval;
    }
    private void checkGame() // check the board game if there is a winer\loser or it is tie
    {
        if(checkBord()==status.O)

        {
            Platform.runLater(()->{
                WinnerPopup winnerPopup = new WinnerPopup();
                winnerPopup.display();
                System.out.println("YOU WIN");
                gameEnd = true;
            });

        }
        if(checkBord()==status.X)
        {
            // POPUP :"You Lose, The AI win"
            Platform.runLater(()->{
                LoserPopUp loserPopUp = new LoserPopUp();
                loserPopUp.display();
            });
            gameEnd = true;


        }
        full=true;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++)
            {
                if(boardStat[i][j]==status.EMPTY)
                    full=false;
            }
        }

        if(full && !(gameEnd)&& turn ==9) {
            gameEnd = true;
            //POPUP TIE
            Platform.runLater(()->{
                TiePopUp tiePopUp = new TiePopUp();
                tiePopUp.display();
            });
            for(int c = 0; c < 3; c++){
                for(int r =0; r < 3; r++){
                    ticTacToeButtons[c][r] = new Button("");
                    boardStat[c][r]=status.EMPTY;
                }
            }



        }






    }



    //5thturn check for a winner

    private boolean checkIfWon(String player) {
        //Todo Check ticTacToeButtons
        //check all rows horizontallly
        //check all columns vertically
        //check diagonally -> 2 diagonals 00 11 22, 02,11,20
        //check diagonally both ways
        if(player.equals(ticTacToeButtons[0][0].getText()) &&
                player.equals(ticTacToeButtons[1][1].getText()) &&
                player.equals(ticTacToeButtons[2][2].getText())){
            return true;
        }
        if(player.equals(ticTacToeButtons[0][0].getText()) &&
                player.equals(ticTacToeButtons[0][1].getText()) &&
                player.equals(ticTacToeButtons[0][2].getText())){
            return true;
        }
        if(player.equals(ticTacToeButtons[1][0].getText()) &&
                player.equals(ticTacToeButtons[1][1].getText()) &&
                player.equals(ticTacToeButtons[1][2].getText())){
            return true;
        }
        if(player.equals(ticTacToeButtons[2][0].getText()) &&
                player.equals(ticTacToeButtons[2][1].getText()) &&
                player.equals(ticTacToeButtons[2][2].getText())){
            return true;
        }
        if(player.equals(ticTacToeButtons[0][0].getText()) &&
                player.equals(ticTacToeButtons[1][0].getText()) &&
                player.equals(ticTacToeButtons[2][0].getText())){
            return true;
        }
        if(player.equals(ticTacToeButtons[0][1].getText()) &&
                player.equals(ticTacToeButtons[1][1].getText()) &&
                player.equals(ticTacToeButtons[2][1].getText())){
            return true;
        }
        if(player.equals(ticTacToeButtons[0][2].getText()) &&
                player.equals(ticTacToeButtons[1][2].getText()) &&
                player.equals(ticTacToeButtons[2][2].getText())){
            return true;
        }
        if(player.equals(ticTacToeButtons[0][2].getText()) &&
                player.equals(ticTacToeButtons[1][1].getText()) &&
                player.equals(ticTacToeButtons[2][0].getText())){
            return true;
        }

        return false;
    }

    private void doTurnForAI() {
        //AI is dumb i.e normally
        //randomly pick buttonsS
        System.out.println("Ai's tutn");
        aiThinking = false;
        int row = (int)(Math.random()*3);
        int col = (int)(Math.random()*3);
        System.out.println(row + ":" + col);
        ticTacToeButtons[row][col].fire();
    }


    @FXML
    void mainmenuHandle(ActionEvent event) {
        if(GameConfig.getGameMode() == 1 || GameConfig.getGameMode() == 0){ // Single player or Re=play
            SwitchSceneTo.showScene(1);
        }
        //System.out.println("back to mainmenu");
    }

    @FXML
    void newgameHandle(ActionEvent event) {
        if(GameConfig.getGameMode() == 1){ // Single player
            resetGame();
        }else if(GameConfig.getGameMode() == 2){
            EntryPoint.getGameClient().sendAcceptSaveGame();
            newgame.setDisable(true);
        }

        //System.out.println("start new game");
    }

    @FXML
    void sendHandle(MouseEvent event) {
        System.out.println("send your massege");
    }

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);

    }

    @FXML
    void zone1hadle(ActionEvent event) {
        if(GameConfig.getGameMode() == 2){
            if(EntryPoint.getGameClient().getMyTurn() && this.buttons[0].getText().equals("")){
                EntryPoint.getGameClient().sendMoveToServer(this.buttons[0].getId(),
                        EntryPoint.getGameClient().getSymbol());

            }
        }else if(GameConfig.getGameMode() == 1){
            if (GameConfig.getGameDiffficultyLevel() == 1){
                doButtonAction(event);
            } else if (GameConfig.getGameDiffficultyLevel() == 3){
                doButtonAction2(event);
            }

        }

    }

    @FXML
    void zone2Handle(ActionEvent event) {
        if(GameConfig.getGameMode() == 2){
            if(EntryPoint.getGameClient().getMyTurn() && this.buttons[1].getText().equals("")){
                EntryPoint.getGameClient().sendMoveToServer(this.buttons[1].getId(),
                        EntryPoint.getGameClient().getSymbol());
            }
        }else if(GameConfig.getGameMode() == 1){
            if (GameConfig.getGameDiffficultyLevel() == 1){
                doButtonAction(event);
            } else if (GameConfig.getGameDiffficultyLevel() == 3){
                doButtonAction2(event);
            }

        }
    }

    @FXML
    void zone3Handle(ActionEvent event) {
        if(GameConfig.getGameMode() == 2){
            if(EntryPoint.getGameClient().getMyTurn() && this.buttons[2].getText().equals("")){
                EntryPoint.getGameClient().sendMoveToServer(this.buttons[2].getId(),
                        EntryPoint.getGameClient().getSymbol());
            }
        }else if(GameConfig.getGameMode() == 1){
            if (GameConfig.getGameDiffficultyLevel() == 1){
                doButtonAction(event);
            } else if (GameConfig.getGameDiffficultyLevel() == 3){
                doButtonAction2(event);
            }

        }
    }

    @FXML
    void zone4Handle(ActionEvent event) {
        if(GameConfig.getGameMode() == 2){
            if(EntryPoint.getGameClient().getMyTurn() && this.buttons[3].getText().equals("")){
                EntryPoint.getGameClient().sendMoveToServer(this.buttons[3].getId(),
                        EntryPoint.getGameClient().getSymbol());
            }
        }else if(GameConfig.getGameMode() == 1){
            if (GameConfig.getGameDiffficultyLevel() == 1){
                doButtonAction(event);
            } else if (GameConfig.getGameDiffficultyLevel() == 3){
                doButtonAction2(event);
            }

        }
    }

    @FXML
    void zone5Handle(ActionEvent event) {
        if(GameConfig.getGameMode() == 2){
            if(EntryPoint.getGameClient().getMyTurn() && this.buttons[4].getText().equals("")){
                EntryPoint.getGameClient().sendMoveToServer(this.buttons[4].getId(),
                        EntryPoint.getGameClient().getSymbol());
            }
        }else if(GameConfig.getGameMode() == 1){
            if (GameConfig.getGameDiffficultyLevel() == 1){
                doButtonAction(event);
            } else if (GameConfig.getGameDiffficultyLevel() == 3){
                doButtonAction2(event);
            }

        }
    }

    @FXML
    void zone6Handle(ActionEvent event) {
        if(GameConfig.getGameMode() == 2){
            if(EntryPoint.getGameClient().getMyTurn() && this.buttons[5].getText().equals("")){
                EntryPoint.getGameClient().sendMoveToServer(this.buttons[5].getId(),
                        EntryPoint.getGameClient().getSymbol());
            }
        }else if(GameConfig.getGameMode() == 1){
            if (GameConfig.getGameDiffficultyLevel() == 1){
                doButtonAction(event);
            } else if (GameConfig.getGameDiffficultyLevel() == 3){
                doButtonAction2(event);
            }

        }
    }

    @FXML
    void zone7Handle(ActionEvent event) {
        if(GameConfig.getGameMode() == 2){
            if(EntryPoint.getGameClient().getMyTurn() && this.buttons[6].getText().equals("")){
                EntryPoint.getGameClient().sendMoveToServer(this.buttons[6].getId(),
                        EntryPoint.getGameClient().getSymbol());
            }
        }else if(GameConfig.getGameMode() == 1){
            if (GameConfig.getGameDiffficultyLevel() == 1){
                doButtonAction(event);
            } else if (GameConfig.getGameDiffficultyLevel() == 3){
                doButtonAction2(event);
            }

        }
    }

    @FXML
    void zone8Handle(ActionEvent event) {
        if(GameConfig.getGameMode() == 2){
            if(EntryPoint.getGameClient().getMyTurn() && this.buttons[7].getText().equals("")){
                EntryPoint.getGameClient().sendMoveToServer(this.buttons[7].getId(),
                        EntryPoint.getGameClient().getSymbol());
            }
        }else if(GameConfig.getGameMode() == 1){
            if (GameConfig.getGameDiffficultyLevel() == 1){
                doButtonAction(event);
            } else if (GameConfig.getGameDiffficultyLevel() == 3){
                doButtonAction2(event);
            }

        }
    }

    @FXML
    void zone9Handle(ActionEvent event) {
        if(GameConfig.getGameMode() == 2){
            if(EntryPoint.getGameClient().getMyTurn() && this.buttons[8].getText().equals("")){
                EntryPoint.getGameClient().sendMoveToServer(this.buttons[8].getId(),
                        EntryPoint.getGameClient().getSymbol());
            }
        }else if(GameConfig.getGameMode() == 1){
            if (GameConfig.getGameDiffficultyLevel() == 1){
                doButtonAction(event);
            } else if (GameConfig.getGameDiffficultyLevel() == 3){
                doButtonAction2(event);
            }

        }
    }

}