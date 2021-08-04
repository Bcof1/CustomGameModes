package me.bcof.dev.customgamemodes.features.RandomBlocksSpawn;

import me.bcof.dev.customgamemodes.DataManager.ConfigHandler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.Random;

public class randomBlocksSpawn implements Listener {
    private ConfigHandler configHandler = new ConfigHandler();

    @EventHandler
    public void onPlayerMove (PlayerMoveEvent event){
        FileConfiguration file = configHandler.getFileConfig();
        if (file.getConfigurationSection("Blocks-spawn-walk") != null) {
            ConfigurationSection section = file.getConfigurationSection("Blocks-spawn-walk");

            if(section.getBoolean("enabled")){
                Location prevLocation = event.getFrom();
                Random random = new Random();

                ArrayList<Material> blocks = new ArrayList<>();
                for (Material block : Material.values()){
                    if(block.isBlock()){
                        blocks.add(block);
                    }
                }
                int num = random.nextInt(blocks.size());

                prevLocation.getBlock().setType(blocks.get(num));
            }

        }

    }
}
