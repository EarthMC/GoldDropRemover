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
        for(int i = 0; i < event.getDrops().size(); i++)
        {
            if(event.getDrops().get(i).getType().equals(Material.IRON_INGOT) || event.getDrops().get(i).getType().equals(Material.IRON_NUGGET))
            {
                event.getDrops().remove(i);
                i--;
                IronDropRemover.log("Removed iron drops from entity death");
            }
        }
    }
}
