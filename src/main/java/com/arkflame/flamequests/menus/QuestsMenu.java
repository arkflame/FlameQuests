package com.arkflame.flamequests.menus;

import org.bukkit.Material;

import dev._2lstudios.interfacemaker.interfaces.InterfaceItem;
import dev._2lstudios.interfacemaker.interfaces.InterfaceMenu;

public class QuestsMenu extends InterfaceMenu {
    public QuestsMenu() {
        // Separator bar
        setItem(9, 17, new InterfaceItem().setName(" ").setType(Material.GLASS));
    }
}
