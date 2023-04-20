package com.tftf.util;

import java.util.HashMap;

public class Surroundings {

    public HashMap<CharSequence, CharSequence> info;

    public Surroundings() {
        info = new HashMap<>();
        info.put("시간", "NONE");
        info.put("날씨", "NONE");
        info.put("계절", "NONE");
        info.put("요일", "NONE");
    }
}