/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;

/**
 *
 * @author Cool IT help
 */
public class Online {

    public ImageView photo;
    int point;
    String name;

    public Online(String name, int point, ImageView photo) {

        this.photo = photo;
        this.name = name;
        this.point = point;

    }

    /* ArrayList<Online> list5 = new ArrayList<String>() {
    // new Online("player1",100,maleon);
        add("player1",100,maleon);
         
     
     
     };*/
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public ImageView getPhoto() {
        return photo;
    }

    public void setPhoto(ImageView photo) {
        this.photo = photo;

    }

}
