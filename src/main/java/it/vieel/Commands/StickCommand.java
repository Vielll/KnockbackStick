package it.vieel.Commands;

import it.vieel.KnockbackStick;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class StickCommand implements CommandExecutor {

    KnockbackStick main;

    public StickCommand(KnockbackStick main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(main.getConfig().getString("permission"))){
                player.sendMessage(main.getConfig().getString("message"));

                // STICK
                ItemStack stick = new ItemStack(Material.STICK);
                ItemMeta stickMeta = stick.getItemMeta();

                stickMeta.addEnchant(Enchantment.KNOCKBACK, 10, false);

                stickMeta.setDisplayName(main.getConfig().getString("name"));
                stick.setItemMeta(stickMeta);

                player.getInventory().addItem(stick);
            }else {
                // NO PERMISSION
                player.sendMessage(main.getConfig().getString("no-permission"));
            }

        }
        return false;
    }
}
