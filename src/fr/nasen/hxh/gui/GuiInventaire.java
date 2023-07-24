package fr.nasen.hxh.gui;

import fr.nasen.hxh.ChatUtils;
import fr.nasen.hxh.Main;
import fr.nasen.hxh.game.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static fr.nasen.hxh.gui.GuiConfig.inventory_config;

public class GuiInventaire implements Listener {
    public static Inventory inventory_inventaire;
    final ItemStack vide = new ItemStack(Material.AIR, 1);
    final ItemStack addInventory = new ItemStack(Material.NETHER_STAR, 1);
    final ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
    final ItemStack slime = new ItemStack(Material.SLIME_BALL, 1);
    final ItemStack magma = new ItemStack(Material.MAGMA_CREAM, 1);
    public GuiInventaire(){
        inventory_inventaire = Bukkit.createInventory(null,6*9 ,   "§2§lH§c§lX§2§lH§6§l-Inventaire");

        this.inventory_inventaire.setItem(0, vide );        this.inventory_inventaire.setItem(9, vide );         this.inventory_inventaire.setItem(18, vide );
        this.inventory_inventaire.setItem(1, vide );         this.inventory_inventaire.setItem(10, vide );       this.inventory_inventaire.setItem(19, vide );
        this.inventory_inventaire.setItem(2, vide );        this.inventory_inventaire.setItem(11, vide );       this.inventory_inventaire.setItem(20, vide );
        this.inventory_inventaire.setItem(3, vide );        this.inventory_inventaire.setItem(12, vide );       this.inventory_inventaire.setItem(21, vide );
        this.inventory_inventaire.setItem(4, vide );        this.inventory_inventaire.setItem(13, vide );       this.inventory_inventaire.setItem(22, vide );
        this.inventory_inventaire.setItem(5, vide );        this.inventory_inventaire.setItem(14, vide );       this.inventory_inventaire.setItem(23, vide );
        this.inventory_inventaire.setItem(6, vide );        this.inventory_inventaire.setItem(15, vide );       this.inventory_inventaire.setItem(24, vide );
        this.inventory_inventaire.setItem(7, vide );         this.inventory_inventaire.setItem(16, vide );       this.inventory_inventaire.setItem(25, vide );
        this.inventory_inventaire.setItem(8, vide );        this.inventory_inventaire.setItem(17, vide );        this.inventory_inventaire.setItem(26, vide );

        this.inventory_inventaire.setItem(27, vide );           this.inventory_inventaire.setItem(36, red );        this.inventory_inventaire.setItem(45, vide );
        this.inventory_inventaire.setItem(28, vide );           this.inventory_inventaire.setItem(37, red );       this.inventory_inventaire.setItem(46, vide );
        this.inventory_inventaire.setItem(29, vide );           this.inventory_inventaire.setItem(38, red );       this.inventory_inventaire.setItem(47, vide );
        this.inventory_inventaire.setItem(30, vide );           this.inventory_inventaire.setItem(39, red );       this.inventory_inventaire.setItem(48, vide );
        this.inventory_inventaire.setItem(31, vide );           this.inventory_inventaire.setItem(40, red );       this.inventory_inventaire.setItem(49, vide );
        this.inventory_inventaire.setItem(32, vide );           this.inventory_inventaire.setItem(41, red );       this.inventory_inventaire.setItem(50, vide );
        this.inventory_inventaire.setItem(33, vide );           this.inventory_inventaire.setItem(42, red );       this.inventory_inventaire.setItem(51, vide );
        this.inventory_inventaire.setItem(34, vide );           this.inventory_inventaire.setItem(43, red );       this.inventory_inventaire.setItem(52, vide);
        this.inventory_inventaire.setItem(35, vide );           this.inventory_inventaire.setItem(44, red );        this.inventory_inventaire.setItem(53, addInventory );
    }

    @EventHandler
    public void OnClickEvent(InventoryClickEvent e)
    {
        Player player = (Player) e.getWhoClicked();
        if(e.getInventory().getName().equals(inventory_inventaire.getName())) {
            e.setCancelled(true);


            if (e.getCurrentItem().isSimilar(addInventory)) {

                if (!Main.isInventory) {
                    Main.isInventory = true;
                    player.closeInventory();

                    player.getInventory().setItem(0, inventory_inventaire.getItem(27));
                    player.getInventory().setItem(1, inventory_inventaire.getItem(28));
                    player.getInventory().setItem(2, inventory_inventaire.getItem(29));
                    player.getInventory().setItem(3, inventory_inventaire.getItem(30));
                    player.getInventory().setItem(4, inventory_inventaire.getItem(31));
                    player.getInventory().setItem(5, inventory_inventaire.getItem(32));
                    player.getInventory().setItem(6, inventory_inventaire.getItem(33));
                    player.getInventory().setItem(7, inventory_inventaire.getItem(34));
                    player.getInventory().setItem(8, inventory_inventaire.getItem(35));
                    player.getInventory().setItem(9, inventory_inventaire.getItem(0));
                    player.getInventory().setItem(10, inventory_inventaire.getItem(1));
                    player.getInventory().setItem(11, inventory_inventaire.getItem(2));
                    player.getInventory().setItem(12, inventory_inventaire.getItem(3));
                    player.getInventory().setItem(13, inventory_inventaire.getItem(4));
                    player.getInventory().setItem(14, inventory_inventaire.getItem(5));
                    player.getInventory().setItem(15, inventory_inventaire.getItem(6));
                    player.getInventory().setItem(16, inventory_inventaire.getItem(7));
                    player.getInventory().setItem(17, inventory_inventaire.getItem(8));
                    player.getInventory().setItem(18, inventory_inventaire.getItem(9));
                    player.getInventory().setItem(19, inventory_inventaire.getItem(10));
                    player.getInventory().setItem(20, inventory_inventaire.getItem(11));
                    player.getInventory().setItem(21, inventory_inventaire.getItem(12));
                    player.getInventory().setItem(22, inventory_inventaire.getItem(13));
                    player.getInventory().setItem(23, inventory_inventaire.getItem(14));
                    player.getInventory().setItem(24, inventory_inventaire.getItem(15));
                    player.getInventory().setItem(25, inventory_inventaire.getItem(16));
                    player.getInventory().setItem(26, inventory_inventaire.getItem(17));

                    player.getInventory().setItem(27, inventory_inventaire.getItem(18));
                    player.getInventory().setItem(28, inventory_inventaire.getItem(19));
                    player.getInventory().setItem(29, inventory_inventaire.getItem(20));
                    player.getInventory().setItem(30, inventory_inventaire.getItem(21));
                    player.getInventory().setItem(31, inventory_inventaire.getItem(22));
                    player.getInventory().setItem(32, inventory_inventaire.getItem(23));
                    player.getInventory().setItem(33, inventory_inventaire.getItem(24));
                    player.getInventory().setItem(34, inventory_inventaire.getItem(25));
                    player.getInventory().setItem(35, inventory_inventaire.getItem(26));

                    player.getInventory().setItem(36, inventory_inventaire.getItem(8));

                    player.getInventory().setHelmet(inventory_inventaire.getItem(45));
                    player.getInventory().setChestplate(inventory_inventaire.getItem(46));
                    player.getInventory().setLeggings(inventory_inventaire.getItem(47));
                    player.getInventory().setBoots(inventory_inventaire.getItem(48));

                    player.sendMessage("§2" + "[" + "§c§m---------------------------------------------§f§2" + "]§f"
                            + "\n" + " " + "\n" + "    §6/save : Enrengistrer sont inventaire " + "\n" +
                            "    §6/enchants : Permet d'enchanter l'item dans votre main " + "\n" + " " +
                            "\n" +
                            "§2" + "[" + "§c§m---------------------------------------------§f§2" + "]§f");


                }
            }
        }


    }
}
