package com.arkflame.flamequests.quests.objectives;

import java.util.Collection;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import com.arkflame.flamequests.utils.MaterialUtil;

public class BlockBreakObjective extends Objective {
    // The amount to break
    private int amount = 0;
    // The tools to use
    private Collection<Material> tools = null;
    // The blocks to break
    private Collection<Material> blocks = null;

    @Override
    public void load(String[] rawObjective) {
        // The amount to break
        String rawAmount = rawObjective[1];
        // The tool used to break
        String rawTool = rawObjective[2];
        // The block to break
        String rawBlock = rawObjective[3];

        // Apply the amount
        try {
            this.amount = Integer.parseInt(rawAmount);
        } catch (NumberFormatException ex) {
            // Ignore invalid number
        }

        // Apply the tools
        tools = MaterialUtil.getMaterialsByRawName(rawTool);

        // Apply the blocks
        blocks = MaterialUtil.getMaterialsByRawName(rawBlock);
    }

    public boolean isTool(ItemStack item) {
        return isTool(item.getType());
    }

    /**
     * 
     * @param type The type of the tool
     * @return If the tool applies to the objective
     */
    public boolean isTool(Material type) {
        return tools.contains(type);
    }

    public boolean isBlock(Block block) {
        return isBlock(block.getType());
    }

    /**
     * 
     * @param type The type of the block
     * @return If the block applies to the objective
     */
    public boolean isBlock(Material type) {
        return blocks.contains(type);
    }

    /**
     * 
     * @return The amount of times the objective has to be done
     */
    public int getAmount() {
        return amount;
    }
}
