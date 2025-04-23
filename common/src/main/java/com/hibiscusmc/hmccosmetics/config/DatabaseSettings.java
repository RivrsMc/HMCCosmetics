package com.hibiscusmc.hmccosmetics.config;

import lombok.Getter;
import me.lojosho.shaded.configurate.ConfigurationNode;

public class DatabaseSettings {

    private static final String DATABASE_TYPE_PATH = "type";
    private static final String MYSQL_DATABASE_SETTINGS = "mysql";

    private static final String MYSQL_DATABASE = "database";
    private static final String DELAY_PATH = "delay";
    private static final String ENABLE_DELAY = "enabled";
    private static final String DELAY_LENGTH = "delay";

    @Getter
    private static String database;
    @Getter
    private static boolean enabledDelay;
    @Getter
    private static int delayLength;

    public static void load(ConfigurationNode source) {
        ConfigurationNode mySql = source.node(MYSQL_DATABASE_SETTINGS);

        database = mySql.node(MYSQL_DATABASE).getString();

        ConfigurationNode delay = source.node(DELAY_PATH);

        enabledDelay = delay.node(ENABLE_DELAY).getBoolean(false);
        delayLength = delay.node(DELAY_LENGTH).getInt(2);
    }

}
