package com.mcatk.itemmanager;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Items {
    private String id;
    private final HashMap<String, ItemStack> itemStackHashMap;
    
    public Items(String id) {
        this.id = id;
        itemStackHashMap = new HashMap<>();
        ConfigurationSection cs =
                ItemManager.getPlugin().getConfig().getConfigurationSection(id);
        if (cs != null) {
            for (String key : cs.getKeys(false)) {
                itemStackHashMap.put(key, (ItemStack) cs.get(key));
            }
        }
    }
    
    public String getId() {
        return id;
    }
    
    public HashMap<String, ItemStack> getItemStackHashMap() {
        return itemStackHashMap;
    }
}
