package de.alex_mhr.serverplugin.JumpandRun.Gui;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import de.alex_mhr.serverplugin.Navigator.NavigatorGUI;

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

        OutlinePane easy = new OutlinePane(1,1,1,1);


        ItemStack green = new ItemStack(Material.LIME_CONCRETE);
        ItemMeta grün = green.getItemMeta();
        grün.setDisplayName("§R§2Easy");
        grün.setLore(Collections.singletonList("§FFür Einsteiger – einfache Sprünge und Checkpoints"));
        green.setItemMeta(grün);

        GuiItem Auge = new GuiItem(green, inventoryClickEvent -> {
            inventoryClickEvent.getWhoClicked();
            JumpandRunStartEasy.start(player);
        });
        easy.addItem(Auge);
        gui.addPane(easy);


        OutlinePane middle = new OutlinePane(4,1,4,1);

        ItemStack middleItem = new ItemStack(Material.YELLOW_CONCRETE);
        ItemMeta mittel = middleItem.getItemMeta();
        mittel.setDisplayName("§R§eMiddle");
        mittel.setLore(Collections.singletonList("§FFür Fortgeschrittene – mehr Timing und Präzision"));
        middleItem.setItemMeta(mittel);

        GuiItem startmiddle = new GuiItem(middleItem, inventoryClickEvent -> {
            inventoryClickEvent.getWhoClicked();
            JumpandRunStartMiddle.start(player);
        });
        middle.addItem(startmiddle);
        gui.addPane(middle);


        OutlinePane hard = new OutlinePane(7,1,7,1);

        ItemStack red = new ItemStack(Material.RED_CONCRETE);
        ItemMeta rot = red.getItemMeta();
        rot.setDisplayName("§R§4Hard");
        rot.setLore(Collections.singletonList("§FNur für Profis – keine Checkpoints, schwierige Sprünge"));
        red.setItemMeta(rot);

        GuiItem starthard = new GuiItem(red, inventoryClickEvent -> {
            inventoryClickEvent.getWhoClicked();
            JumpandRunStartHard.start(player);
        });
        hard.addItem(starthard);
        gui.addPane(hard);


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
}