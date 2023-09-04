package de.CypDasHuhn.BA.commands;

import de.CypDasHuhn.BA.commands.General.Command;
import de.CypDasHuhn.BA.message.Message;
import de.CypDasHuhn.BA.structure.LoadStructure;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

import static java.lang.Integer.parseInt;

public class BuildLoad {
    public static void command(String[] args, CommandSender sender) {
        if (args.length < 4) {
            Message.send(sender, "to_short");
            return;
        }

        String name = args[0];
        World world = Command.getWorld(sender);
        Location cornerA = new Location(world, parseInt(args[1]), parseInt(args[2]), parseInt(args[3]));

        LoadStructure.load(name, 0, cornerA);
    }
}
