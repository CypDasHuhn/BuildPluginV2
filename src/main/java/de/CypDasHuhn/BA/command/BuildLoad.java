package de.CypDasHuhn.BA.command;

import de.CypDasHuhn.BA.filemanager.LoadStructureConfig;
import de.CypDasHuhn.BA.shared.PlayerMethods;
import de.CypDasHuhn.BA.shared.SpigotMethods;
import de.CypDasHuhn.BA.shared.UtilityMethods;
import de.CypDasHuhn.BA.structure.LoadStructure;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;

import java.util.List;

import static java.lang.Integer.parseInt;

public class BuildLoad {
    private final static String[] customArguments = {
            "+",
            "select"
    };

    public static void command(String[] args, CommandSender sender) {
        Location cornerA = null;
        boolean selection;

        int frame = -1;
        boolean nextFrame;

        String module;

        //region argument reception
        String[] argsTypes = UtilityMethods.getArgumentTypes(args, customArguments);

        if (!argsTypes[0].equals("String")) { return; }
            String name = args[0];
        if (argsTypes[1].equals("select")) {
            selection = true;
        } else if (argsTypes[1].equals("int") &&argsTypes[2].equals("int")&&argsTypes[3].equals("int")) {
            cornerA = SpigotMethods.getLocationFromInts(PlayerMethods.getWorld(sender),args[1],args[2],args[3]);
        }

        if (argsTypes[argsTypes.length-1].equals("String")) {
            module = args[args.length-1];
        } else if (argsTypes[argsTypes.length-1].equals("int")) {
            frame = parseInt(args[args.length-1]);
        }

        //endregion

        // ERROR HANDLING
        LoadStructureConfig.load();
        // DATA HANDLING
        LoadStructure.load(name, cornerA);
    }

    public static List<String> completer(String[] args) {

        return null;
    }
}
