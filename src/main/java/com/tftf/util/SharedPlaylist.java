package com.tftf.util;

import java.util.ArrayList;

public class SharedPlaylist extends Playlist {
    public int likeCount;
    public int downloadCount;

    public SharedPlaylist(String userID, String name, String description, ArrayList<Integer> musicList, int likeCount, int downloadCount) {
        super(userID, name, description, musicList);
        this.likeCount = likeCount;
        this.downloadCount = downloadCount;
    }
}
