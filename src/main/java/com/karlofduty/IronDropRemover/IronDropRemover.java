package com.karlofduty.IronDropRemover;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public class IronDropRemover extends JavaPlugin
{
    public static FileConfiguration config;
    private static IronDropRemover instance;

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

    public static IronDropRemover getInstance() {
        return instance;
    }

    public static ConsoleCommandSender getConsole()
    {
        return instance.getServer().getConsoleSender();
    }

    public static void executeCommand(String command)
    {
        instance.getServer().dispatchCommand(getConsole(), command);
    }

    public static void log(String message)
    {
        instance.getServer().getLogger().info(message);
    }
    public static void logColoured(String message)
    {
        getConsole().sendMessage(message);
    }
    public static void logWarning(String message)
    {
        instance.getServer().getLogger().warning(message);
    }
}
