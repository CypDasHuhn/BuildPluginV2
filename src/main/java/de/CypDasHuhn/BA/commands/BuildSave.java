package de.CypDasHuhn.BA.commands;

import de.CypDasHuhn.BA.commands.General.Command;
import de.CypDasHuhn.BA.fileManager.LoadStructureConfig;
import de.CypDasHuhn.BA.fileManager.RegisterStructureConfig;
import de.CypDasHuhn.BA.message.Message;
import de.CypDasHuhn.BA.structure.LoadStructure;
import de.CypDasHuhn.BA.structure.SaveStructure;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

import static java.lang.Integer.parseInt;

public class BuildSave {
    public static void command(String[] args, CommandSender sender) {
        // ERROR HANDLING - ARGUMENT LENGTH
        if (args.length < 4) {
            Message.send(sender, "to_short");
            return;
        }

        String name = args[0];
        World world = Command.getWorld(sender);
        Location cornerA = new Location(world, parseInt(args[1]), parseInt(args[2]), parseInt(args[3]));

        if (!LoadStructureConfig.structureRegistered(name)) {
            if (args.length < 7) {
                Message.send(sender, "to_short");
                return;
            }

            RegisterStructureConfig.register(name);

            Location cornerB = new Location(world, parseInt(args[4]), parseInt(args[5]), parseInt(args[6]));

            if (illegalSize(cornerA, cornerB)) {
                Message.send(sender, "size_big");
                return;
            }

            SaveStructure.save(name, 0, cornerA, cornerB);
            Bukkit.broadcastMessage("GEMACHT");

        } else {
            Bukkit.broadcastMessage("KOMISHC");
            int[] size = LoadStructure.getStructureSize(name);
            Location cornerB = cornerA.clone().add(size[0], size[1], size[2]);
            SaveStructure.save(name, 0, cornerA, cornerB);
        }
    }


    public static boolean illegalSize(Location cornerA, Location cornerB) {
        return (
            Math.abs(cornerA.getBlockX()-cornerB.getBlockX()) > 48 ||
            Math.abs(cornerA.getBlockY()-cornerB.getBlockY()) > 48 ||
            Math.abs(cornerA.getBlockZ()-cornerB.getBlockZ()) > 48
        );
    }
}
