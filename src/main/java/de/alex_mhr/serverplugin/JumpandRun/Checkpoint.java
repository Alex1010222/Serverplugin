package de.alex_mhr.serverplugin.JumpandRun;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.*;

public class Checkpoint implements Listener {
    public static final Map<Player, Location> playerCheckpoint = new HashMap<>();
    public static final Map<UUID, Set<Location>> activatedPlates = new HashMap<>();

    public static Location getCheckpoint(Player player) {
        return playerCheckpoint.get(player);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        UUID uuid = player.getUniqueId();
        
        Location plateLocation = event.getClickedBlock() != null ? event.getClickedBlock().getLocation() : null;

        if (action == Action.PHYSICAL && event.getClickedBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) {

            // Spieler-spezifische Platte holen
            Set<Location> playerPlates = activatedPlates.getOrDefault(uuid, new HashSet<>());

            // Wenn Spieler die Platte schon aktiviert hat → nichts tun
            if (playerPlates.contains(plateLocation)) return;

            // Platte registrieren
            playerPlates.add(plateLocation);
            activatedPlates.put(uuid, playerPlates);

            // Checkpoint setzen
            playerCheckpoint.put(player, player.getLocation());

            playerCheckpoint.put(player, player.getLocation());

            player.sendTitle("§6Checkpoint", "",10,20,10);
            player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 2);


        }
    }
}
