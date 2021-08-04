package me.bcof.dev.customgamemodes.features.LavaFollowsYou;

import me.bcof.dev.customgamemodes.DataManager.ConfigHandler;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.Random;

public class LavaEvent implements Listener {
    private ConfigHandler configHandler = new ConfigHandler();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event){
        FileConfiguration file = configHandler.getFileConfig();
        if (file.getConfigurationSection("lava-follows-you") != null) {
            ConfigurationSection section = file.getConfigurationSection("lava-follows-you");

            if(section.getBoolean("enabled")){
                Location prevLocation = event.getFrom();

                Random random = new Random();
                double numX = random.nextInt(section.getInt("lava-range-x"));
                double numZ = random.nextInt(section.getInt("lava-range-z"));
                Location blockChange = new Location(prevLocation.getWorld(), prevLocation.getBlockX()-numX, prevLocation.getBlockY(), prevLocation.getBlockZ()-numZ);
                blockChange.getBlock().setType(Material.LAVA);
            }

        }
    }

}
