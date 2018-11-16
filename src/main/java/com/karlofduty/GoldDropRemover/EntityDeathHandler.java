package com.karlofduty.GoldDropRemover;

import org.bukkit.Material;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class EntityDeathHandler implements Listener
{
    @EventHandler
    public void onDeath(EntityDeathEvent event)
    {
        if(!(event.getEntity() instanceof PigZombie || event.getEntity() instanceof Drowned))
        {
            return;
        }
        List<ItemStack> items = event.getDrops();
        ItemStack goldIngot = new ItemStack(Material.GOLD_INGOT);
        ItemStack goldNugget = new ItemStack(Material.GOLD_NUGGET);

        while(items.remove(goldIngot)){}

        while(items.remove(goldNugget)){}
    }
}
