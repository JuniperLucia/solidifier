package ind.coralsolace.solidifier.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.jetbrains.annotations.NotNull;

public class Erode implements CommandExecutor {
    public Integer i;
    public boolean materialCheck(ItemStack heldItem) { // Checks held item to identify color and/or if it's concrete
        Material[] conCrete = {Material.WHITE_CONCRETE, Material.ORANGE_CONCRETE, Material.MAGENTA_CONCRETE, Material.LIGHT_BLUE_CONCRETE, Material.YELLOW_CONCRETE, Material.LIME_CONCRETE, Material.PINK_CONCRETE, Material.GRAY_CONCRETE, Material.LIGHT_GRAY_CONCRETE, Material.CYAN_CONCRETE, Material.PURPLE_CONCRETE, Material.BLUE_CONCRETE, Material.BROWN_CONCRETE, Material.GREEN_CONCRETE, Material.RED_CONCRETE, Material.BLACK_CONCRETE};
        i = 0;
        for (Material m: conCrete) {
            if (heldItem.getType() == m) {
                return true;
            }
            i += 1;
        }
        return false;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player)) { // Blocks usage by anyone but players
            sender.sendMessage("This command may only be executed by players.");
            return true;
        }
        // /solidify
        if (command.getName().equalsIgnoreCase("erode")) {
            PlayerInventory inventory = ((Player) sender).getInventory();
            ItemStack heldItem = inventory.getItemInMainHand();
            if (materialCheck(heldItem)) {
                Material[] conPow = {Material.WHITE_CONCRETE_POWDER, Material.ORANGE_CONCRETE_POWDER, Material.MAGENTA_CONCRETE_POWDER, Material.LIGHT_BLUE_CONCRETE_POWDER, Material.YELLOW_CONCRETE_POWDER, Material.LIME_CONCRETE_POWDER, Material.PINK_CONCRETE_POWDER, Material.GRAY_CONCRETE_POWDER, Material.LIGHT_GRAY_CONCRETE_POWDER, Material.CYAN_CONCRETE_POWDER, Material.PURPLE_CONCRETE_POWDER, Material.BLUE_CONCRETE_POWDER, Material.BROWN_CONCRETE_POWDER, Material.GREEN_CONCRETE_POWDER, Material.RED_CONCRETE_POWDER, Material.BLACK_CONCRETE_POWDER};
                int quantity = heldItem.getAmount();
                ItemStack item = new ItemStack(conPow[i], quantity);
                inventory.setItemInMainHand(item);
                sender.sendMessage("§7Solidify §l" + quantity + "§r§7 of [§8" + conPow[i] + "§7]");
            }
            else {
                sender.sendMessage("§cInvalid item. Please hold Concrete to use this command.");
            }
        }
        return true;
    }
}
