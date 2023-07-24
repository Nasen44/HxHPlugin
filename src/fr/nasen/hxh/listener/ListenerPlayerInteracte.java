package fr.nasen.hxh.listener;

import fr.nasen.hxh.gui.GuiConfig;
import fr.nasen.hxh.command.CommandSetHost;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ListenerPlayerInteracte implements Listener {

    @EventHandler(priority = EventPriority.NORMAL)
    public void onJoin(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if(e.getItem() != null){
            if(e.getItem().isSimilar(CommandSetHost.config)){
                player.openInventory(GuiConfig.inventory_config);
            }
        }


    }

    @EventHandler
    public void OnClickEvent(InventoryClickEvent e){
        if(e.getCurrentItem().isSimilar(CommandSetHost.config)){
            e.setCancelled(true);
        }
    }



    @EventHandler
    public void onDropEvent(PlayerDropItemEvent e){
        ItemStack itemStack = e.getItemDrop().getItemStack();
        if(itemStack.isSimilar(CommandSetHost.config)){
            e.setCancelled(true);
        }
    }
}
