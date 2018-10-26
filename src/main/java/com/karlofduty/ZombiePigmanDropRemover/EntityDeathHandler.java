package com.karlofduty.ZombiePigmanDropRemover;

import org.bukkit.entity.PigZombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathHandler implements Listener
{
    @EventHandler
    public void onDeath(EntityDeathEvent event)
    {
        if(event.getEntity() instanceof PigZombie)
        {
            event.getDrops().clear();
        }
    }
}
