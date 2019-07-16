package com.karlofduty.GoldDropRemover;

import org.bukkit.Material;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathHandler implements Listener
{
    @EventHandler
    public void onDeath(EntityDeathEvent event)
    {
        if(!(event.getEntity() instanceof PigZombie) && !(event.getEntity() instanceof Drowned))
        {
            return;
        }

        for(int i = 0; i < event.getDrops().size(); i++)
        {
            if(event.getDrops().get(i).getType().equals(Material.GOLD_INGOT) || event.getDrops().get(i).getType().equals(Material.GOLD_NUGGET) || event.getDrops().get(i).getType().equals(Material.GOLDEN_SWORD))
            {
                event.getDrops().remove(i);
                i--;
                GoldDropRemover.log("Removed gold drops from entity death");
            }
        }
    }
}
