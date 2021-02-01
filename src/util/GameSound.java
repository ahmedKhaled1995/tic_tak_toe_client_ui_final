/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

/**
 *
 * @author LENOVO
 */
public class GameSound {

    private static final ArrayList<String> soundTracksList = new ArrayList<String>() {
        {
            add("farmfrenzy.mp3");              // index 0 -> main menu soundtrack
            add("button-click.mp3");            // index 1 -> button click soundtrack
            add("gun.mp3");                     // index 2 -> game begins
            add("tile-click.wav");              // index 3 -> tile click
            add("win.wav");                     // index 4 -> player wins soundtrack
            add("fail.mp3");                    // index 5 -> player loses soundtrack
            add("type.mp3");                    // index 6 -> player types soundtrack 
            add("about.mp3");                   // index 7 -> about theme soundtrack
            add("cheering.mp3");
        }
    };

    private static final String path = "/resources/sound/";

    private static MediaPlayer mainMenuMediaPlayer;
    private static AudioClip audiosPlayer;

    private static boolean playedOnce = false;

    /**
     * will play the media according to the given trackIndex for infinite number
     * of cycles
     *
     * @param trackIndex
     */
    public static void playMediaTrack(int trackIndex) {
        if (!playedOnce) {
            mainMenuMediaPlayer = createMediaPlayer(trackIndex);
            playedOnce = true;
            mainMenuMediaPlayer.setVolume(0.1);
            mainMenuMediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mainMenuMediaPlayer.play();
        }
    }

    public static void playMediaTrack(int trackIndex, int cycleCount) {
        mainMenuMediaPlayer = createMediaPlayer(trackIndex);
        playedOnce = true;
        mainMenuMediaPlayer.setVolume(0.5);
        mainMenuMediaPlayer.setCycleCount(cycleCount);
        mainMenuMediaPlayer.play();
    }

    public static void playAudioTrack(int trackIndex, int cycleCount) {
        audiosPlayer = createAudioClip(trackIndex);
        audiosPlayer.setCycleCount(cycleCount);
        audiosPlayer.play();
    }

    public static void playClickTrack() {
        playAudioTrack(1, 1);
    }

    public static void playMainMenuTrack() {
        playMediaTrack(0);
    }

    public static void playGameBeginsTrack() {
        playAudioTrack(2, 1);
    }

    public static void playTileClickTrack() {
        playAudioTrack(3, 1);
    }

    public static void playWinTrack() {
        playAudioTrack(4, 1);
    }

    public static void playLoseTrack() {
        playAudioTrack(5, 1);
    }

    public static void playTypingTrack() {
        playAudioTrack(6, 1);
    }

    public static void playAboutTrack() {
        playMediaTrack(7, 1);
    }

    /**
     * stops the media player from playing
     */
    public static void stopMediaPlayer() {
        mainMenuMediaPlayer.stop();
        playedOnce = false;
    }

    public static boolean mainMenuNotPlaying() {
        return !mainMenuMediaPlayer.getStatus().equals(Status.PLAYING);
    }

    public static boolean audioNotPlaying() {
        return !audiosPlayer.isPlaying();
    }

    public static MediaPlayer getMainMenuMediaPlayer() {
        return mainMenuMediaPlayer;
    }

    public static AudioClip getAudioClip() {
        return audiosPlayer;
    }
    
    public static void stopAudio() {
        audiosPlayer.stop();
    }

    public static MediaPlayer createMediaPlayer(int trackIndex) {
        return new MediaPlayer(new Media(GameSound.class.getResource(path + soundTracksList.get(trackIndex)).toExternalForm()));
    }

    public static AudioClip createAudioClip(int trackIndex) {
        return new AudioClip(GameSound.class.getResource(path + soundTracksList.get(trackIndex)).toString());
    }
}
