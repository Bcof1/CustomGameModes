package me.bcof.dev.customgamemodes.features;

import me.bcof.dev.customgamemodes.DataManager.ConfigHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class FeatureListCommand implements CommandExecutor {
    private ConfigHandler configHandler = new ConfigHandler();
    /**
     * Executes the given command, returning its success.
     * <br>
     * If false is returned, then the "usage" plugin.yml entry for this command
     * (if defined) will be sent to the player.
     *
     * @param sender  Source of the command
     * @param command Command which was executed
     * @param label   Alias of the command which was used
     * @param args    Passed command arguments
     * @return true if a valid command, otherwise false
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.hasPermission("customgamemodes.list")){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', returnFeatureList()));
                player.sendMessage(ChatColor.GRAY + "You can enable/disable custom gamemodes from being run in the " + ChatColor.YELLOW + "features.yml" + ChatColor.GRAY + "file!");
            }else{
                player.sendMessage(ChatColor.RED + "You can not use this command!");
            }

        }else{
            System.out.println(returnFeatureList());
        }
        return true;
    }


    public String returnFeatureList(){
        String featureList = "";
        FileConfiguration file = configHandler.getFileConfig();

        for (String feature : file.getKeys(false)){
            featureList = "&2&l" + feature + "&7, " + "&3&l" + featureList;
        }

        return featureList;

    }
}
