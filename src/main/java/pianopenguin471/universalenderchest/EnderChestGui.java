package pianopenguin471.universalenderchest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EnderChestGui {
	private static Inventory INV;
	
	public void setInventory(Inventory inv) {
		this.INV = inv;
	}
	
	public Inventory getInventory() {
		return INV;
	}
	
	public void register(Inventory enderChest) {
		int size = 27;
		Inventory inv = Bukkit.createInventory(null, size, ChatColor.AQUA + "" + ChatColor.BOLD + "Ender Chest");
		inv.setContents(enderChest.getContents());
		setInventory(inv);
	}
	
	public void openInventory(Player player) {
		player.openInventory(INV);
	}
}
