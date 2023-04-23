package com.tftf.util;

import java.util.HashMap;

public class Surroundings {

    public HashMap<String, String> infoMap;

    public Surroundings() {
        infoMap = new HashMap<>();
        infoMap.put("시간", "NONE");
        infoMap.put("날씨", "NONE");
        infoMap.put("계절", "NONE");
        infoMap.put("요일", "NONE");
    }
}