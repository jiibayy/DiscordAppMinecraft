package fr.jiibay.discordminecraft;

import fr.jiibay.discordminecraft.Managers.JdaRegister;
import fr.jiibay.discordminecraft.Managers.SpigotRegister;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class Main extends JavaPlugin {

    public static Main main;


    public static FileConfiguration getFileConfig(){

        return Main.getMain().getConfig();
    }

    @Override
    public void onLoad() {

    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        main = this;
        new SpigotRegister().RegisterPlugin();

        getLogger().info("DiscordMinecraftApp enable !");

        try {
            JdaRegister.RegisterBot();
        } catch (LoginException | InterruptedException e) {
            getLogger().info("[Error] : Your bot cant connect to discord !");
        }
    }

    @Override
    public void onDisable() {
        JdaRegister.UnregisterBot();
    }



    public static Main getMain() {
        return main;
    }

}
