package com.mcatk.itemmanager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ItemManagerCommand implements CommandExecutor {
    private CommandSender sender;
    private String[] args;
    
    void printHelp() {
        sender.sendMessage("帮助：严格按照格式执行");
        sender.sendMessage("创建类型: /im create <类型ID>");
        sender.sendMessage("加入物品: /im add <类型ID> <商品ID>");
        sender.sendMessage("获取物品: /im get <类型ID> <商品ID>");
        sender.sendMessage("列出物品: /im list");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.isOp()) {
            return false;
        }
        this.sender = sender;
        this.args = args;
        if (args.length == 0) {
            printHelp();
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "create":
                create();
                break;
            case "add":
                add();
                break;
            case "give":
                give();
                break;
            case "list":
                list();
                break;
            default:
        }
        return true;
    }
    
    private void create() {
        String sortId = args[1];
        ItemManager.getItemSort().createSort(sortId);
        sender.sendMessage("Ok");
    }
    
    private void add() {
        String sortId = args[1];
        String itemId = args[2];
        ItemManager.getItemSort().addItem(sortId, itemId,
                ((Player) sender).getInventory().getItemInMainHand());
        sender.sendMessage("Ok");
    }
    
    private void give() {
        String sortId = args[1];
        String itemId = args[2];
        ((Player) sender).getInventory().addItem(
                ItemManager.getItemSort().getItem(sortId, itemId)
        );
        sender.sendMessage("Ok");
    }
    
    private void list() {
        sender.sendMessage(ItemManager.getItemSort().listAll());
    }
    
}
