package com.muzadev.akisdummy.util;

import com.muzadev.akisdummy.model.Guru;

public interface PrefRule {
    void saveUser(Guru guru);
    void deleteGuru();
    Guru getUser();
}
