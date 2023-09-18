package de.CypDasHuhn.BA.command;

import de.CypDasHuhn.BA.filemanager.LoadStructureConfig;
import de.CypDasHuhn.BA.filemanager.SaveStructureConfig;
import de.CypDasHuhn.BA.shared.PlayerMethods;
import de.CypDasHuhn.BA.shared.SpigotMethods;
import de.CypDasHuhn.BA.shared.UtilityMethods;
import de.CypDasHuhn.BA.structure.SaveStructure;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.Integer.parseInt;

public class BuildSave {
    private final static String[] customArguments = {
            "+",
            "select"
    };

    public static void command(String[] args, CommandSender sender) {
        //<editor-fold desc="Variable Setting">
        Location cornerA = null;
        Location cornerB = null;

        int frame = -1;

        String name;
        //</editor-fold>
        //region argument reception
        String[] argsTypes = UtilityMethods.getArgumentTypes(args, customArguments);

        if (!argsTypes[0].equals("String")) {
            return;
        }
        name = args[0];

        if (argsTypes[1].equals("select")) {
            cornerA = PlayerMethods.getSelection(sender);
        } else if (argsTypes[1].equals("int") && argsTypes[2].equals("int") && argsTypes[3].equals("int")) {
            cornerA = SpigotMethods.getLocationFromInts(PlayerMethods.getWorld(sender), args[1], args[2], args[3]);
        }

        if (argsTypes[4].equals("int") && argsTypes[5].equals("int") && argsTypes[6].equals("int")) {
            cornerB = SpigotMethods.getLocationFromInts(PlayerMethods.getWorld(sender), args[4], args[5], args[6]);
        } else if (argsTypes[argsTypes.length - 1].equals("+")) {
            frame = LoadStructureConfig.getCurrentFrames(name) + 1;
        } else if (argsTypes[argsTypes.length - 1].equals("int")) {
            frame = parseInt(args[args.length - 1]);
        }
        //endregion
        //region register/save config
        if (LoadStructureConfig.structureRegistered(name)) {
            if (cornerB != null) {
                // error message
                return;
            }
            SaveStructureConfig.register(name);
        } else {
            if (cornerB == null) {
                // error message
                return;
            }
            SaveStructureConfig.save(name, frame);
        }
        //endregion
        SaveStructure.save(name, frame, cornerA, cornerB);
    }

    public static List<String> completer(String[] args, Location location) {
        List<String> completions = new ArrayList<String>();
        switch (args.length) {
            case 0:
                completions.add("[Name]");
                break;
            case 1:
                completions.add("[Name]");
                String[] structures = LoadStructureConfig.getStructuresSaved();
                Collections.addAll(completions, structures);
                break;
            case 2:
                completions.add("select");

                break;
        }
        return completions;
    }
}
