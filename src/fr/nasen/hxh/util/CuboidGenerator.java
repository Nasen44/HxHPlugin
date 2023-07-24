package fr.nasen.hxh.util;
import fr.nasen.hxh.Main;
import javafx.print.PageLayout;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
public class CuboidGenerator {
    private final String worldName;

    private final int x1;

    private final int y1;

    private final int z1;

    private final int x2;

    private final int y2;

    private final int z2;

    public CuboidGenerator(JavaPlugin plugin, World world, int x1, int y1, int z1, int x2, int y2, int z2) {
        this.worldName = world.getName();
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.z1 = Math.min(z1, z2);
        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);
        this.z2 = Math.max(z1, z2);
    }

    public CuboidGenerator(JavaPlugin plugin, World world, int size) {
        this.worldName = world.getName();
        this.x1 = Math.min(size, -size);
        this.y1 = 3;
        this.z1 = Math.min(size, -size);
        this.x2 = Math.max(size, -size);
        this.y2 = 3;
        this.z2 = Math.max(size, -size);
    }

    public Location getLowerNE() {
        return new Location(getWorld(), this.x1, this.y1, this.z1);
    }

    public Location getUpperSW() {
        return new Location(getWorld(), this.x2, this.y2, this.z2);
    }

    public World getWorld() {
        return Bukkit.getWorld(this.worldName);
    }

    public Location getCenter() {
        int x1 = getUpperX() + 1;
        int y1 = getUpperY() + 1;
        int z1 = getUpperZ() + 1;
        return new Location(getWorld(), getLowerX() + (x1 - getLowerX()) / 2.0D, getLowerY() + (y1 - getLowerY()) / 2.0D, getLowerZ() + (z1 - getLowerZ()) / 2.0D);
    }

    public int getSizeX() {
        return this.x2 - this.x1 + 1;
    }

    public int getSizeY() {
        return this.y2 - this.y1 + 1;
    }

    public int getSizeZ() {
        return this.z2 - this.z1 + 1;
    }

    public int getLowerX() {
        return this.x1;
    }

    public int getLowerY() {
        return this.y1;
    }

    public int getLowerZ() {
        return this.z1;
    }

    public int getUpperX() {
        return this.x2;
    }

    public int getUpperY() {
        return this.y2;
    }

    public int getUpperZ() {
        return this.z2;
    }

    public void generateChunks() {
        World w = getWorld();
        int x1 = getLowerX() & 0xFFFFFFF0;
        int x2 = getUpperX() & 0xFFFFFFF0;
        int z1 = getLowerZ() & 0xFFFFFFF0;
        int z2 = getUpperZ() & 0xFFFFFFF0;
        int current = 0;
        int max = getSizeX() / 16 * getSizeZ() / 16;
        max = max + (getSizeX() / 16 + getSizeZ() / 16) * 2 + 1;
        for (int x = x1; x <= x2; x += 16) {
            for (int z = z1; z <= z2; z += 16) {
                Chunk chunk = w.getChunkAt(x >> 4, z >> 4);
                w.loadChunk(chunk);
                if (current % 100 == 0)
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                if (current % 5000 == 0)
                    try {
                        getWorld().save();
                    } catch (Exception ignored) {
                    }
                if (current % 200 == 0)
                    for(Player player : Bukkit.getOnlinePlayers()){
                        Main.getInstance().tile.sendActionBar(player,"§8» §fGénération des chunks: §8(&a" + current + "&8/&a" + max + "&8) &8[&a" + (Math.round(current * 100.0F / max / 1.0F * 10.0F) / 10.0F) + "%&8] &8(&fRAM: &e" + (Math.round((float) (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) * 100.0F / (float) Runtime.getRuntime().maxMemory()) / 10.0F) + "%&8)");

                    }
                current++;

                if (Math.round((float) (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) * 100.0F / (float) Runtime.getRuntime().maxMemory()) / 10.0F > 80.0F) {
                    while (Math.round((float) (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) * 100.0F / (float) Runtime.getRuntime().maxMemory()) / 10.0F > 60.0F) {
                        try {
                            for(Player player : Bukkit.getOnlinePlayers()){
                                Main.getInstance().tile.sendActionBar(player,"§4Utilisation de la ram trop importante.. [" + (Math.round((float) (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().freeMemory()) * 100.0F / (float) Runtime.getRuntime().maxMemory()) / 10.0F) + "%)");

                            }
                            System.gc();
                            Thread.sleep(5000L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
