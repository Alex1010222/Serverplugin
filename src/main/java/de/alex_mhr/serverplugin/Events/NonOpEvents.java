package de.alex_mhr.serverplugin.Events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class NonOpEvents implements Listener {
    @EventHandler
    public void DropEvent(PlayerDropItemEvent event) {
        var player = event.getPlayer();
        if (!player.isOp()) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (player.getInventory().getItemInMainHand().getType() == Material.COMPASS
                || player.getInventory().getItemInMainHand().getType() == Material.RED_BED
                || player.getInventory().getItemInMainHand().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
            return;
        }
        if (action == Action.LEFT_CLICK_BLOCK ||
                action == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().getType() == Material.COMPASS
                    || player.getInventory().getItemInMainHand().getType() == Material.RED_BED
                    || player.getInventory().getItemInMainHand().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
                return;
            }
            if (player.isOp()) {
                return;
            }
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onCommandNonOp(PlayerCommandSendEvent event) {
        Player player = event.getPlayer();
        if (!player.isOp()) {
            player.setGameMode(GameMode.SURVIVAL);
        }
    }

    @EventHandler
    public void onCommandOp(PlayerCommandSendEvent event) {
        Player player = event.getPlayer();
        if (player.isOp()) {
            player.setGameMode(GameMode.CREATIVE);
        }
    }
}