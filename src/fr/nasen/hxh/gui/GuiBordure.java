package fr.nasen.hxh.gui;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;

import java.util.ArrayList;
import java.util.List;


public class GuiBordure implements Listener {
    public static Inventory inventory_bordure;
    final ItemStack vide = new ItemStack(Material.AIR, 1);
    final ItemStack vert = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
    final ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
    final ItemStack bordure = new ItemStack(Material.PRISMARINE_SHARD, 1);
    ItemStack banner = new ItemStack(Material.BANNER, 1);
    public GuiBordure(){
        inventory_bordure = Bukkit.createInventory(null,3*9 ,   "§2§lH§c§lX§2§lH§6§l-Bordure");

        BannerMeta m = (BannerMeta)banner.getItemMeta(); //Create the BannerMeta of the banner. A BannerMeta is contains the same features as a normal ItemMeta, but it also has custom functions for Banners.

        m.setBaseColor(DyeColor.WHITE);  //Set the base color(background color) to white, just like in the Pokéball example.
        List<Pattern> patterns = new ArrayList<Pattern>();
//
        patterns.add(new Pattern(DyeColor.BLACK, PatternType.STRAIGHT_CROSS));
        patterns.add(new Pattern(DyeColor.WHITE, PatternType.BORDER));
        patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_TOP));
        patterns.add(new Pattern(DyeColor.WHITE, PatternType.STRIPE_BOTTOM));
//

        m.setPatterns(patterns);
        banner.setItemMeta(m);
        this.inventory_bordure.setItem(0, red );         this.inventory_bordure.setItem(9, vert );         this.inventory_bordure.setItem(18, red );
        this.inventory_bordure.setItem(1, red );          this.inventory_bordure.setItem(10, vide );       this.inventory_bordure.setItem(19, red );
        this.inventory_bordure.setItem(2, red );         this.inventory_bordure.setItem(11, vide );       this.inventory_bordure.setItem(20, red );
        this.inventory_bordure.setItem(3, red );         this.inventory_bordure.setItem(12, banner );       this.inventory_bordure.setItem(21, red );
        this.inventory_bordure.setItem(4, red );         this.inventory_bordure.setItem(13, bordure );       this.inventory_bordure.setItem(22, red );
        this.inventory_bordure.setItem(5, red );         this.inventory_bordure.setItem(14, vide );       this.inventory_bordure.setItem(23, red );
        this.inventory_bordure.setItem(6, red );         this.inventory_bordure.setItem(15, vide );       this.inventory_bordure.setItem(24, red );
        this.inventory_bordure.setItem(7, red );          this.inventory_bordure.setItem(16, vide );       this.inventory_bordure.setItem(25, red );
        this.inventory_bordure.setItem(8, red );         this.inventory_bordure.setItem(17, vert );        this.inventory_bordure.setItem(26, red );
    }
    @EventHandler
    public void OnClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(inventory_bordure.getName())) {
            e.setCancelled(true);


        }
    }

        }
