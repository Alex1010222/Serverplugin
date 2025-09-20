package de.alex_mhr.serverplugin.Commands.jrCommands;

import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.Material;

public class setStart extends CommandAPICommand {
    public setStart(String commandName) {
        super(commandName);
        executesPlayer((player, commandArguments) -> {
            if (player.isOp()) {

                var loc = player.getLocation();
                loc.getBlock().setType(Material.EMERALD_BLOCK);
            }
        });
    }
}
