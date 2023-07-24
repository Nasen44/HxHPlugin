package fr.nasen.hxh.command;

import fr.nasen.hxh.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAimBot implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if(s.equals("aimbot")){

            if(Main.aimbot){
                Main.aimbot= false;
            }else {
                Main.aimbot= true;
            }

        }
        return false;
    }
}
