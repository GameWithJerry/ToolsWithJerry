package de.gamewithjerry.autocrop.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class BedListener implements Listener {

    int InBed = 0;
    Server s = Bukkit.getServer();

    @EventHandler
    public void BedEnterListener(PlayerBedEnterEvent event) {

        Player p = event.getPlayer();

        if(event.isCancelled() != true) {
            InBed++;

            for(Player p2 : s.getOnlinePlayers()) {
                p2.sendMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "BedInfo" + ChatColor.DARK_GREEN + "] " + ChatColor.YELLOW + "Der Spieler " + p.getDisplayName() + " liegt nun im Bett. " + ChatColor.GOLD + "(" + ChatColor.YELLOW + InBed + ChatColor.GOLD + "/"+ ChatColor.YELLOW + s.getOnlinePlayers().size() + ChatColor.GOLD +")");
            }

            if(InBed / s.getOnlinePlayers().size() >= 0.5) {
                s.getWorld("world").setTime(1000);
            }
        }

        p.sendMessage(String.valueOf(InBed / s.getOnlinePlayers().size()));
    }

    @EventHandler
    public void BedLeaveListener(PlayerBedLeaveEvent event) {

        Player p = event.getPlayer();
        InBed--;

        if(p.getWorld().getTime() != 0) {
            for(Player p2 : s.getOnlinePlayers()) {
                p2.sendMessage(ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "BedInfo" + ChatColor.DARK_GREEN + "] " + ChatColor.YELLOW + "Der Spieler " + p.getDisplayName() + " hat sein Bett verlassen. " + ChatColor.GOLD + "(" + ChatColor.YELLOW + InBed + ChatColor.GOLD + "/"+ ChatColor.YELLOW + s.getOnlinePlayers().size() + ChatColor.GOLD +")");
            }
        }
    }
}
