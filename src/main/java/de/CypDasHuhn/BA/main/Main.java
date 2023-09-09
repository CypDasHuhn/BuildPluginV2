package de.CypDasHuhn.BA.main;
import de.CypDasHuhn.BA.command.general.CustomTabCompleter;
import de.CypDasHuhn.BA.command.general.Command;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.structure.StructureManager;

public class Main extends JavaPlugin {
    private static Main plugin;
    public static String pluginName;
    public static StructureManager serverManager;

    public void onEnable(){
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        plugin = this;
        pluginName = getDescription().getName();
        serverManager = getServer().getStructureManager();

        String[] commands = {"testcommand", "buildsave", "buildload", "buildmodify"};
        for (String a : commands) {
            getCommand(a).setExecutor(new Command());
            getCommand(a).setTabCompleter(new CustomTabCompleter());
        }
    }

    public static Main getPlugin(){
        return plugin;
    }
}
