package sys;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.Optional;

public class ViewUpdater {

    private TableView<Online> leaderBoardTable;

    public void setLeaderBoardTable(TableView<Online> leaderBoardTable) {
        this.leaderBoardTable = leaderBoardTable;
    }

    public void updateLeaderBoardTableView(JSONArray users){
        Platform.runLater(()->{
            ObservableList<Online> usersList = FXCollections.observableArrayList();
            for(Object user : users){
                JSONObject player = (JSONObject) user;
                if(player.get("userName").equals(GameLauncher.getGameClient().getUserName())){
                    continue;
                }
                ImageView image = null;
                if(player.get("status").toString().equalsIgnoreCase("online")){
                    image = Resource.getEmojOn();
                }else{
                    image = Resource.getEmojOff();
                }
                usersList.add(new Online(player.get("userName").toString(),
                        Integer.parseInt(player.get("score").toString()), image));
            }
            this.leaderBoardTable.setItems(usersList);
        });
    }

    public void updateLoggedInUser(String userName){
        if(this.leaderBoardTable != null){
            Optional<Online> playerRow = this.leaderBoardTable.getItems().stream().
                    filter(item -> item.getName().equals(userName)).findAny();
            playerRow.get().setPhoto(Resource.getEmojOn());
            this.leaderBoardTable.refresh();
        }
    }

    public void updateLoggedOutUser(String userName){
        if(this.leaderBoardTable != null){
            Optional<Online> playerRow = this.leaderBoardTable.getItems().stream().
                    filter(item -> item.getName().equals(userName)).findAny();
            playerRow.get().setPhoto(Resource.getEmojOff());
            this.leaderBoardTable.refresh();
        }
    }

    public void updateSignedUpUser(String userName){
        if(this.leaderBoardTable != null){
            this.leaderBoardTable.getItems().add(new Online(userName, 0, Resource.getEmojOn()));
        }
    }
}
