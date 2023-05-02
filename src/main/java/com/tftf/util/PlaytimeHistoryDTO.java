package com.tftf.util;

import com.google.gson.JsonObject;

public class PlaytimeHistoryDTO {
    String email;
    int musicId;
    Long totalPlaytime;
    JsonObject historyJO;

    public PlaytimeHistoryDTO(String email, int musicId, Long totalPlaytime, JsonObject historyJO) {
        this.email = email;
        this.musicId = musicId;
        this.totalPlaytime = totalPlaytime;
        this.historyJO = historyJO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(int musicId) {
        this.musicId = musicId;
    }

    public Long getTotalPlaytime() {
        return totalPlaytime;
    }

    public void setTotalPlaytime(Long totalPlaytime) {
        this.totalPlaytime = totalPlaytime;
    }

    public JsonObject getHistoryJO() {
        return historyJO;
    }

    public void setHistoryJO(JsonObject historyJO) {
        this.historyJO = historyJO;
    }
}