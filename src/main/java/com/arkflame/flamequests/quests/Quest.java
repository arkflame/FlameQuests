package com.arkflame.flamequests.quests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import org.bukkit.configuration.ConfigurationSection;

import com.arkflame.flamequests.quests.objectives.BlockBreakObjective;
import com.arkflame.flamequests.quests.objectives.Objective;
import com.arkflame.flamequests.quests.rewards.ItemReward;
import com.arkflame.flamequests.quests.rewards.Reward;

public class Quest {
    // The name of the quest
    private String name;

    // The name to display of the quest
    private String displayName;

    // The first line of the lore to show for the quest
    private String lore;

    // Objectives to complete for this quest
    private List<Objective> objectives = new ArrayList<>();

    // Rewards to receive for this quest
    private Collection<Reward> rewards = new HashSet<>();

    public Quest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLore() {
        return lore;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public Collection<Reward> getRewards() {
        return rewards;
    }

    // Load this quest from it's section
    public void load(ConfigurationSection config) {
        loadDisplayName(config);
        loadLore(config);
        loadObjectives(config);
        loadRewards(config);
    }

    // Load the displayname from the section of this quest
    public void loadDisplayName(ConfigurationSection config) {
        this.displayName = config.getString("display-name");
    }

    // Load the lore from the section of this quest
    public void loadLore(ConfigurationSection config) {
        this.lore = config.getString("lore");
    }

    // Load the objectives from the section of this quest
    public void loadObjectives(ConfigurationSection config) {
        // Iterate over objective texts
        for (String textObjective : config.getStringList("objectives")) {
            // Dummy objective
            Objective objective = null;
            // Split the objective text by commas
            String[] rawObjective = textObjective.split("; ");

            // Check if there is atleast one value
            if (rawObjective.length > 0) {
                // The first value is the objective name
                String objectiveName = rawObjective[0];

                switch (objectiveName) {
                    // Block Break objective
                    case "Block Break": {
                        objective = new BlockBreakObjective();
                        break;
                    }
                    default: {
                        break;
                    }
                }

                // Check if the objective was created
                if (objective != null) {
                    // Load the objective
                    objective.load(rawObjective);
                    // Register objective listeners
                    objective.registerListeners();
                    // Add to the list of objectives
                    objectives.add(objective);
                }
            }
        }
    }

    // Load the objectives from the section of this quest
    public void loadRewards(ConfigurationSection config) {
        // Iterate over reward texts
        for (String textReward : config.getStringList("rewards")) {
            // Dummy reward
            Reward reward = null;
            // Split the reward text by commas
            String[] rawReward = textReward.split("; ");

            // Check if there is atleast one value
            if (rawReward.length > 0) {
                // The first value is the reward name
                String rewardName = rawReward[0];

                switch (rewardName) {
                    // Item reward
                    case "Item": {
                        reward = new ItemReward();
                        break;
                    }
                    default: {
                        break;
                    }
                }

                // Check if the reward was created
                if (reward != null) {
                    // Load the reward
                    reward.load(rawReward);
                    // Add to the list of rewards
                    rewards.add(reward);
                }
            }
        }
    }
}
