package fr.nasen.hxh.command;

import fr.nasen.hxh.Main;
import fr.nasen.hxh.game.Game;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSetGroupe implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(s.equals("setgroup")){

            if(args.length > 0){
                Game.GROUPE = Integer.parseInt(args[0]);
                for(Player player : Bukkit.getOnlinePlayers()){
                    Main.getInstance().tile.sendFullTitle(player, 5,5,40, "§l§c"+"\u26A0" + "Groupe de " + Game.GROUPE+"\u26A0", "§2Merci de bien vouloir respecter la limite de groupe.");

                    player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1F, 1F);
                }
            }
            return true;
        }
        return false;
    }
}
