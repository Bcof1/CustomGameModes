package me.bcof.dev.customgamemodes;

import me.bcof.dev.customgamemodes.DataManager.ConfigHandler;
import me.bcof.dev.customgamemodes.DataManager.AddFeatures;
import me.bcof.dev.customgamemodes.features.BlockMultiplies.BlockBrokeEvent;
import me.bcof.dev.customgamemodes.features.FeatureListCommand;

import me.bcof.dev.customgamemodes.features.LavaFollowsYou.LavaEvent;
import me.bcof.dev.customgamemodes.features.LookAtBlock.lookAtBlockEvent;
import me.bcof.dev.customgamemodes.features.RandomBlocksSpawn.randomBlocksSpawn;
import me.bcof.dev.customgamemodes.features.SmeltingMultipliesItems.SmeltingEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.Random;

public final class CustomGameModes extends JavaPlugin {
    private CustomGameModes instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        loadConfigHandler();

        AddFeatures addFeatures = new AddFeatures();
        addFeatures.createFeaturesInConfig();

        getCommand("customfeatures").setExecutor(new FeatureListCommand());

        getServer().getPluginManager().registerEvents(new LavaEvent(), this);
        getServer().getPluginManager().registerEvents(new SmeltingEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockBrokeEvent(), this);
        getServer().getPluginManager().registerEvents(new randomBlocksSpawn(), this);
        getServer().getPluginManager().registerEvents(new lookAtBlockEvent(), this);
        healthRandomizer();



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public CustomGameModes getInstance() {
        return instance;
    }

    public void loadConfigHandler() {
        ConfigHandler configHandler = new ConfigHandler();
        configHandler.setup();
        configHandler.saveFileConfig();
        configHandler.reloadCaneConfig();

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }

    public void healthRandomizer() {
        ConfigHandler configHandler = new ConfigHandler();
        FileConfiguration file = configHandler.getFileConfig();
        ConfigurationSection section = file.getConfigurationSection("Health-Randomizer");


        new BukkitRunnable() {
            @Override
            public void run() {
                if (file.getConfigurationSection("Health-Randomizer") != null) {
                    ConfigurationSection section = file.getConfigurationSection("Health-Randomizer");
                    if (section.getBoolean("enabled")) {
                        Random random = new Random();

                        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                            int num = random.nextInt((int) player.getMaxHealth());
                            player.setHealth(num);
                        }
                    }
                }
            }
        }.runTaskTimer(this, 20L * section.getInt("seconds-to-execute"), 1);

    }


}
