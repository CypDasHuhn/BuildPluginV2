package de.CypDasHuhn.BA.commands;

import de.CypDasHuhn.BA.commands.General.Command;
import de.CypDasHuhn.BA.fileManager.LoadStructureConfig;
import de.CypDasHuhn.BA.fileManager.RegisterStructureConfig;
import de.CypDasHuhn.BA.message.Message;
import de.CypDasHuhn.BA.structure.LoadStructure;
import de.CypDasHuhn.BA.structure.SaveStructure;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;

import static java.lang.Integer.parseInt;

public class BuildSave {
    public static boolean command(String[] args, CommandSender sender) {

        String name = null;
        World world = Command.getWorld(sender);
        Location cornerA = null;
        Location cornerB = null;
        int frame = 0;
        boolean nextFrame = false;
        boolean selectedRegion = false;

        String argumentTypes = Command.getArgumentTypes(args);
        switch (argumentTypes) {
            case "String int int int int int int" -> {
                cornerA = cornerFromArguments(args, 1, world);
                cornerB = cornerFromArguments(args, 4, world);
            }
            case "String int int int" -> {
                cornerA = cornerFromArguments(args, 1, world);
            }
            case "String int int int int" -> {
                cornerA = cornerFromArguments(args, 1, world);
                frame = parseInt(args[4]);
            }
            case "String int int int String" -> {
                cornerA = cornerFromArguments(args, 1, world);
                nextFrame = true;
            }
            case "String String int" -> {
                frame = parseInt(args[2]);
                selectedRegion = true;
            }
            case "String String String" -> {
                nextFrame = true;
                selectedRegion = true;
            }
            default -> {
                return false;
            }
        }
        name = args[0];

        if (!LoadStructureConfig.structureRegistered(name)) {
            if (cornerB == null) {
                return false;
            }
        } else {

        }

        try {
            if (args.length < 4)  throw new IllegalArgumentException();
            //region Variable Setting
            Location[] corners = {new Location(world, parseInt(args[1]), parseInt(args[2]), parseInt(args[3])), null};
            //endregion
            if (!LoadStructureConfig.structureRegistered(name)) {
                if (args.length < 7) throw new IllegalArgumentException();

                RegisterStructureConfig.register(name);

                corners[1] = new Location(world, parseInt(args[4]), parseInt(args[5]), parseInt(args[6]));

                if (illegalSize(corners[0], corners[1])) throw new IllegalArgumentException();
            } else {
                int[] size = LoadStructure.getStructureSize(name);
                corners[1] = corners[0].clone().add(size[0], size[1], size[2]);
            }
            SaveStructure.save(name, 0, corners[0], corners[1]);
        } catch (IllegalArgumentException exception) {

            return false;
        } catch (Exception exception) {

            return false;
        }
        return true;
    }
    public static Location cornerFromArguments(String[] args, int position, World world) {
        return new Location(
                world,
                parseInt(args[position]),
                parseInt(args[position+1]),
                parseInt(args[position+2])
        );
    }

    public static boolean illegalSize(Location cornerA, Location cornerB) {
        return (
            Math.abs(cornerA.getBlockX()-cornerB.getBlockX()) > 48 ||
            Math.abs(cornerA.getBlockY()-cornerB.getBlockY()) > 48 ||
            Math.abs(cornerA.getBlockZ()-cornerB.getBlockZ()) > 48
        );
    }
}
