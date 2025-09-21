package de.alex_mhr.serverplugin.Navigator;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.CompassMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveNavigator implements Listener {
    @EventHandler
    public void onPlayerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        ItemStack compass = new ItemStack(Material.COMPASS);

        player.getInventory().clear();

        ItemMeta meta = compass.getItemMeta();
        meta.setDisplayName("§R§BNavigator");
        meta.setEnchantmentGlintOverride(true);
        compass.setItemMeta(meta);

        player.getInventory().setItem(4, compass);


    }
}
