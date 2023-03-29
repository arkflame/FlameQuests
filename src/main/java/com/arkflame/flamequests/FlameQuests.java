package com.arkflame.flamequests;

import org.bukkit.Server;
import org.bukkit.configuration.Configuration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import com.arkflame.flamequests.commands.ExampleCommand;
import com.arkflame.flamequests.listeners.managers.ListenerManager;
import com.arkflame.flamequests.quests.managers.QuestManager;
import com.arkflame.flamequests.tasks.ExampleTask;

public class FlameQuests extends JavaPlugin {
    @Override
    public void onEnable() {
        // Save default config
        this.saveDefaultConfig();

        // Get the config
        Configuration config = getConfig();

        // Get the server
        Server server = getServer();

        // Get the scheduler
        BukkitScheduler scheduler = server.getScheduler();

        // Set static instance
        instance = this;

        // Register listeners
        listenerManager = new ListenerManager(instance);

        // Create the quest manager
        questManager = new QuestManager();

        // Load the quest manager
        questManager.load(config);

        // Register the example command
        getCommand("example").setExecutor(new ExampleCommand(questManager));

        // Register the example task
        scheduler.runTaskTimer(this, new ExampleTask(), 20L, 20L);
    }

    // Instances for API
    private static FlameQuests instance;
    private static ListenerManager listenerManager;
    private static QuestManager questManager;

    // QuestManager getter for API
    public QuestManager getQuestManager() {
        return questManager;
    }

    // ListenerManager getter for API
    public ListenerManager getListenerManager() {
        return listenerManager;
    }

    // FlameQuests getter for API
    public static FlameQuests getInstance() {
        return instance;
    }
}