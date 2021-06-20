package pianopenguin471.universalenderchest;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderchestCommand implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("echest")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You cannot use this command if you are not a player.");
				return true;
			}
			Player player = (Player) sender;
			player.openInventory(player.getEnderChest())
			Main.enderchests.get(player.getUniqueId()).openInventory(player);
			return true;
		}
		return false;
	}
}
