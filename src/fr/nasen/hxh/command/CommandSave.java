package fr.nasen.hxh.command;

import fr.nasen.hxh.Main;
import fr.nasen.hxh.game.ItemUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static fr.nasen.hxh.command.CommandSetHost.config;
import static fr.nasen.hxh.gui.GuiInventaire.inventory_inventaire;

public class CommandSave implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(s.equals("save")){
            Player player = (Player) commandSender;

           inventory_inventaire.setItem(0,player.getInventory().getItem(9));       inventory_inventaire.setItem(9, player.getInventory().getItem(18));     inventory_inventaire.setItem(18,player.getInventory().getItem(27));
           inventory_inventaire.setItem(1,player.getInventory().getItem(10));      inventory_inventaire.setItem(10,player.getInventory().getItem(19));     inventory_inventaire.setItem(19,player.getInventory().getItem(28));
           inventory_inventaire.setItem(2,player.getInventory().getItem(11));      inventory_inventaire.setItem(11,player.getInventory().getItem(20));     inventory_inventaire.setItem(20,player.getInventory().getItem(29));
           inventory_inventaire.setItem(3,player.getInventory().getItem(12));      inventory_inventaire.setItem(12,player.getInventory().getItem(21));     inventory_inventaire.setItem(21,player.getInventory().getItem(30));
           inventory_inventaire.setItem(4,player.getInventory().getItem(13));      inventory_inventaire.setItem(13,player.getInventory().getItem(22));     inventory_inventaire.setItem(22,player.getInventory().getItem(31));
           inventory_inventaire.setItem(5,player.getInventory().getItem(14));      inventory_inventaire.setItem(14,player.getInventory().getItem(23));     inventory_inventaire.setItem(23,player.getInventory().getItem(32));
           inventory_inventaire.setItem(6,player.getInventory().getItem(15));      inventory_inventaire.setItem(15,player.getInventory().getItem(24));     inventory_inventaire.setItem(24,player.getInventory().getItem(33));
           inventory_inventaire.setItem(7,player.getInventory().getItem(16));      inventory_inventaire.setItem(16,player.getInventory().getItem(25));     inventory_inventaire.setItem(25,player.getInventory().getItem(34));
           inventory_inventaire.setItem(8,player.getInventory().getItem(17));      inventory_inventaire.setItem(17,player.getInventory().getItem(26));     inventory_inventaire.setItem(26,player.getInventory().getItem(35));

            inventory_inventaire.setItem(27,player.getInventory().getItem(0));inventory_inventaire.setItem(45,player.getInventory().getHelmet());
            inventory_inventaire.setItem(28,player.getInventory().getItem(1));inventory_inventaire.setItem(46,player.getInventory().getChestplate());
            inventory_inventaire.setItem(29,player.getInventory().getItem(2));inventory_inventaire.setItem(47,player.getInventory().getLeggings());
            inventory_inventaire.setItem(30,player.getInventory().getItem(3));inventory_inventaire.setItem(48,player.getInventory().getBoots());
            inventory_inventaire.setItem(31,player.getInventory().getItem(4));
            inventory_inventaire.setItem(32,player.getInventory().getItem(5));
            inventory_inventaire.setItem(33,player.getInventory().getItem(6));
            inventory_inventaire.setItem(34,player.getInventory().getItem(7));
            inventory_inventaire.setItem(35,player.getInventory().getItem(8));
            player.getInventory().clear();
            Main.isInventory = false;

            ItemUtils.ItemEnchant(config);
            player.getInventory().setItem(4,config);
            return true;
        }

        return false;
    }
}
