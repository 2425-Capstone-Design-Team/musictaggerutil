package com.tftf.util;

import java.util.ArrayList;

public class MusicTag {
    public ArrayList<CharSequence> tagList;

    public MusicTag() {
        tagList = new ArrayList<>();
    }

    public int getSize() {
        return tagList.size();
    }

    public CharSequence at(int index) {
        return tagList.get(index);
    }
}
