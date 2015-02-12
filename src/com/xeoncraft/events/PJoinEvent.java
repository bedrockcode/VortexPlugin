package com.xeoncraft.events;

import com.xeoncraft.main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.IOException;

public class PJoinEvent implements Listener {

    public main plugin;

    public PJoinEvent(main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void joinEvent(PlayerJoinEvent ev) throws IOException
    {
        if ((ev.getPlayer() instanceof Player)) {
            Player p = ev.getPlayer();
            main.setPlayerStats(p);
            if (!main.onlineplayers.contains(p.getName())) {
                main.onlineplayers.add(p.getName());
            }
        }

        String msg = "";
        if (ev.getPlayer().hasPlayedBefore())
            msg = ChatColor.GREEN + "Join> ";
        else {
            msg = ChatColor.BLUE + "First" + ChatColor.GREEN + " Join> ";
        }
        msg = msg.replace("%player%", ev.getPlayer().getName());
        msg = msg.replace("&", "§");
        ev.setJoinMessage(msg);
    }
}

