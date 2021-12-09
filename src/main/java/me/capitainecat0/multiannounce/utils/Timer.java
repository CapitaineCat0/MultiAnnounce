package me.capitainecat0.multiannounce.utils;

import me.capitainecat0.multiannounce.MultiAnnounce;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Random;

public class Timer extends BukkitRunnable {

    private final List<String> messages;
    private final boolean random;
    private int LastMessage = 0;
    public Timer(MultiAnnounce plugin){
        this.messages = plugin.getConfig().getStringList("messages");
        this.random = plugin.getConfig().getBoolean("random-messages");
    }
    @Override
    public void run() {
        String message = "";
        if(!random){
            if (LastMessage == MultiAnnounce.getInstance().getConfig().getStringList("messages").size()) LastMessage = 0;{
                message = messages.get(LastMessage + 1);
                LastMessage++;
            }
        }else{
            Random random = new Random();
            int nextMessage = random.nextInt(messages.size());
            while(nextMessage == LastMessage){
                random.nextInt(messages.size());
            }
            message = messages.get(nextMessage);
            LastMessage = nextMessage;
        }
        for(Player player : Bukkit.getOnlinePlayers()){
            player.sendMessage(message.replace("&", "§"));
        }
    }
}