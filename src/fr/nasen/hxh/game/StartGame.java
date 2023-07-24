package fr.nasen.hxh.game;

import fr.nasen.hxh.Main;
import fr.nasen.hxh.role.hunter.Biscuit;
import org.bukkit.scheduler.BukkitRunnable;

public class StartGame {

    public static int tempsSec;
    public static int tempsMin;
    public static int tempsHeure;
    public static void startGame(){

        new BukkitRunnable() {

            @Override
            public void run() {

                tempsSec++;
                if(tempsSec == 60){
                    tempsSec = 0;
                    tempsMin++;
                    if(tempsMin==60){
                        tempsMin=0;
                        tempsHeure++;
                    }
                }

                if(Biscuit.cooldown_biscuit != 0){
                    Biscuit.cooldown_biscuit--;
                }

            }
        }.runTaskTimer(Main.getInstance(), 0, 20);
    }
}
