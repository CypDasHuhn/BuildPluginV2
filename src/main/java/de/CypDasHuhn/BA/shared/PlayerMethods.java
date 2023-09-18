package de.CypDasHuhn.BA.shared;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerMethods {
    public static World getWorld(CommandSender sender) {
        return null;
    }

    public static Location getTargetBlock(CommandSender sender) {
        if (!(sender instanceof Player)) return null;
        return ((Player) sender).getTargetBlock(null, 4).getLocation();
    }

    public static Location getSelection(CommandSender sender) {
        return null;
    }
}
