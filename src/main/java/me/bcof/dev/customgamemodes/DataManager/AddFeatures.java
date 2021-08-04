package me.bcof.dev.customgamemodes.DataManager;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;


public class AddFeatures {
    private ConfigHandler configHandler = new ConfigHandler();

    /*
    Creates the features in the config
     */

    public void createFeaturesInConfig(){
        FileConfiguration file = configHandler.getFileConfig();

        if (file.getConfigurationSection("lava-follows-you") == null) {
            file.createSection("lava-follows-you");
            ConfigurationSection section = file.getConfigurationSection("lava-follows-you");
            section.set("enabled", true);
            section.set("lava-range-x", 20);
            section.set("lava-range-z", 10);
            configHandler.saveFileConfig();
        }

        if(file.getConfigurationSection("Smelting-Multiplies-Items") == null){
            file.createSection("Smelting-Multiplies-Items");
            ConfigurationSection section = file.getConfigurationSection("Smelting-Multiplies-Items");
            section.set("enabled", true);
            section.set("random-multiplier-enabled", false);
            section.set("random-multiplier-range", 5);
            section.set("multiplier", 10);
            configHandler.saveFileConfig();

        }

        if(file.getConfigurationSection("Block-Multiplies") == null){
            file.createSection("Block-Multiplies");
            ConfigurationSection section = file.getConfigurationSection("Block-Multiplies");
            section.set("enabled", true);
            section.set("random-multiplier-enabled", false);
            section.set("random-multiplier-range", 5);
            section.set("multiplier", 10);
            configHandler.saveFileConfig();

        }

        if(file.getConfigurationSection("Blocks-spawn-walk") == null){
            file.createSection("Blocks-spawn-walk");
            ConfigurationSection section = file.getConfigurationSection("Blocks-spawn-walk");
            section.set("enabled", true);
            configHandler.saveFileConfig();

        }

        if(file.getConfigurationSection("Health-Randomizer") == null){
            file.createSection("Health-Randomizer");
            ConfigurationSection section = file.getConfigurationSection("Health-Randomizer");
            section.set("enabled", true);
            section.set("seconds-to-execute", 30);
            configHandler.saveFileConfig();

        }

        if(file.getConfigurationSection("Look-At-Block") == null){
            file.createSection("Look-At-Block");
            ConfigurationSection section = file.getConfigurationSection("Look-At-Block");
            section.set("enabled", true);
            configHandler.saveFileConfig();

        }

    }
}

