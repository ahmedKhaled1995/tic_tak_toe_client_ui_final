/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author LENOVO
 */
public class GameConfig {

    //This class is intended to hold all the player configuration regarding the difficulty level, game mode, flags about players's requests
    //feel free to add more configurations
    /*
        Difficulty level: 
        1 -> Easy
        2 -> Medium
        3 -> Hard
     */
    private static int gameDifficultyLevel;

    /*
        Game Mode:
        0 -> Watch saved matches
        1 -> Single Player Mode
        2 -> Multiplayer Mode
     */
    private static int gameMode;

    /*
        0 -> signin scene
        1 -> signup scene
        2 -> home scene
        3 -> difficultyselection scene (Single Player Mode)
        4 -> leaderboard scene (Multiplayer Mode)
        5 -> savedgames scene 
        6 -> gameboard scene
        7 -> about scene
    */
    private static int currentView;

    public static void setGameDifficultyLevel(int _gameDifficultyLevel) {
        gameDifficultyLevel = _gameDifficultyLevel;
    }

    public static int getGameDiffficultyLevel() {
        return gameDifficultyLevel;
    }

    public static void setGameMode(int _gameMode) {
        gameMode = _gameMode;
    }

    public static int getGameMode() {
        return gameMode;
    }

    public static int getCurrentView() {
        return currentView;
    }

    public static void setCurrentView(int viewIndex) {
        currentView = viewIndex;
    }
}
