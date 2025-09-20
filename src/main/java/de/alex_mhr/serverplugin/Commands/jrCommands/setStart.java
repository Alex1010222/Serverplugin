package de.alex_mhr.serverplugin.Commands.jrCommands;

import de.alex_mhr.serverplugin.Commands.jrCommands.StartCommands.EasyCommand;
import de.alex_mhr.serverplugin.Commands.jrCommands.StartCommands.hardCommand;
import de.alex_mhr.serverplugin.Commands.jrCommands.StartCommands.middleCommand;
import dev.jorel.commandapi.CommandAPICommand;

public class setStart extends CommandAPICommand {
    public setStart(String commandName) {
        super(commandName);

        withSubcommand(new EasyCommand("easy")).register();
        withSubcommand(new middleCommand("middle")).register();
        withSubcommand(new hardCommand("hard")).register();
    }
}
