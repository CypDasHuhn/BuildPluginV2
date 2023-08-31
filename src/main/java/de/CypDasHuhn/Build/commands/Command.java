package de.CypDasHuhn.Build.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Command implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        switch (label) {
            case "testcommand":
                Bukkit.broadcastMessage("test");
                break;
            default:
                break;
        }
        return false;
    }
}