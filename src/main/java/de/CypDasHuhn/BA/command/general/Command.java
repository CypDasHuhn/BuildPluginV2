package de.CypDasHuhn.BA.command.general;

import de.CypDasHuhn.BA.command.BuildLoad;
import de.CypDasHuhn.BA.command.BuildModify;
import de.CypDasHuhn.BA.command.BuildSave;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        switch (label) {
            case "bs", "buildsave" -> BuildSave.command(args, sender);
            case "bl", "buildload" -> BuildLoad.command(args, sender);
            case "bm", "buildmodify" -> BuildModify.command(args, sender);
        }
        return false;
    }

}