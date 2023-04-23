package com.tftf.util;

import java.util.ArrayList;
import java.util.HashMap;

public class MusicTag {
    public HashMap<CharSequence, CharSequence> tagMap;
    public ArrayList<CharSequence> tagList;

    public MusicTag() {
        tagMap = new HashMap<>();
        tagList = new ArrayList<>();
    }

    public int getSize() {
        return tagList.size();
    }

    public CharSequence at(int index) {
        return tagList.get(index);
    }
}
