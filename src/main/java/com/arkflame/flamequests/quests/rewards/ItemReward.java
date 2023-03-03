package com.arkflame.flamequests.quests.rewards;

import java.util.Arrays;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class ItemReward extends Reward {
    // The item to reward
    private ItemStack item = null;

    @Override
    public void give(Player player) {
        // Clone the stack
        ItemStack clone = item.clone();

        // Give the stack
        Map<Integer, ItemStack> itemsLeft = player.getInventory().addItem(clone);

        // Check if there are items left
        if (!itemsLeft.isEmpty()) {
            // Get location of the player
            Location playerLocation = player.getLocation();

            // Get the world of the player
            World playerWorld = playerLocation.getWorld();

            // Iterate over left items
            for (ItemStack itemLeft : itemsLeft.values()) {
                // Drop left item in player position
                playerWorld.dropItem(playerLocation, itemLeft);
            }
        }
    }

    @Override
    public void load(String[] rawItem) {
        // Amount
        int amount = 1;

        // Check if amount was input
        if (rawItem.length > 1) {
            // The amount
            String rawAmount = rawItem[1];

            try {
                // Get the amount
                amount = Integer.parseInt(rawAmount);
            } catch (NumberFormatException ex) {
                // Ignore invalid number
            }
        }

        // Fix invalid amount
        if (amount < 1) {
            // Apply default amount
            amount = 1;
        }

        // Type
        Material type = null;

        // Check if type was input
        if (rawItem.length > 2) {
            // The type
            String rawType = rawItem[2].replace(" ", "_").toUpperCase();

            // Get the material of the type
            type = Material.getMaterial(rawType);
        }

        // Check if type is valid
        if (type == null) {
            // Default as stone
            type = Material.STONE;
        }

        // Create the item from type and amount
        item = new ItemStack(type, amount);

        // Check if data was input
        if (rawItem.length > 3) {
            // The data
            String rawData = rawItem[3];

            try {
                // Apply the data
                item.setDurability((short) Integer.parseInt(rawData));
            } catch (NumberFormatException ex) {
                // Ignore invalid number
            }
        }

        // Get the item meta
        ItemMeta meta = item.getItemMeta();

        // Check if displayname was input
        if (rawItem.length > 4) {
            // The displayname
            String rawDisplayName = rawItem[4];

            // Check if nameless
            if (!rawDisplayName.equals("Nameless")) {
                // Apply the display name
                meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', rawDisplayName));
            }
        }

        // Check if lore was input
        if (rawItem.length > 5) {
            // The lore
            String rawLore = rawItem[5];

            // Check if loreless
            if (!rawLore.equals("Loreless")) {
                // Apply the lore
                meta.setLore(Arrays.asList(ChatColor.translateAlternateColorCodes('&', rawLore).split(", ")));
            }
        }

        // Check if enchantments were input
        if (rawItem.length > 6) {
            // The enchantments
            String rawEnchantments = rawItem[6];

            // Check if enchantless
            if (!rawEnchantments.equals("Enchantless")) {
                // Iterate over enchantments
                for (String rawEnchantment : rawEnchantments.split(", ")) {
                    // Split name from level
                    String[] splitEnchantment = rawEnchantment.split(": ");
                    // Get the name
                    String enchantmentName = splitEnchantment[0].replace(" ", "_").toUpperCase();
                    // Get the raw level
                    String rawLevel = splitEnchantment[1];

                    // Get the enchantment
                    Enchantment enchantment = Enchantment.getByName(enchantmentName);

                    // Check if enchantment is valid
                    if (enchantment != null) {
                        // Level
                        int level = 1;

                        try {
                            // Get the level
                            level = Integer.parseInt(rawLevel);
                        } catch (NumberFormatException ex) {
                            // Ignore invalid number
                        }

                        // Check if level is valid
                        if (level >= 1) {
                            // Check if item is enchantment book
                            if (meta instanceof EnchantmentStorageMeta) {
                                // Add enchantment to enchantment book
                                ((EnchantmentStorageMeta) meta).addStoredEnchant(enchantment, level, true);
                            } else {
                                // Add enchantment to item
                                meta.addEnchant(enchantment, level, true);
                            }
                        }
                    }
                }
            }
        }

        // Set the meta of the item
        item.setItemMeta(meta);
    }
}
