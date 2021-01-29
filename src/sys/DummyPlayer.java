/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys;

/**
 *
 * @author LENOVO
 */
public class DummyPlayer {

    private static String userName;
    private static int score;
    
    public static void setUserName(String _userName) {
        userName = _userName;
    }
    
    public static String getUserName() {
        return userName;
    }

    public static void setScore(int _score) {
        score = _score;
    }

    public static int getScore() {
        return score;
    }
}
