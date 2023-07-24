package fr.nasen.hxh.scoreboard;
import fr.nasen.hxh.Main;
import fr.nasen.hxh.command.CommandStart;
import fr.nasen.hxh.game.Game;
import fr.nasen.hxh.game.StartGame;
import fr.nasen.hxh.gui.GuiRole;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.NodeEqualityPredicate;
import net.luckperms.api.node.types.InheritanceNode;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.UUID;
public class PersonalScoreboard {
    private Player player;
    private final UUID uuid;
    private final ObjectiveSign objectiveSign;
    private LuckPerms luckPerms;
    public Main plugin;
    public static  UUID host;
    PersonalScoreboard(UUID uuid, ObjectiveSign objectiveSign, Main main){
        this.uuid = uuid;
        this.objectiveSign = objectiveSign;
        this.luckPerms = Bukkit.getServicesManager().getRegistration(LuckPerms.class).getProvider();
        plugin = main;
    }
    PersonalScoreboard(Player player){

        this.player = player;
        uuid = player.getUniqueId();
        objectiveSign = new ObjectiveSign("sidebar", "§2H§cX§2H§6-UHC");

        reloadData();
        objectiveSign.addReceiver(player);
    }

    public void reloadData(){}

    public void setLines(String ip){

        objectiveSign.setDisplayName("§2§lH§c§lX§2§lH§6§l-UHC");

//        objectiveSign.setLine(0, "§1");
//        objectiveSign.setLine(1, "§6Joueurs: §a" + Bukkit.getOnlinePlayers().size() + "/20");
//        objectiveSign.setLine(2, "§6Pseudo: §b" + player.getName());
//        objectiveSign.setLine(3, "§2");
//        objectiveSign.setLine(4, ip);

        objectiveSign.setLine(0, "§1");
        objectiveSign.setLine(1, "§m--------------------------§m");
        objectiveSign.setLine(2, "      ");
        objectiveSign.setLine(3, "  §2Pseudo: §c" + player.getName());
        objectiveSign.setLine(4, "  §2Joueurs : §c" + Bukkit.getOnlinePlayers().size() + "/20");



            if (host != null) {
                objectiveSign.setLine(5, "  §2Host: §c" + Bukkit.getPlayer(host).getName());
            } else {
                objectiveSign.setLine(5, "  §2Host: §c" + "Not Found");

            }



        objectiveSign.setLine(6, "");
        objectiveSign.setLine(7, "§m--------------------------§m ");
        objectiveSign.setLine(8, "   ");
        objectiveSign.setLine(9, "https://discord.gg/UZ4DqWVHx9");
        if(Game.STARTGAME){
            objectiveSign.setLine(0, "§1");
            objectiveSign.setLine(1, "§m--------------------------§m");
            objectiveSign.setLine(2, "      ");
            if(StartGame.tempsHeure ==0){
                if(StartGame.tempsMin == 0){
                    objectiveSign.setLine(3, "  §2Temps: §c" + StartGame.tempsSec + "sec");
                }else{
                    objectiveSign.setLine(3, "  §2Temps: §c" +StartGame.tempsMin +"min " +  StartGame.tempsSec + "sec " );
                }
            }else {
                objectiveSign.setLine(3, "  §2Temps: §c" + StartGame.tempsHeure+"h "+ StartGame.tempsMin +"min " +StartGame.tempsSec + "sec " );
            }

            objectiveSign.setLine(4, "  §2Joueurs : §c" + Bukkit.getOnlinePlayers().size() + "/20");



            if (host != null) {
                objectiveSign.setLine(5, "  §2Host: §c" + Bukkit.getPlayer(host).getName());
            } else {
                objectiveSign.setLine(5, "  §2Host: §c" + "Not Found");

            }

            objectiveSign.setLine(6, "  §2Groupes : §c" + Game.GROUPE);

            objectiveSign.setLine(7, "");
            objectiveSign.setLine(8, "§m--------------------------§m ");
            objectiveSign.setLine(9, "   ");
            objectiveSign.setLine(10, "https://discord.gg/UZ4DqWVHx9");
        }
        objectiveSign.updateLines();
    }
    public boolean isInGroup(OfflinePlayer player, String group) {
        String playerName = player.getName();
        if (playerName == null) {
            return false;
        }
        User user = luckPerms.getUserManager().getUser(playerName);
        if (user == null) {


            return false;
        }

        InheritanceNode inheritanceNode = InheritanceNode.builder(group).build();
        return user.data().contains(inheritanceNode, NodeEqualityPredicate.EXACT).asBoolean();
    }
    public void onLogout(){
        objectiveSign.removeReceiver(Bukkit.getServer().getOfflinePlayer(uuid));
    }
}




