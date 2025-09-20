package de.alex_mhr.serverplugin;

import de.alex_mhr.serverplugin.Commands.GiveNavigatorCommand;
import de.alex_mhr.serverplugin.Events.NonOpEvents;
import de.alex_mhr.serverplugin.Events.QuitEvent;
import de.alex_mhr.serverplugin.JumpandRun.*;
import de.alex_mhr.serverplugin.JumpandRun.Gui.JumpandRunGUI;
import de.alex_mhr.serverplugin.JumpandRun.Itemfunction.Bettfunktion;
import de.alex_mhr.serverplugin.JumpandRun.Itemfunction.Druckplattefunktion;
import de.alex_mhr.serverplugin.Navigator.GiveNavigator;
import de.alex_mhr.serverplugin.Navigator.NavigatorFunktion;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import de.alex_mhr.serverplugin.Commands.jrmainCommand;

public final class Serverplugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic



        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new GiveNavigator(), this);
        pluginManager.registerEvents(new NavigatorFunktion(), this);
        pluginManager.registerEvents(new NonOpEvents(), this);

        pluginManager.registerEvents(new QuitEvent(), this);

        //Alles für das Jump and Run
        pluginManager.registerEvents(new Bettfunktion(), this);
        pluginManager.registerEvents(new Druckplattefunktion(), this);
        pluginManager.registerEvents(new Checkpoint(), this);
        pluginManager.registerEvents(new Ziel(), this);
        pluginManager.registerEvents(new JumpandRunGUI(), this);

        // Nur Commands
        new GiveNavigatorCommand("Navigator").register();

        new jrmainCommand("jr").register();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
