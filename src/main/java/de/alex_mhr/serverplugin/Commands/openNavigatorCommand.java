package de.alex_mhr.serverplugin.Commands;

import de.alex_mhr.serverplugin.Navigator.NavigatorGUI;
import dev.jorel.commandapi.CommandAPICommand;

public class openNavigatorCommand extends CommandAPICommand {
    public openNavigatorCommand(String commandName) {
        super(commandName);

        executesPlayer(((player, commandArguments) -> {
            NavigatorGUI navigatorGUI = new NavigatorGUI();
            navigatorGUI.GUI(player);
        }));
    }
}
