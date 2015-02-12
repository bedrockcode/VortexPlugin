package com.xeoncraft;

import com.xeoncraft.commands.Helpbook;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.material.Command;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    public void onEnable() {

        System.out.println("VortexPlugin has been activated! -created by Whiztech, Bedrockblaster, and Gl1tchMC");

        getCommand("helpbook").setExecutor(new Helpbook(this));

    }


}





