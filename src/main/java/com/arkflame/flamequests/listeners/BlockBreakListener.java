package com.arkflame.flamequests.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.arkflame.flamequests.managers.QuestManager;
import com.arkflame.flamequests.quests.Quest;
import com.arkflame.flamequests.quests.objectives.BlockBreakObjective;
import com.arkflame.flamequests.quests.objectives.Objective;

public class BlockBreakListener implements Listener {
    private QuestManager questManager;

    public BlockBreakListener(QuestManager questManager) {
        this.questManager = questManager;
    }

    @EventHandler(ignoreCancelled = true)
    public void blockBreakListener(BlockBreakEvent event) {
        // TODO: Cache block break objectives to optimize performance
        // Iterate over quests
        for (Quest quest : questManager.getQuests()) {
            // Iterate over objectives
            for (Objective objective : quest.getObjectives()) {
                // Check if objective is BlockBreak
                if (objective instanceof BlockBreakObjective) {
                    // TODO: Make player progress
                }
            }
        }
    }
}
