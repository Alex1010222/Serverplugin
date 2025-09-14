package de.alex_mhr.serverplugin.JumpandRun;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;
import de.alex_mhr.serverplugin.Navigator.NavigatorGUI;

import javax.swing.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JumpandRunGUI implements Listener {

    public static final Map<UUID, ItemStack> switchedItem = new HashMap<>();

    public void GUI(Player player) {
        var uuid = player.getUniqueId();

        ChestGui gui = new ChestGui(3, "Jump and Run");

        gui.setOnGlobalClick(inventoryClickEvent -> inventoryClickEvent.setCancelled(true));

        gui.getPanes().clear();

        OutlinePane background = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOWEST);
        background.addItem(new GuiItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE)));
        background.setRepeat(true);

        gui.addPane(background);

        OutlinePane Start = new OutlinePane(2,1,2,1);


        ItemStack Enderauge = new ItemStack(Material.ENDER_EYE);
        ItemMeta Eye = Enderauge.getItemMeta();
        Eye.setDisplayName("§R§BStart");
        Eye.setLore(Collections.singletonList("§FStarte das Jump and Run"));
        Enderauge.setItemMeta(Eye);

        GuiItem Auge = new GuiItem(Enderauge, inventoryClickEvent -> {
            inventoryClickEvent.getWhoClicked().getInventory().clear();

            player.setGameMode(GameMode.ADVENTURE);

            ItemStack druckplatte = new ItemStack(Material.HEAVY_WEIGHTED_PRESSURE_PLATE);
            ItemMeta meta4 = druckplatte.getItemMeta();
            meta4.setDisplayName("§RTeleportiert dich zum letzten Checkpoint");
            druckplatte.setItemMeta(meta4);
            player.getInventory().setItem(3, druckplatte);

            ItemStack bett = new ItemStack(Material.RED_BED);
            ItemMeta bedmeta = bett.getItemMeta();
            bedmeta.setDisplayName("§RKlicke zum aufgeben");
            bett.setItemMeta(bedmeta);
            player.getInventory().setItem(5, bett);

            Location JumpandRunlocation = new Location(Bukkit.getWorld("world"), -14.5, 86, -18.5);
            player.teleportAsync(JumpandRunlocation);


            player.closeInventory();
            JumpandRunGUI jumpandRunGUI = new JumpandRunGUI();
            jumpandRunGUI.GUI(player);
        });
        Start.addItem(Auge);
        gui.addPane(Start);

        OutlinePane Backbutton = new OutlinePane(0,2,1,1);

        ItemStack Back = new ItemStack(Material.ARROW);
        ItemMeta Pfeil = Back.getItemMeta();
        Pfeil.setDisplayName("§RZurück");
        Back.setItemMeta(Pfeil);

        GuiItem Zurück = new GuiItem(Back, event -> {
           event.getWhoClicked();

           NavigatorGUI navigatorGUI = new NavigatorGUI();
           navigatorGUI.GUI(player);

        });

        Backbutton.addItem(Zurück);
        gui.addPane(Backbutton);

        gui.show(player);
    }
    @EventHandler
    public void onQuitEvent(PlayerQuitEvent event) {
        var player = event.getPlayer();
        switchedItem.remove(player);
    }
}
