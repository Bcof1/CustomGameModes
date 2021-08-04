package me.bcof.dev.customgamemodes.features.BlockMultiplies;

import me.bcof.dev.customgamemodes.DataManager.ConfigHandler;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class BlockBrokeEvent implements Listener {
    ConfigHandler configHandler = new ConfigHandler();

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onBlockBreak(BlockBreakEvent event){
        FileConfiguration file = configHandler.getFileConfig();

        if(file.getConfigurationSection("Block-Multiplies") != null){
            ConfigurationSection section = file.getConfigurationSection("Block-Multiplies");
            if(section.getBoolean("enabled")){
                Block block = event.getBlock();

                if(section.getBoolean("random-multiplier-enabled")){
                    Random random = new Random();
                    int multiplier = random.nextInt(section.getInt("random-multiplier-range"));
                    ItemStack newBlock = new ItemStack(block.getType(), multiplier);
                    event.getPlayer().getInventory().addItem(newBlock);

                }else{
                    ItemStack newBlock = new ItemStack(block.getType(), section.getInt("multiplier"));
                    event.getPlayer().getInventory().addItem(newBlock);
                }
            }
        }


    }
}
