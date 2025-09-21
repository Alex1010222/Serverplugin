package de.alex_mhr.serverplugin.JumpandRun.Gui;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import static de.alex_mhr.serverplugin.Commands.jrCommands.StartCommands.hardCommand.hardlocation;


public class JumpandRunStartHard {
    public static void start(Player player) {
        if (hardlocation != null) {
            player.getInventory().clear();
            player.setGameMode(GameMode.ADVENTURE);

            ItemStack bett = new ItemStack(Material.RED_BED);
            ItemMeta bedmeta = bett.getItemMeta();
            bedmeta.setDisplayName("§RKlicke zum aufgeben");
            bett.setItemMeta(bedmeta);
            player.getInventory().setItem(4, bett);

            player.teleportAsync(hardlocation);


            player.closeInventory();
        } else {
            player.sendMessage("§4 Es wurde noch kein Start festgelegt");
            player.closeInventory();
        }

    }
}
