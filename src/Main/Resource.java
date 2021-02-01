package Main;

import javafx.scene.image.ImageView;

public class Resource {

    //..\resources\images\x.png

    public static ImageView getMaleOff(){
        return  new ImageView("/resources/maleoff.png");
    }

    public static ImageView getMaleOn(){
        return new ImageView("/resources/maleon.png");
    }

    public static ImageView getEmojOn(){
        return new ImageView("/resources/online1.png");
    }

    public static ImageView getEmojOff(){
        return new ImageView("/resources/offline1.png");
    }

    public static ImageView getXPic(){
        return new ImageView("/resources/images/x.png");
    }

    public static ImageView getOPic(){
        return new ImageView("/resources/images/o.png");
    }
}
