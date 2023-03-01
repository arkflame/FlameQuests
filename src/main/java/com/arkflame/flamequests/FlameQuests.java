package com.arkflame.flamequests;

import org.bukkit.plugin.java.JavaPlugin;

import com.arkflame.flamequests.commands.ExampleCommand;
import com.arkflame.flamequests.listeners.PlayerJoinListener;
import com.arkflame.flamequests.tasks.ExampleTask;

public class FlameQuests extends JavaPlugin {
    
    @Override
    public void onEnable () {
        // Save default config
        this.saveDefaultConfig();

        // Set static instance
        FlameQuests.instance = this;

        // Register the example command
        this.getCommand("example").setExecutor(new ExampleCommand());
        
        // Register the example listener
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);

        // Register the example task
        final long taskRepeatEvery = this.getConfig().getInt("task-repeat-every") * 20L;
        this.getServer().getScheduler().runTaskTimer(this, new ExampleTask(), taskRepeatEvery, taskRepeatEvery);
    }

    private static FlameQuests instance;

    public static FlameQuests getInstance () {
        return FlameQuests.instance;
    }
}