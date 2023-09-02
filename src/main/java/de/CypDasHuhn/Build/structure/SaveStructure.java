package de.CypDasHuhn.Build.structure;

import de.CypDasHuhn.Build.CustomFiles;
import de.CypDasHuhn.Build.main.Main;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.command.CommandSender;
import org.bukkit.structure.Structure;
import org.bukkit.structure.StructureManager;

public class SaveStructure {


    public static void saveStructure(String name, int frame, CommandSender sender, Location cornerA, Location cornerB) {
        // STRUCTURE MANAGER
        StructureManager structureManager = Main.serverManager;
        NamespacedKey key = new NamespacedKey(Main.getPlugin(), "BuildPlugin_"+name+"_"+frame);
        //CREATE STRUCTURE
        Structure structure = structureManager.createStructure();
        structure.fill(cornerA, cornerB, false);
        // STRUCTURE SAVING
        structureManager.registerStructure(key, structure);
        structureManager.saveStructure(key);
    }
}
