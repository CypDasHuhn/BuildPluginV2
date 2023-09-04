package de.CypDasHuhn.BA.fileManager;

import de.CypDasHuhn.BA.CustomFiles;
import org.bukkit.configuration.file.FileConfiguration;

public class LoadStructureConfig {
    public static boolean structureRegistered(String name) {
        // CONFIG GETTING
        CustomFiles[] customFiles = CustomFiles.getCustomFiles(1);
        FileConfiguration sConfig = customFiles[0].gfc(name, "structures");
        // CONFIG READING
        return (sConfig.getString("type") != null);
    }
}
