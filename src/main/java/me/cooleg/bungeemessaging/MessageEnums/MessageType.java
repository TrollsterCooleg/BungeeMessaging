package me.cooleg.bungeemessaging.MessageEnums;

/**
 * Lists out the different message types, and the string version of its name.
 * Learn more about these different message types <a href="https://www.spigotmc.org/wiki/bukkit-bungee-plugin-messaging-channel/">here</a>.
 */
public enum MessageType {

    CONNECT("Connect"),
    CONNECTOTHER("ConnectOther"),
    IP("IP"),
    IPOTHER("IPOther"),
    PLAYERCOUNT("PlayerCount"),
    PLAYERLIST("PlayerList"),
    GETSERVERS("GetServers"),
    MESSAGE("Message"),
    MESSAGERAW("MessageRaw"),
    GETSERVER("GetServer"),
    FORWARD("Forward"),
    FORWARDTOPLAYER("ForwardToPlayer"),
    UUID("UUID"),
    UUIDOTHER("UUIDOther"),
    SERVERIP("ServerIP"),
    KICKPLAYER("KickPlayer");

    private final String subChannel;
    MessageType(String subChannel) {
        this.subChannel = subChannel;
    }
    public String getSubChannel() {
        return subChannel;
    }
}
