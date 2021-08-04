package me.bcof.dev.customgamemodes.features.LookAtBlock;

import me.bcof.dev.customgamemodes.DataManager.ConfigHandler;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class lookAtBlockEvent implements Listener {
    private ConfigHandler configHandler = new ConfigHandler();

    @EventHandler
    public void onPlayerMove (PlayerMoveEvent event){
        FileConfiguration file = configHandler.getFileConfig();

        if(file.getConfigurationSection("Look-At-Block") != null){
            ConfigurationSection section = file.getConfigurationSection("Look-At-Block");

            if(section.getBoolean("enabled")){
                Location location = event.getPlayer().getEyeLocation();
                ItemStack item = new ItemStack(location.getBlock().getType());
                event.getPlayer().getInventory().addItem(item);

            }
        }
    }
}
