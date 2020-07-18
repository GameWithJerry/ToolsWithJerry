package de.gamewithjerry.autocrop.beacon;

import de.gamewithjerry.autocrop.Main;
import net.minecraft.server.v1_16_R1.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Beacon {

    private Main plugin;

    ArrayList<ItemStack> loot = new ArrayList<>();

    int beaconTier;

    Inventory beaconInv = Bukkit.createInventory(null, InventoryType.BARREL, "Beacon Tier: " + beaconTier);



    public Beacon(Main plugin) {
        this.plugin = plugin;
    }

    public void spawnBeacon(Player player) {
        World world = player.getWorld();

        Location beaconSpawn = new Location(world, 1, 225,1);

        //world.spawnFallingBlock(beaconSpawn, Material.BON,1);
    }

}
