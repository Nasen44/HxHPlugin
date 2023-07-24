package fr.nasen.hxh.gui;

import fr.nasen.hxh.Main;
import fr.nasen.hxh.game.Game;
import fr.nasen.hxh.game.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GuiScenario implements Listener {
    public static Inventory inventory_scenario;
    final ItemStack vide = new ItemStack(Material.AIR, 1);
    final ItemStack addInventory = new ItemStack(Material.NETHER_STAR, 1);
    final ItemStack gris = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
    final ItemStack slime = new ItemStack(Material.SLIME_BALL, 1);
    final ItemStack magma = new ItemStack(Material.MAGMA_CREAM, 1);
    final ItemStack cateyes = new ItemStack(Material.EYE_OF_ENDER, 1);
     ItemStack pioche = new ItemStack(Material.DIAMOND_PICKAXE, 1);
    ItemStack fer = new ItemStack(Material.IRON_INGOT, 1);
    ItemStack bois = new ItemStack(Material.LOG, 1);
    ArrayList<String> lore_hastey = new ArrayList<String>();
    ArrayList<String> lore_cateyes = new ArrayList<String>();
    ArrayList<String> lore_timber = new ArrayList<String>();
    ArrayList<String> lore_cutclean = new ArrayList<String>();


    public GuiScenario(){

        inventory_scenario = Bukkit.createInventory(null,6*9 ,   "§2§lH§c§lX§2§lH§6§l-Scenario");
        ItemUtils.ItemDisplayName(pioche, ChatColor.DARK_RED + "HasteyBoys");
        ItemUtils.ItemDisplayName(fer, ChatColor.DARK_RED + "CutClean");
        ItemUtils.ItemDisplayName(bois, ChatColor.DARK_RED + "Timber");
        ItemUtils.ItemDisplayName(cateyes, ChatColor.DARK_RED + "CatEyes");
        ItemUtils.ItemEnchant(fer);
        ItemUtils.ItemEnchant(pioche);
        ItemUtils.ItemEnchant(cateyes);
        ItemUtils.ItemEnchant(bois);

        ItemMeta nethermeta = pioche.getItemMeta();
        ItemMeta fermeta = fer.getItemMeta();
        ItemMeta timbermeta = bois.getItemMeta();
        ItemMeta catmeta = cateyes.getItemMeta();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

            @Override
            public void run() {
                lore_hastey.clear();
                if(Game.HASTEY_BOYS){
                    lore_hastey.add("§aActivé");
                }else{
                    lore_hastey.add("§cDesactivé");
                }

                nethermeta.setLore(lore_hastey);
                inventory_scenario.getItem(10).setItemMeta(nethermeta);


                lore_cateyes.clear();
                if(Game.CATEYES){
                    lore_cateyes.add("§aActivé");
                }else{
                    lore_cateyes.add("§cDesactivé");
                }

                catmeta.setLore(lore_cateyes);
                inventory_scenario.getItem(13).setItemMeta(catmeta);

                lore_cutclean.clear();
                if(Game.CUTCLEAN){
                    lore_cutclean.add("§aActivé");
                }else{
                    lore_cutclean.add("§cDesactivé");
                }

                fermeta.setLore(lore_cutclean);
                inventory_scenario.getItem(11).setItemMeta(fermeta);


                lore_timber.clear();
                if(Game.TIMBER){
                    lore_timber.add("§aActivé");
                }else{
                    lore_timber.add("§cDesactivé");
                }

                timbermeta.setLore(lore_timber);
                inventory_scenario.getItem(12).setItemMeta(timbermeta);


            }
        }, 0, 0);

        this.inventory_scenario.setItem(0, gris );        this.inventory_scenario.setItem(9, gris );        this.inventory_scenario.setItem(18, gris );
        this.inventory_scenario.setItem(1, gris );        this.inventory_scenario.setItem(10, pioche );       this.inventory_scenario.setItem(19, vide );
        this.inventory_scenario.setItem(2, vide );        this.inventory_scenario.setItem(11, fer );       this.inventory_scenario.setItem(20, vide );
        this.inventory_scenario.setItem(3, vide );        this.inventory_scenario.setItem(12, bois );       this.inventory_scenario.setItem(21, vide );
        this.inventory_scenario.setItem(4, vide );        this.inventory_scenario.setItem(13, cateyes );       this.inventory_scenario.setItem(22, vide );
        this.inventory_scenario.setItem(5, vide );        this.inventory_scenario.setItem(14, vide );       this.inventory_scenario.setItem(23, vide );
        this.inventory_scenario.setItem(6, vide );        this.inventory_scenario.setItem(15, vide );       this.inventory_scenario.setItem(24, vide );
        this.inventory_scenario.setItem(7, gris );        this.inventory_scenario.setItem(16, vide );       this.inventory_scenario.setItem(25, vide );
        this.inventory_scenario.setItem(8, gris );        this.inventory_scenario.setItem(17, gris );       this.inventory_scenario.setItem(26, gris );




    }

    @EventHandler
    public void craftEvent(PrepareItemCraftEvent e) {

        if(Game.HASTEY_BOYS){

            if (e.getInventory().getResult().getType().equals(Material.DIAMOND_AXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.IRON_PICKAXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.STONE_PICKAXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.WOOD_PICKAXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.DIAMOND_PICKAXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.GOLD_AXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.GOLD_PICKAXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }

            if (e.getInventory().getResult().getType().equals(Material.GOLD_SPADE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }


            if (e.getInventory().getResult().getType().equals(Material.DIAMOND_AXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.IRON_AXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.STONE_AXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.WOOD_AXE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }

            if (e.getInventory().getResult().getType().equals(Material.DIAMOND_SPADE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.IRON_SPADE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.STONE_SPADE)) {

                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }
            if (e.getInventory().getResult().getType().equals(Material.WOOD_SPADE)) {



                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DIG_SPEED, 3);
                ItemUtils.ItemVeritableEnchant(e.getInventory().getResult(), Enchantment.DURABILITY, 3);
            }


        }

    }

    @EventHandler
    public void OnClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(inventory_scenario.getName())) {
            e.setCancelled(true);

            if(e.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)){

                if( Game.HASTEY_BOYS){
                    Game.HASTEY_BOYS = false;



                }else{
                    Game.HASTEY_BOYS = true;

                }

            }

            if(e.getCurrentItem().getType().equals(Material.IRON_INGOT)){

                if( Game.CUTCLEAN){
                    Game.CUTCLEAN = false;



                }else{
                    Game.CUTCLEAN = true;

                }

            }

            if(e.getCurrentItem().getType().equals(Material.LOG)){

                if( Game.TIMBER){
                    Game.TIMBER = false;



                }else{
                    Game.TIMBER = true;

                }

            }


            if(e.getCurrentItem().getType().equals(Material.EYE_OF_ENDER)){

                if( Game.CATEYES){
                    Game.CATEYES = false;



                }else{
                    Game.CATEYES = true;

                }

            }
        }

    }

    @EventHandler
    private void onBlockBreak(BlockBreakEvent e) {

        if(Game.TIMBER){
            this.dropTree(e.getBlock().getLocation());
        }
    }

    private void dropTree(Location location) {
        List<Block> blocks = new LinkedList();

        for(int i = location.getBlockY(); i < location.getWorld().getHighestBlockYAt(location.getBlockX(), location.getBlockZ()); ++i) {
            Location l = location.add(0.0D, 1.0D, 0.0D);
            if (l.getBlock().getType() != Material.LOG && l.getBlock().getType() != Material.LOG_2) {
                break;
            }

            blocks.add(l.getBlock());
            l = null;
        }

        Iterator var6 = blocks.iterator();

        while(var6.hasNext()) {
            Block block = (Block)var6.next();
            block.breakNaturally(new ItemStack(Material.DIAMOND_AXE));
        }

        blocks = null;
    }


}
