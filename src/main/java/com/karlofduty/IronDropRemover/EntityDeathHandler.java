package com.karlofduty.IronDropRemover;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDeathHandler implements Listener
{
    @EventHandler
    public void onDeath(EntityDeathEvent event)
    {
        if(event.getEntity() instanceof Player)
        {
            return;
        }
        ItemStack ironIngot = new ItemStack(Material.IRON_INGOT);
        ItemStack ironNugget = new ItemStack(Material.IRON_NUGGET);

        while(event.getDrops().remove(ironIngot)){}

        while(event.getDrops().remove(ironNugget)){}

        IronDropRemover.log("Removed iron drops from entity death");
    }
}
