package de.alex_mhr.serverplugin.JumpandRun;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

import de.alex_mhr.serverplugin.JumpandRun.CheckpointCounter;

import static de.alex_mhr.serverplugin.JumpandRun.Checkpoint.playerCheckpoint;
import static de.alex_mhr.serverplugin.JumpandRun.Checkpoint.activatedPlates;
import static de.alex_mhr.serverplugin.JumpandRun.CheckpointCounter.playerCounters;
import static de.alex_mhr.serverplugin.JumpandRun.CheckpointCounter.ActivatedPlates;
import static de.alex_mhr.serverplugin.JumpandRun.ResetCounter.playerresetcounter;

public class Ziel implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack compass = new ItemStack(Material.COMPASS);
        var uuid = player.getUniqueId();

        // Erstellen einer Meta
        ItemMeta meta = compass.getItemMeta();
        //Setzt den Namen des Items
        meta.setDisplayName("Navigator");
        //Zeigt an, dass das Item verzaubert isz
        meta.setEnchantmentGlintOverride(true);
        //Setzt die meta
        compass.setItemMeta(meta);

        //Wemm eine bestimmte Druckplatte activiiert wir
        if (action == Action.PHYSICAL && event.getClickedBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE) {

            //die location wird dadurch festgelegt
            Location location = new Location(Bukkit.getWorld("world"), 0.5, 64, 0.5);
            //der Spieler wird an die Location telepotiert
            player.teleportAsync(location);

            // an der Position des Spielers wird der Sound abgespielt
            player.playSound(location, Sound.ENTITY_PLAYER_LEVELUP, 1, 2);

            //das Inventar wird aufgerufen und anschließend gecleart
            player.getInventory().clear();
            //Der Spieler bekommt an den 4 Slot des Inventars einen Komppas von Itenstack
            player.getInventory().setItem(4, compass);

            //Wenn der Spieler OP hat
            if (player.isOp()) {
                //wird der spieler in Crativ gedetzt
                player.setGameMode(GameMode.CREATIVE);
            }

            //Die hashmap wird von dem Spieler gelöscht
            playerCheckpoint.remove(player);
            activatedPlates.remove(uuid);
            playerCounters.remove(uuid);
            ActivatedPlates.remove(uuid);
            playerresetcounter.remove(uuid);

        }
    }
}