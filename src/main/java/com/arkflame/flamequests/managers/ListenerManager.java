package com.arkflame.flamequests.managers;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import com.arkflame.flamequests.listeners.BlockBreakListener;

public class ListenerManager {
    private BlockBreakListener blockBreakListener;

    public ListenerManager(Plugin plugin) {
        PluginManager pluginManager = plugin.getServer().getPluginManager();

        pluginManager.registerEvents(blockBreakListener = new BlockBreakListener(), plugin);
    }

    public BlockBreakListener getBlockBreakListener() {
        return blockBreakListener;
    }
}
