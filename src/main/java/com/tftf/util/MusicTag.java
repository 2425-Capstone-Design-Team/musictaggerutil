package com.tftf.util;

import java.util.ArrayList;
import java.util.HashMap;

public class MusicTag {
    public HashMap<String, String> tagMap;

    public MusicTag() {
        tagMap = new HashMap<>();
    }

    public int getSize() {
        return tagMap.size();
    }

    public ArrayList<Pair<String, String>> toList() {
        ArrayList<Pair<String, String>> tagList = new ArrayList<>();

        for (String key : tagMap.keySet()) {
            String val = tagMap.get(key);

            tagList.add(new Pair<>(key, val));
        }

        return tagList;
    }
}
