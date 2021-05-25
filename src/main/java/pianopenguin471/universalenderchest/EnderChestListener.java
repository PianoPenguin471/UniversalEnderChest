package pianopenguin471.universalenderchest;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class EnderChestListener implements Listener {
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.hasBlock()) {
				if (event.getClickedBlock().getType() == Material.ENDER_CHEST) {
					Main.enderchests.get(event.getPlayer().getUniqueId()).openInventory(event.getPlayer());
				}
			}
		}
	}
	
	@EventHandler
	public void loadEnderChest(PlayerJoinEvent event) {
		if (!Main.enderchests.containsKey(event.getPlayer().getUniqueId())) {
			EnderChestGui menu = new EnderChestGui();
			menu.register(event.getPlayer().getEnderChest());
			Main.enderchests.put(event.getPlayer().getUniqueId(), menu);
		}
		Main.enderchests.get(event.getPlayer().getUniqueId()).register(event.getPlayer().getEnderChest());
	}
	
	@EventHandler
	public void saveEnderChest(PlayerQuitEvent event) {
		event.getPlayer().getEnderChest().setContents(Main.enderchests.get(event.getPlayer().getUniqueId()).getInventory().getContents());
	}
}
