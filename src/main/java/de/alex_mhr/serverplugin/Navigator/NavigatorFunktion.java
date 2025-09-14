package de.alex_mhr.serverplugin.Navigator;


import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import de.alex_mhr.serverplugin.Navigator.GiveNavigator;
import de.alex_mhr.serverplugin.Navigator.NavigatorGUI;

import javax.swing.*;

public class NavigatorFunktion implements Listener {
    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (player.getInventory().getItemInMainHand().getType() == Material.COMPASS) {
            if (action == Action.LEFT_CLICK_BLOCK ||
                    action == Action.LEFT_CLICK_AIR ||
                    action == Action.RIGHT_CLICK_AIR ||
                    action == Action.RIGHT_CLICK_BLOCK) {

                NavigatorGUI navigatorGUI = new NavigatorGUI();
                navigatorGUI.GUI(player);

            }
        }
    }
    @EventHandler
    public void ondieEvent(PlayerDeathEvent event) {
        var player = event.getPlayer();
        player.getInventory().clear();
    }
}
