package io.github.RussianMushroom.CommandLoader.handler;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandException;
import org.bukkit.command.ConsoleCommandSender;

import io.github.RussianMushroom.CommandLoader.config.ConfigLoader;

/**
 * 
 * @author RussianMushroom
 *
 */
public class CommandHandler {

	public static void handle() {
		List<String> commands = ConfigLoader.getCommands()
				.orElse(new ArrayList<>());
		ConsoleCommandSender consoleSender = Bukkit.getServer().getConsoleSender();
		
		commands.forEach(command -> {
			try {
				Bukkit.getServer().dispatchCommand(consoleSender, 
						command);
				Bukkit.getServer().getLogger().info("[CommandLoader] successfully dispatched command: " + command);
			} catch (CommandException e) {
				Bukkit.getServer().getLogger().info("[CommandLoader] could not dispatch the command: " + command);
			}
		});		
	}
	
}
