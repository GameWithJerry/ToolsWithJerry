package de.gamewithjerry.toolswithjerry.commands;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if(!(sender instanceof Player)) { return true; }

        Player player = (Player) sender;

        if(player.getBedSpawnLocation() != null) {
            player.teleport(player.getBedSpawnLocation());
        } else {
            player.teleport(Bukkit.getWorld(player.getWorld().getName()).getSpawnLocation());
        }

        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1F, 1F);

        return true;
    }
}
