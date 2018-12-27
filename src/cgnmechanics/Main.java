package cgnmechanics;

import org.bukkit.plugin.java.JavaPlugin;

import cgnmechanics.events.PlayerDeath;
import cgnmechanics.events.PlayerDeathMessage;
import cgnmechanics.events.WeatherChange;

public class Main extends JavaPlugin {
	private static Main instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
		getServer().getPluginManager().registerEvents(new WeatherChange(), this);
		getServer().getPluginManager().registerEvents(new PlayerDeathMessage(), this);
	}
	
	public static Main getInstance() {
		return instance;
	}
}