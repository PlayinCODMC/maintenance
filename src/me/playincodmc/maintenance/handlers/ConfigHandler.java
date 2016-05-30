package me.playincodmc.maintenance.handlers;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import me.playincodmc.maintenance.Main;

public class ConfigHandler {
	Main plugin;
	
	public ConfigHandler(Main plugin){
		this.plugin = plugin;
	}
	
	private FileConfiguration Player = null;
	private File Playerb = null;
	
	public void reloadPlayerData() {
	    if (Playerb == null) {
	    	Playerb = new File(plugin.getDataFolder(), "player_data.yml");
	    }

	    Player = YamlConfiguration.loadConfiguration(Playerb);

	    InputStream defConfigStream = plugin.getResource("player_data.yml");
	    if (defConfigStream != null) {
	        @SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        Player.setDefaults(defConfig);
	    }
	}

	public FileConfiguration GetPlayerData() {
	    if (Player == null) {
	    	reloadPlayerData();
	    }
	    return Player;
	}

	public void savePlayerData() {
	    if (Player == null || Playerb == null) {
	        return;
	    }
	    try {
	    	GetPlayerData().save(Playerb);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save config to " + Playerb, ex);
	    }
	}

	public void saveDefaultPlayerData() {
	    if (Playerb == null) {
	    	Playerb = new File(plugin.getDataFolder(), "player_data.yml");
	    }
	    if (Playerb.exists()) {            
	         plugin.saveResource("player_data.yml", false);
	     }
	}
}
