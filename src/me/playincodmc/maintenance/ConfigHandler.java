package me.playincodmc.maintenance;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigHandler {
	Main plugin;
	
	public ConfigHandler(Main plugin){
		this.plugin = plugin;
	}
	
	private FileConfiguration help = null;
	private File helpb = null;
	
	public void reloadHelpData() {
	    if (helpb == null) {
	    	helpb = new File(plugin.getDataFolder(), "help.yml");
	    }

	    help = YamlConfiguration.loadConfiguration(helpb);

	    InputStream defConfigStream = plugin.getResource("help.yml");
	    if (defConfigStream != null) {
	        @SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        help.setDefaults(defConfig);
	    }
	}

	public FileConfiguration GetHelpData() {
	    if (help == null) {
	    	reloadHelpData();
	    }
	    return help;
	}

	public void saveHelpData() {
	    if (help == null || helpb == null) {
	        return;
	    }
	    try {
	    	GetHelpData().save(helpb);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save config to " + helpb, ex);
	    }
	}

	public void saveDefualtHelpData() {
	    if (helpb == null) {
	    	helpb = new File(plugin.getDataFolder(), "help.yml");
	    }
	    if (helpb.exists()) {            
	         plugin.saveResource("help.yml", false);
	     }
	}
	
	private FileConfiguration Rules = null;
	private File Rulesb = null;
	
	public void reloadRulesData() {
	    if (Rulesb == null) {
	    	Rulesb = new File(plugin.getDataFolder(), "rules.yml");
	    }

	    Rules = YamlConfiguration.loadConfiguration(Rulesb);

	    InputStream defConfigStream = plugin.getResource("rules.yml");
	    if (defConfigStream != null) {
	        @SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        Rules.setDefaults(defConfig);
	    }
	}

	public FileConfiguration GetRulesData() {
	    if (Rules == null) {
	    	reloadRulesData();
	    }
	    return Rules;
	}

	public void saveRulesData() {
	    if (Rules == null || Rulesb == null) {
	        return;
	    }
	    try {
	    	GetRulesData().save(Rulesb);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save config to " + Rulesb, ex);
	    }
	}

	public void saveDefualtRulesData() {
	    if (Rulesb == null) {
	    	Rulesb = new File(plugin.getDataFolder(), "rules.yml");
	    }
	    if (Rulesb.exists()) {            
	         plugin.saveResource("rules.yml", false);
	     }
	}
	private FileConfiguration Scoreboard = null;
	private File Scoreboardb = null;
	
	public void reloadScoreboardData() {
	    if (Scoreboardb == null) {
	    	Scoreboardb = new File(plugin.getDataFolder(), "scoreboard.yml");
	    }

	    Scoreboard = YamlConfiguration.loadConfiguration(Scoreboardb);

	    InputStream defConfigStream = plugin.getResource("scoreboard.yml");
	    if (defConfigStream != null) {
	        @SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        Scoreboard.setDefaults(defConfig);
	    }
	}

	public FileConfiguration GetScoreboardData() {
	    if (Scoreboard == null) {
	    	reloadScoreboardData();
	    }
	    return Scoreboard;
	}

	public void saveScoreboardData() {
	    if (Scoreboard == null || Scoreboardb == null) {
	        return;
	    }
	    try {
	    	GetScoreboardData().save(Scoreboardb);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save config to " + Scoreboardb, ex);
	    }
	}

	public void saveDefualtScoreboardData() {
	    if (Scoreboardb == null) {
	    	Scoreboardb = new File(plugin.getDataFolder(), "scoreboard.yml");
	    }
	    if (Scoreboardb.exists()) {            
	         plugin.saveResource("scoreboard.yml", false);
	     }
	}
	private FileConfiguration Kits = null;
	private File Kitsb = null;
	
	public void reloadKitsData() {
	    if (Kitsb == null) {
	    	Kitsb = new File(plugin.getDataFolder(), "kits.yml");
	    }

	    Kits = YamlConfiguration.loadConfiguration(Kitsb);

	    InputStream defConfigStream = plugin.getResource("kits.yml");
	    if (defConfigStream != null) {
	        @SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        Kits.setDefaults(defConfig);
	    }
	}

	public FileConfiguration GetKitsData() {
	    if (Kits == null) {
	    	reloadKitsData();
	    }
	    return Kits;
	}

	public void saveKitsData() {
	    if (Kits == null || Kitsb == null) {
	        return;
	    }
	    try {
	    	GetKitsData().save(Kitsb);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save config to " + Kitsb, ex);
	    }
	}

	public void saveDefualtKitsData() {
	    if (Kitsb == null) {
	    	Kitsb = new File(plugin.getDataFolder(), "kits.yml");
	    }
	    if (Kitsb.exists()) {            
	         plugin.saveResource("kits.yml", false);
	     }
	}
	private FileConfiguration Warps = null;
	private File Warpsb = null;
	
	public void reloadWarpsData() {
	    if (Warpsb == null) {
	    	Warpsb = new File(plugin.getDataFolder(), "warps.yml");
	    }

	    Warps = YamlConfiguration.loadConfiguration(Warpsb);

	    InputStream defConfigStream = plugin.getResource("warps.yml");
	    if (defConfigStream != null) {
	        @SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        Warps.setDefaults(defConfig);
	    }
	}

	public FileConfiguration GetWarpsData() {
	    if (Warps == null) {
	    	reloadWarpsData();
	    }
	    return Warps;
	}

	public void saveWarpsData() {
	    if (Warps == null || Warpsb == null) {
	        return;
	    }
	    try {
	    	GetWarpsData().save(Warpsb);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save config to " + Warpsb, ex);
	    }
	}

	public void saveDefualtWarpsData() {
	    if (Warpsb == null) {
	    	Warpsb = new File(plugin.getDataFolder(), "warps.yml");
	    }
	    if (Warpsb.exists()) {            
	         plugin.saveResource("warps.yml", false);
	     }
	}
	private FileConfiguration Chat = null;
	private File Chatb = null;
	
	public void reloadChatData() {
	    if (Chatb == null) {
	    	Chatb = new File(plugin.getDataFolder(), "chat.yml");
	    }

	    Chat = YamlConfiguration.loadConfiguration(Chatb);

	    InputStream defConfigStream = plugin.getResource("chat.yml");
	    if (defConfigStream != null) {
	        @SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        Chat.setDefaults(defConfig);
	    }
	}

	public FileConfiguration GetChatData() {
	    if (Chat == null) {
	    	reloadChatData();
	    }
	    return Chat;
	}

	public void saveChatData() {
	    if (Chat == null || Chatb == null) {
	        return;
	    }
	    try {
	    	GetChatData().save(Chatb);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save config to " + Chatb, ex);
	    }
	}

	public void saveDefualtChatData() {
	    if (Chatb == null) {
	    	Chatb = new File(plugin.getDataFolder(), "chat.yml");
	    }
	    if (Chatb.exists()) {            
	         plugin.saveResource("chat.yml", false);
	     }
	}
	
	private FileConfiguration TabColor = null;
	private File TabColorb = null;
	
	public void reloadTabColorData() {
	    if (TabColorb == null) {
	    	TabColorb = new File(plugin.getDataFolder(), "tabcolor.yml");
	    }

	    TabColor = YamlConfiguration.loadConfiguration(TabColorb);

	    InputStream defConfigStream = plugin.getResource("tabcolor.yml");
	    if (defConfigStream != null) {
	        @SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
	        TabColor.setDefaults(defConfig);
	    }
	}

	public FileConfiguration GetTabColorData() {
	    if (TabColor == null) {
	    	reloadTabColorData();
	    }
	    return TabColor;
	}

	public void saveTabColorData() {
	    if (TabColor == null || TabColorb == null) {
	        return;
	    }
	    try {
	    	GetTabColorData().save(TabColorb);
	    } catch (IOException ex) {
	        plugin.getLogger().log(Level.SEVERE, "Could not save config to " + TabColorb, ex);
	    }
	}

	public void saveDefaultTabColorData() {
	    if (TabColorb == null) {
	    	TabColorb = new File(plugin.getDataFolder(), "tabcolor.yml");
	    }
	    if (TabColorb.exists()) {            
	         plugin.saveResource("TabColor.yml", false);
	     }
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
