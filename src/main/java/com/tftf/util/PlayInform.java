package com.tftf.util;

public class PlayInform {

    String userID;
    int musicID;
    Long playedTime;
    Surroundings surroundings;

    public PlayInform(String userID, int musicID, Long playedTime, Surroundings surroundings) {
        this.userID = userID;
        this.musicID = musicID;
        this.playedTime = playedTime;
        this.surroundings = surroundings;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getMusicID() {
        return musicID;
    }

    public void setMusicID(int musicID) {
        this.musicID = musicID;
    }

    public Long getPlayedTime() {
        return playedTime;
    }

    public void setPlayedTime(Long playedTime) {
        this.playedTime = playedTime;
    }

    public Surroundings getSurroundings() {
        return surroundings;
    }

    public void setSurroundings(Surroundings surroundings) {
        this.surroundings = surroundings;
    }
}
