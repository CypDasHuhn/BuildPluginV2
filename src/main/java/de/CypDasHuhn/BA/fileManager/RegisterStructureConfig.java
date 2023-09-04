package de.CypDasHuhn.BA.fileManager;

import de.CypDasHuhn.BA.CustomFiles;
import org.bukkit.configuration.file.FileConfiguration;

import static java.lang.Integer.parseInt;

public class RegisterStructureConfig {
    public static void register(String name) {
        // CONFIG GETTING
        CustomFiles[] customFiles = CustomFiles.getCustomFiles(2);
        FileConfiguration sConfig = customFiles[0].gfc(name, "structures");
        FileConfiguration dConfig = customFiles[1].gfc("StructureData", "");

        // CONFIG SETTING
        int amount = dConfig.getInt("amount");

        dConfig.set("amount", amount + 1);
        dConfig.set("list." + amount, name);

        sConfig.set("ID", amount + 1);
        sConfig.set("type", "standing");
        sConfig.set("frames", 1);

        CustomFiles.saveArray(customFiles);
    }
}
