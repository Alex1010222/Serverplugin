package de.alex_mhr.serverplugin.Commands.jrCommands.StartCommands;

import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.Location;
import org.bukkit.Material;

public class middleCommand extends CommandAPICommand {

    public static Location middlelocation;

    public middleCommand(String commandName) {
        super(commandName);
        executesPlayer((player, commandArguments) -> {

            if (player.isOp()) {

                var loc = player.getLocation();
                var newlo = player.getLocation().add(0,1,0);
                loc.getBlock().setType(Material.EMERALD_BLOCK);

                middlelocation = newlo;

            }
        });
    }
}
