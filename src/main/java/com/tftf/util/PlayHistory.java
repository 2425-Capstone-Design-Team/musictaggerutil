package com.tftf.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.*;

public class PlayHistory {

    public Long totalPlaytime = 0L;
    HashMap<CharSequence, HashMap<CharSequence, Long>> historyMap;

    public PlayHistory() {
        historyMap = new HashMap<>();

        Surroundings surroundings = new Surroundings();
        for (CharSequence category : surroundings.infoMap.keySet()) {
            historyMap.put(category, new HashMap<>());
        }
    }

    public void addPlaytime(Surroundings surroundings, Long playtime) {
        totalPlaytime += playtime;

        for (CharSequence category : historyMap.keySet()) {
            CharSequence currentSurroundings = surroundings.infoMap.get(category);
            HashMap<CharSequence, Long> history = historyMap.get(category);
            if (!history.containsKey(currentSurroundings)) {
                history.put(currentSurroundings, 0L);
            }
            history.replace(currentSurroundings, history.get(currentSurroundings) + playtime);
        }
    }

    public Long getPlaytime(CharSequence category, CharSequence section) {

        if (historyMap.containsKey(category)) {
            return historyMap.get(category).getOrDefault(section, 0L);
        }
        else return 0L;
    }

    public void importFromJson(JsonObject jo) {
        Gson gson = new Gson();

        Type type = new TypeToken<HashMap<String, HashMap<String, Long>>>() {
        }.getType();
        historyMap = gson.fromJson(jo, type);
    }

    public JsonObject exportToJson() {
        Gson gson = new Gson();

        return gson.toJsonTree(historyMap).getAsJsonObject();
    }
}