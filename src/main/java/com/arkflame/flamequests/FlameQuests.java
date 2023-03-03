package com.arkflame.flamequests;

import org.bukkit.Server;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.arkflame.flamequests.commands.ExampleCommand;
import com.arkflame.flamequests.listeners.BlockBreakListener;
import com.arkflame.flamequests.managers.QuestManager;
import com.arkflame.flamequests.tasks.ExampleTask;

public class FlameQuests extends JavaPlugin {
    @Override
    public void onEnable () {
        // Save default config
        this.saveDefaultConfig();

        // Get the config
        Configuration config = getConfig();

        // Get the server
        Server server = getServer();

        // Get the plugin manger
        PluginManager pluginManager = server.getPluginManager();

        // Get the scheduler
        BukkitScheduler scheduler = server.getScheduler();

        // Set static instance
        instance = this;

        // Create the quest manager
        questManager = new QuestManager();

        // Load the quest manager
        questManager.load(config);

        // Register the example command
        getCommand("example").setExecutor(new ExampleCommand(questManager));
        
        // Register the example listener
        pluginManager.registerEvents(new BlockBreakListener(questManager), this);

        // Register the example task
        scheduler.runTaskTimer(this, new ExampleTask(), 20L, 20L);
    }

    private static FlameQuests instance;
    private static QuestManager questManager;

    public QuestManager getQuestManager() {
        return questManager;
    }

    public static FlameQuests getInstance () {
        return FlameQuests.instance;
    }
}