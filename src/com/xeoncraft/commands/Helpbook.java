package com.xeoncraft.commands;

import com.xeoncraft.main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.material.Command;

public class Helpbook implements CommandExecutor {

    public helpbook(main main)
    {
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player player = (Player)sender;

        if (cmd.getName().equalsIgnoreCase("helpbook")) {
            if ((sender instanceof Player)) {
                Player player1 = (Player) sender;
                ItemStack book = new ItemStack(Material.WRITTEN_BOOK);
                BookMeta bm = (BookMeta) book.getItemMeta();
                bm.addPage(new String[]{ChatColor.AQUA + "Welcome to Vortex Ninja!" + ChatColor.GREEN + "\n This server is full of friendly people and fun games!"});
                bm.addPage(new String[]{ChatColor.AQUA + "This should hopefully be a new page!" + ChatColor.GREEN + "\n If its not well \n shit..."});
                bm.setAuthor(ChatColor.DARK_AQUA + "VortexNinjaStaff");
                bm.setTitle(ChatColor.BLUE + "Help Book");
                book.setItemMeta(bm);
                player.getInventory().addItem(new ItemStack[]{book});
            }
        }


        return false;
    }

}
