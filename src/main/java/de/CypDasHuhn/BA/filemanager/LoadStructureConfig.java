package de.CypDasHuhn.BA.filemanager;

import de.CypDasHuhn.BA.filemanager.CustomFiles;
import org.bukkit.configuration.file.FileConfiguration;

public class LoadStructureConfig {
    public static void load() {

    }

    public static String[] getStructuresSaved() {
        CustomFiles[] customFiles = new CustomFiles[1];
        FileConfiguration dConfig = customFiles[0].gfc("StructureData","Data");

        int structureAmount = dConfig.getInt("StructureAmount");
        String[] structures = new String[structureAmount];

        for (int i = 0; i < structureAmount; i++) {
            structures[i] = dConfig.getString("Structures."+i+".Name");
        }

        return structures;
    }

    public static boolean structureRegistered(String name) {
        return false;
    }

    public static int getCurrentFrames(String name) {
        return 0;
    }
}
