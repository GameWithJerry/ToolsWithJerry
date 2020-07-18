package de.gamewithjerry.autocrop.beacon;

import de.gamewithjerry.autocrop.Main;
import net.minecraft.server.v1_16_R1.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.block.data.type.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class Beacon {

    private Main plugin;

    ArrayList<ItemStack> loot = new ArrayList<>();

    int beaconTier;

    Inventory beaconInv = Bukkit.createInventory(null, InventoryType.BARREL, "Beacon Tier: " + beaconTier);

    public Beacon(Main plugin) {
        this.plugin = plugin;
    }

    public void lootSetter() {

        ItemStack test = new ItemStack(Material.STICK);
        ItemMeta testMeta = test.getItemMeta();
        testMeta.setDisplayName("Hi");
        ArrayList<String> testLore = new ArrayList<>();
        testLore.add("hi");
        testMeta.setLore(testLore);
        test.setItemMeta(testMeta);

    }

    public static void spawnBeacon(Player player) {
        World world = player.getWorld();

        Location beacon1 = new Location(world, -444,256, 40);
        Location beacon2 = new Location(world, -445, 256, 40);

        ArrayList<Location> beaconSpawnList = new ArrayList<>();
        beaconSpawnList.add(beacon1);

        Location beaconSpawn = beaconSpawnList.get((int) Math.random() * 2);

        world.spawnFallingBlock(beaconSpawn, Material.BARREL, (byte) 1);
    }



}
