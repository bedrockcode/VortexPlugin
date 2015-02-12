package com.xeoncraft.commands;

import com.xeoncraft.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TPhere implements CommandExecutor {

    public TPhere(main main)
    {
    }

    String prefix = ChatColor.BLUE + "Condition> " + ChatColor.GRAY;
    String insufperms = ChatColor.BLUE + "Permission> " + ChatColor.RED + "You do not have sufficient permissions to preform this command.";
    String incusage = ChatColor.BLUE + "Usage> " + ChatColor.GRAY;
    String pnotonline1 = ChatColor.BLUE + "Player search> " + ChatColor.GRAY + "Player ";
    String pnotonline2 = ChatColor.GRAY + "is not currently online!";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if(sender instanceof Player);

        if (cmd.getName().equalsIgnoreCase("tphere")) {
            if (args.length == 1) {
                if (p.hasPermission("vn.tphere")) {
                    Player t = Bukkit.getServer().getPlayer(args[0]);
                    if (t != null) {
                        t.teleport(p.getLocation());
                        p.sendMessage(prefix + "Teleporting...");
                        t.sendMessage(prefix + "Teleporting...");
                    } else {
                        p.sendMessage(prefix + pnotonline1 + args[0] + pnotonline2);
                    }
                } else {
                    p.sendMessage(prefix + insufperms);
                }
            } else if (p.hasPermission("vn.tphere"))
                p.sendMessage(prefix + incusage + "/tphere <player>");
            else
                p.sendMessage(prefix + insufperms);
        }
        return false;
    }
}
