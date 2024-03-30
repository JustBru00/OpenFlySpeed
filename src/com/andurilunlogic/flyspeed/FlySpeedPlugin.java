package com.andurilunlogic.flyspeed;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.andurilunlogic.flyspeed.commands.WalkSpeedCommand;

@SuppressWarnings("deprecation")
public class FlySpeedPlugin extends JavaPlugin {
	
	 public static String prefix = null;
	 public static String noPermission = null;
	 public static String flightEnabled = null;
	 public static String flightDisabled = null;
	
	@Override
	public void onEnable() {
		// Save default configuration file
		getConfig().options().copyDefaults(true);
		saveConfig();
		
		// Register command executors
		FlyspeedCommands fspeedcom = new FlyspeedCommands();
		getCommand("flyspeed").setExecutor(fspeedcom);
		getCommand("walkspeed").setExecutor(new WalkSpeedCommand(this));
		getCommand("speed").setExecutor(fspeedcom);
		getCommand("fly").setExecutor(fspeedcom);
		
		// Load Text Strings
		prefix = color(getConfig().getString("prefix"));
		noPermission = color(getConfig().getString("no-permission"));
		flightEnabled = color(getConfig().getString("flight-enabled"));
		flightDisabled = color(getConfig().getString("flight-disabled"));
		
		// TODO Announce plugin enabled
	}

	@Override
	public void onDisable() {
		
	}
	
	public static String color(String uncolored) {
		return ChatColor.translateAlternateColorCodes('&', uncolored);
	}	
	
}
