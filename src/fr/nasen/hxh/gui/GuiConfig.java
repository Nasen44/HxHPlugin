package fr.nasen.hxh.gui;

import fr.nasen.hxh.ChatUtils;
import fr.nasen.hxh.Main;
import fr.nasen.hxh.game.Game;
import fr.nasen.hxh.game.ItemUtils;
import fr.nasen.hxh.game.StartGame;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

import static fr.nasen.hxh.gui.GuiInventaire.inventory_inventaire;

public class GuiConfig implements Listener {
    final ItemStack gris = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 7);
    final ItemStack vert = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
    final ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
    final ItemStack slime = new ItemStack(Material.SLIME_BALL, 1);
    final ItemStack oeuil = new ItemStack(Material.EYE_OF_ENDER, 1);
    final ItemStack magma = new ItemStack(Material.MAGMA_CREAM, 1);
    final ItemStack inventaire = new ItemStack(Material.CHEST, 1);
    final ItemStack bordure = new ItemStack(Material.PRISMARINE_SHARD, 1);
    final ItemStack vide = new ItemStack(Material.AIR, 1);
    final ItemStack book = new ItemStack(Material.BOOK, 1);
    public static Inventory inventory_config;
    public GuiConfig(){
        inventory_config = Bukkit.createInventory(null,6*9 ,   "§2§lH§c§lX§2§lH§6§l-Config");
        ItemUtils.ItemDisplayName(inventaire, "§8[§6Inventaire§8]");
        ItemUtils.ItemDisplayName(book, "§8[§6Roles§8]");
        ItemUtils.ItemDisplayName(oeuil, "§8[§6Scénario§8]");

        ItemUtils.ItemDisplayName(slime, "§8[§6Start§8]");
        ItemUtils.ItemDisplayName(magma, "§8[§6IsStarting§8]");
        this.inventory_config.setItem(0, gris );        this.inventory_config.setItem(9, gris );        this.inventory_config.setItem(18, vide );
        this.inventory_config.setItem(1, gris );        this.inventory_config.setItem(10, vide );       this.inventory_config.setItem(19, vide );
        this.inventory_config.setItem(2, gris ); this.inventory_config.setItem(11, vide );       this.inventory_config.setItem(20, vide );
        this.inventory_config.setItem(3, vide );        this.inventory_config.setItem(12, vide );       this.inventory_config.setItem(21, vide );
        this.inventory_config.setItem(4, book );        this.inventory_config.setItem(13, vide );       this.inventory_config.setItem(22, vide );
        this.inventory_config.setItem(5, vide );        this.inventory_config.setItem(14, vide );       this.inventory_config.setItem(23, vide );
        this.inventory_config.setItem(6, gris );         this.inventory_config.setItem(15, vide );       this.inventory_config.setItem(24, vide );
        this.inventory_config.setItem(7, gris );        this.inventory_config.setItem(16, vide );       this.inventory_config.setItem(25, vide );
        this.inventory_config.setItem(8, gris );        this.inventory_config.setItem(17, gris );       this.inventory_config.setItem(26, vide );

        this.inventory_config.setItem(27, vide );        this.inventory_config.setItem(36, gris );        this.inventory_config.setItem(45, gris );
        this.inventory_config.setItem(28, vide );       this.inventory_config.setItem(37, oeuil );      this.inventory_config.setItem(46, gris );
        this.inventory_config.setItem(29, vide );       this.inventory_config.setItem(38, vide );      this.inventory_config.setItem(47, vide );
        this.inventory_config.setItem(30, vide );      this.inventory_config.setItem(39, vide );      this.inventory_config.setItem(48, vide );
        this.inventory_config.setItem(31, inventaire );      this.inventory_config.setItem(40, vide );      this.inventory_config.setItem(49, slime );
        this.inventory_config.setItem(32, vide );      this.inventory_config.setItem(41, vide );      this.inventory_config.setItem(50, vide );
        this.inventory_config.setItem(33, vide );      this.inventory_config.setItem(42, vide );      this.inventory_config.setItem(51, vide );
        this.inventory_config.setItem(34, vide );      this.inventory_config.setItem(43, vide );        this.inventory_config.setItem(52, gris );
        this.inventory_config.setItem(35, vide );        this.inventory_config.setItem(44, gris );        this.inventory_config.setItem(53, gris );
    }
    int timerthreads;
    public void stopssTimer(){
        Bukkit.getServer().getScheduler().cancelTask(timerthreads   );
    }
    @EventHandler
    public void OnClickEvent(InventoryClickEvent e) {
        System.out.println(e.getSlot());
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(inventory_config.getName())) {
            e.setCancelled(true);

            if (e.getCurrentItem().isSimilar(book)) {
                player.openInventory(GuiRole.inventory_role);
            }
            if (e.getCurrentItem().isSimilar(bordure)) {

                player.openInventory(GuiBordure.inventory_bordure);
            }
            if (e.getCurrentItem().isSimilar(oeuil)) {

                player.openInventory(GuiScenario.inventory_scenario);
            }
            if (e.getCurrentItem().isSimilar(inventaire)) {
                if (player.isOp()) {

                    player.openInventory(inventory_inventaire);
                } else {

                }
                player.sendMessage(ChatUtils.hxhUhc + " Cette Fonctionnalité est en developpement ! ");
            }

            if (e.getCurrentItem().isSimilar(slime)) {
                if (player.isOp()) {
                    if (!Game.STARTGAME) {
                        player.closeInventory();
                        if (Bukkit.getWorld("Area12") != null) {
                            inventory_config.setItem(49, magma);
                          new BukkitRunnable(){

                                int t = 10;

                                @Override
                                public void run() {

                                    t--;
//                                if(inventory_config.getItem(49).isSimilar(slime)){
//                                    this.cancel();
//                                }
                                    for(Player player1 : Bukkit.getOnlinePlayers()){
                                        Main.getInstance().tile.sendFullTitle(player1, 5, 10, 5, "§2" + t, "");
                                    }


                                    if(inventory_config.getItem(49).isSimilar(slime)){
                                        this.cancel();
                                    }
                                    if (t == 0) {
                                        Main.getInstance().tile.sendFullTitle(player, 5, 30, 5, "§aBonne Chance", "");

                                        Game.STARTGAME = true;
                                        StartGame.startGame();
                                        for (Player p : Bukkit.getOnlinePlayers()) {
                                            Random r = new Random();
                                            int t = r.nextInt(700);
                                            int v = r.nextInt(700);
                                            p.setGameMode(GameMode.SURVIVAL);
                                            p.setHealth(p.getMaxHealth());
                                            p.setFoodLevel(20);
                                            p.teleport(new Location(Bukkit.getWorld("Area12"), t, 100, v));

                                            p.getInventory().setItem(0, inventory_inventaire.getItem(27));
                                            p.getInventory().setItem(1, inventory_inventaire.getItem(28));
                                            p.getInventory().setItem(2, inventory_inventaire.getItem(29));
                                            p.getInventory().setItem(3, inventory_inventaire.getItem(30));
                                            p.getInventory().setItem(4, inventory_inventaire.getItem(31));
                                            p.getInventory().setItem(5, inventory_inventaire.getItem(32));
                                            p.getInventory().setItem(6, inventory_inventaire.getItem(33));
                                            p.getInventory().setItem(7, inventory_inventaire.getItem(34));
                                            p.getInventory().setItem(8, inventory_inventaire.getItem(35));
                                            p.getInventory().setItem(9, inventory_inventaire.getItem(0));
                                            p.getInventory().setItem(10, inventory_inventaire.getItem(1));
                                            p.getInventory().setItem(11, inventory_inventaire.getItem(2));
                                            p.getInventory().setItem(12, inventory_inventaire.getItem(3));
                                            p.getInventory().setItem(13, inventory_inventaire.getItem(4));
                                            p.getInventory().setItem(14, inventory_inventaire.getItem(5));
                                            p.getInventory().setItem(15, inventory_inventaire.getItem(6));
                                            p.getInventory().setItem(16, inventory_inventaire.getItem(7));
                                            p.getInventory().setItem(17, inventory_inventaire.getItem(8));
                                            p.getInventory().setItem(18, inventory_inventaire.getItem(9));
                                            p.getInventory().setItem(19, inventory_inventaire.getItem(10));
                                            p.getInventory().setItem(20, inventory_inventaire.getItem(11));
                                            p.getInventory().setItem(21, inventory_inventaire.getItem(12));
                                            p.getInventory().setItem(22, inventory_inventaire.getItem(13));
                                            p.getInventory().setItem(23, inventory_inventaire.getItem(14));
                                            p.getInventory().setItem(24, inventory_inventaire.getItem(15));
                                            p.getInventory().setItem(25, inventory_inventaire.getItem(16));
                                            p.getInventory().setItem(26, inventory_inventaire.getItem(17));

                                            p.getInventory().setItem(27, inventory_inventaire.getItem(18));
                                            p.getInventory().setItem(28, inventory_inventaire.getItem(19));
                                            p.getInventory().setItem(29, inventory_inventaire.getItem(20));
                                            p.getInventory().setItem(30, inventory_inventaire.getItem(21));
                                            p.getInventory().setItem(31, inventory_inventaire.getItem(22));
                                            p.getInventory().setItem(32, inventory_inventaire.getItem(23));
                                            p.getInventory().setItem(33, inventory_inventaire.getItem(24));
                                            p.getInventory().setItem(34, inventory_inventaire.getItem(25));
                                            p.getInventory().setItem(35, inventory_inventaire.getItem(26));

                                            p.getInventory().setItem(36, inventory_inventaire.getItem(8));

                                            p.getInventory().setHelmet(inventory_inventaire.getItem(45));
                                            p.getInventory().setChestplate(inventory_inventaire.getItem(46));
                                            p.getInventory().setLeggings(inventory_inventaire.getItem(47));
                                            p.getInventory().setBoots(inventory_inventaire.getItem(48));
                                            if(Game.CATEYES){
                                                p.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, Integer.MAX_VALUE, 0, false, false));
                                            }
                                        }

                                        this.cancel();
                                    }

                                }
                          }.runTaskTimer(Main.getInstance(), 0, 20);


                        } else {
                            player.sendMessage(ChatUtils.hxhUhc + " Vous n'avez pas pregen merci de /hxh pregen !");
                        }

                    } else {
                        player.sendMessage(ChatUtils.hxhUhc + " La partie a deja commencé");
                    }


                }
            }else{
                if (e.getCurrentItem().isSimilar(magma)) {

                    inventory_config.setItem(49, slime);
                }
            }



        }

    }

}
