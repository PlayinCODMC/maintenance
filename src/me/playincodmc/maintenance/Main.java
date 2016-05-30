package me.playincodmc.maintenance;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.playincodmc.maintenance.commands.MaintenanceCMD;
import me.playincodmc.maintenance.handlers.Utils;
import me.playincodmc.maintenance.listeners.Events;

public class Main extends JavaPlugin implements Listener, CommandExecutor {


	public Utils utils = new Utils();

	public static Main instance;

	
	public ConfigHandler configHandler = new ConfigHandler(this);


	public static Main getInstance() {
		return instance;
	}

	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		instance = this;
		getServer().getPluginManager().registerEvents(new Events(this), this);
		registerCommands();
		File config = new File(getDataFolder() + File.separator + "config.yml");
		if(!config.exists()){
			getLogger().info("Creating config file.");
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}else{
			getLogger().info("Config file loaded.");
		}
	}

	public void onDisable() {
	}
	public String convertTime(int time){
		String times = null;
		if(time <= 1 ){
			times = time + " second";
		}else if(time < 60 ){
			times = time + " seconds";
		}else if(time <= 119 ){
			time = (int) time / 60;
			times =  time + " minute";
		}else if(time < 3600){
			time = (int) time / 60;
			times = time + " minutes";
		}else if(time <= 7199){
			time = (int) time / 3600;
			times = time + " hour";
		}else if(time > 3600){
			time = (int) time / 3600;
			times = time + " hours";
		}
		return times;
	}
	 private void registerCommands() {
			getCommand("maintenance").setExecutor(new MaintenanceCMD(this));
	 }

}
