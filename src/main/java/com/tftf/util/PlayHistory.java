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
    HashMap<CharSequence, HashMap<CharSequence, Long>> historyMap;

    public PlayHistory(String userID, int musicID) {
        this.userID = userID;
        this.musicID = musicID;

        totalPlayedTime = 0L;

        historyMap = new HashMap<>();

        Surroundings surroundings = new Surroundings();
        for (CharSequence category : surroundings.infoMap.keySet()) {
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

        for (CharSequence category : historyMap.keySet()) {
            CharSequence currentSurroundings = surroundings.infoMap.get(category);
            HashMap<CharSequence, Long> history = historyMap.get(category);
            if (!history.containsKey(currentSurroundings)) {
                history.put(currentSurroundings, 0L);
            }
            history.replace(currentSurroundings, history.get(currentSurroundings) + playedTime);
        }
    }

    public Long getPlayedTime(CharSequence category, CharSequence tag) {

        if (historyMap.containsKey(category)) {
            return historyMap.get(category).getOrDefault(tag, 0L);
        }
        else return 0L;
    }
}