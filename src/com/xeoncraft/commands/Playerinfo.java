package com.xeoncraft.commands;

import com.xeoncraft.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Playerinfo implements CommandExecutor {

    public Playerinfo(main main)
    {
    }

    String prefix = ChatColor.BLUE + "PlayerStats> " + ChatColor.GRAY;
    String insufperms = ChatColor.BLUE + "Permission> " + ChatColor.RED + "You do not have sufficient permissions to preform this command.";
    String incusage = ChatColor.BLUE + "Usage> " + ChatColor.GRAY;
    String playerstatus = ChatColor.BLUE + "Status> " + ChatColor.GRAY;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if(sender instanceof Player)

            if (cmd.getName().equalsIgnoreCase("playerinfo")) {
                if (p.hasPermission("vn.playerinfo")) {
                    if (args.length == 1) {
                        Player t = Bukkit.getServer().getPlayer(args[0]);
                        if (main.stats.getString("Player." + args[0]) != null) {
                            if (main.onlineplayers.contains(args[0])) {
                                p.sendMessage(prefix + "Status: §2ONLINE");
                                try {
                                    main.setPlayerStats(t);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                p.sendMessage(prefix + "Status: §4OFFLINE");
                            }
                            String name = (String)main.stats.get("Player." + args[0] + ".Playername");
                            double health = ((Double)main.stats.get("Player." + args[0] + ".Health")).doubleValue();
                            double maxhealth = ((Double)main.stats.get("Player." + args[0] + ".MaxHealth")).doubleValue();
                            int foodlevel = ((Integer)main.stats.get("Player." + args[0] + ".Foodlevel")).intValue();
                            int level = ((Integer)main.stats.get("Player." + args[0] + ".Level")).intValue();
                            long firstplayed = ((Long)main.stats.get("Player." + args[0] + ".Firstplayed")).longValue();
                            String world = (String)main.stats.get("Player." + args[0] + ".World");
                            int posx = ((Integer)main.stats.get("Player." + args[0] + ".Location.X")).intValue();
                            int posy = ((Integer)main.stats.get("Player." + args[0] + ".Location.Y")).intValue();
                            int posz = ((Integer)main.stats.get("Player." + args[0] + ".Location.Z")).intValue();
                            DateFormat df = new SimpleDateFormat("HH:mm:ss dd/MM/yy");
                            p.sendMessage(prefix + "Playername: " + ChatColor.DARK_AQUA + name);
                            p.sendMessage(prefix + "Foodlevel: " + ChatColor.DARK_AQUA + foodlevel + "/20");
                            p.sendMessage(prefix + "Level: " + ChatColor.DARK_AQUA + level);
                            p.sendMessage(prefix + "Firstplayed: " + ChatColor.DARK_AQUA + df.format(new Date(firstplayed)));
                            p.sendMessage(prefix + "World: " + ChatColor.DARK_AQUA + world);
                            p.sendMessage(prefix + "Location: " + ChatColor.DARK_AQUA + " X:" + posx + " Y:" + posy + " Z:" + posz);
                            return false;
                        }
                        p.sendMessage(prefix + "No stats for player " + ChatColor.DARK_AQUA + args[0] + ChatColor.GRAY + " available");
                    }
                    else {
                        p.sendMessage(incusage + "/playerinfo <player> or /pinfo <player>");
                    }
                }
                else p.sendMessage(insufperms);
            }


        return false;
    }
}