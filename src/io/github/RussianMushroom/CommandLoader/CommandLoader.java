package io.github.RussianMushroom.CommandLoader;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.RussianMushroom.CommandLoader.config.ConfigLoader;
import io.github.RussianMushroom.CommandLoader.handler.CommandHandler;

/**
 * 
 * @author RussianMushroom
 *
 */
public class CommandLoader extends JavaPlugin {
	
	@Override
	public void onEnable() {
		// Load config file
		ConfigLoader.load();
		
		// Run commands from file with a tick delay
		Bukkit.getScheduler().runTaskLater(
				this, 
				() -> CommandHandler.handle(), 
				1);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}

}
