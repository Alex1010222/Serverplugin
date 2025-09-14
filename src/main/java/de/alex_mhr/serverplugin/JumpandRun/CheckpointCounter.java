package de.alex_mhr.serverplugin.JumpandRun;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.*;

public class CheckpointCounter implements Listener {

    public static final Map<UUID, Integer> playerCounters = new HashMap<>();

    public static final Map<UUID, Set<Location>> ActivatedPlates = new HashMap<>();


    @EventHandler
    public void onInteractEvent(PlayerInteractEvent event) {
        var player = event.getPlayer();
        var action = event.getAction();
        var block = event.getClickedBlock();

        if (action != Action.PHYSICAL || block == null) return;

        var uuid = player.getUniqueId();
        var plateLocation = block.getLocation();
        var material = block.getType();
        var activated = ActivatedPlates.getOrDefault(uuid, new HashSet<>());

        if (material == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) {
            if (activated.contains(plateLocation)) return;

            activated.add(plateLocation);
            ActivatedPlates.put(uuid, activated); // speichern
            int count = playerCounters.getOrDefault(uuid, 0) + 1;
            playerCounters.put(uuid, count);

        }

        if (material == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {
            int count = playerCounters.getOrDefault(uuid, 0);
        }
    }
}