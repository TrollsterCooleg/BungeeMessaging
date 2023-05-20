package me.cooleg.bungeemessaging.RecievedMessages;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import javax.annotation.Nonnull;

public class IncomingMessages implements PluginMessageListener {

    @Override
    public void onPluginMessageReceived(@Nonnull String channel, @Nonnull Player player, @Nonnull byte[] bytes) {
        if (!channel.equals("BungeeCord")) {return;}
        IncomingPluginMessageEvent event = new IncomingPluginMessageEvent(player, bytes);
        Bukkit.getServer().getPluginManager().callEvent(event);
    }

}
