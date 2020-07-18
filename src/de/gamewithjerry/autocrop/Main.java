package de.gamewithjerry.autocrop;

import de.gamewithjerry.autocrop.command.SpawnBeacon;
import de.gamewithjerry.autocrop.listener.BlockRightClick;
import de.gamewithjerry.autocrop.listener.BedListener;
import de.gamewithjerry.autocrop.listener.DeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BlockRightClick(), this);
        getServer().getPluginManager().registerEvents(new BedListener(), this);
        getServer().getPluginManager().registerEvents(new DeathListener(), this);

        getCommand("spawnbeacon").setExecutor(new SpawnBeacon(this));

        System.out.println("[ToolsWithJerry] Plugin aktiviert!");
    }

    @Override
    public void onDisable() {
        System.out.println("[ToolsWithJerry] Plugin deaktiviert!");
    }


}
