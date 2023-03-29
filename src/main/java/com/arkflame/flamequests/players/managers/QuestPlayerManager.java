package com.arkflame.flamequests.players.managers;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.arkflame.flamequests.players.QuestPlayer;

public class QuestPlayerManager {
    private Map<UUID, QuestPlayer> players = new ConcurrentHashMap<>();

    public QuestPlayer get(UUID uuid) {
        return players.getOrDefault(uuid, null);
    }

    public QuestPlayer create(UUID uuid) {
        QuestPlayer questPlayer = players.getOrDefault(uuid, new QuestPlayer());

        players.put(uuid, questPlayer);

        return questPlayer;
    }

    public void remove(UUID uuid) {
        players.remove(uuid);
    }
}
