package com.arkflame.flamequests.players;

import java.util.EnumMap;

import com.arkflame.flamequests.enums.QuestStatus;

public class QuestPlayer {
    /** Quests the player has made progress **/
    private EnumMap<QuestStatus, QuestProgress> quests = new EnumMap<>(QuestStatus.class);

    public void load() {
        // TODO: Load data from service
    }
}
