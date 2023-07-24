package fr.nasen.hxh.listener;

import fr.nasen.hxh.Main;
import fr.nasen.hxh.command.CommandSetHost;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ListenerPlayerJoin implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        Main.getInstance().getScoreboardManager().onLogin(p);

    }
    @EventHandler(priority = EventPriority.NORMAL)
    public void onBlockPose(BlockPlaceEvent e) {

        if(e.getBlockPlaced().getType().equals(Material.REDSTONE_COMPARATOR_OFF)){

            if(e.getPlayer().getItemInHand().equals(CommandSetHost.config)){
                e.setCancelled(true);
            }

        }

    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Main.getInstance().getScoreboardManager().onLogout(p);

    }


}
