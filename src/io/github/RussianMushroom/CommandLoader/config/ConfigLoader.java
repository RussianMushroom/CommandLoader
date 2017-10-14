package io.github.RussianMushroom.CommandLoader.config;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;


/**
 * 
 * @author RussianMushroom
 *
 */
public class ConfigLoader {
	
	private static final File COMMAND_FILE = new File("plugins/CommandLoader/commands.yml");

	public static void load() {
		YamlConfiguration yConfig = new YamlConfiguration();
		
		yConfig.set("CommandLoader.CommandList", Arrays.asList("say CommandLoader is here!"));
		
		try {
			if(!COMMAND_FILE.exists()) {
				yConfig.save(COMMAND_FILE);
				Bukkit.getServer().getLogger().info("[CommandLoader] The config file has been created!");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Optional<List<String>> getCommands() {
		YamlConfiguration yConfig = new YamlConfiguration();
		
		try {
			yConfig.load(COMMAND_FILE);
			return Optional.of((List<String>) yConfig.getList("CommandLoader.CommandList"));
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}
	
}
