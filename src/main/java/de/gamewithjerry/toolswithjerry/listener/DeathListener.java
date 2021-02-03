package de.gamewithjerry.toolswithjerry.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    @EventHandler
    public void PlayerDeathListener(PlayerDeathEvent event) {
        Player player = event.getEntity();
        String deathMessage = event.getDeathMessage();

        for (Player oplayer : Bukkit.getOnlinePlayers()) {
            //if(oplayer != player) {
                oplayer.sendTitle(ChatColor.RED + player.getDisplayName(), ChatColor.YELLOW + deathMessage.replace(player.getDisplayName() + " ", ""), 10, 70, 20);
                oplayer.playSound(oplayer.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
            //}

        }
    }
}
