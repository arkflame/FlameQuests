package com.arkflame.flamequests.tasks;

import org.bukkit.Bukkit;

import com.arkflame.flamequests.FlameQuests;

public class ExampleTask implements Runnable {
    @Override
    public void run() {
        final String message = FlameQuests.getInstance().getConfig().getString("messages.from-task");
        Bukkit.getServer().broadcastMessage(message);
    }
}