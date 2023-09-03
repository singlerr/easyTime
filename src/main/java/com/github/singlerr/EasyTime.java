package com.github.singlerr;

import com.github.singlerr.listener.EventListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class EasyTime extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new EventListener(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       if(label.equals("ztime")){
           if(sender instanceof Player && sender.isOp()){
               Player player = (Player) sender;
               player.getWorld().setTime(6000);
               player.sendMessage("시간 설정 : 6000");
           }
       }
        return false;
    }
}
