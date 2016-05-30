package me.playincodmc.maintenance.commands;

import java.awt.TextComponent;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.inventivetalent.title.TitleAPI;

import me.playincodmc.maintenance.Main;
import me.playincodmc.maintenance.handlers.Utils;

public class MaintenanceCMD implements CommandExecutor {
	Main plugin;
	
	public MaintenanceCMD(Main plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		if(s instanceof Player){
			Player player = (Player) s;
				if(player.hasPermission("maintenance.use")){
					if(args.length == 1){
						if(!Utils.isInteger(args[0])){
							player.sendMessage("'" + args[0] + "' is not a number.");
							return false;
						}

						for(Player online : Bukkit.getOnlinePlayers()){
							
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "title " + online.getName() + " title {text:'I love you bae. <3', color:red} " + plugin.convertTime(Integer.parseInt(args[0])));
						}
						
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						@Override
						public void run() {
							for(Player online : Bukkit.getOnlinePlayers()){
								if(!online.hasPermission("maintenance.bypass")){
									online.kickPlayer(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MAINTENANCE-KICKINGAME-MESSAGE")));
								}
							}
						}
					}, Integer.parseInt(args[0]) * 20);
					
					}else{
						player.sendMessage("Usage: /maintenance <time-in-seconds>");
					}
				}else{
					Utils.noPermission(player);
				}
		}
		return true;
	}
}