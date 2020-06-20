package fr.jiibay.discordminecraft.Managers;

import fr.jiibay.discordminecraft.Listeners.asyncChat;
import fr.jiibay.discordminecraft.Listeners.onJoin;
import fr.jiibay.discordminecraft.Listeners.onQuit;
import fr.jiibay.discordminecraft.Main;
import org.bukkit.plugin.PluginManager;

public class SpigotRegister {


    // SPIGOT REGISTER PLUGIN
    public void RegisterPlugin(){

        PluginManager pluginManager = Main.getMain().getServer().getPluginManager();

        pluginManager.registerEvents(new asyncChat(), Main.getMain());
        pluginManager.registerEvents(new onQuit(), Main.getMain());
        pluginManager.registerEvents(new onJoin(), Main.getMain());
    }
}
