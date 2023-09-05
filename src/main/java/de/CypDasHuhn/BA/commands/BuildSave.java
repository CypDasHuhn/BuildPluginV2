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
        try {
            if (args.length < 4)  throw new IllegalArgumentException();
            //region Variable Setting
            String name = args[0];
            World world = Command.getWorld(sender);
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

    public static boolean illegalSize(Location cornerA, Location cornerB) {
        return (
            Math.abs(cornerA.getBlockX()-cornerB.getBlockX()) > 48 ||
            Math.abs(cornerA.getBlockY()-cornerB.getBlockY()) > 48 ||
            Math.abs(cornerA.getBlockZ()-cornerB.getBlockZ()) > 48
        );
    }

    public static String getArgumentFormat(String[] args) {
        switch (args.length) {
            case 7:
                boolean isNumeric = true;
                for (int i = 1; i < 7; i++) {
                    if (!isNumeric(args[i])) isNumeric = false;
                }

                if (isNumeric) return "register";
                else return null;
            case 5:

                return null;
            case 4:

                return null;
            case 3:

                return null;
        }
        if (args.length == 7) {

        }
        return null;
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
