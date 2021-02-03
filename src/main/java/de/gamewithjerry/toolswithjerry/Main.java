package de.gamewithjerry.toolswithjerry;

import de.gamewithjerry.toolswithjerry.listener.BlockRightClick;
import de.gamewithjerry.toolswithjerry.listener.BedListener;
import de.gamewithjerry.toolswithjerry.listener.DeathListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new BlockRightClick(), this);
        pluginManager.registerEvents(new BedListener(), this);
        pluginManager.registerEvents(new DeathListener(), this);

        System.out.println("[ToolsWithJerry] Plugin aktiviert!");
    }

    @Override
    public void onDisable() {
        System.out.println("[ToolsWithJerry] Plugin deaktiviert!");
    }


}
