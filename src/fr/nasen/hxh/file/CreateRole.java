package fr.nasen.hxh.file;

import fr.nasen.hxh.ChatUtils;
import fr.nasen.hxh.Main;
import org.bukkit.entity.Player;

import java.io.File;

public class CreateRole {
    public static String getRole(Player p){
        File file = new File("plugins"+ File.separator+"HxHUhc" + File.separator, p.getUniqueId() + ".json");
        RoleSerializationManager roleSerializationManager = new RoleSerializationManager();

        String json =   FileUtils.loadContent(file);
        RoleProfile profile = roleSerializationManager.deserialize(json);
        return profile.getRole();
    }
    public static String getNen(Player p){
        File file = new File("plugins"+ File.separator+"HxHUhc" + File.separator, p.getUniqueId() + ".json");
        RoleSerializationManager roleSerializationManager = new RoleSerializationManager();

        String json =   FileUtils.loadContent(file);
        RoleProfile profile = roleSerializationManager.deserialize(json);
        return profile.getNen();
    }
    public static void attributRole(Player p, String role, String nen ){
        File file = new File("plugins"+ File.separator+"HxHUhc" + File.separator, p.getUniqueId() + ".json");
        RoleSerializationManager profileSerializationManager = new RoleSerializationManager();
        RoleProfile profile = RoleProfile.createProfile(role, nen);
        String json = profileSerializationManager.serialize(profile);
        FileUtils.save(file, json);
    }
}
