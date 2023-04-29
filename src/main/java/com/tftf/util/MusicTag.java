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

    public ArrayList<CharSequence> toList() {
        return new ArrayList<>(tagMap.values());
    }
}
