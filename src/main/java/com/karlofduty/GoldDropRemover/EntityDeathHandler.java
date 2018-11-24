package com.karlofduty.GoldDropRemover;

import org.bukkit.Material;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class EntityDeathHandler implements Listener
{
    @EventHandler
    public void onDeath(EntityDeathEvent event)
    {
        if(!(event.getEntity() instanceof PigZombie) && !(event.getEntity() instanceof Drowned))
        {
            return;
        }
        ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
        ItemStack goldNugget = new ItemStack(Material.GOLD_NUGGET);

        while(event.getDrops().remove(goldIngot)){}

        while(event.getDrops().remove(goldNugget)){}

        GoldDropRemover.log("Removed gold drops from entity death");
    }
}
