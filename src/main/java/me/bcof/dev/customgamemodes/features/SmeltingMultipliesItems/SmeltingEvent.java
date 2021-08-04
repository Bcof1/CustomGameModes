package me.bcof.dev.customgamemodes.features.SmeltingMultipliesItems;

import me.bcof.dev.customgamemodes.DataManager.ConfigHandler;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceSmeltEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class SmeltingEvent implements Listener {
    ConfigHandler configHandler = new ConfigHandler();

    @EventHandler
    public void onSmelt(FurnaceSmeltEvent event){
        FileConfiguration file = configHandler.getFileConfig();
        if(file.getConfigurationSection("Smelting-Multiplies-Items") != null){
            ConfigurationSection section = file.getConfigurationSection("Smelting-Multiplies-Items");
            if(section.getBoolean("enabled")){
                ItemStack item = event.getResult();

                if(section.getBoolean("random-multiplier-enabled")){
                    Random random = new Random();
                    int multiplier = random.nextInt(section.getInt("random-multiplier-range"));
                    ItemStack newItem = new ItemStack(item.getType(), item.getAmount() * multiplier);

                    event.setResult(newItem);
                }else{
                    ItemStack newItem = new ItemStack(item.getType(), item.getAmount() * section.getInt("multiplier"));
                    event.setResult(newItem);
                }
            }
        }

    }
}
