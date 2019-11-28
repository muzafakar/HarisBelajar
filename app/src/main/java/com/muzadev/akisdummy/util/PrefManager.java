package com.muzadev.akisdummy.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.muzadev.akisdummy.model.Guru;

public class PrefManager implements PrefRule {
    private Context context;
    private SharedPreferences sharedPreferences;

    private static final String GURU = "GURU";

    public PrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("AKSIS", Context.MODE_PRIVATE);
    }

    @Override
    public void saveUser(Guru guru) {
        String json = new Gson().toJson(guru);
        sharedPreferences.edit().putString(GURU, json).apply();
    }

    @Override
    public Guru getUser() {
        String json = sharedPreferences.getString(GURU, "");
        Guru guru = new Gson().fromJson(json, Guru.class);
        return guru;
    }
}
