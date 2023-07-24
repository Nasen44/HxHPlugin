package fr.nasen.hxh.command;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if(s.equals("gmc")){
            player.setGameMode(GameMode.CREATIVE);
        }
        if(s.equals("gms")){
            player.setGameMode(GameMode.SURVIVAL);
        }
        if(s.equals("gma")){
            player.setGameMode(GameMode.ADVENTURE);
        }if(s.equals("gmsp")){
            player.setGameMode(GameMode.SPECTATOR);
        }




        return false;
    }
}
