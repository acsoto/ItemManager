package com.mcatk.itemmanager;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class ItemSort {
    private final HashMap<String, Items> itemsHashMap;
    
    public ItemSort() {
        itemsHashMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder("物品类已载入:\n");
        for (String key : ItemManager.getPlugin().getConfig().getKeys(false)) {
            itemsHashMap.put(key, new Items(key));
            stringBuilder.append(key).append("\n");
        }
        ItemManager.getPlugin().getLogger().info(stringBuilder.toString());
    }
    
    public void createSort(String id) {
        itemsHashMap.put(id, new Items(id));
    }
    
    public void addItem(String id1, String id2, ItemStack itemStack) {
        if (!itemsHashMap.containsKey(id1)) {
            itemsHashMap.put(id1, new Items(id1));
        }
        itemsHashMap.get(id1).getItemStackHashMap().put(id2, itemStack);
        ItemManager.getPlugin().getConfig().set(id1 + "." + id2, itemStack);
        ItemManager.getPlugin().saveConfig();
    }
    
    public ItemStack getItem(String id1, String id2) {
        return itemsHashMap.get(id1).getItemStackHashMap().get(id2);
    }
    
}
