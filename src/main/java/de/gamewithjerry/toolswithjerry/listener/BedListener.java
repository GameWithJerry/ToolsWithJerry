package de.gamewithjerry.toolswithjerry.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class BedListener implements Listener {

    int playersInBed;
    BossBar sleepbar;
    Server server = Bukkit.getServer();

    public BedListener() {
        playersInBed = 0;
        sleepbar = Bukkit.createBossBar("", BarColor.YELLOW, BarStyle.SOLID);
    }

    @EventHandler
    public void BedEnterListener(PlayerBedEnterEvent event) {
        if (event.getBedEnterResult() == PlayerBedEnterEvent.BedEnterResult.OK){
            playersInBed++;
            checkPlayersInBed();
        }
    }

    @EventHandler
    public void BedLeaveListener(PlayerBedLeaveEvent event) {
        playersInBed--;
        checkPlayersInBed();
    }

    private void checkPlayersInBed() {
        List<Player> playersonline = Objects.requireNonNull(Bukkit.getWorld("world")).getPlayers();
        int neededPlayers = playersonline.size() / 3;

        if (neededPlayers <= 0){
            neededPlayers = 1;
        }

        sleepbar.removeAll();
        if(playersInBed > 0) {
            sleepbar.setTitle("Schlafen, um die Nacht zu überspringen (" + playersInBed + "/" + neededPlayers + ")");

            if (!(playersInBed / neededPlayers > 1)) {
                sleepbar.setProgress((double) playersInBed / neededPlayers);
            } else {
                sleepbar.setProgress(1);
            }

            for(Player player : playersonline) {
                sleepbar.addPlayer(player);
            }
        }

        if (playersInBed >= neededPlayers){

            World world = Bukkit.getWorld("world");

            world.setTime(23500);
            world.setWeatherDuration(0);

            if (world.isThundering()){
                world.setThundering(false);
            }

            try {
                world.setStorm(false);
            } catch (NullPointerException ignored){}
        }
    }
}
