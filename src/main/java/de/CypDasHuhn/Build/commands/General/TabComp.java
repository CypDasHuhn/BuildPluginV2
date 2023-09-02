package de.CypDasHuhn.Build.commands.General;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.List;

public class TabComp implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        switch (label) {
            case "testcommand":

                break;
            default:
                break;
        }
        return null;
    }
}

