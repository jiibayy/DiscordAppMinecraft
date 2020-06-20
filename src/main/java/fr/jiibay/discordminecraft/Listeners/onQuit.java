package fr.jiibay.discordminecraft.Listeners;

import fr.jiibay.discordminecraft.Main;
import fr.jiibay.discordminecraft.Managers.JdaRegister;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onQuit implements Listener {

    @EventHandler
    public void onQuitPlayer(PlayerQuitEvent e){

        Player player = e.getPlayer();

        if (Main.getFileConfig().getBoolean("options.quit", true)){

            if (Main.getFileConfig().getString("options.message_quit").isEmpty()){
                Main.getMain().getLogger().info("Error : No find message for message_quit");
                return;
            }
            // MINECRAFT
            e.setQuitMessage(Main.getFileConfig().getString("options.message_quit")
                    .replace("%user%", player.getName())
                    .replace("&", "§")
            );

            // JDA
            if (JdaRegister.isTokenValid()) {
                JdaRegister.getDefaultChannel().sendMessage(Main.getFileConfig().getString("options.message_quit")
                        .replace("%user%", player.getName())
                        .replace("&", "§")
                ).queue();
            }
        }

    }
}
