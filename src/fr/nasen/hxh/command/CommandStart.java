package fr.nasen.hxh.command;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.world.DataException;
import fr.nasen.hxh.ChatUtils;
import fr.nasen.hxh.Main;
import fr.nasen.hxh.biome.BIomeEdit;
import fr.nasen.hxh.biome.OrePopulator;
import fr.nasen.hxh.file.CreateRole;
import fr.nasen.hxh.file.RoleProfile;
import fr.nasen.hxh.game.AttributRole;
import fr.nasen.hxh.game.Game;
import fr.nasen.hxh.gui.GuiRole;


import fr.nasen.hxh.role.hunter.Biscuit;
import org.bukkit.*;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.block.CraftBlock;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;


import static com.sun.org.apache.xml.internal.security.Init.isInitialized;

public class CommandStart implements CommandExecutor {
    public static String wc_area = "Area1";
    public static OrePopulator populator;
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if (s.equals("hxh")) {
            if (args[0].equalsIgnoreCase("role")) {

                if(Game.STARTGAME) {
                    if (CreateRole.getRole(player).equals(Biscuit.biscuit)) {
                        player.sendMessage(Biscuit.message());
                    }
                }else{
                    player.sendMessage(ChatUtils.hxhUhc+  "La game n'a pas commencé");
                }
            }
            if (args[0].equalsIgnoreCase("kukki")) {

                if(Bukkit.getPlayer(args[1]) != null){
                if(CreateRole.getRole(player).equals(Biscuit.biscuit)) {

                    if (Biscuit.UTIL_REGEN < 2) {

                        Player p = Bukkit.getPlayer(args[1]);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 1, false, false));

                        Biscuit.UTIL_REGEN++;
                    }

                }else{
                    player.sendMessage(ChatUtils.hxhUhc + "Ce joueur n'est pas connecté");
                }
                }
            }
            if (args[0].equalsIgnoreCase("compo")) {
                String str = "";
                for(String s1 : GuiRole.roleHunter){
                    str += "\n"+ "  §8§l-§r" + s1;
                }
                String str1 = "";
                for(String s1 : GuiRole.roleZoldycks){
                    str1 += "\n"+ "  §8§l-§r" + s1;
                }
                String str2 = "";
                for(String s1 : GuiRole.roleBrigadeFantome){
                    str2 += "\n"+ "  §8§l-§r" + s1;
                }
                String str3 = "";
                for(String s1 : GuiRole.roleFourmis){
                    str3 += "\n"+ "  §8§l-§r" + s1;
                }
                String str4 = "";
                for(String s1 : GuiRole.roleSolo){
                    str4 += "\n"+ "  §8§l-§r" + s1;
                }
                player.sendMessage( "§m-----------------------§r" + "\n"+ " " + "\n"+ "§2§lHunter§8(§7" + GuiRole.roleHunter.size() + "§8)"+ "\n" + " "+ "\n" +
                        str + "\n"+ " " +"\n" + "§5§lZoldycks§8(§7"+ GuiRole.roleZoldycks.size()+ "§8)"+ "\n" + " "+ "\n" + str1+ "\n" + " "+"\n"+ "§7§lBrigade Fantome§8(§7" + GuiRole.roleBrigadeFantome.size() + "§8)"+ "\n" + " "+ "\n" + str2 +"\n" + " "+ "\n" +  "§c§lFourmis§8(§7" + GuiRole.roleFourmis.size() + "§8)"+ "\n" + " "+ "\n" + str3 + "\n" + " "+ "\n" +
                        "§6§lSolo§8(§7" + GuiRole.roleSolo.size() + "§8)"+ "\n" + " "+ "\n" +str4+ "\n" + " "+ "\n" +

                        "§r§m-----------------------");
            }
            if (args[0].equalsIgnoreCase("pregen")) {

                if(Bukkit.getWorld(wc_area) == null){
                    Main.getInstance().tile.sendFullTitle(player, 20, 200, 20, ChatColor.RED +"Le server est en creation " , ChatColor.GREEN + "Merci de bien vouloir patientez et de ne pas spam" );




//




                    WorldCreator wc = new WorldCreator(wc_area);
                    BIomeEdit.removeBiomes();
                    wc.type(WorldType.LARGE_BIOMES);
                    wc.environment(World.Environment.NORMAL);
                    World w = Bukkit.createWorld(wc);
                    wc.createWorld().setSpawnLocation(-150,70,0);






//                    int t = 0;
//                    for(int x = 0; x<100; x++){
//
//                        if(x == 99){
//
//                            t++;
//                            x=0;
//
//                        }
//                        setChunkBiome(wc.createWorld().getChunkAt(x,t), Biome.DEEP_OCEAN);
//
//                    }






                    w.setSpawnLocation(-13, 145, 18);
                    w.setGameRuleValue("doFireTick", "false");
                    WorldBorder worldBorder = w.getWorldBorder();
                    worldBorder.setCenter(0,0);
                    worldBorder.setDamageAmount(0);
                    worldBorder.setDamageBuffer(0);
                    worldBorder.setSize(2500, 0);
                    setupNormalWorld(w);


                    for(Player player1 : Bukkit.getOnlinePlayers()){
                        player1.teleport(w.getSpawnLocation());

                    }

                    loadSchematic(wc_area);
//                for(Player p : Bukkit.getOnlinePlayers()){
//                    Random r = new Random();
//                    int t = r.nextInt(700);
//                    int v = r.nextInt(700);
//                    p.teleport(new Location(wc.createWorld(), t, 60, v));
//                }
                }else{
                    player.sendMessage(ChatUtils.hxhUhc + "Il faut exécuté /hxh delete pour supprimé le monde avant de pregen ! ");
                }



            }
            if (args[0].equalsIgnoreCase("tp")) {

                File file = new File("Area1");
                if(args[1].equalsIgnoreCase("Area1")){
                    if(file.exists()){
                        player.teleport(new Location(Bukkit.getWorld((args[1])), 0, 70, 0));
                    }else{

                        player.sendMessage("Le monde n'a pas été pregen ! ");
                    }

                }else{
                    player.teleport(new Location(Bukkit.getWorld((args[1])), 0, 70, 0));
                }

            }
            if (args[0].equalsIgnoreCase("force")) {
                if (args[1].equalsIgnoreCase("role")) {
                    if(Game.STARTGAME){
                        //Attribution des roles
                        AttributRole.attributRole();
                    }

                }
            }
            if (args[0].equalsIgnoreCase("test")) {

            }
            if (args[0].equalsIgnoreCase("delete")) {






                World worldtodelete = Bukkit.getWorld("Area12");
                File folder = worldtodelete.getWorldFolder();
                Bukkit.getServer().unloadWorld((worldtodelete), isInitialized()); //unload world
                deleteDirectory(folder); //delete world


                if(Bukkit.getWorld("Area1") == null){
                    WorldCreator wc = new WorldCreator("Area1");

                    BIomeEdit.changeBiome("ROOFED_FOREST");
                    wc.type(WorldType.LARGE_BIOMES);
                    wc.environment(World.Environment.NORMAL);
                    World w = Bukkit.createWorld(wc);
                    wc.createWorld().setSpawnLocation(-13, 145, 18);

                    CommandStart.loadSchematic("Area1");
                    for(Player p : Bukkit.getOnlinePlayers()){
                        p.teleport(new Location(Bukkit.getWorld(("Area1")),-13, 145, 18));
                    }

                    if(Bukkit.getWorld(wc_area) != null){
                        World worldtodeletes = Bukkit.getWorld("Area12");
                        File folders = worldtodeletes.getWorldFolder();
                        Bukkit.getServer().unloadWorld((worldtodeletes), isInitialized()); //unload world
                        deleteDirectory(folders); //delete world
                    }

                }else{
                    if(Bukkit.getWorld(wc_area) != null){
                        World worldtodeletes = Bukkit.getWorld("Area12");
                        File folders = worldtodeletes.getWorldFolder();
                        Bukkit.getServer().unloadWorld((worldtodeletes), isInitialized()); //unload world
                        deleteDirectory(folders); //delete world
                    }
                    for(Player p : Bukkit.getOnlinePlayers()){
                        p.teleport(new Location(Bukkit.getWorld(("Area1")),-13, 145, 18));
                    }
                }


            }

            }
        return false;
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }

        // The directory is now empty so delete it
        return dir.delete();
    }

    public static boolean deleteDirectory(File path) {
        if( path.exists() ) {
            File files[] = path.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                }
                else {
                    files[i].delete();
                } //end else
            }
        }
        return( path.delete() );
    }
    public static  void setupNormalWorld(World world) {
        populator = new OrePopulator();
        populator.addRule(new OrePopulator.Rule("DIAMOND_ORE", 4, 9, 18, 3));
        populator.addRule(new OrePopulator.Rule("GOLD_ORE", 5, 15, 40, 4));

        world.getPopulators().add(populator);
    }

    public static void loadSchematic(String area)
    {
        Location location = new Location(Bukkit.getWorld(area), 0,150, 0);
        WorldEditPlugin worldEditPlugin = (WorldEditPlugin)Bukkit.getPluginManager().getPlugin("WorldEdit");
        File schematic = new File("plugins"+ File.separator+"HxHUhc" + File.separator + "/schematics/SpawnHxH.schematic");
        System.out.println("plugins"+ File.separator+"HxHUhc" + File.separator + "/schematics/SpawnHxH.schematic");
        EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(location.getWorld()), 100000000);

        try
        {
            CuboidClipboard clipboard = MCEditSchematicFormat.getFormat(schematic).load(schematic);
            clipboard.rotate2D(90);
            clipboard.paste(session, new Vector(location.getX(), location.getY(), location.getZ()), false);
        }
        catch (MaxChangedBlocksException | DataException | IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Set the biome for a chunk.
     *
     * @param chunk The chunk.
     * @param biome The biome to set.
     */

    public static  void setChunkBiome(Chunk chunk, Biome biome) {
        for(int x = 0 ; x < 16; x++) {
            for(int z = 0 ; z < 16; z++) {
                final Block block = chunk.getBlock(x, 0, z);
                block.setBiome(biome);
            }
        }
    }

    public void replaceChunkBiome(Chunk chunk, Biome oldBiome, Biome newBiome) {
        for(int x = 0 ; x < 16; x++) {
            for(int z = 0 ; z < 16; z++) {
                if(chunk.getBlock(x, 0, z).getBiome() == oldBiome) {
                    final Block block = chunk.getBlock(x, 0, z);
                    block.setBiome(newBiome);
                }
            }
        }
    }
}
