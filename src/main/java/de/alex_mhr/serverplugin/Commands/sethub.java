package de.alex_mhr.serverplugin.Commands;

import dev.jorel.commandapi.CommandAPICommand;
import org.bukkit.Location;

public class sethub extends CommandAPICommand {

    public static Location hublocation;

    public sethub(String commandName) {
        super(commandName);
        executesPlayer((player, commandArguments) -> {
            var loc = player.getLocation();
            hublocation = loc;
        });
    }
}
