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
            double x = loc.getX();
            double y = loc.getY();
            double z = loc.getZ();

            player.sendMessage("§aDer Hub wurde bei §b " + Math.round(x) + ", " + Math.round(y) + ", " + Math.round(z) + " §agesetzt");
        });
    }
}
