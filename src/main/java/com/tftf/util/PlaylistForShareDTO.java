package com.tftf.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class PlaylistForShareDTO {

    String name;
    JsonArray musicListJson;
    String email;
    String description;
    int likeCount;
    int copyCount;

    public PlaylistForShareDTO(String name, JsonArray musicListJson, String email, String description, int likeCount, int copyCount) {
        this.name = name;
        this.musicListJson = musicListJson;
        this.email = email;
        this.description = description;
        this.likeCount = likeCount;
        this.copyCount = copyCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonArray getMusicListJson() {
        return musicListJson;
    }

    public void setMusicListJson(JsonArray musicListJson) {
        this.musicListJson = musicListJson;
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

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCopyCount() {
        return copyCount;
    }

    public void setCopyCount(int copyCount) {
        this.copyCount = copyCount;
    }
}
