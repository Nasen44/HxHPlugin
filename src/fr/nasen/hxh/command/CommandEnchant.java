package fr.nasen.hxh.command;

import fr.nasen.hxh.ChatUtils;
import fr.nasen.hxh.Main;
import fr.nasen.hxh.game.ItemUtils;
import fr.nasen.hxh.gui.GuiEnchant;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static fr.nasen.hxh.gui.GuiEnchant.*;

public class CommandEnchant implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        Player player = (Player) commandSender;
        if(s.equals("enchants")){
            if(Main.isInventory){


            if(player.getItemInHand() != null) {
                if (player.getItemInHand().getType() != Material.AIR) {
                    ItemUtils.ItemDisplayName(livre1, "§dSharpness");
                    ItemUtils.ItemVeritableEnchant(livre1, Enchantment.DAMAGE_ALL, 0);
                    ItemUtils.ItemDisplayName(livre2, "§dProtection");
                    ItemUtils.ItemVeritableEnchant(livre2, Enchantment.PROTECTION_ENVIRONMENTAL, 0);
                    ItemUtils.ItemDisplayName(livre3, "§dUnbreaking");
                    ItemUtils.ItemVeritableEnchant(livre3, Enchantment.DURABILITY, 0);
                    ItemUtils.ItemDisplayName(livre4, "§dPower");
                    ItemUtils.ItemVeritableEnchant(livre4, Enchantment.ARROW_DAMAGE, 0);
                    ItemUtils.ItemDisplayName(livre5, "§dKnockback");
                    ItemUtils.ItemVeritableEnchant(livre5, Enchantment.KNOCKBACK, 0);
                    ItemUtils.ItemDisplayName(livre6, "§dInfinity");
                    ItemUtils.ItemVeritableEnchant(livre6, Enchantment.ARROW_INFINITE, 0);
                    ItemUtils.ItemDisplayName(livre7, "§dFire Aspect");
                    ItemUtils.ItemVeritableEnchant(livre7, Enchantment.FIRE_ASPECT, 0);
                    ItemUtils.ItemDisplayName(livre8, "§dDepth Strider");
                    ItemUtils.ItemVeritableEnchant(livre8, Enchantment.DEPTH_STRIDER, 0);
                    ItemUtils.ItemDisplayName(livre9, "§dEfficiency");
                    ItemUtils.ItemVeritableEnchant(livre9, Enchantment.DIG_SPEED, 0);
                    ItemUtils.ItemDisplayName(livre10, "§dFlame");
                    ItemUtils.ItemVeritableEnchant(livre10, Enchantment.ARROW_FIRE, 0);
                    ItemUtils.ItemDisplayName(livre11, "§dFortune");
                    ItemUtils.ItemVeritableEnchant(livre11, Enchantment.LOOT_BONUS_BLOCKS, 0);
                    ItemUtils.ItemDisplayName(livre12, "§dBlast Protection");
                    ItemUtils.ItemVeritableEnchant(livre12, Enchantment.PROTECTION_EXPLOSIONS, 0);
                    ItemUtils.ItemDisplayName(livre13, "§dFire Protection");
                    ItemUtils.ItemVeritableEnchant(livre13, Enchantment.PROTECTION_FIRE, 0);
                    ItemUtils.ItemDisplayName(livre14, "§dFeather Falling");
                    ItemUtils.ItemVeritableEnchant(livre14, Enchantment.PROTECTION_FALL, 0);
                    ItemUtils.ItemDisplayName(livre15, "§dPunch");
                    ItemUtils.ItemVeritableEnchant(livre15, Enchantment.ARROW_KNOCKBACK, 0);
                    ItemUtils.ItemDisplayName(livre16, "§dSilk Touch");
                    ItemUtils.ItemVeritableEnchant(livre16, Enchantment.SILK_TOUCH, 0);
                    ItemUtils.ItemDisplayName(livre17, "§dSmite");
                    ItemUtils.ItemVeritableEnchant(livre17, Enchantment.DAMAGE_UNDEAD, 0);
                    ItemUtils.ItemDisplayName(livre18, "§dThorns");
                    ItemUtils.ItemVeritableEnchant(livre18, Enchantment.THORNS, 0);

                    inventory_enchants.setItem(0, red);
                    inventory_enchants.setItem(9, livre1);
                    inventory_enchants.setItem(18, livre10);
                    inventory_enchants.setItem(1, red);
                    inventory_enchants.setItem(10, livre2);
                    inventory_enchants.setItem(19, livre11);
                    inventory_enchants.setItem(2, red);
                    inventory_enchants.setItem(11, livre3);
                    inventory_enchants.setItem(20, livre12);
                    inventory_enchants.setItem(3, red);
                    inventory_enchants.setItem(12, livre4);
                    inventory_enchants.setItem(21, livre13);
                    inventory_enchants.setItem(4, vide);
                    inventory_enchants.setItem(13, livre5);
                    inventory_enchants.setItem(22, livre14);
                    inventory_enchants.setItem(5, red);
                    inventory_enchants.setItem(14, livre6);
                    inventory_enchants.setItem(23, livre15);
                    inventory_enchants.setItem(6, red);
                    inventory_enchants.setItem(15, livre7);
                    inventory_enchants.setItem(24, livre16);
                    inventory_enchants.setItem(7, red);
                    inventory_enchants.setItem(16, livre8);
                    inventory_enchants.setItem(25, livre17);
                    inventory_enchants.setItem(8, red);
                    inventory_enchants.setItem(17, livre9);
                    inventory_enchants.setItem(26, livre18);
                    GuiEnchant.inventory_enchants.setItem(4, player.getItemInHand());
                    player.openInventory(GuiEnchant.inventory_enchants);

                } else {
                    player.sendMessage(ChatUtils.hxhUhc + "Vous ne tenez rien dans votre main.");
                }
            }
            }


        }
        return false;
    }
}
