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
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static fr.nasen.hxh.gui.GuiZoldyck.inventory_roleZoldyck;

public class GuiRole implements Listener
{

    public static List<String> roleHunter = new ArrayList<>();
    public static List<String> roleZoldycks = new ArrayList<>();
    public static List<String> roleBrigadeFantome = new ArrayList<>();
    public static List<String> roleFourmis = new ArrayList<>();
    public static List<String> roleSolo = new ArrayList<>();
    public static final ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
    public static final ItemStack vide = new ItemStack(Material.AIR, 1);
    public static  ItemStack netherStar = new ItemStack(Material.NETHER_STAR, 1);
    final ItemStack vert = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
    final ItemStack gris = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
    static final ItemStack laineHunter = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack laineHunter1 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineHunter4 = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack laineHunter2 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineHunter5 = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack laineHunter3 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineHunter6 = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack laineHunter7 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineHunter10 = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack laineHunter8 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineHunter11 = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack laineHunter9 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineHunter12 = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack laineHunter13 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineHunter14 = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack laineHunter15 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineHunter16 = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack laineHunter17 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineHunter18 = new ItemStack(Material.WOOL, 1, (short) 5);
    static final ItemStack cobble1 = new ItemStack(Material.COBBLESTONE, 1);static final ItemStack cobble2 = new ItemStack(Material.MOSSY_COBBLESTONE, 1);


    final ItemStack laineZoldyck = new ItemStack(Material.WOOL, 1, (short) 5);
    final ItemStack laineZoldyck1 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineZoldyck4 = new ItemStack(Material.WOOL, 1, (short) 5 );
    final ItemStack laineZoldyck2 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineZoldyck5 = new ItemStack(Material.WOOL, 1, (short) 5);
    final ItemStack laineZoldyck3 = new ItemStack(Material.WOOL, 1, (short) 5);static final ItemStack laineZoldyck6 = new ItemStack(Material.WOOL, 1, (short)5 );
    public static Inventory inventory_role;
    ArrayList<String> lore_role = new ArrayList<String>();
    public GuiRole (){
        List<String> rolesZoldycks2 = Arrays.asList("§5Zeno", "§5Silva", "§5Irumi", "§5Karuto", "§5Gotô", "§5Tsubone");
        List<String> rolesBrigade2 = Arrays.asList("§7Kuroro", "§7Nobunaga", "§7Feitan", "§7Machi", "§7Phinks", "§7Franklin", "§7Shizuku", "§7Bonorenuf", "§7Uvogin", "§7Sharnalk", "§7Pakunoda");
        List<String> rolesFourmis2 = Arrays.asList("§cMeruem", "§cNeferpitô", "§cShauapufu","§cYupi");
        List<String> roleSolo2 = Arrays.asList("§6Hisoka", "§6Aruka");
        List<String> rolesHunter2 = Arrays.asList("§aGon", "§aKirua", "§aKurapika", "§aWing", "§aLeolio", "§aBiscuit", "§aKaito", "§aKnuckle", "§aMorau", "§aRazor", "§aShoot", "§aJin", "§aNetero", "§aPamu", "§aSenritsu", "§aMeleoron", "§aNovu");
        for(String str : rolesHunter2){
            GuiRole.roleHunter.add(str);
        }
        for(String str : rolesZoldycks2){
            GuiRole.roleZoldycks.add(str);
        }
        for(String str : rolesBrigade2){
            GuiRole.roleBrigadeFantome.add(str);
        }
        for(String str : rolesFourmis2){
            GuiRole.roleFourmis.add(str);
        }
        for(String str : roleSolo2){
            GuiRole.roleSolo.add(str);
        }





        ItemUtils.ItemDisplayName(laineHunter,"§aGon" );ItemUtils.ItemDisplayName(laineHunter14, "§aSenritsu");
        ItemUtils.ItemDisplayName(laineHunter1, "§aKirua");ItemUtils.ItemDisplayName(laineHunter15,  "§aMeleoron");
        ItemUtils.ItemDisplayName(laineHunter2, "§aKurapika");ItemUtils.ItemDisplayName(laineHunter16,  "§aNovu");
        ItemUtils.ItemDisplayName(laineHunter3, "§aWing");
        ItemUtils.ItemDisplayName(laineHunter4,  "§aLeolio");
        ItemUtils.ItemDisplayName(laineHunter5, "§aBiscuit");
        ItemUtils.ItemDisplayName(laineHunter6, "§aKaito");
        ItemUtils.ItemDisplayName(laineHunter7,  "§aKnuckle");
        ItemUtils.ItemDisplayName(laineHunter8, "§aMorau");
        ItemUtils.ItemDisplayName(laineHunter9, "§aRazor");
        ItemUtils.ItemDisplayName(laineHunter10, "§aShoot");
        ItemUtils.ItemDisplayName(laineHunter11, "§aJin");
        ItemUtils.ItemDisplayName(laineHunter12, "§aNetero");
        ItemUtils.ItemDisplayName(laineHunter13, "§aPamu");


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
                inventory_role.getItem(4).setItemMeta(nethermeta);

            }
        }, 0, 0);


        inventory_role = Bukkit.createInventory(null,6*9 ,   "§2§lH§c§lx§2§lH§6§l-Roles-Hunter");
        this.inventory_role.setItem(0, gris );        this.inventory_role.setItem(9, gris );         this.inventory_role.setItem(18, vide );
        this.inventory_role.setItem(1, gris );         this.inventory_role.setItem(10, laineHunter );       this.inventory_role.setItem(19, laineHunter7 );
        this.inventory_role.setItem(2, gris );        this.inventory_role.setItem(11, laineHunter1 );       this.inventory_role.setItem(20, laineHunter8 );
        this.inventory_role.setItem(3, vide );        this.inventory_role.setItem(12, laineHunter2 );       this.inventory_role.setItem(21, laineHunter9 );
        this.inventory_role.setItem(4, netherStar );        this.inventory_role.setItem(13, laineHunter3 );       this.inventory_role.setItem(22, laineHunter10 );
        this.inventory_role.setItem(5, vide );        this.inventory_role.setItem(14, laineHunter4 );       this.inventory_role.setItem(23, laineHunter11 );
        this.inventory_role.setItem(6, gris );        this.inventory_role.setItem(15, laineHunter5 );       this.inventory_role.setItem(24, laineHunter12 );
        this.inventory_role.setItem(7, gris );         this.inventory_role.setItem(16, laineHunter6 );       this.inventory_role.setItem(25, laineHunter13 );
        this.inventory_role.setItem(8, gris );        this.inventory_role.setItem(17, gris  );        this.inventory_role.setItem(26, vide );

        this.inventory_role.setItem(27, vide );           this.inventory_role.setItem(36, gris );       this.inventory_role.setItem(45, gris );
        this.inventory_role.setItem(28, laineHunter14 );           this.inventory_role.setItem(37, vide );   this.inventory_role.setItem(46, gris );
        this.inventory_role.setItem(29, laineHunter15);           this.inventory_role.setItem(38, vide );      this.inventory_role.setItem(47, vide );
        this.inventory_role.setItem(30, laineHunter16 );           this.inventory_role.setItem(39, vide );      this.inventory_role.setItem(48, vide );
        this.inventory_role.setItem(31, vide );           this.inventory_role.setItem(40, vide );      this.inventory_role.setItem(49, vide );
        this.inventory_role.setItem(32, vide );           this.inventory_role.setItem(41, vide );      this.inventory_role.setItem(50, vide );
        this.inventory_role.setItem(33, vide );           this.inventory_role.setItem(42, vide );      this.inventory_role.setItem(51, vide );
        this.inventory_role.setItem(34, vide );           this.inventory_role.setItem(43, cobble1 );      this.inventory_role.setItem(52, gris );
        this.inventory_role.setItem(35, vide );           this.inventory_role.setItem(44, gris );       this.inventory_role.setItem(53, gris );

    }

    @EventHandler
    public void OnClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals(inventory_role.getName())) {
            e.setCancelled(true);


            if (e.getCurrentItem().isSimilar(cobble1)) {

                player.openInventory(inventory_roleZoldyck);
            } else {

            }


            if (e.getInventory().getName().equals(inventory_role.getName())) {
                if (e.getSlot() >= 10) {
                    if (e.getSlot() <= 30) {
                        if (e.getCurrentItem().getType().equals(Material.WOOL)) {
                            if (e.getCurrentItem().getDurability() == 5) {
                                e.getCurrentItem().setDurability((short) 14);
                                roleHunter.remove(inventory_role.getItem(e.getSlot()).getItemMeta().getDisplayName());
                            } else if (e.getCurrentItem().getDurability() == 14) {
                                e.getCurrentItem().setDurability((short) 5);
                                roleHunter.add(inventory_role.getItem(e.getSlot()).getItemMeta().getDisplayName());
                            }
                        }
                    }
                }
            }
        }
    }
    }
