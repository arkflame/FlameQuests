package com.arkflame.flamequests.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void blockBreakListener(BlockBreakEvent event) {
        // TODO: Iterate over players
        // TODO: Get the current quests
        // TODO: Iterate over objectives
        // TODO: Make the player progress
    }
}
