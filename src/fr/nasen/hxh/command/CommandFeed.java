package fr.nasen.hxh.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandFeed implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if(s.equals("feed")){

            player.setFoodLevel(20);

            if(args.length >0){
                if(args[0].equals("all")){
                    for(Player p : Bukkit.getOnlinePlayers()){
                        p.setFoodLevel(20);
                    }
                }else {
                    Bukkit.getPlayer(args[0]).setFoodLevel(20);
                }
            }








        }
        return false;
    }
}
