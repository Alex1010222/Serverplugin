package de.alex_mhr.serverplugin.JumpandRun.Gui;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static de.alex_mhr.serverplugin.Commands.jrCommands.StartCommands.hardCommand.hardlocation;

import static de.alex_mhr.serverplugin.Commands.jrCommands.StartCommands.EasyCommand.easylocation;

public class JumpandRunStartHard {
    public static void start(Player player) {
        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);

        ItemStack bett = new ItemStack(Material.RED_BED);
        ItemMeta bedmeta = bett.getItemMeta();
        bedmeta.setDisplayName("§RKlicke zum aufgeben");
        bett.setItemMeta(bedmeta);
        player.getInventory().setItem(4, bett);

        player.teleportAsync(hardlocation);


        player.closeInventory();

    }
}
