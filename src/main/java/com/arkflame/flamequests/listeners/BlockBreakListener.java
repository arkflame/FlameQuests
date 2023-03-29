package com.arkflame.flamequests.listeners;

import java.util.Collection;
import java.util.HashSet;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import com.arkflame.flamequests.quests.objectives.BlockBreakObjective;
import com.arkflame.flamequests.quests.objectives.Objective;

public class BlockBreakListener implements Listener {
    private Collection<Objective> objectives = new HashSet<>();

    public void registerObjective(Objective objective) {
        objectives.add(objective);
    }

    @EventHandler(ignoreCancelled = true)
    public void blockBreakListener(BlockBreakEvent event) {
        // Iterate over objectives
        for (Objective objective : objectives) {
            // Check if objective is BlockBreak
            if (objective instanceof BlockBreakObjective) {
                // TODO: Make player progress
            }
        }
    }
}
