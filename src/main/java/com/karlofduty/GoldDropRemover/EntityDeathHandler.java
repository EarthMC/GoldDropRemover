package com.karlofduty.GoldDropRemover;

import org.bukkit.Material;
import org.bukkit.entity.Drowned;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Piglin;
import org.bukkit.entity.PiglinBrute;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathHandler implements Listener
{
    @EventHandler
    public void onDeath(EntityDeathEvent event)
    {
        if (event.getEntity() instanceof PigZombie || event.getEntity() instanceof Drowned ||
            event.getEntity() instanceof Piglin || event.getEntity() instanceof PiglinBrute)
        {
            for (int i = 0; i < event.getDrops().size(); i++)
            {
                if (isGold(event.getDrops().get(i).getType()))
                {
                    event.getDrops().remove(i);
                    i--;
                }
            }
        }
    }

    private boolean isGold(Material material)
    {
        switch(material)
        {
            case GOLD_BLOCK:
            case GOLD_INGOT:
            case GOLD_NUGGET:
            case GOLD_ORE:
            case GOLDEN_APPLE:
            case GOLDEN_AXE:
            case GOLDEN_BOOTS:
            case GOLDEN_CARROT:
            case GOLDEN_CHESTPLATE:
            case GOLDEN_HELMET:
            case GOLDEN_HOE:
            case GOLDEN_HORSE_ARMOR:
            case GOLDEN_LEGGINGS:
            case GOLDEN_PICKAXE:
            case GOLDEN_SHOVEL:
            case GOLDEN_SWORD:
                return true;
            default:
                return false;
        }
    }
}
