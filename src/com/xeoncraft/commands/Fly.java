package com.xeoncraft.commands;

import com.xeoncraft.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;

/**
 * Created by Whiztech on 2/12/15.
 */
public class Fly implements CommandExecutor {

    public Fly(main main)
    {
    }

    String prefix = ChatColor.BLUE + "Condition> " + ChatColor.GRAY;
    String insufperms = ChatColor.BLUE + "Permission> " + ChatColor.RED + "You do not have sufficient permissions to preform this command.";
    String incusage = ChatColor.BLUE + "Usage> " + ChatColor.GRAY;
    String unknownerror = ChatColor.BLUE + "Error> " + ChatColor.GRAY + "Welp. Something went wrong.";
    String pnotonline1 = ChatColor.BLUE + "Player search> " + ChatColor.GRAY + "Player ";
    String pnotonline2 = ChatColor.GRAY + "is not currently online!";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if(sender instanceof Player)

        if (cmd.getName().equalsIgnoreCase("fly")) {
            if (args.length == 0) {
                if (p.hasPermission("vn.fly")) {
                    if (!p.isFlying()) {
                        p.setAllowFlight(true);
                        p.setFlying(true);
                        p.sendMessage(prefix + "Flying is now " + ChatColor.DARK_RED + "disabled");
                    } else if (p.isFlying()) {
                        p.setFlying(false);
                        p.setAllowFlight(false);
                        p.sendMessage(prefix + "Flying is now " + ChatColor.GREEN + "enabled");
                    } else {
                        p.sendMessage(unknownerror);
                    }
                } else p.sendMessage(insufperms);
            } else if (args.length == 1) {
                if (p.hasPermission("vn.fly.other")) {
                    Player t = Bukkit.getServer().getPlayer(args[0]);
                    if (t != null) {
                        if (!t.isFlying()) {
                            t.setAllowFlight(true);
                            t.setFlying(true);
                            t.sendMessage(prefix + "Flying is now " + ChatColor.DARK_RED + "disabled");
                            p.sendMessage(prefix + "Flying for player " + t.getName() + " is now " + ChatColor.DARK_RED + "disabled");
                        } else if (!t.getAllowFlight()) {
                            t.setAllowFlight(true);
                            t.sendMessage(prefix + "Flying is now " + ChatColor.GREEN + "enabled");
                            p.sendMessage(prefix + "Flying for player " + t.getName() + " is now " + ChatColor.GREEN + "enabled");
                        } else {
                            p.sendMessage(unknownerror);
                        }
                    } else p.sendMessage(pnotonline1 + args[0] + pnotonline2);
                } else {
                    p.sendMessage(insufperms);
                }
            } else if ((p.hasPermission("vn.fly")) || (p.hasPermission("vn.fly.other")))
                p.sendMessage(incusage + "/fly [player]");
            else {
                p.sendMessage(insufperms);
            }

        }
        return false;
    }
}
