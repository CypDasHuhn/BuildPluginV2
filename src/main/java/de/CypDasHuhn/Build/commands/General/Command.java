package de.CypDasHuhn.Build.commands.General;

import de.CypDasHuhn.Build.commands.BuildSave;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        switch (label) {
            case "testcommand":
                Bukkit.broadcastMessage("test");
                break;
            case "buildsave":
            case "bs":
                BuildSave.command(args, sender);
                break;
            default:
                break;
        }
        return false;
    }

    public static World getWorld(CommandSender sender) {
        if (sender instanceof Player) return ((Player) sender).getWorld();
        else if (sender instanceof BlockCommandSender) return ((BlockCommandSender) sender).getBlock().getWorld();
        return null;
    }
}