package com.mcatk.itemmanager;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemManager extends JavaPlugin {
    
    private static ItemManager plugin;
    private static ItemSort itemSort;
    
    @Override
    public void onEnable() {
        plugin = this;
        saveConfig();
        itemSort = new ItemSort();
        regCommand();
        
    }
    
    @Override
    public void onDisable() {
    }
    
    public static ItemManager getPlugin() {
        return plugin;
    }
    
    public static ItemSort getItemSort() {
        return itemSort;
    }
    
    public static void reload() {
        itemSort = new ItemSort();
    }
    
    private void regCommand() {
        Bukkit.getPluginCommand("im").
                setExecutor(new ItemManagerCommand());
    }
    
    public static ItemStack getItem(String sortId, String itemId) {
        return itemSort.getItem(sortId, itemId);
    }
    
    public static void addItem(String sortId, String itemId, ItemStack itemStack) {
        itemSort.addItem(sortId, itemId, itemStack);
    }
}
