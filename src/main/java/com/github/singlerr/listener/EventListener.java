package com.github.singlerr.listener;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public final class EventListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent event){
        if(event.getClickedBlock() == null || ! event.getPlayer().isOp())
            return;

        if(!(event.getClickedBlock().getType().equals(Material.SIGN_POST)))
            return;

        Sign sign = (Sign) event.getClickedBlock().getState();

        if(sign.getLines().length <= 1)
            return;
        String cmd = sign.getLine(0);

        if(! cmd.equals("[시간]"))
            return;

        String val = sign.getLine(1);
        long value;
        try{
            value = Long.parseLong(val);
        }catch (NumberFormatException e){
            return;
        }
       // History.TIME_HISTORY.addLast(event.getPlayer().getWorld().getTime());
        event.getPlayer().getWorld().setTime(value);
        event.getPlayer().sendMessage("시간 설정 : " + val);
        event.setCancelled(true);
    }
}
