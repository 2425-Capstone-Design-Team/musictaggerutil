package com.tftf.util;

import java.util.ArrayList;

public class PlaylistForShare extends Playlist {

    String email;
    String description;
    Integer likeCount;
    Integer copyCount;

    public PlaylistForShare(String name, ArrayList<Integer> musicList, String email, String description, Integer likeCount, Integer copyCount) {
        super(name, musicList);
        this.email = email;
        this.description = description;
        this.likeCount = likeCount;
        this.copyCount = copyCount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public Integer getCopyCount() {
        return copyCount;
    }

    public void setCopyCount(Integer copyCount) {
        this.copyCount = copyCount;
    }
}
