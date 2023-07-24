package fr.nasen.hxh.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHeal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if(s.equals("heal")) {


            if (args.length > 0) {
                player.setHealth(player.getMaxHealth());
                if (args[0].equals("all")) {
                    for (Player p : Bukkit.getOnlinePlayers()) {

                        p.setHealth(p.getMaxHealth());
                    }
                }

            }
        }
        return false;
    }
}
