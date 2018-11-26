package com.karlofduty.GoldDropRemover;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class GoldDropRemover extends JavaPlugin
{
    private static GoldDropRemover instance;

    @Override
    public void onEnable()
    {
        instance = this;
        getServer().getPluginManager().registerEvents(new EntityDeathHandler(), this);
    }

    @Override
    public void onDisable()
    {

    }
    public static void log(String message)
    {
        instance.getServer().getLogger().info(message);
    }
}
