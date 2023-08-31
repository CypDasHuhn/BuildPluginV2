package de.CypDasHuhn.PluginPrefix.main;

import de.CypDasHuhn.PluginPrefix.commands.Command;
import de.CypDasHuhn.PluginPrefix.commands.TabComp;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main plugin;

    public void onEnable(){
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        plugin = this;

        String[] commands = {"testcommand"};
        for (String a : commands) {
            getCommand(a).setExecutor(new Command());
            getCommand(a).setTabCompleter(new TabComp());
        }
    }

    public static Main getPlugin(){
        return plugin;
    }
}
