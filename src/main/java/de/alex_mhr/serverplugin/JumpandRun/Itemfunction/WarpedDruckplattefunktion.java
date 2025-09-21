package de.alex_mhr.serverplugin.JumpandRun.Itemfunction;

import de.alex_mhr.serverplugin.JumpandRun.Checkpoint;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import static de.alex_mhr.serverplugin.Commands.jrCommands.StartCommands.EasyCommand.easylocation;

public class WarpedDruckplattefunktion implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        //Wenn der Spieler in der Hand eine ... hat
        if (player.getInventory().getItemInMainHand().getType() == Material.WARPED_PRESSURE_PLATE) {
            //Wenn der Spieler Links- oder Rechtsklick macht
            if (action == Action.LEFT_CLICK_AIR ||
                    action == Action.RIGHT_CLICK_AIR ||
                    action == Action.LEFT_CLICK_BLOCK ||
                    action == Action.RIGHT_CLICK_BLOCK) {

                //Dadurch bekommt man die Postion des Checkponits aud einer anderen Class
                Location checkpoint = Checkpoint.getCheckpoint(player);

                if (checkpoint != null) {
                    //Der Spieler wird an die location telpotieren
                    player.teleportAsync(checkpoint);
                } else {
                    player.teleportAsync(easylocation);
                }
            }
        }
    }

}
