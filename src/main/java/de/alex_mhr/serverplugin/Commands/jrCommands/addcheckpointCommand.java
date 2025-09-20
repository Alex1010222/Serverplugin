package de.alex_mhr.serverplugin.Commands.jrCommands;

import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.Location;
import org.bukkit.Material;

public class addcheckpointCommand extends CommandAPICommand {
    public addcheckpointCommand(String commandName) {
        super(commandName);

        executesPlayer((player, commandArguments) -> {
            if (player.isOp()){
                Location loc = player.getLocation();

                loc.getBlock().setType(Material.GOLD_BLOCK);

                int newBlockX = loc.getBlockX();
                int blockY = loc.getBlockY() + 1;
                int blockZ = loc.getBlockZ();

                Location checkpointLoc = new Location(loc.getWorld(), newBlockX, blockY, blockZ);
                checkpointLoc.getBlock().setType(Material.LIGHT_WEIGHTED_PRESSURE_PLATE);

            }
        });
    }
}
