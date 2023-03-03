package com.arkflame.flamequests.quests.rewards;

import org.bukkit.entity.Player;

public abstract class Reward {
    // Give the reward to the player
    public abstract void give(Player player);

    // Load the reward data from splitted text
    public abstract void load(String[] rawObjective);
}
