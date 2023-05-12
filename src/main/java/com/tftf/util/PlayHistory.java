package com.tftf.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class PlayHistory {
    public String userID;
    public int musicID;
    public Long totalPlayedTime;
    HashMap<String, HashMap<String, Long>> historyMap;

    public PlayHistory(String userID, int musicID) {
        this.userID = userID;
        this.musicID = musicID;

        totalPlayedTime = 0L;

        historyMap = new HashMap<>();

        Surroundings surroundings = new Surroundings();
        for (String category : surroundings.infoMap.keySet()) {
            historyMap.put(category, new HashMap<>());
        }
    }

    public PlayHistory(String userID, int musicID, Long totalPlayedTime, JsonObject historyJO) {
        this.userID = userID;
        this.musicID = musicID;
        this.totalPlayedTime = totalPlayedTime;

        JsonConverter.setPlayHistoryFromJson(this, historyJO);
    }

    public void cumulatePlayedTime(Long playedTime, Surroundings surroundings) {
        totalPlayedTime += playedTime;

        for (String category : historyMap.keySet()) {
            String currentSurroundings = surroundings.infoMap.get(category);
            HashMap<String, Long> tagMap = historyMap.get(category);
            if (!tagMap.containsKey(currentSurroundings)) {
                tagMap.put(currentSurroundings, 0L);
            }
            tagMap.replace(currentSurroundings, tagMap.get(currentSurroundings) + playedTime);
        }
    }

    public Long getPlayedTime(String category, String tag) {

        if (historyMap.containsKey(category)) {
            return historyMap.get(category).getOrDefault(tag, 0L);
        }
        else return 0L;
    }
}