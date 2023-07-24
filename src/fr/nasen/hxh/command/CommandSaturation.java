package fr.nasen.hxh.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSaturation implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if(s.equals("saturation")) {


            if (args.length > 0) {

                int saturation = Integer.parseInt(args[0]);
                if(player.getSaturation() <= 20 ){
                    for (Player p : Bukkit.getOnlinePlayers()) {
                      p.setExhaustion(saturation);
                      p.sendMessage("rze");
                    }
                }



            }
        }
        return false;
    }
}
