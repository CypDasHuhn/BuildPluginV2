package de.CypDasHuhn.BA.command.general;

import de.CypDasHuhn.BA.command.BuildLoad;
import de.CypDasHuhn.BA.command.BuildModify;
import de.CypDasHuhn.BA.command.BuildSave;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class CustomTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        switch (label) {
            case "bs", "buildsave" -> { return BuildSave.completer(args); }
            case "bl", "buildload" -> { return BuildLoad.completer(args); }
            case "bm", "buildmodify" -> { return BuildModify.completer(args); }
        }
        return null;
    }
}
