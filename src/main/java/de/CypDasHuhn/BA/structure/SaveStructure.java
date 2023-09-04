package de.CypDasHuhn.BA.structure;

import de.CypDasHuhn.BA.main.Main;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.structure.Structure;
import org.bukkit.structure.StructureManager;

public class SaveStructure {


    public static void save(String name, int frame, Location cornerA, Location cornerB) {
        // STRUCTURE MANAGER
        StructureManager structureManager = Main.serverManager;
        NamespacedKey key = new NamespacedKey(Main.getPlugin(), Main.pluginName+ "_" + name + "_" + frame);
        //CREATE STRUCTURE
        Structure structure = structureManager.createStructure();
        structure.fill(cornerA, cornerB, false);
        // STRUCTURE SAVING
        structureManager.registerStructure(key, structure);
        structureManager.saveStructure(key);
    }
}
