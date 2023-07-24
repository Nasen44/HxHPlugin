package fr.nasen.hxh.role.hunter;

import fr.nasen.hxh.ChatUtils;
import fr.nasen.hxh.file.CreateRole;
import fr.nasen.hxh.game.Game;
import fr.nasen.hxh.game.ItemUtils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Biscuit implements Listener {

    public static int UTIL_REGEN = 0;
    public static int cooldown_biscuit = 0;

    public static ItemStack nether = new ItemStack(Material.NETHER_STAR, 1);

    public static String biscuit =  "§aBiscuit";
    public static void onRoleAttribut(Player p){
        p.sendMessage(message());

        ItemUtils.ItemEnchant(nether);
        ItemUtils.ItemDisplayName(nether, ChatColor.GOLD + "Transformation");
        p.getInventory().addItem(nether);

    }

    public static String message(){
        return
                "§m--------------------§r"+ "\n"+
                "§fTu §fes §aBiscuit\n" +
                "§fTu §fdois §fgagner §favec §fles §aHunter\n" +
                "§8Pouvoirs:\n" +
                "§d/hxh §dkukki §f(pseudo) : §8Octroie §8l'effets §drégéneration §d2 §8pendant §830 §8secondes §8aux §8joueurs §8choisis\n" +
                "§dTransformation §8: §8Octroie §8l'effet §4Force §41 §8pendant §85 §8minutes (§8Cooldown-§810 §8minutes)\n" +
                "§fNature §fde §fNen §f: Transformation"+ "\n"
                +  "§m--------------------";
    }
    public void regenPlayer(Player player){

    }

    @EventHandler
    private void transformationBuscuit(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if(Game.STARTGAME){
            if(CreateRole.getRole(player).equals(biscuit)){

                if(cooldown_biscuit ==0){

                    cooldown_biscuit = 600;
                    player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600, 0, false,false));
                }else {

                    player.sendMessage(ChatUtils.cooldown);
                }
            }
        }

    }
}
