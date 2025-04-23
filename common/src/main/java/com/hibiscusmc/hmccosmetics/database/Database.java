package com.hibiscusmc.hmccosmetics.database;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.bukkit.entity.Player;

import com.hibiscusmc.hmccosmetics.database.types.Data;
import com.hibiscusmc.hmccosmetics.database.types.MySQLData;
import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import com.hibiscusmc.hmccosmetics.user.CosmeticUsers;

import lombok.Getter;

public class Database {

    @Getter
    private static Data data;
    private static final MySQLData MYSQL_DATA = new MySQLData();

    public Database() {
        data = MYSQL_DATA;

        setup();
    }

    public static void setup() {
        data.setup();
    }

    public static void save(CosmeticUser user) {
        data.save(user);
    }

    public static void save(Player player) {
        data.save(CosmeticUsers.getUser(player));
    }

    public static CompletableFuture<UserData> get(UUID uniqueId) {
        return data.get(uniqueId);
    }

    public static void clearData(UUID uniqueId) {
        data.clear(uniqueId);
    }
}
