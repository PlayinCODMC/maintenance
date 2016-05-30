package me.playincodmc.maintenance.listeners;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

import me.playincodmc.maintenance.Main;

public class Events implements Listener{

	private static Main plugin;

	public Events(Main instance)
	{
		plugin = instance;
	}	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		
		SimpleDateFormat formatDate = new SimpleDateFormat("d/M/Y hh:mm:ss a");
		String lastlogin = formatDate.format(new Date());

		if(plugin.getConfig().getString("MAINTENANCE").equalsIgnoreCase("true")){
			if(!p.hasPermission("maintenance.bypass")){
				p.kickPlayer(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MAINTENANCE-KICK-MESSAGE")));
			}
		}
		
	     plugin.getConfig().options().copyDefaults(true);
	     plugin.saveConfig();
	     

		
	}
	
	@EventHandler
    public void onServerListPing(ServerListPingEvent event)
    {
        event.setMotd(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MOTD")));
    }
	
}
