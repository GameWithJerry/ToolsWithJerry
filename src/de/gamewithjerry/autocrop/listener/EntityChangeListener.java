package de.gamewithjerry.autocrop.listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;

public class EntityChangeListener implements Listener {

    public static Location beaconBlockLocation;

    @EventHandler
    public void onEntityChangeBlock(EntityChangeBlockEvent event) {

        if(event.getEntity() instanceof FallingBlock) {
            Block fallenBlock = event.getBlock();

            if(fallenBlock.getBlockData().getMaterial().equals(Material.BARREL)) {
                beaconBlockLocation = fallenBlock.getLocation();
            }
        }
    }
}
