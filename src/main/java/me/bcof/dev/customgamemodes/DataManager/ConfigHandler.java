package me.bcof.dev.customgamemodes.DataManager;

import me.bcof.dev.customgamemodes.CustomGameModes;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigHandler {
    private CustomGameModes main = CustomGameModes.getPlugin(CustomGameModes.class);
    private FileConfiguration fileConfig;
    private File file;

    public void setup(){
        if(!main.getDataFolder().exists()){
            main.getDataFolder().mkdirs();
        }
        file = new File(main.getDataFolder(), "features.yml");

        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        fileConfig = YamlConfiguration.loadConfiguration(file);
    }

    public FileConfiguration getFileConfig() {
        return fileConfig;
    }

    public void saveFileConfig(){
        try{
            fileConfig.save(file);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void reloadCaneConfig(){
        fileConfig = YamlConfiguration.loadConfiguration(file);
    }
}
