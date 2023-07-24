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

public class GuiBrigade implements Listener {
    public static Inventory inventory_roleBrigade;
    final ItemStack gris = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
    public static final ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
    static final ItemStack cobble1 = new ItemStack(Material.COBBLESTONE, 1);static final ItemStack cobble2 = new ItemStack(Material.MOSSY_COBBLESTONE, 1);
    public static final ItemStack vide = new ItemStack(Material.AIR, 1);
    public static  ItemStack netherStar = new ItemStack(Material.NETHER_STAR, 1);
    final ItemStack vert = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
    final ItemStack laineBrigade = new ItemStack(Material.WOOL, 1, (short) 5);
    final ItemStack laineBrigade1 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineBrigade4 = new ItemStack(Material.WOOL, 1, (short) 5 );static final ItemStack laineBrigade7 = new ItemStack(Material.WOOL, 1, (short)5 );
    final ItemStack laineBrigade2 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineBrigade5 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineBrigade8 = new ItemStack(Material.WOOL, 1, (short)5 );
    final ItemStack laineBrigade3 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineBrigade6 = new ItemStack(Material.WOOL, 1, (short)5 );static final ItemStack laineBrigade9 = new ItemStack(Material.WOOL, 1, (short)5 );
    ArrayList<String> lore_role = new ArrayList<String>();
    static final ItemStack laineBrigade10 = new ItemStack(Material.WOOL, 1, (short)5 );
    public GuiBrigade(){
        inventory_roleBrigade = Bukkit.createInventory(null,6*9 ,   "§2§lH§c§lx§2§lH§6§l-Brigade");

        ItemUtils.ItemDisplayName(laineBrigade, "§7Kuroro");ItemUtils.ItemDisplayName(laineBrigade5, "§7Franklin");ItemUtils.ItemDisplayName(laineBrigade10, "§7Pakunoda");
        ItemUtils.ItemDisplayName(laineBrigade1, "§7Nobunaga");ItemUtils.ItemDisplayName(laineBrigade6, "§7Shizuku");
        ItemUtils.ItemDisplayName(laineBrigade2, "§7Feitan");ItemUtils.ItemDisplayName(laineBrigade7, "§7Bonorenuf");
        ItemUtils.ItemDisplayName(laineBrigade3, "§7Machi");ItemUtils.ItemDisplayName(laineBrigade8, "§7Uvogin");
            ItemUtils.ItemDisplayName(laineBrigade4, "§7Phinks");ItemUtils.ItemDisplayName(laineBrigade9, "§7Sharnalk");

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
                inventory_roleBrigade.getItem(4).setItemMeta(nethermeta);

            }
        }, 0, 0);

        this.inventory_roleBrigade.setItem(0, gris );         this.inventory_roleBrigade.setItem(9, gris );                  this.inventory_roleBrigade.setItem(18, vide );
        this.inventory_roleBrigade.setItem(1, gris );         this.inventory_roleBrigade.setItem(10, laineBrigade );         this.inventory_roleBrigade.setItem(19,  laineBrigade7);
        this.inventory_roleBrigade.setItem(2, gris );         this.inventory_roleBrigade.setItem(11, laineBrigade1 );        this.inventory_roleBrigade.setItem(20, laineBrigade8);
        this.inventory_roleBrigade.setItem(3, vide );         this.inventory_roleBrigade.setItem(12, laineBrigade2 );        this.inventory_roleBrigade.setItem(21, laineBrigade9);
        this.inventory_roleBrigade.setItem(4, netherStar );   this.inventory_roleBrigade.setItem(13, laineBrigade3 );        this.inventory_roleBrigade.setItem(22, laineBrigade10 );
        this.inventory_roleBrigade.setItem(5, vide );         this.inventory_roleBrigade.setItem(14, laineBrigade4 );        this.inventory_roleBrigade.setItem(23, vide );
        this.inventory_roleBrigade.setItem(6, gris );         this.inventory_roleBrigade.setItem(15, laineBrigade5 );        this.inventory_roleBrigade.setItem(24, vide );
        this.inventory_roleBrigade.setItem(7, gris );         this.inventory_roleBrigade.setItem(16, laineBrigade6 );                 this.inventory_roleBrigade.setItem(25, vide );
        this.inventory_roleBrigade.setItem(8, gris );         this.inventory_roleBrigade.setItem(17, gris );                 this.inventory_roleBrigade.setItem(26, vide );

        this.inventory_roleBrigade.setItem(27, vide );           this.inventory_roleBrigade.setItem(36, gris );       this.inventory_roleBrigade.setItem(45, gris );
        this.inventory_roleBrigade.setItem(28, vide );           this.inventory_roleBrigade.setItem(37, cobble2 );    this.inventory_roleBrigade.setItem(46, gris );
        this.inventory_roleBrigade.setItem(29, vide);            this.inventory_roleBrigade.setItem(38, vide );       this.inventory_roleBrigade.setItem(47, vide );
        this.inventory_roleBrigade.setItem(30, vide );           this.inventory_roleBrigade.setItem(39, vide );       this.inventory_roleBrigade.setItem(48, vide );
        this.inventory_roleBrigade.setItem(31, vide );           this.inventory_roleBrigade.setItem(40, vide );       this.inventory_roleBrigade.setItem(49, vide );
        this.inventory_roleBrigade.setItem(32, vide );           this.inventory_roleBrigade.setItem(41, vide );       this.inventory_roleBrigade.setItem(50, vide );
        this.inventory_roleBrigade.setItem(33, vide );           this.inventory_roleBrigade.setItem(42, vide );       this.inventory_roleBrigade.setItem(51, vide );
        this.inventory_roleBrigade.setItem(34, vide );           this.inventory_roleBrigade.setItem(43, cobble1 );    this.inventory_roleBrigade.setItem(52, gris );
        this.inventory_roleBrigade.setItem(35, vide );           this.inventory_roleBrigade.setItem(44, gris );       this.inventory_roleBrigade.setItem(53, gris );

    }

    @EventHandler
    public void OnClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(inventory_roleBrigade.getName())) {
            e.setCancelled(true);
            if (e.getCurrentItem().isSimilar(cobble1)) {

                player.openInventory(GuiFourmis.inventoryFourmis);
            } else {

                if (e.getCurrentItem().isSimilar(cobble2)) {
                    player.openInventory(GuiZoldyck.inventory_roleZoldyck);

                }
            }
            if (e.getSlot() >= 10) {
                if (e.getSlot() <= 22) {
                    if (e.getCurrentItem().getType().equals(Material.WOOL)) {
                        if (e.getCurrentItem().getDurability() == 5) {
                            e.getCurrentItem().setDurability((short) 14);
                            roleBrigadeFantome.remove(inventory_roleBrigade.getItem(e.getSlot()).getItemMeta().getDisplayName());
                        } else if (e.getCurrentItem().getDurability() == 14) {
                            e.getCurrentItem().setDurability((short) 5);
                            roleBrigadeFantome.add(inventory_roleBrigade.getItem(e.getSlot()).getItemMeta().getDisplayName());
                        }
                    }
                }
            }

        }
    }
}
