package com.tftf.util;

import java.util.ArrayList;

public class Playlist {

    String name;
    ArrayList<Integer> musicList;

    public Playlist(String name, ArrayList<Integer> musicList) {
        this.name = name;
        this.musicList = musicList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getMusicList() {
        return musicList;
    }

    public void setMusicList(ArrayList<Integer> musicList) {
        this.musicList = musicList;
    }
}