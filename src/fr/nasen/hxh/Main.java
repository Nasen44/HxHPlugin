package fr.nasen.hxh;

import fr.nasen.hxh.biome.BIomeEdit;
import fr.nasen.hxh.file.RoleSerializationManager;
import fr.nasen.hxh.game.Game;
import fr.nasen.hxh.gui.*;
import fr.nasen.hxh.command.*;
import fr.nasen.hxh.listener.HomingTask;
import fr.nasen.hxh.listener.ListenerPlayerInteracte;
import fr.nasen.hxh.listener.ListenerPlayerJoin;
import fr.nasen.hxh.packet.PacketMapChunk;
import fr.nasen.hxh.role.hunter.Biscuit;
import fr.nasen.hxh.scoreboard.ScoreboardManager;
import fr.nasen.hxh.title.Title;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class Main extends JavaPlugin implements Listener {
    public static boolean aimbot = false;
    private static Main instance;
    private ScoreboardManager scoreboardManager;
    public static boolean isInventory = false;

    public static String message;

    public Title tile = new Title();
    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;

    private RoleSerializationManager profileSerializationManager;
    @Override
        public void onEnable() {
        instance = this;
        this.profileSerializationManager = new RoleSerializationManager();

        Bukkit.getPluginManager().registerEvents(new ListenerPlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new ListenerPlayerInteracte(), this);
        Bukkit.getPluginManager().registerEvents(new GuiInventaire(), this);
        Bukkit.getPluginManager().registerEvents(new GuiBordure(), this);
        Bukkit.getPluginManager().registerEvents(new GuiConfig(), this);
        Bukkit.getPluginManager().registerEvents(new GuiEnchant(), this);
        Bukkit.getPluginManager().registerEvents(new GuiRole(), this);
        Bukkit.getPluginManager().registerEvents(new GuiZoldyck(), this);
        Bukkit.getPluginManager().registerEvents(new GuiBrigade(), this);
        Bukkit.getPluginManager().registerEvents(new GuiFourmis(), this);
        Bukkit.getPluginManager().registerEvents(new Biscuit(), this);
        Bukkit.getPluginManager().registerEvents(new GuiScenario(), this);
        Bukkit.getPluginManager().registerEvents(new GuiSolo(), this);


        getCommand("hxh").setExecutor(new CommandStart());
        getCommand("gmc").setExecutor(new CommandGamemode());
        getCommand("gma").setExecutor(new CommandGamemode());
        getCommand("gms").setExecutor(new CommandGamemode());
        getCommand("gmsp").setExecutor(new CommandGamemode());
        getCommand("heal").setExecutor(new CommandHeal());
        getCommand("aimbot").setExecutor(new CommandAimBot());
        getCommand("feed").setExecutor(new CommandFeed());
        getCommand("enchants").setExecutor(new CommandEnchant());
        getCommand("saturation").setExecutor(new CommandSaturation());
        getCommand("sethost").setExecutor(new CommandSetHost(this));
        getCommand("save").setExecutor(new CommandSave());
        getCommand("setgroup").setExecutor(new CommandSetGroupe());

        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        scheduledExecutorService = Executors.newScheduledThreadPool(16);
        executorMonoThread = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager();








    }


    @Override
    public void onLoad() {


        BIomeEdit.removeBiomes();
    }

    @Override
    public void onDisable() {
        getScoreboardManager().onDisable();
    }
    public static Main getInstance() {
        return instance;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ScheduledExecutorService getExecutorMonoThread() {
        return executorMonoThread;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }




    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerjoin(PlayerJoinEvent e) {


        if(Bukkit.getWorld(CommandStart.wc_area) != null){
            e.getPlayer().teleport(new Location(Bukkit.getWorld(CommandStart.wc_area), -13, 145,18));
        }else{
            if(Bukkit.getWorld("Area1") != null){
                e.getPlayer().teleport(new Location(Bukkit.getWorld("Area1"), -13, 145,18));
            }
        }

        e.setJoinMessage("§2[§c+§2] §6§l"+ e.getPlayer().getName());

    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerjoin(PlayerQuitEvent e) {

        e.setQuitMessage("§2[§c-§2] §6§l"+ e.getPlayer().getName());
    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void uhcRegen(EntityRegainHealthEvent e) {

        if(e.getEntity() instanceof Player){
            if(e.getRegainReason().equals(EntityRegainHealthEvent.RegainReason.SATIATED)){
                Player player = (Player) e.getEntity();
                e.setCancelled(true);
        }

        }

    }

//


    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerjoin(WorldInitEvent e) {

        BIomeEdit.changeBiome("tezst");

    }
//    @EventHandler(priority = EventPriority.NORMAL)
//    public void onGenerate(ChunkLoadEvent event) {
//        if (event.isNewChunk()) {
//            Chunk c = event.getChunk();
//
//            for (int x = 0; x < 16; x++) {
//                for (int z = 0; z < 16; z++) {
//                    for (int y = 0; y <= c.getWorld().getMaxHeight(); y++) {
//                        Block b = c.getBlock(x, y, z);
//                        if(b.getX() < 300 || b.getX() > -300){
//                            if(b.getZ() < 300|| b.getZ() > -300){
//                                b.setBiome(Biome.PLAINS);
//                            }else{
//                                b.setBiome(Biome.ROOFED_FOREST);
//                            }
//                        }else{
//                            b.setBiome(Biome.ROOFED_FOREST);
//                        }
//
//
//
//                    }
//
//                }
//            }
//
//            for (final Player player : Bukkit.getOnlinePlayers()) {
//                new PacketMapChunk(c).send(player);
//            }
//            event.getWorld().refreshChunk(c.getX(), c.getZ());
//
//        }
//
//        }


    @EventHandler(priority = EventPriority.NORMAL)
    public void uhcFoodLevel(FoodLevelChangeEvent e) {

        if(e.getEntity() instanceof Player){
            Player player = (Player) e.getEntity();
            if(e.getFoodLevel() < 20){

                player.setExhaustion(0);
                player.setSaturation(player.getSaturation() + 5);
            }
        }

    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void uhcRegen(PlayerDeathEvent e) {


        e.getEntity().setGameMode(GameMode.SPECTATOR);
        e.getEntity().setHealth(20);

    }


    @EventHandler(priority = EventPriority.NORMAL)
    public void uhcRun(BlockBreakEvent e) {


        Block b = e.getBlock();
        Player p = e.getPlayer();

            if (p.getGameMode() == GameMode.SURVIVAL) {
                if (b.getType() == Material.STONE) {




                    e.setCancelled(true);
                    b.setType(Material.AIR);
                    b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.COBBLESTONE));

                }

                if(Game.CUTCLEAN){
                    if (b.getType() == Material.IRON_ORE) {
                        ((ExperienceOrb)p.getWorld().spawn(b.getLocation(), ExperienceOrb.class)).setExperience(5);


                        e.setCancelled(true);
                        b.setType(Material.AIR);
                        b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.IRON_INGOT));

                    }
                    if (b.getType() == Material.GOLD_ORE) {
                        ((ExperienceOrb)p.getWorld().spawn(b.getLocation(), ExperienceOrb.class)).setExperience(5);

                        e.setCancelled(true);
                        b.setType(Material.AIR);
                        b.getWorld().dropItem(b.getLocation(), new ItemStack(Material.GOLD_INGOT));


                    }
                }


        }


    }

    @EventHandler
    public void eventArrowFired(EntityShootBowEvent e) {
        if (aimbot) {
            if (((e.getEntity() instanceof LivingEntity)) && ((e.getProjectile() instanceof Arrow))) {
                LivingEntity player = e.getEntity();

                double minAngle = 6.283185307179586D;
                Entity minEntity = null;
                for (Entity entity : player.getNearbyEntities(64.0D, 64.0D, 64.0D)) {
                    if ((player.hasLineOfSight(entity)) && ((entity instanceof LivingEntity)) && (!entity.isDead())) {
                        Vector toTarget = entity.getLocation().toVector().clone().subtract(player.getLocation().toVector());
                        double angle = e.getProjectile().getVelocity().angle(toTarget);
                        if (angle < minAngle) {
                            minAngle = angle;
                            minEntity = entity;
                        }
                    }
                }
                if (minEntity != null) {
                    new HomingTask((Arrow) e.getProjectile(), (LivingEntity) minEntity, Main.getInstance());
                }
            }
        }
    }


    public RoleSerializationManager getProfileSerializationManager() {
        return profileSerializationManager;
    }

}

