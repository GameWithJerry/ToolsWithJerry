package de.gamewithjerry.autocrop.listener;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockRightClick implements Listener {

    @EventHandler
    public void BlockRightClick(PlayerInteractEvent event) {

        if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {

            Player player = event.getPlayer();
            Block block = event.getClickedBlock();
            boolean isCrop;

            if(block.getBlockData() instanceof Ageable) {

                switch(block.getType()) {
                    case COCOA_BEANS:
                    case WHEAT:
                    case CARROTS:
                    case POTATOES:
                    case BEETROOTS:
                        isCrop = true;
                        break;

                    default:
                        isCrop = false;
                        break;
                }

                if(isCrop == true) {

                    Ageable ab = (Ageable) block.getBlockData();

                    if(ab.getAge() == ab.getMaximumAge()) {

                        World world = block.getLocation().getWorld();
                        Material block2 = block.getType();

                        block.breakNaturally();
                        world.getBlockAt(block.getLocation()).setType(block2);

                        player.playSound(player.getLocation(), Sound.ITEM_CROP_PLANT, 1F, 1F);
                    }
                }
            }
        }
    }
}
