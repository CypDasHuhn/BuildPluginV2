package de.CypDasHuhn.BA.main;

import de.CypDasHuhn.BA.commands.General.Command;
import de.CypDasHuhn.BA.commands.General.TabComp;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.structure.StructureManager;

public class Main extends JavaPlugin {
    private static Main plugin;
    public static String pluginName;
    public static StructureManager serverManager;

    public void onEnable(){
        Bukkit.broadcastMessage("HALLO BITCHES");
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        plugin = this;
        pluginName = getDescription().getName();

        serverManager = getServer().getStructureManager();

        String[] commands = {"testcommand", "buildsave", "buildload"};
        for (String a : commands) {
            getCommand(a).setExecutor(new Command());
            getCommand(a).setTabCompleter(new TabComp());
        }
    }

    public static Main getPlugin(){
        return plugin;
    }
}
