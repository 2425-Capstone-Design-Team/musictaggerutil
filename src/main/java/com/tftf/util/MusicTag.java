package com.tftf.util;

import java.util.ArrayList;
import java.util.HashMap;

public class MusicTag {
    public HashMap<CharSequence, CharSequence> tagMap;

    public MusicTag() {
        tagMap = new HashMap<>();
    }

    public int getSize() {
        return tagMap.size();
    }

    public ArrayList<Pair<CharSequence, CharSequence>> toList() {
        ArrayList<Pair<CharSequence, CharSequence>> tagList = new ArrayList<>();

        for (CharSequence key : tagMap.keySet()) {
            CharSequence val = tagMap.get(key);

            tagList.add(new Pair<>(key, val));
        }

        return tagList;
    }
}
