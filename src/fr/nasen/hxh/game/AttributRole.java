package fr.nasen.hxh.game;

import fr.nasen.hxh.file.CreateRole;
import fr.nasen.hxh.gui.GuiRole;
import fr.nasen.hxh.role.hunter.Biscuit;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class AttributRole {


    public static List<String>  allRole= new ArrayList<>();
    public static void attributRole(){
        allRole.addAll(GuiRole.roleSolo);
        allRole.addAll(GuiRole.roleHunter);
        allRole.addAll(GuiRole.roleFourmis);
        allRole.addAll(GuiRole.roleZoldycks);
        allRole.addAll(GuiRole.roleBrigadeFantome);
        Collections.shuffle(allRole);
        for(Player player : Bukkit.getOnlinePlayers()){
            if(player.getGameMode().equals(GameMode.SURVIVAL)){

                //Donne un role aléatoir a toute les personne presente dans le server (qui sont en survie)
                Random r = new Random();
                int t = r.nextInt(allRole.size());
                String role = allRole.get(t);
                if(role.equals(Biscuit.biscuit)){
                    CreateRole.attributRole(player, role, null);
                    Biscuit.onRoleAttribut(player);
                }else{
                    player.sendMessage("tu est : " + role);
                }


            }
        }

    }
}
