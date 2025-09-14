package de.alex_mhr.serverplugin.Commands;

import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveNavigatorCommand extends CommandAPICommand {
    public GiveNavigatorCommand(String commandName) {
        super(commandName);

        executesPlayer(((player, commandArguments) -> {
            ItemStack compass = new ItemStack(Material.COMPASS);
            ItemMeta meta = compass.getItemMeta();
            meta.setDisplayName("Navigator");
            meta.setEnchantmentGlintOverride(true);
            compass.setItemMeta(meta);

            player.getInventory().setItem(4, compass);

        }));
    }
}
