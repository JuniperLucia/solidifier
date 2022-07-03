package ind.coralsolace.solidifier;

import ind.coralsolace.solidifier.commands.Solidify;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Solidifier extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("solidify").setExecutor(new Solidify());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
