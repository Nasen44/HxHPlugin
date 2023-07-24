package fr.nasen.hxh.game;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtils {
    public static void ItemDisplayName(ItemStack itemStack, String name){
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
    }
    public static void ItemEnchant(ItemStack itemStack){
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        itemStack.setItemMeta(itemMeta);
    }
    public static void ItemVeritablesEnchant(ItemStack itemStack, Enchantment enchantment, int level){
        EnchantmentStorageMeta meta_rider = (EnchantmentStorageMeta) itemStack.getItemMeta();
        meta_rider.addStoredEnchant(enchantment, level, true);
        itemStack.setItemMeta(meta_rider);
    }
    public static void ItemVeritableEnchant(ItemStack itemStack, Enchantment enchantment, int level){

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addEnchant(enchantment, level, true);
        itemStack.setItemMeta(itemMeta);
    }
    public static void ItemDesEnchant(ItemStack itemStack){
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.removeItemFlags(ItemFlag.HIDE_ENCHANTS);
        itemMeta.removeEnchant(Enchantment.DAMAGE_ALL);
        itemStack.setItemMeta(itemMeta);
    }
}
