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

    public MusicTag getMusicTag() {
        HashMap<CharSequence, HashMap<CharSequence, Long>> historySum = new HashMap<>();
        for (CharSequence category : historyMap.keySet()) {
            historySum.put(category, new HashMap<>());

            HashMap<CharSequence, Long> history = historyMap.get(category);
            for (CharSequence tagKey : history.keySet()) {
                if (!historySum.get(category).containsKey(tagKey)) {
                    historySum.get(category).put(tagKey, 0L);
                }
                Long tagVal = history.get(tagKey);
                historySum.get(category).replace(tagKey, historySum.get(category).get(tagKey) + tagVal);
            }
        }

        // HashMap<태그카테고리, (내림차순)PriorityQueue<Pair<점수, 주변정보>>>
        HashMap<CharSequence, PriorityQueue<Pair<CharSequence, Long>>> tagRank = new HashMap<>();

        for (CharSequence category : historySum.keySet()) {
            PriorityQueue<Pair<CharSequence, Long>> categoryRank = new PriorityQueue<>(
                    historySum.get(category).size(), (p1, p2) -> (int) (p2.getSecond() - p1.getSecond()) );
            //} { p1, p2 -> (p1.second - p2.second).toInt() }

            for (CharSequence tagKey : historySum.get(category).keySet()) {
                Long tagVal = historySum.get(category).get(tagKey);
                categoryRank.add(new Pair<>(tagKey, tagVal));
            }
            tagRank.put(category, categoryRank);
        }

        MusicTag musicTag = new MusicTag();
        for (CharSequence category : tagRank.keySet()) {
            if (!tagRank.get(category).isEmpty()) {
                musicTag.tagMap.put(category, tagRank.get(category).peek().getFirst());
            }
        }
        return musicTag;
    }
}