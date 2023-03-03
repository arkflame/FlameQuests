package com.arkflame.flamequests.utils;

import java.util.Collection;
import java.util.HashSet;

import org.bukkit.Material;

public class MaterialUtil {
    public static void addMaterial(Collection<Material> materials, String materialName) {
        addMaterial(materials, Material.getMaterial(materialName));
    }

    public static void addMaterial(Collection<Material> materials, Material material) {
        // Check if material exists
        if (material != null) {
            // Add the material
            materials.add(material);
        }
    }

    public static Collection<Material> getMaterialsByRawName(String rawName) {
        // Create the collection to return
        Collection<Material> materials = new HashSet<>();

        // Uppercase in case is used as a material
        rawName = rawName.toUpperCase();

        switch (rawName) {
            case "PICKAXE": {
                // Add the variants of pickaxes
                addMaterial(materials, "WOODEN_PICKAXE");
                addMaterial(materials, "WOOD_PICKAXE");
                addMaterial(materials, "GOLDEN_PICKAXE");
                addMaterial(materials, "GOLD_PICKAXE");
                addMaterial(materials, "STONE_PICKAXE");
                addMaterial(materials, "IRON_PICKAXE");
                addMaterial(materials, "DIAMOND_PICKAXE");
                addMaterial(materials, "NETHERITE_PICKAXE");
            }
            case "STONES": {
                // Add the variants of stone
                materials.add(Material.STONE);
                materials.add(Material.DIAMOND_ORE);
                materials.add(Material.IRON_ORE);
                materials.add(Material.GOLD_ORE);
                materials.add(Material.COAL_ORE);
                materials.add(Material.LAPIS_ORE);
                materials.add(Material.EMERALD_ORE);
                materials.add(Material.REDSTONE_ORE);
            }
            default: {
                // Get material by raw name
                Material material = Material.getMaterial(rawName);

                // Check if material by raw name exists
                if (material != null) {
                    // Add material by raw name
                    materials.add(material);
                }
                break;
            }
        }

        return materials;
    }
}
