package de.alex_mhr.serverplugin.Commands;

import de.alex_mhr.serverplugin.Commands.jrCommands.addcheckpointCommand;
import de.alex_mhr.serverplugin.Commands.jrCommands.setStart;
import de.alex_mhr.serverplugin.Commands.jrCommands.setend;
import dev.jorel.commandapi.CommandAPICommand;

public class jrmainCommand extends CommandAPICommand {
    public jrmainCommand(String commandName) {
        super(commandName);

        withSubcommand(new addcheckpointCommand("addcheckpoint"));
        withSubcommand(new setend("setend")).register();
        withSubcommand(new setStart("setstart")).register();
    }
}
