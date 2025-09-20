package de.alex_mhr.serverplugin.Commands.jrCommands.StartCommands;

import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.Material;

public class hardCommand extends CommandAPICommand {
    public hardCommand(String commandName) {
        super(commandName);

        executesPlayer((player, commandArguments) -> {

            if (player.isOp()) {

                var loc = player.getLocation();
                loc.getBlock().setType(Material.EMERALD_BLOCK);
            }
        });
    }
}
