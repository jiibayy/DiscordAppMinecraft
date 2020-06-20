package fr.jiibay.discordminecraft.Managers;

import fr.jiibay.discordminecraft.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;

import javax.security.auth.login.LoginException;

public class JdaRegister {

    public static JDA jda;


    // JDA START BOT
    public static void RegisterBot() throws LoginException, InterruptedException {


        jda = new JDABuilder(Main.getFileConfig().getString("options.token"))
                .build().awaitReady();

        jda.getPresence().setActivity(Activity.playing("Minecraft"));
    }

    public static boolean isTokenValid(){
        if (Main.getFileConfig().getString("options.token").isEmpty()){
            Main.getMain().getLogger().info("[Error] : Your message cant send discord because your token is invalid !");
            return false;
        }
        return true;
    }

    // JDA DISCONNECT BOT
    public static void UnregisterBot(){
        jda.shutdown();
    }


    // JDA CHANNEL DEFAULT SEND
    public static TextChannel getDefaultChannel(){

        return JdaRegister.getJda().getTextChannelsByName(Main.getFileConfig().getString("options.channel_send"), true).get(0);
    }

    public static JDA getJda() {
        return jda;
    }
}
