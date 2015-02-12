package com.xeoncraft.commands;

import com.xeoncraft.main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Speed implements CommandExecutor {

    public Speed(main main)
    {
    }

    String prefix = ChatColor.BLUE + "Condition> " + ChatColor.GRAY;
    String insufperms = ChatColor.BLUE + "Permission> " + ChatColor.RED + "You do not have sufficient permissions to preform this command.";
    String incusage = ChatColor.BLUE + "Usage> " + ChatColor.GRAY;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if(sender instanceof Player);

        if (cmd.getName().equalsIgnoreCase("speed")) {
            if (p.hasPermission("overpoweredplugin.speed")) {
                float speed = 0.0F;
                if (args.length >= 1) {
                    speed = Float.valueOf(Integer.parseInt(args[0])).floatValue();
                    if ((speed < 1.0F) || (speed > 10.0F)) {
                        p.sendMessage(prefix + incusage + "/speed <1-10> [walk|fly]");
                        return false;
                    }
                }
                if (args.length == 1) {
                    p.setWalkSpeed(speed / 10.0F);
                    p.setFlySpeed(speed / 10.0F);
                    p.sendMessage(prefix + "Speed has been set to " + ChatColor.BLUE + speed);
                } else if (args.length == 2) {
                    if (args[1].equalsIgnoreCase("walk")) {
                        p.setFlySpeed(speed / 10.0F);
                        p.sendMessage(prefix + "Fly-Speed has been set to " + ChatColor.BLUE + speed);
                    } else if (args[1].equalsIgnoreCase("fly")) {
                        p.setWalkSpeed(speed / 10.0F);
                        p.sendMessage(prefix + "Walk-Speed has been set to " + ChatColor.BLUE + speed);
                    } else {
                        p.sendMessage(prefix + incusage + "/speed <1-10> [walk|fly]");
                    }
                } else {
                    p.sendMessage(prefix + incusage + "/speed <1-10> [walk|fly]");
                }
            } else {
                p.sendMessage(prefix + insufperms);
            }

        }
        return false;
    }
}
