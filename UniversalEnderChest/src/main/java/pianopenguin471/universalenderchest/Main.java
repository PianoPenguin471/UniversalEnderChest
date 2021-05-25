package pianopenguin471.universalenderchest;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class Main extends JavaPlugin {
	public static Map<UUID, EnderChestGui> enderchests = new HashMap<>();
	@Override
	public void onEnable() {
		// Plugin startup logic
		getServer().getPluginManager().registerEvents(new EnderChestListener(),this);
		getCommand("echest").setExecutor(new EnderchestCommand());
	}
	
	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
