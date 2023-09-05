package de.CypDasHuhn.BA.commands.General;

import de.CypDasHuhn.BA.commands.BuildLoad;
import de.CypDasHuhn.BA.commands.BuildSave;
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
            case "buildload":
            case "bl":
                BuildLoad.command(args, sender);
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

    public static String getArgumentTypes(String[] strings) {
        if (strings == null || strings.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (String str : strings) {
            if (isNumeric(str)) {
                result.append("int ");
            } else {
                result.append("String ");
            }
        }

        // Remove the trailing space
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}