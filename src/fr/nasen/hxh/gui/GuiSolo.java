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

public class GuiSolo implements Listener {
    public static Inventory inventory_roleSolo;
    final ItemStack gris = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
    public static final ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
    static final ItemStack cobble1 = new ItemStack(Material.COBBLESTONE, 1);static final ItemStack cobble2 = new ItemStack(Material.MOSSY_COBBLESTONE, 1);
    public static final ItemStack vide = new ItemStack(Material.AIR, 1);
    public static  ItemStack netherStar = new ItemStack(Material.NETHER_STAR, 1);
    final ItemStack laineSolo = new ItemStack(Material.WOOL, 1, (short) 5);
    final ItemStack laineSolo1 = new ItemStack(Material.WOOL, 1, (short) 5);


    ArrayList<String> lore_role = new ArrayList<String>();
    public GuiSolo(){
        inventory_roleSolo = Bukkit.createInventory(null,6*9 ,   "§2§lH§c§lx§2§lH§6§l-Solo");

        ItemUtils.ItemDisplayName(laineSolo, "§6Hisoka");
        ItemUtils.ItemDisplayName(laineSolo1, "§6Aruka");
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
                inventory_roleSolo.getItem(4).setItemMeta(nethermeta);

            }
        }, 0, 0);
        this.inventory_roleSolo.setItem(0, gris );         this.inventory_roleSolo.setItem(9, gris );                  this.inventory_roleSolo.setItem(18, vide );
        this.inventory_roleSolo.setItem(1, gris );         this.inventory_roleSolo.setItem(10, laineSolo );            this.inventory_roleSolo.setItem(19,  vide);
        this.inventory_roleSolo.setItem(2, gris );         this.inventory_roleSolo.setItem(11, laineSolo1 );           this.inventory_roleSolo.setItem(20, vide);
        this.inventory_roleSolo.setItem(3, vide );         this.inventory_roleSolo.setItem(12, vide );                 this.inventory_roleSolo.setItem(21, vide);
        this.inventory_roleSolo.setItem(4, netherStar );   this.inventory_roleSolo.setItem(13, vide );                 this.inventory_roleSolo.setItem(22, vide );
        this.inventory_roleSolo.setItem(5, vide );         this.inventory_roleSolo.setItem(14, vide );                 this.inventory_roleSolo.setItem(23, vide );
        this.inventory_roleSolo.setItem(6, gris );         this.inventory_roleSolo.setItem(15, vide );                 this.inventory_roleSolo.setItem(24, vide );
        this.inventory_roleSolo.setItem(7, gris );         this.inventory_roleSolo.setItem(16, vide );                 this.inventory_roleSolo.setItem(25, vide );
        this.inventory_roleSolo.setItem(8, gris );         this.inventory_roleSolo.setItem(17, gris );                 this.inventory_roleSolo.setItem(26, vide );

        this.inventory_roleSolo.setItem(27, vide );           this.inventory_roleSolo.setItem(36, gris );       this.inventory_roleSolo.setItem(45, gris );
        this.inventory_roleSolo.setItem(28, vide );           this.inventory_roleSolo.setItem(37, cobble2 );    this.inventory_roleSolo.setItem(46, gris );
        this.inventory_roleSolo.setItem(29, vide);            this.inventory_roleSolo.setItem(38, vide );       this.inventory_roleSolo.setItem(47, vide );
        this.inventory_roleSolo.setItem(30, vide );           this.inventory_roleSolo.setItem(39, vide );       this.inventory_roleSolo.setItem(48, vide );
        this.inventory_roleSolo.setItem(31, vide );           this.inventory_roleSolo.setItem(40, vide );       this.inventory_roleSolo.setItem(49, vide );
        this.inventory_roleSolo.setItem(32, vide );           this.inventory_roleSolo.setItem(41, vide );       this.inventory_roleSolo.setItem(50, vide );
        this.inventory_roleSolo.setItem(33, vide );           this.inventory_roleSolo.setItem(42, vide );       this.inventory_roleSolo.setItem(51, vide );
        this.inventory_roleSolo.setItem(34, vide );           this.inventory_roleSolo.setItem(43, vide );    this.inventory_roleSolo.setItem(52, gris );
        this.inventory_roleSolo.setItem(35, vide );           this.inventory_roleSolo.setItem(44, gris );       this.inventory_roleSolo.setItem(53, gris );


    }

    @EventHandler
    public void OnClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(inventory_roleSolo.getName())) {
            e.setCancelled(true);
            if (e.getCurrentItem().isSimilar(cobble1)) {

            } else {

                if (e.getCurrentItem().isSimilar(cobble2)) {
                    player.openInventory(GuiFourmis.inventoryFourmis);
                }
            }
            if (e.getSlot() >= 10) {
                if (e.getSlot() <= 22) {
                    if (e.getCurrentItem().getType().equals(Material.WOOL)) {
                        if (e.getCurrentItem().getDurability() == 5) {
                            e.getCurrentItem().setDurability((short) 14);
                            roleSolo.remove(inventory_roleSolo.getItem(e.getSlot()).getItemMeta().getDisplayName());
                        } else if (e.getCurrentItem().getDurability() == 14) {
                            e.getCurrentItem().setDurability((short) 5);
                            roleSolo.add(inventory_roleSolo.getItem(e.getSlot()).getItemMeta().getDisplayName());
                        }
                    }
                }
            }

        }
    }

}
