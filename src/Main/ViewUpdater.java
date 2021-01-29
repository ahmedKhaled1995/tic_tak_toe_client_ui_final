package Main;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Optional;

public class ViewUpdater {

    private TableView<PlayerRow> leaderBoardTable;
    private Button[] buttons;

    public void setLeaderBoardTable(TableView<PlayerRow> leaderBoardTable) {
        this.leaderBoardTable = leaderBoardTable;
    }

    public void updateLeaderBoardTableView(JSONArray users){
        Platform.runLater(()->{
            ObservableList<PlayerRow> usersList = FXCollections.observableArrayList();
            for(Object user : users){
                JSONObject player = (JSONObject) user;
                if(player.get("userName").equals(EntryPoint.getGameClient().getUserName())){
                    continue;
                }
                ImageView image = null;
                if(player.get("status").toString().equalsIgnoreCase("online")){
                    image = Resource.getEmojOn();
                }else{
                    image = Resource.getEmojOff();
                }
                usersList.add(new PlayerRow(player.get("userName").toString(),
                        Integer.parseInt(player.get("score").toString()), image));
            }
            this.leaderBoardTable.setItems(usersList);
        });
    }

    public void updateLoggedInUser(String userName){
        if(this.leaderBoardTable != null){
            Optional<PlayerRow> playerRow = this.leaderBoardTable.getItems().stream().
                    filter(item -> item.getName().equals(userName)).findAny();
            playerRow.get().setPhoto(Resource.getEmojOn());
            this.leaderBoardTable.refresh();
        }
    }

    public void updateLoggedOutUser(String userName){
        if(this.leaderBoardTable != null){
            Optional<PlayerRow> playerRow = this.leaderBoardTable.getItems().stream().
                    filter(item -> item.getName().equals(userName)).findAny();
            playerRow.get().setPhoto(Resource.getEmojOff());
            this.leaderBoardTable.refresh();
        }
    }

    public void updateSignedUpUser(String userName){
        if(this.leaderBoardTable != null){
            this.leaderBoardTable.getItems().add(new PlayerRow(userName, 0, Resource.getEmojOn()));
        }
    }

    public void setBoardButtons(Button[] buttons){
        this.buttons = buttons;
        this.buttons[0].setId("0");
        this.buttons[1].setId("1");
        this.buttons[2].setId("2");
        this.buttons[3].setId("3");
        this.buttons[4].setId("4");
        this.buttons[5].setId("5");
        this.buttons[6].setId("6");
        this.buttons[7].setId("7");
        this.buttons[8].setId("8");
    }

    public void updateBoard(JSONObject replyJson){
        Platform.runLater(()->{
            int index = Integer.parseInt(replyJson.get("index").toString());
            String myTurn = replyJson.get("myTurn").toString();
            if(EntryPoint.getGameClient().getSymbol() == 1){
                if(myTurn.equals("true")){  // So the previous turn was the opponent
                    this.buttons[index].setText("O");
                }else{
                    this.buttons[index].setText("X");
                }
            }else{
                if(myTurn.equals("true")){  // So the previous turn was the opponent
                    this.buttons[index].setText("X");
                }else{
                    this.buttons[index].setText("O");
                }
            }
        });
    }
}
