package de.alex_mhr.serverplugin.JumpandRun.Itemfunction;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static de.alex_mhr.serverplugin.JumpandRun.Checkpoint.playerCheckpoint;
import static de.alex_mhr.serverplugin.JumpandRun.Checkpoint.activatedPlates;

public class Bettfunktion implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack compass = new ItemStack(Material.COMPASS);
        var uuid = player.getUniqueId();

        // Erstellen einer Meta
        ItemMeta meta = compass.getItemMeta();
        //Setzt den Namen des
        meta.setDisplayName("Navigator");
        //Zeigt an, dass das Item verzaubert isz
        meta.setEnchantmentGlintOverride(true);
        //Setzt die meta
        compass.setItemMeta(meta);

        //Wenn der Spielr in der Hand ein Rotes Bett hat
        if (player.getInventory().getItemInMainHand().getType() == Material.RED_BED) {
            //Wenn der Spieler Links- oder Rechtsklick macht
            if (action == Action.LEFT_CLICK_AIR ||
                    action == Action.RIGHT_CLICK_AIR ||
                    action == Action.LEFT_CLICK_BLOCK ||
                    action == Action.RIGHT_CLICK_BLOCK) {

                player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

                //das Inventar wird aufgerufen und anschließend geclearz
                player.getInventory().clear();

                //die location wird dadurch festgelegt
                Location location = new Location(Bukkit.getWorld("world"), 0.5, 64, 0.5);
                //der Spieler wird an die Location telepotiert
                player.teleportAsync(location);
                //Der Spieler bekommt an den 4 Slot des Inventars einen Komppas von Itenstack
                player.getInventory().setItem(4,compass);

                //Die hashmap wird von dem Spieler gelöscht
                playerCheckpoint.remove(player);
                activatedPlates.remove(uuid);


                //Wenn der Spieler OP hat
                if (player.isOp()) {
                    //wird der spieler in Crativ gedetzt
                    player.setGameMode(GameMode.CREATIVE);
                }

            }
        }
    }
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack Compass = event.getCurrentItem();
        if (Compass != null && Compass.getType() == Material.RED_BED){
            if (!player.isOp()) {
                event.setCancelled(true);
            }
        }
    }
}
