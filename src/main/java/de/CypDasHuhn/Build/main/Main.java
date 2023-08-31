package de.CypDasHuhn.Build.main;

import de.CypDasHuhn.Build.commands.Command;
import de.CypDasHuhn.Build.commands.TabComp;
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
