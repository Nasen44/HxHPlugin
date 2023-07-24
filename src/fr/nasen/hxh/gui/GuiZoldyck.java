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

public class GuiZoldyck implements Listener {
    final ItemStack gris = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
    public static Inventory inventory_roleZoldyck;
    static final ItemStack cobble1 = new ItemStack(Material.COBBLESTONE, 1);static final ItemStack cobble2 = new ItemStack(Material.MOSSY_COBBLESTONE, 1);
    public static final ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
    public static final ItemStack vide = new ItemStack(Material.AIR, 1);
    public static  ItemStack netherStar = new ItemStack(Material.NETHER_STAR, 1);
    final ItemStack vert = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);

    final ItemStack laineZoldyck = new ItemStack(Material.WOOL, 1, (short) 5);
    final ItemStack laineZoldyck1 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineZoldyck4 = new ItemStack(Material.WOOL, 1, (short) 5 );
    final ItemStack laineZoldyck2 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineZoldyck5 = new ItemStack(Material.WOOL, 1, (short) 5);
    final ItemStack laineZoldyck3 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineZoldyck6 = new ItemStack(Material.WOOL, 1, (short)5 );
    ArrayList<String> lore_role = new ArrayList<String>();
    public GuiZoldyck(){
        ItemUtils.ItemDisplayName(laineZoldyck, "§5Zeno");ItemUtils.ItemDisplayName(laineZoldyck5, "§5Tsubone");
        ItemUtils.ItemDisplayName(laineZoldyck1, "§5Silva");
        ItemUtils.ItemDisplayName(laineZoldyck2, "§5Irumi");
        ItemUtils.ItemDisplayName(laineZoldyck3, "§5Karuto");
        ItemUtils.ItemDisplayName(laineZoldyck4, "§5Gotô");
        ItemUtils.ItemDisplayName(netherStar, "§8Role");
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
                inventory_roleZoldyck.getItem(4).setItemMeta(nethermeta);

            }
        }, 0, 0);
        inventory_roleZoldyck = Bukkit.createInventory(null,6*9 ,   "§2§lH§c§lx§2§lH§6§l-Zoldyck");
        this.inventory_roleZoldyck.setItem(0, gris );        this.inventory_roleZoldyck.setItem(9, gris );                  this.inventory_roleZoldyck.setItem(18, vide );
        this.inventory_roleZoldyck.setItem(1, gris );         this.inventory_roleZoldyck.setItem(10, laineZoldyck );        this.inventory_roleZoldyck.setItem(19,  vide);
        this.inventory_roleZoldyck.setItem(2, gris );        this.inventory_roleZoldyck.setItem(11, laineZoldyck1 );       this.inventory_roleZoldyck.setItem(20, vide);
        this.inventory_roleZoldyck.setItem(3, vide );        this.inventory_roleZoldyck.setItem(12, laineZoldyck2 );       this.inventory_roleZoldyck.setItem(21, vide);
        this.inventory_roleZoldyck.setItem(4, netherStar );  this.inventory_roleZoldyck.setItem(13, laineZoldyck3 );       this.inventory_roleZoldyck.setItem(22, vide );
        this.inventory_roleZoldyck.setItem(5, vide );        this.inventory_roleZoldyck.setItem(14, laineZoldyck4 );       this.inventory_roleZoldyck.setItem(23, vide );
        this.inventory_roleZoldyck.setItem(6, gris );        this.inventory_roleZoldyck.setItem(15, laineZoldyck5 );       this.inventory_roleZoldyck.setItem(24, vide );
        this.inventory_roleZoldyck.setItem(7, gris );         this.inventory_roleZoldyck.setItem(16, vide );       this.inventory_roleZoldyck.setItem(25, vide );
        this.inventory_roleZoldyck.setItem(8, gris );        this.inventory_roleZoldyck.setItem(17, gris );                 this.inventory_roleZoldyck.setItem(26, vide );

        this.inventory_roleZoldyck.setItem(27, vide );            this.inventory_roleZoldyck.setItem(36, gris );        this.inventory_roleZoldyck.setItem(45, gris );
        this.inventory_roleZoldyck.setItem(28, vide );  this.inventory_roleZoldyck.setItem(37, cobble2 );       this.inventory_roleZoldyck.setItem(46, gris );
        this.inventory_roleZoldyck.setItem(29, vide);   this.inventory_roleZoldyck.setItem(38, vide );       this.inventory_roleZoldyck.setItem(47, vide );
        this.inventory_roleZoldyck.setItem(30, vide );  this.inventory_roleZoldyck.setItem(39, vide );       this.inventory_roleZoldyck.setItem(48, vide );
        this.inventory_roleZoldyck.setItem(31, vide );           this.inventory_roleZoldyck.setItem(40, vide );       this.inventory_roleZoldyck.setItem(49, vide );
        this.inventory_roleZoldyck.setItem(32, vide );           this.inventory_roleZoldyck.setItem(41, vide );       this.inventory_roleZoldyck.setItem(50, vide );
        this.inventory_roleZoldyck.setItem(33, vide );           this.inventory_roleZoldyck.setItem(42, vide );       this.inventory_roleZoldyck.setItem(51, vide );
        this.inventory_roleZoldyck.setItem(34, vide );           this.inventory_roleZoldyck.setItem(43, cobble1 );     this.inventory_roleZoldyck.setItem(52, gris );
        this.inventory_roleZoldyck.setItem(35, vide );            this.inventory_roleZoldyck.setItem(44, gris );        this.inventory_roleZoldyck.setItem(53, gris );

    }
    @EventHandler
    public void OnClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(inventory_roleZoldyck.getName())) {
            e.setCancelled(true);
            if (e.getCurrentItem().isSimilar(cobble1)) {

                player.openInventory(GuiBrigade.inventory_roleBrigade);
            } else {

                if (e.getCurrentItem().isSimilar(cobble2)) {
                    player.openInventory(inventory_role);

                }
            }
            if (e.getSlot() >= 10) {
                if (e.getSlot() <= 16) {
                    if (e.getCurrentItem().getType().equals(Material.WOOL)) {
                        if (e.getCurrentItem().getDurability() == 5) {
                            e.getCurrentItem().setDurability((short) 14);
                            roleZoldycks.remove(inventory_roleZoldyck.getItem(e.getSlot()).getItemMeta().getDisplayName());
                        } else if (e.getCurrentItem().getDurability() == 14) {
                            e.getCurrentItem().setDurability((short) 5);
                            roleZoldycks.add(inventory_roleZoldyck.getItem(e.getSlot()).getItemMeta().getDisplayName());
                        }
                    }
                }
            }

        }
    }
}
