package lab9;

import java.util.ArrayList;

/**
 * Class CDPlayer
 */
public class CDPlayer extends MusicPlayer {

    private int deviceID;
    private int thisTrack;

    /**
     * Constructor for CD-Player
     */
    public CDPlayer(int id) {
        super();
        deviceID = id;
        thisTrack = 0;
    }

    /**
     * Over-ride Method: turnOn
     */
    public void turnOn() {
        super.turnOn();
        thisTrack = 0;
    }

    /**
     * Over-ride Method: turnOff
     */
    public void turnOff() {
        super.turnOff();
        thisTrack = 0;
    }

    /**
     * Method to play next track in the playlist by
     * printing it to stdout and changing current
     */
    public void nextTrack() {
        System.out.println("Playing " + playlist.get(thisTrack + 1));
        thisTrack ++;
    }

    /**
     * Method to play previous track in the playlist by
     * printing it to stdout and changing current
     */
    public void previousTrack() {
        System.out.println("Playing " + playlist.get(thisTrack - 1));
        thisTrack --;
    }

    /**
     * Method to play current track
     */
    public void play() {
        super.play(thisTrack);
    }

}