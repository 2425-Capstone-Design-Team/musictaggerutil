package com.tftf.util;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JsonConverter {

    static Gson gson = new Gson();


    public static JsonObject getJsonFromPlayHistory(PlayHistory history) {
        return gson.toJsonTree(history.historyMap).getAsJsonObject();
    }
    public static void setPlayHistoryFromJson(PlayHistory history, JsonObject jo) {
        Type type = new TypeToken<HashMap<String, HashMap<String, Long>>>() {
        }.getType();
        history.historyMap = gson.fromJson(jo, type);
        JsonParser jsonParser = new JsonParser();
    }



    public static JsonArray getJsonFromIntList(List<Integer> intList) {
        return gson.toJsonTree(intList).getAsJsonArray();
    }
    public static ArrayList<Integer> getIntListFromJson(JsonArray json) {
        Type type = new TypeToken<ArrayList<Integer>>() {
        }.getType();
        return gson.fromJson(json, type);
    }



    public static JsonArray getJsonFromListOfPlaylist(List<Playlist> listOfPlaylist) {
        return gson.toJsonTree(listOfPlaylist).getAsJsonArray();
    }
    public static ArrayList<Playlist> getListOfPlaylistFromJson(JsonArray json) {
        Type type = new TypeToken<ArrayList<Playlist>>() {
        }.getType();
        return gson.fromJson(json, type);
    }
}
