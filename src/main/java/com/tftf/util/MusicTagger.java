package com.tftf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MusicTagger {

    public static MusicTag getMusicTag(HashMap<String, HashMap<String, Long>> historyMap) {

        // HashMap<태그카테고리, (내림차순)PriorityQueue<Pair<점수, 주변정보>>>
        HashMap<String, PriorityQueue<Pair<String, Long>>> tagRank = new HashMap<>();

        for (String category : historyMap.keySet()) {
            PriorityQueue<Pair<String, Long>> categoryRank = new PriorityQueue<>(
                    historyMap.get(category).size(), (p1, p2) -> (int) (p2.getSecond() - p1.getSecond()) );
            //} { p1, p2 -> (p1.second - p2.second).toInt() }

            for (String tagKey : historyMap.get(category).keySet()) {
                Long tagVal = historyMap.get(category).get(tagKey);
                categoryRank.add(new Pair<>(tagKey, tagVal));
            }
            tagRank.put(category, categoryRank);
        }

        MusicTag musicTag = new MusicTag();
        for (String category : tagRank.keySet()) {
            if (!tagRank.get(category).isEmpty()) {
                musicTag.tagMap.put(category, tagRank.get(category).peek().getFirst());
            }
        }
        return musicTag;
    }

    public static HashMap<String, HashMap<String, Long>> getHistoryMapSum(List<PlayHistory> playHistoryList) {

        HashMap<String, HashMap<String, Long>> historySum = new HashMap<>();

        for (PlayHistory playHistory : playHistoryList) {
            HashMap<String, HashMap<String, Long>> historyMap = playHistory.historyMap;
            for (String category : historyMap.keySet()) {
                historySum.put(category, new HashMap<>());

                HashMap<String, Long> history = historyMap.get(category);
                for (String tagKey : history.keySet()) {
                    if (!historySum.get(category).containsKey(tagKey)) {
                        historySum.get(category).put(tagKey, 0L);
                    }
                    Long tagVal = history.get(tagKey);
                    historySum.get(category).replace(tagKey, historySum.get(category).get(tagKey) + tagVal);
                }
            }
        }

        return historySum;
    }

    public static MusicTag getMusicTag(PlayHistory playHistory) {
        return getMusicTag(playHistory.historyMap);
    }

    public static MusicTag getMusicTag(List<PlayHistory> playHistoryList) {

        return getMusicTag(getHistoryMapSum(playHistoryList));
    }
}
