package com.xeoncraft.commands;

import com.xeoncraft.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Homes implements CommandExecutor {

    public Homes(main main)
    {
    }

    String prefix = ChatColor.BLUE + "VortexNinja> " + ChatColor.GRAY;
    String insufperms = ChatColor.BLUE + "Permission> " + ChatColor.RED + "You do not have sufficient permissions to preform this command.";
    String incusage = ChatColor.BLUE + "Usage> " + ChatColor.GRAY;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if(sender instanceof Player)

            if (cmd.getName().equalsIgnoreCase("sethome")) {
                if (p.hasPermission("vn.sethome")) {
                    if (args.length == 0) {
                        main.homes.set("Player." + p.getName() + ".Homepoint.X", Integer.valueOf(p.getLocation().getBlockX()));
                        main.homes.set("Player." + p.getName() + ".Homepoint.Y", Integer.valueOf(p.getLocation().getBlockY()));
                        main.homes.set("Player." + p.getName() + ".Homepoint.Z", Integer.valueOf(p.getLocation().getBlockZ()));
                        main.homes.set("Player." + p.getName() + ".Homepoint.World", p.getWorld().getName());
                        try {
                            main.homes.save(main.homepoints);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        p.sendMessage(prefix + "Your home has been set");
                    } else {
                        p.sendMessage(prefix + incusage + "/sethome");
                    }
                } else p.sendMessage(prefix + insufperms);
            } else {
                int xc;
                int yc;
                int zc;
                if (cmd.getName().equalsIgnoreCase("home")) {
                    if (p.hasPermission("vn.home")) {
                        String w = (String) main.homes.get("Player." + p.getName() + ".Homepoint.World");
                        if (args.length == 0) {
                            xc = ((Integer) main.homes.get("Player." + p.getName() + ".Homepoint.X")).intValue();
                            yc = ((Integer) main.homes.get("Player." + p.getName() + ".Homepoint.Y")).intValue();
                            zc = ((Integer) main.homes.get("Player." + p.getName() + ".Homepoint.Z")).intValue();
                            Location loc = new Location(Bukkit.getServer().getWorld(w), xc, yc, zc);
                            p.teleport(loc);
                            p.sendMessage(prefix + "Teleporting...");
                        } else {
                            p.sendMessage(prefix + incusage + "/home");
                        }
                    } else {
                        p.sendMessage(prefix + insufperms);
                    }

                }
            }
        return false;
    }
}