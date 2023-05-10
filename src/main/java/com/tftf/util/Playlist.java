package com.tftf.util;

import java.util.ArrayList;

public class Playlist {

    public String userID;
    public String name;
    public String description;
    public ArrayList<Integer> musicList;

    public Playlist(String userID, String name, String description, ArrayList<Integer> musicList) {
        this.userID = userID;
        this.name = name;
        this.description = description;
        this.musicList = musicList;
    }
}