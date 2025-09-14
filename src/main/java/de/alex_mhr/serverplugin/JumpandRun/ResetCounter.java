package de.alex_mhr.serverplugin.JumpandRun;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.bukkit.event.block.Action.LEFT_CLICK_BLOCK;

public class ResetCounter implements Listener {

    public static final Map<UUID, Integer> playerresetcounter = new HashMap<>();

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        var player = event.getPlayer();
        var action = event.getAction();
        var uuid = player.getUniqueId();
        var block = event.getClickedBlock();

        if (player.getInventory().getItemInMainHand().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
            if (action == Action.LEFT_CLICK_BLOCK ||
                    action == Action.LEFT_CLICK_AIR ||
                    action == Action.RIGHT_CLICK_AIR ||
                    action == Action.RIGHT_CLICK_BLOCK) {
                int resetcount = playerresetcounter.getOrDefault(uuid, 0) + 1;
                playerresetcounter.put(uuid, resetcount);
            }
        }
        if (action == Action.PHYSICAL) {
            if (block.getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
                int resetcount = playerresetcounter.getOrDefault(uuid, 0);
            }
        }
    }
}
