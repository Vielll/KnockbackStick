package it.vieel;

import it.vieel.Commands.StickCommand;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class KnockbackStick extends JavaPlugin {

    @Override
    public void onEnable() {
        Metrics metrics = new Metrics(this, 18365);

        // CONFIG
        this.getConfig().options().copyDefaults(true);
        this.saveDefaultConfig();

        // START
        System.out.print("\nLoading of...\n\n _  __                 _    _                _     _____ _   _      _    \n" +
                "| |/ /                | |  | |              | |   / ____| | (_)    | |   \n" +
                "| ' / _ __   ___   ___| | _| |__   __ _  ___| | _| (___ | |_ _  ___| | __\n" +
                "|  < | '_ \\ / _ \\ / __| |/ / '_ \\ / _` |/ __| |/ /\\___ \\| __| |/ __| |/ /\n" +
                "| . \\| | | | (_) | (__|   <| |_) | (_| | (__|   < ____) | |_| | (__|   < \n" +
                "|_|\\_\\_| |_|\\___/ \\___|_|\\_\\_.__/ \\__,_|\\___|_|\\_\\_____/ \\__|_|\\___|_|\\_\\\n\n By Vieel\n Version 1.0\n");

        // UPDATE
        new UpdateChecker(this, 109602).getLatestVersion(version -> {
                    if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                        Bukkit.getLogger().info("\n\nSlotSelector is at the latest version\n");
                    } else {
                        Bukkit.getLogger().warning("\n\nThere is an update of SlotSelector\n");
                    }
        });

        // COMMAND
        getCommand(("knockbackstick")).setExecutor(new StickCommand(this) );
    }
}
