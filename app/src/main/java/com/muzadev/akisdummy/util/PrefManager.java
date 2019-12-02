package com.muzadev.akisdummy.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.muzadev.akisdummy.model.Guru;

public class PrefManager implements PrefRule {
    private SharedPreferences sharedPreferences;

    private static final String GURU = "GURU";

    public PrefManager(Context context) {
        sharedPreferences = context.getSharedPreferences("AKSIS", Context.MODE_PRIVATE);
    }

    @Override
    public void saveUser(Guru guru) {
        String json = new Gson().toJson(guru);
        sharedPreferences.edit().putString(GURU, json).apply();
    }

    @Override
    @Nullable
    public Guru getUser() {
        String json = sharedPreferences.getString(GURU, "");
        Guru guru = new Gson().fromJson(json, Guru.class);
        return guru;
    }

    @Override
    public void deleteGuru() {
        sharedPreferences.edit().remove(GURU).apply();
    }
}
