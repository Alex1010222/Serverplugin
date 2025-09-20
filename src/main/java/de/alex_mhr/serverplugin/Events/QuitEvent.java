package de.alex_mhr.serverplugin.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import static de.alex_mhr.serverplugin.JumpandRun.Checkpoint.*;
import static de.alex_mhr.serverplugin.JumpandRun.Gui.JumpandRunGUI.switchedItem;

public class QuitEvent implements Listener{

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        var uuid = player.getUniqueId();

        playerCheckpoint.remove(player);
        activatedPlates.remove(uuid);
        switchedItem.remove(uuid);


    }
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        var player = event.getPlayer();

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard empty = manager.getNewScoreboard();
        player.setScoreboard(empty);
    }
}
