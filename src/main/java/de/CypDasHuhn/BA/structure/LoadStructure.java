package de.CypDasHuhn.BA.structure;

import de.CypDasHuhn.BA.main.Main;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.structure.Mirror;
import org.bukkit.block.structure.StructureRotation;
import org.bukkit.structure.Structure;
import org.bukkit.structure.StructureManager;

import java.util.Random;

public class LoadStructure {
    public static void load(String name, int frame, Location cornerA) {
        // STRUCTURE MANAGER
        StructureManager structureManager = Main.serverManager;
        NamespacedKey key = new NamespacedKey(Main.getPlugin(), Main.pluginName+ "_" + name + "_" + frame);

        // Check if the structure is already registered
        if (structureManager.getStructure(key) != null) {
            // Load and place the structure
            Structure structure = structureManager.loadStructure(key);
            if (structure != null) {
                structure.place(cornerA, false, StructureRotation.NONE, Mirror.NONE, -1, 1.0f, new Random());
            } else {
                // Handle structure loading failure
                // You can add error handling here, such as logging or sending a message to the player
            }
        } else {
            // Handle if the structure is not registered
            // You can add error handling here, such as logging or sending a message to the player
        }
    }


    public static int[] getStructureSize(String name) {

        return null;
    }
}
