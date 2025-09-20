package de.alex_mhr.serverplugin.JumpandRun.Gui;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JumpandRunStartMiddle {
    public static void start(Player player) {
        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);

        ItemStack druckplatte = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
        ItemMeta meta4 = druckplatte.getItemMeta();
        meta4.setDisplayName("§RTeleportiert dich zum letzten Checkpoint");
        druckplatte.setItemMeta(meta4);
        player.getInventory().setItem(3, druckplatte);

        ItemStack bett = new ItemStack(Material.RED_BED);
        ItemMeta bedmeta = bett.getItemMeta();
        bedmeta.setDisplayName("§RKlicke zum aufgeben");
        bett.setItemMeta(bedmeta);
        player.getInventory().setItem(5, bett);

        Location JumpandRunlocation = new Location(Bukkit.getWorld("world"), -14.5, 86, -18.5);
        player.teleportAsync(JumpandRunlocation);


        player.closeInventory();
    }
}
