package fr.nasen.hxh.command;

import fr.nasen.hxh.Main;
import fr.nasen.hxh.game.Game;
import fr.nasen.hxh.game.ItemUtils;
import fr.nasen.hxh.scoreboard.PersonalScoreboard;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.data.DataMutateResult;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.NodeEqualityPredicate;
import net.luckperms.api.node.types.InheritanceNode;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.io.File;

public class CommandSetHost implements CommandExecutor {
    public  static final ItemStack config = new ItemStack(Material.REDSTONE_COMPARATOR, 1);
    private LuckPerms luckPerms;
    public Main plugin;
    public CommandSetHost(Main main){
        this.luckPerms = Bukkit.getServicesManager().getRegistration(LuckPerms.class).getProvider();
        plugin = main;

    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if(s.equals("sethost")){
            Player host = Bukkit.getPlayer(args[0]);
            if(!Game.STARTGAME){
                player.getInventory().clear();
            }



            if(isInGroup(player, "host")){
                removeFromGroup(player, "host");
                addToGroup(host, "host");
                PersonalScoreboard.host = host.getUniqueId();
                ItemUtils.ItemEnchant(config);
                ItemUtils.ItemDisplayName(config, "§8[§6Configuration§8]");
                host.getInventory().setItem(4,config);
            }else {
                if(player.isOp()){
                    PersonalScoreboard.host = host.getUniqueId();
                    addToGroup(host, "host");
                    ItemUtils.ItemEnchant(config);
                    host.getInventory().setItem(4,config);
                }
            }




        }
        return false;
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
    public boolean addToGroup(OfflinePlayer player, String group) {
        Group newGroup = luckPerms.getGroupManager().getGroup(group);
        if (newGroup == null) {
            return false;
        }

        String playerName = player.getName();
        if (playerName == null) {
            return false;
        }
        User user = luckPerms.getUserManager().getUser(playerName);
        if (user == null) {
            return false;
        }

        InheritanceNode node = InheritanceNode.builder(group).build();
        DataMutateResult result = user.data().add(node);
        if (result == DataMutateResult.FAIL) {
            return false;
        }

        luckPerms.getUserManager().saveUser(user);
        return true;
    }


    public boolean removeFromGroup(OfflinePlayer player, String group) {
        String playerName = player.getName();
        if (playerName == null) {
            return false;
        }
        User user = luckPerms.getUserManager().getUser(playerName);
        if (user == null) {
            Main.getInstance().getLogger().warning("LuckPermsHandler: tried to remove group for offline user "
                    + player.getName() + " but it isn't loaded!");
            return false;
        }

        InheritanceNode groupNode = InheritanceNode.builder(group).build();
        boolean result = user.data().remove(groupNode) != DataMutateResult.FAIL;

        luckPerms.getUserManager().saveUser(user);
        return result;
    }

}
