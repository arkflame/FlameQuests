package com.arkflame.flamequests.listeners.managers;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import com.arkflame.flamequests.listeners.BlockBreakListener;
import com.arkflame.flamequests.listeners.PlayerJoinListener;

public class ListenerManager {
    private BlockBreakListener blockBreakListener;
    private PlayerJoinListener playerJoinListener;

    public ListenerManager(Plugin plugin) {
        PluginManager pluginManager = plugin.getServer().getPluginManager();

        pluginManager.registerEvents(blockBreakListener = new BlockBreakListener(), plugin);
        pluginManager.registerEvents(playerJoinListener = new PlayerJoinListener(), plugin);
    }

    public BlockBreakListener getBlockBreakListener() {
        return blockBreakListener;
    }

    public PlayerJoinListener getPlayerJoinListener() {
        return playerJoinListener;
    }
}
