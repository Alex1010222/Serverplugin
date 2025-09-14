package de.alex_mhr.serverplugin.Navigator;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.gui.type.util.Gui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import de.alex_mhr.serverplugin.JumpandRun.JumpandRunGUI;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class NavigatorGUI {
    public void GUI(Player player){
        ChestGui gui = new ChestGui(5,"Navigatormeü");

        OutlinePane background = new OutlinePane(0, 0, 9, 5, Pane.Priority.LOWEST);
        background.addItem(new GuiItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE)));
        background.setRepeat(true);

        gui.addPane(background);

        gui.setOnGlobalClick(event -> event.setCancelled(true));

        OutlinePane Spawn = new OutlinePane(4,1,4,1);

        ItemStack Grassblock = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta meta = Grassblock.getItemMeta();
        meta.setDisplayName("§r§BHub");
        meta.setLore(Collections.singletonList("§FTelepotiert dich zum Hub"));
        Grassblock.setItemMeta(meta);

        GuiItem spawn = new GuiItem(Grassblock,event -> {
            event.getWhoClicked().sendRichMessage("<green>Du wurdest zum Hub telepotiert</green>");

            Location location = new Location(Bukkit.getWorld("world"), 0.5, 64, 0.5);
            player.teleportAsync(location);
            player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 1.0f);
        });
        Spawn.addItem(spawn);
        gui.addPane(Spawn);



        OutlinePane JumpandRun = new OutlinePane(7,1,7,1);
        ItemStack Star = new ItemStack(Material.NETHER_STAR);
        ItemMeta meta3 = Star.getItemMeta();
        meta3.setDisplayName("§RJump and Run");
        meta3.setLore(Collections.singletonList("§FÖffne das Menü für das Jump and Run"));
        Star.setItemMeta(meta3);

        GuiItem NetherStar = new GuiItem(Star, event -> {
            event.getWhoClicked();

            JumpandRunGUI jumpandRunGUI = new JumpandRunGUI();
            jumpandRunGUI.GUI(player);

        });

        JumpandRun.addItem(NetherStar);
        gui.addPane(JumpandRun);

        gui.show(player);

    }
}
