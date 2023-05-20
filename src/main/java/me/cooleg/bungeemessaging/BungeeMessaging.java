package me.cooleg.bungeemessaging;

import me.cooleg.bungeemessaging.OutgoingMessages.BungeeMessageOut;
import me.cooleg.bungeemessaging.RecievedMessages.IncomingMessages;
import org.bukkit.plugin.java.JavaPlugin;

public final class BungeeMessaging extends JavaPlugin {

    @Override
    public void onEnable() {
        BungeeMessageOut.setPlugin(this);
        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new IncomingMessages());
    }

    @Override
    public void onDisable() {
        this.getServer().getMessenger().unregisterIncomingPluginChannel(this);
        this.getServer().getMessenger().unregisterOutgoingPluginChannel(this);
    }

}
