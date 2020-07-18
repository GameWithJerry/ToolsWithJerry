package de.gamewithjerry.autocrop;

import de.gamewithjerry.autocrop.command.SpawnBeacon;
import de.gamewithjerry.autocrop.listener.BlockRightClick;
import de.gamewithjerry.autocrop.listener.BedListener;
import de.gamewithjerry.autocrop.listener.DeathListener;
import de.gamewithjerry.autocrop.listener.EntityChangeListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new BlockRightClick(), this);
        pluginManager.registerEvents(new BedListener(), this);
        pluginManager.registerEvents(new DeathListener(), this);
        pluginManager.registerEvents(new EntityChangeListener(), this);

        getCommand("spawnbeacon").setExecutor(new SpawnBeacon(this));

        System.out.println("[ToolsWithJerry] Plugin aktiviert!");
    }

    @Override
    public void onDisable() {
        System.out.println("[ToolsWithJerry] Plugin deaktiviert!");
    }


}
