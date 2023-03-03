package com.arkflame.flamequests.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.arkflame.flamequests.managers.QuestManager;
import com.arkflame.flamequests.quests.Quest;
import com.arkflame.flamequests.quests.rewards.Reward;

public class ExampleCommand implements CommandExecutor {
    private QuestManager questManager;

    public ExampleCommand(QuestManager questManager) {
        this.questManager = questManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("flamequests.admin")) {
            sender.sendMessage("No permission");
            return true;
        }

        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players");
            return true;
        }

        for (Quest quest : questManager.getQuests()) {
            for (Reward reward : quest.getRewards()) {
                reward.give((Player) sender);
            }
            break;
        }

        sender.sendMessage("Here are your items");

        return true;
    }
}
