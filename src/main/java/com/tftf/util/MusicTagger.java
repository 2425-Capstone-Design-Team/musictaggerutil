package com.tftf.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MusicTagger {

    public static MusicTag getMusicTag(HashMap<CharSequence, HashMap<CharSequence, Long>> historyMap) {

        // HashMap<태그카테고리, (내림차순)PriorityQueue<Pair<점수, 주변정보>>>
        HashMap<CharSequence, PriorityQueue<Pair<CharSequence, Long>>> tagRank = new HashMap<>();

        for (CharSequence category : historyMap.keySet()) {
            PriorityQueue<Pair<CharSequence, Long>> categoryRank = new PriorityQueue<>(
                    historyMap.get(category).size(), (p1, p2) -> (int) (p2.getSecond() - p1.getSecond()) );
            //} { p1, p2 -> (p1.second - p2.second).toInt() }

            for (CharSequence tagKey : historyMap.get(category).keySet()) {
                Long tagVal = historyMap.get(category).get(tagKey);
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

    public static HashMap<CharSequence, HashMap<CharSequence, Long>> getHistoryMapSum(List<PlayHistory> playHistoryList) {

        HashMap<CharSequence, HashMap<CharSequence, Long>> historySum = new HashMap<>();

        for (PlayHistory playHistory : playHistoryList) {
            HashMap<CharSequence, HashMap<CharSequence, Long>> historyMap = playHistory.historyMap;
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
