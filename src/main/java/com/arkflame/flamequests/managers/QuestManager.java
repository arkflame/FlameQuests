package com.arkflame.flamequests.managers;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;

import com.arkflame.flamequests.quests.Quest;

public class QuestManager {
    private Map<String, Quest> quests = new HashMap<>();

    public void load(Configuration config) {
        // Get the section of the quests
        ConfigurationSection section = config.getConfigurationSection("quests");

        // Iterate over configured quests
        for (String questName : section.getKeys(false)) {
            // Get the section of the quest
            ConfigurationSection questSection = section.getConfigurationSection(questName);

            // Create the quest
            Quest quest = new Quest(questName);

            // Load the quest
            quest.load(questSection);

            // Register quest
            registerQuest(quest);
        }
    }

    public void registerQuest(Quest quest) {
        quests.put(quest.getName(), quest);
    }

    public void removeQuest(Quest quest) {
        removeQuest(quest.getName());
    }

    public void removeQuest(String name) {
        quests.remove(name);
    }

    public Map<String, Quest> getQuestMap() {
        return quests;
    }

    public Collection<Quest> getQuests() {
        return quests.values();
    }
}
