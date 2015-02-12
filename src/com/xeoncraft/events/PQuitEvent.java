package com.xeoncraft.events;

import com.xeoncraft.main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

public class PQuitEvent implements Listener {

    public main plugin;

    public PQuitEvent(main plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void quitEvent(PlayerQuitEvent ev) throws IOException
    {
        if ((ev.getPlayer() instanceof Player)) {
            Player p = ev.getPlayer();
            main.setPlayerStats(p);
            if (main.onlineplayers.contains(p.getName())) {
                main.onlineplayers.remove(p.getName());
            }

        }

        String msg = "";
        msg = ChatColor.DARK_RED + "Quit> ";
        msg = msg.replace("%player%", ev.getPlayer().getName());
        msg = msg.replace("&", "§");
        ev.setQuitMessage(msg);
    }
}

