package fr.nasen.hxh.gui;

import fr.nasen.hxh.game.ItemUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiEnchant implements Listener {
    public static Inventory inventory_enchants;
    public static final ItemStack vide = new ItemStack(Material.AIR, 1);
    final ItemStack vert = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 5);
    public static final ItemStack red = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
    public static ItemStack livre1 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static  final ItemStack livre2 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static final ItemStack livre3 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static final ItemStack livre4 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static final ItemStack livre5 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static  final ItemStack livre6 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static final ItemStack livre7 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static final ItemStack livre8 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static final ItemStack livre9 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static  final ItemStack livre10 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static final ItemStack livre11 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static  final ItemStack livre12 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static final ItemStack livre13 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static  final ItemStack livre14 = new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static  final ItemStack livre15= new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static  final ItemStack livre16= new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static  final ItemStack livre17= new ItemStack(Material.ENCHANTED_BOOK, 1);
    public static final ItemStack livre18= new ItemStack(Material.ENCHANTED_BOOK, 1);
    public GuiEnchant(){

        inventory_enchants = Bukkit.createInventory(null,3*9 ,   "§2§lH§c§lx§2§lH§6§l-Enchants");
        ItemUtils.ItemDisplayName(livre1,"§dSharpness");
        ItemUtils.ItemVeritableEnchant(livre1, Enchantment.DAMAGE_ALL, 0);
        ItemUtils.ItemDisplayName(livre2,"§dProtection");
        ItemUtils.ItemVeritableEnchant(livre2, Enchantment.PROTECTION_ENVIRONMENTAL, 0);
        ItemUtils.ItemDisplayName(livre3,"§dUnbreaking");
        ItemUtils.ItemVeritableEnchant(livre3, Enchantment.DURABILITY, 0);
        ItemUtils.ItemDisplayName(livre4,"§dPower");
        ItemUtils.ItemVeritableEnchant(livre4, Enchantment.ARROW_DAMAGE, 0);
        ItemUtils.ItemDisplayName(livre5,"§dKnockback");
        ItemUtils.ItemVeritableEnchant(livre5, Enchantment.KNOCKBACK, 0);
        ItemUtils.ItemDisplayName(livre6,"§dInfinity");
        ItemUtils.ItemVeritableEnchant(livre6, Enchantment.ARROW_INFINITE, 0);
        ItemUtils.ItemDisplayName(livre7,"§dFire Aspect");
        ItemUtils.ItemVeritableEnchant(livre7, Enchantment.FIRE_ASPECT, 0);
        ItemUtils.ItemDisplayName(livre8,"§dDepth Strider");
        ItemUtils.ItemVeritableEnchant(livre8, Enchantment.DEPTH_STRIDER, 0);
        ItemUtils.ItemDisplayName(livre9,"§dEfficiency");
        ItemUtils.ItemVeritableEnchant(livre9, Enchantment.DIG_SPEED, 0);
        ItemUtils.ItemDisplayName(livre10,"§dFlame");
        ItemUtils.ItemVeritableEnchant(livre10, Enchantment.ARROW_FIRE, 0);
        ItemUtils.ItemDisplayName(livre11,"§dFortune");
        ItemUtils.ItemVeritableEnchant(livre11, Enchantment.LOOT_BONUS_BLOCKS, 0);
        ItemUtils.ItemDisplayName(livre12,"§dBlast Protection");
        ItemUtils.ItemVeritableEnchant(livre12, Enchantment.PROTECTION_EXPLOSIONS, 0);
        ItemUtils.ItemDisplayName(livre13,"§dFire Protection");
        ItemUtils.ItemVeritableEnchant(livre13, Enchantment.PROTECTION_FIRE, 0);
        ItemUtils.ItemDisplayName(livre14,"§dFeather Falling");
        ItemUtils.ItemVeritableEnchant(livre14, Enchantment.PROTECTION_FALL, 0);
        ItemUtils.ItemDisplayName(livre15,"§dPunch");
        ItemUtils.ItemVeritableEnchant(livre15, Enchantment.ARROW_KNOCKBACK, 0);
        ItemUtils.ItemDisplayName(livre16,"§dSilk Touch");
        ItemUtils.ItemVeritableEnchant(livre16, Enchantment.SILK_TOUCH, 0);
        ItemUtils.ItemDisplayName(livre17,"§dSmite");
        ItemUtils.ItemVeritableEnchant(livre17, Enchantment.DAMAGE_UNDEAD, 0);
        ItemUtils.ItemDisplayName(livre18,"§dThorns");
        ItemUtils.ItemVeritableEnchant(livre18, Enchantment.THORNS, 0);

        this.inventory_enchants.setItem(0, red );        this.inventory_enchants.setItem(9, livre1 );        this.inventory_enchants.setItem(18, livre10 );
        this.inventory_enchants.setItem(1, red );        this.inventory_enchants.setItem(10, livre2 );       this.inventory_enchants.setItem(19, livre11 );
        this.inventory_enchants.setItem(2, red );        this.inventory_enchants.setItem(11, livre3 );       this.inventory_enchants.setItem(20, livre12 );
        this.inventory_enchants.setItem(3, red );        this.inventory_enchants.setItem(12, livre4 );       this.inventory_enchants.setItem(21, livre13 );
        this.inventory_enchants.setItem(4, vide );        this.inventory_enchants.setItem(13, livre5 );       this.inventory_enchants.setItem(22, livre14 );
        this.inventory_enchants.setItem(5, red );        this.inventory_enchants.setItem(14, livre6 );       this.inventory_enchants.setItem(23, livre15 );
        this.inventory_enchants.setItem(6, red );        this.inventory_enchants.setItem(15, livre7 );       this.inventory_enchants.setItem(24, livre16 );
        this.inventory_enchants.setItem(7, red );        this.inventory_enchants.setItem(16, livre8 );       this.inventory_enchants.setItem(25, livre17 );
        this.inventory_enchants.setItem(8, red );        this.inventory_enchants.setItem(17, livre9 );       this.inventory_enchants.setItem(26, livre18 );
    }
    @EventHandler
    public void OnClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getInventory().getName().equals(inventory_enchants.getName())) {
            e.setCancelled(true);
        }

        ItemStack item = player.getItemInHand();
        if (e.getInventory().getName().equals(inventory_enchants.getName())) {
            if (e.getSlot() == 9) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.DAMAGE_ALL);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.DAMAGE_ALL, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.DAMAGE_ALL, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.DAMAGE_ALL, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.DAMAGE_ALL, enchant + 1);
            }
            if (e.getSlot() == 10) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.PROTECTION_ENVIRONMENTAL, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.PROTECTION_ENVIRONMENTAL, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.PROTECTION_ENVIRONMENTAL, enchant + 1);
            }
            if (e.getSlot() == 11) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.DURABILITY);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.DURABILITY, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.DURABILITY, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.DURABILITY, enchant + 1);
            }
            if (e.getSlot() == 12) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.ARROW_DAMAGE);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.ARROW_DAMAGE, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.ARROW_DAMAGE, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.ARROW_DAMAGE, enchant + 1);
            }
            if (e.getSlot() == 13) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.KNOCKBACK);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.KNOCKBACK, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.KNOCKBACK, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.KNOCKBACK, enchant + 1);
            }
            if (e.getSlot() == 14) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.ARROW_INFINITE);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.ARROW_INFINITE, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.ARROW_INFINITE, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.ARROW_INFINITE, enchant + 1);
            }
            if (e.getSlot() == 15) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.FIRE_ASPECT);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.FIRE_ASPECT, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.FIRE_ASPECT, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.FIRE_ASPECT, enchant + 1);
            }
            if (e.getSlot() == 16) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.DEPTH_STRIDER);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.DEPTH_STRIDER, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.DEPTH_STRIDER, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.DEPTH_STRIDER, enchant + 1);
            }

            if (e.getSlot() == 17) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.DIG_SPEED);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.DIG_SPEED, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.DIG_SPEED, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.DIG_SPEED, enchant + 1);
            }
            if (e.getSlot() == 18) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.ARROW_FIRE);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.ARROW_FIRE, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.ARROW_FIRE, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.ARROW_FIRE, enchant + 1);
            }
            if (e.getSlot() == 19) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.LOOT_BONUS_BLOCKS, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.LOOT_BONUS_BLOCKS, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.LOOT_BONUS_BLOCKS, enchant + 1);
            }
            if (e.getSlot() == 20) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.PROTECTION_EXPLOSIONS);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.PROTECTION_EXPLOSIONS, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.PROTECTION_EXPLOSIONS, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.PROTECTION_EXPLOSIONS, enchant + 1);
            }
            if (e.getSlot() == 21) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.PROTECTION_FIRE);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.PROTECTION_FIRE, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.PROTECTION_FIRE, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.PROTECTION_FIRE, enchant + 1);
            }
            if (e.getSlot() == 22) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.PROTECTION_FALL);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.PROTECTION_FALL, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.PROTECTION_FALL, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.PROTECTION_FALL, enchant + 1);
            }
            if (e.getSlot() == 23) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.ARROW_KNOCKBACK);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.ARROW_KNOCKBACK, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.ARROW_KNOCKBACK, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.ARROW_KNOCKBACK, enchant + 1);
            }
            if (e.getSlot() == 24) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.SILK_TOUCH);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.SILK_TOUCH, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.SILK_TOUCH, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.SILK_TOUCH, enchant + 1);
            }
            if (e.getSlot() == 25) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.DAMAGE_UNDEAD, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.DAMAGE_UNDEAD, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.DAMAGE_UNDEAD, enchant + 1);
            }
            if (e.getSlot() == 26) {


                int enchant = inventory_enchants.getItem(e.getSlot()).getEnchantmentLevel(Enchantment.THORNS);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(e.getSlot()), Enchantment.THORNS, enchant + 1);
                ItemUtils.ItemVeritableEnchant(inventory_enchants.getItem(4), Enchantment.THORNS, enchant + 1);
                ItemUtils.ItemVeritableEnchant(item, Enchantment.THORNS, enchant + 1);
            }
        }

    }
}
