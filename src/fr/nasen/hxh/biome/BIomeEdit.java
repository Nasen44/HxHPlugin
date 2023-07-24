package fr.nasen.hxh.biome;

import net.minecraft.server.v1_8_R3.BiomeBase;
import org.bukkit.Bukkit;

import java.lang.reflect.Field;

public class BIomeEdit {

    public static void changeBiome(String Biome){
        try {
            String mojangPath = "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
            Class clazz = Class.forName(mojangPath + ".BiomeBase");

            Field plainsField = clazz.getDeclaredField(Biome);
            plainsField.setAccessible(true);
            Object plainsBiome = plainsField.get(null);

            // Biomes liste auslesen
            Field biomesField = clazz.getDeclaredField("biomes");
            biomesField.setAccessible(true);
            Object[] biomes = (Object[]) biomesField.get(null);



            // Ocean auf Plains setzen

            for(int i = 0;i< biomes.length;i++){
                if(i != BiomeBase.ROOFED_FOREST.id){
                    biomes[i] = BiomeBase.PLAINS;
                }else {
                    biomes[i] = BiomeBase.ROOFED_FOREST;
                }

            }


            biomesField.set(null, biomes);
        } catch (Exception e) {
            // Error
        }

    }
    public static void removeBiomes() {
        try {
            java.lang.reflect.Field biomesField = BiomeBase.class.getDeclaredField("biomes");
            biomesField.setAccessible(true);
            if ((biomesField.get(null) instanceof BiomeBase[])) {
                BiomeBase[] biomes = (BiomeBase[]) biomesField.get(null);
                biomes[BiomeBase.DEEP_OCEAN.id] = BiomeBase.PLAINS;
                biomes[BiomeBase.FROZEN_OCEAN.id] = BiomeBase.ROOFED_FOREST;
                biomes[BiomeBase.OCEAN.id] = BiomeBase.ROOFED_FOREST;
                biomes[BiomeBase.JUNGLE.id] = BiomeBase.ROOFED_FOREST;
                biomes[BiomeBase.JUNGLE_EDGE.id] = BiomeBase.ROOFED_FOREST;
                biomes[BiomeBase.JUNGLE_HILLS.id] = BiomeBase.DESERT;
                biomes[BiomeBase.MEGA_TAIGA.id] = BiomeBase.BIRCH_FOREST;
                biomes[BiomeBase.MEGA_TAIGA_HILLS.id] = BiomeBase.BEACH;
                biomes[BiomeBase.MESA.id] = BiomeBase.SAVANNA;
                biomes[BiomeBase.MESA_PLATEAU.id] = BiomeBase.SAVANNA_PLATEAU;
                biomes[BiomeBase.MESA_PLATEAU_F.id] = BiomeBase.BIRCH_FOREST_HILLS;
                biomes[BiomeBase.ICE_PLAINS.id] = BiomeBase.PLAINS;
                biomes[BiomeBase.ICE_MOUNTAINS.id] = BiomeBase.ROOFED_FOREST;
                biomes[BiomeBase.ICE_MOUNTAINS.id] = BiomeBase.ROOFED_FOREST;
                biomesField.set(null, biomes);
            }
        } catch (Exception ignored) {
        }
    }
}
