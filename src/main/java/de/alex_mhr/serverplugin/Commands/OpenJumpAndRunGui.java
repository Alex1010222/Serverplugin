package de.alex_mhr.serverplugin.Commands;

import de.alex_mhr.serverplugin.JumpandRun.JumpandRunGUI;
import dev.jorel.commandapi.CommandAPICommand;

public class OpenJumpAndRunGui extends CommandAPICommand {
    public OpenJumpAndRunGui(String commandName) {
        super(commandName);

        executesPlayer((player, commandArguments) -> {
            JumpandRunGUI jumpandRunGUI = new JumpandRunGUI();
            jumpandRunGUI.GUI(player);

        });
    }
}
