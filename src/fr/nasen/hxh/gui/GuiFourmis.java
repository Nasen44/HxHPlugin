package fr.nasen.hxh.gui;

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
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import static fr.nasen.hxh.gui.GuiRole.*;

public class GuiFourmis implements Listener {

    final ItemStack gris = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
    public static final ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
    static final ItemStack cobble1 = new ItemStack(Material.COBBLESTONE, 1);static final ItemStack cobble2 = new ItemStack(Material.MOSSY_COBBLESTONE, 1);
    public static final ItemStack vide = new ItemStack(Material.AIR, 1);
    public static  ItemStack netherStar = new ItemStack(Material.NETHER_STAR, 1);
    final ItemStack vert = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
    final ItemStack laineFourmis = new ItemStack(Material.WOOL, 1, (short) 5);
    final ItemStack laineFourmis1 = new ItemStack(Material.WOOL, 1, (short) 5);
    final ItemStack laineFourmis2 = new ItemStack(Material.WOOL, 1, (short) 5);
    final ItemStack laineFourmis3 = new ItemStack(Material.WOOL, 1, (short) 5);
    public static Inventory inventoryFourmis;
    ArrayList<String> lore_role = new ArrayList<String>();
    public GuiFourmis(){
        inventoryFourmis = Bukkit.createInventory(null,6*9 ,   "§2§lH§c§lx§2§lH§6§l-Fourmis");
        ItemUtils.ItemDisplayName(laineFourmis, "§cMeruem");ItemUtils.ItemDisplayName(laineFourmis3, "§cYupi");
        ItemUtils.ItemDisplayName(laineFourmis1, "§cNeferpitô");
        ItemUtils.ItemDisplayName(laineFourmis2, "§cShauapufu");

        ItemMeta nethermeta = netherStar.getItemMeta();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {

            @Override
            public void run() {
                lore_role.clear();
                lore_role.add("§8"+"\u00BB" + "§r§2Hunter§8(§7" + roleHunter.size() + "§8)");
                lore_role.add("§8"+"\u00BB" + "§r§5Zoldycks§8(§7" + roleZoldycks.size() + "§8)");
                lore_role.add("§8"+"\u00BB" + "§r§7Brigade Fantome§8(§7" + roleBrigadeFantome.size() + "§8)");
                lore_role.add("§8"+"\u00BB" + "§r§cFourmis§8(§7" + roleFourmis.size() + "§8)");
                lore_role.add("§8"+"\u00BB" + "§r§6Solo§8(§7" + roleSolo.size() + "§8)");
                nethermeta.setLore(lore_role);
                inventoryFourmis.getItem(4).setItemMeta(nethermeta);

            }
        }, 0, 0);


        this.inventoryFourmis.setItem(0, gris );         this.inventoryFourmis.setItem(9, gris );                  this.inventoryFourmis.setItem(18, vide );
        this.inventoryFourmis.setItem(1, gris );         this.inventoryFourmis.setItem(10, laineFourmis );         this.inventoryFourmis.setItem(19,  vide);
        this.inventoryFourmis.setItem(2, gris );         this.inventoryFourmis.setItem(11, laineFourmis1 );        this.inventoryFourmis.setItem(20, vide);
        this.inventoryFourmis.setItem(3, vide );         this.inventoryFourmis.setItem(12, laineFourmis2 );        this.inventoryFourmis.setItem(21, vide);
        this.inventoryFourmis.setItem(4, netherStar );   this.inventoryFourmis.setItem(13, laineFourmis3 );        this.inventoryFourmis.setItem(22, vide );
        this.inventoryFourmis.setItem(5, vide );         this.inventoryFourmis.setItem(14, vide );        this.inventoryFourmis.setItem(23, vide );
        this.inventoryFourmis.setItem(6, gris );         this.inventoryFourmis.setItem(15, vide );        this.inventoryFourmis.setItem(24, vide );
        this.inventoryFourmis.setItem(7, gris );         this.inventoryFourmis.setItem(16, vide );        this.inventoryFourmis.setItem(25, vide );
        this.inventoryFourmis.setItem(8, gris );         this.inventoryFourmis.setItem(17, gris );                 this.inventoryFourmis.setItem(26, vide );

        this.inventoryFourmis.setItem(27, vide );           this.inventoryFourmis.setItem(36, gris );       this.inventoryFourmis.setItem(45, gris );
        this.inventoryFourmis.setItem(28, vide );           this.inventoryFourmis.setItem(37, cobble2 );    this.inventoryFourmis.setItem(46, gris );
        this.inventoryFourmis.setItem(29, vide);            this.inventoryFourmis.setItem(38, vide );       this.inventoryFourmis.setItem(47, vide );
        this.inventoryFourmis.setItem(30, vide );           this.inventoryFourmis.setItem(39, vide );       this.inventoryFourmis.setItem(48, vide );
        this.inventoryFourmis.setItem(31, vide );           this.inventoryFourmis.setItem(40, vide );       this.inventoryFourmis.setItem(49, vide );
        this.inventoryFourmis.setItem(32, vide );           this.inventoryFourmis.setItem(41, vide );       this.inventoryFourmis.setItem(50, vide );
        this.inventoryFourmis.setItem(33, vide );           this.inventoryFourmis.setItem(42, vide );       this.inventoryFourmis.setItem(51, vide );
        this.inventoryFourmis.setItem(34, vide );           this.inventoryFourmis.setItem(43, cobble1 );    this.inventoryFourmis.setItem(52, gris );
        this.inventoryFourmis.setItem(35, vide );           this.inventoryFourmis.setItem(44, gris );       this.inventoryFourmis.setItem(53, gris );

    }
    @EventHandler
    public void OnClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(inventoryFourmis.getName())) {
            e.setCancelled(true);
            if (e.getCurrentItem().isSimilar(cobble1)) {
                player.openInventory(GuiSolo.inventory_roleSolo);
            } else {

                if (e.getCurrentItem().isSimilar(cobble2)) {
                    player.openInventory(GuiBrigade.inventory_roleBrigade);

                }
            }
            if (e.getSlot() >= 10) {
                if (e.getSlot() <= 13) {
                    if (e.getCurrentItem().getType().equals(Material.WOOL)) {
                        if (e.getCurrentItem().getDurability() == 5) {
                            e.getCurrentItem().setDurability((short) 14);
                            roleFourmis.remove(inventoryFourmis.getItem(e.getSlot()).getItemMeta().getDisplayName());
                        } else if (e.getCurrentItem().getDurability() == 14) {
                            e.getCurrentItem().setDurability((short) 5);
                            roleFourmis.add(inventoryFourmis.getItem(e.getSlot()).getItemMeta().getDisplayName());
                        }
                    }
                }
            }

        }
    }
}

