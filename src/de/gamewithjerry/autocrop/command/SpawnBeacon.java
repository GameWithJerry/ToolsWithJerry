package de.gamewithjerry.autocrop.command;

import de.gamewithjerry.autocrop.Main;
import de.gamewithjerry.autocrop.beacon.Beacon;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnBeacon implements CommandExecutor {

    private Main plugin;

    public SpawnBeacon(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("spawnbeacon")) {
            Beacon.spawnBeacon(p);
        }
        return false;
    }
}
