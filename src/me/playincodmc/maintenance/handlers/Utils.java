package me.playincodmc.maintenance.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;

public class Utils {
	
	
	public static void clear(Player p) {
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		for (PotionEffect f : p.getActivePotionEffects())
			p.removePotionEffect(f.getType());
	}

	public static ItemStack lore(ItemStack item, String... lore) {
		ItemMeta m = item.getItemMeta();
		m.setLore(Arrays.asList(lore));
		item.setItemMeta(m);
		return item;
	}

	public static ItemStack name(ItemStack item, String name) {
		ItemMeta m = item.getItemMeta();
		m.setDisplayName(name);
		item.setItemMeta(m);
		return item;
	}

	public static ItemStack color(ItemStack item, Color color) {
		if (item.getItemMeta() instanceof LeatherArmorMeta) {
			LeatherArmorMeta m = (LeatherArmorMeta) item.getItemMeta();
			m.setColor(color);
			item.setItemMeta(m);
		}
		return item;
	}

	public static ItemStack enchant(ItemStack item, Enchantment[] enchantments, int[] levels) {
		// for(Enchantment ench : enchantments){
		for (int i = 0; i < levels.length; i++) {
			item.addUnsafeEnchantment(enchantments[i], levels[i]);
		}
		// }
		return item;
	}

	public static ItemStack enchant(ItemStack item, Enchantment enchantment, int level) {
		item.addUnsafeEnchantment(enchantment, level);
		return item;
	}

	public static ItemStack setHead(ItemStack head, String owner) {
		SkullMeta itemMeta = (SkullMeta) head.getItemMeta();
		itemMeta.setOwner(owner);
		itemMeta.setDisplayName("§6Head");
		head.setItemMeta(itemMeta);
		return head;
	}

	public static String getMessage(String[] args, int start) {
		String string = "";
		for (int i = start; i < args.length; i++) {
			string = ChatColor.translateAlternateColorCodes('&', string + args[i] + ' ');
		}
		return string;
	}

	public static void cooldown(Player player) {
		player.sendMessage("§cYou are still on cooldown.");
	}

	public static void noPermission(Player p) {
		p.sendMessage(ChatColor.RED + "You do not have permission to do this.");
	}

	public static boolean getRegion(int lowX, int highX, int lowZ, int highZ, int x, int z) {
		if (x > lowX && z < highZ && x < highX && z > lowZ) {
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean isInteger(String str) {
	    if (str == null) {
	        return false;
	    }
	    int length = str.length();
	    if (length == 0) {
	        return false;
	    }
	    int i = 0;
	    if (str.charAt(0) == '-') {
	        if (length == 1) {
	            return false;
	        }
	        i = 1;
	    }
	    for (; i < length; i++) {
	        char c = str.charAt(i);
	        if (c < '0' || c > '9') {
	            return false;
	        }
	    }
	    return true;
	}

	
	

}
