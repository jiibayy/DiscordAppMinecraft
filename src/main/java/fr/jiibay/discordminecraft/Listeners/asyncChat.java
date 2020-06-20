package fr.jiibay.discordminecraft.Listeners;

import fr.jiibay.discordminecraft.Main;
import fr.jiibay.discordminecraft.Managers.JdaRegister;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class asyncChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e){

        Player player = e.getPlayer();

        if (Main.getFileConfig().getString("options.message_chat").isEmpty()){
            Main.getMain().getLogger().info("Error : No find message for message_chat");
            return;
        }

        if (Main.getFileConfig().getBoolean("options.chat", true)){

            // MINECRAFT
            e.setFormat(Main.getFileConfig().getString("options.message_chat")
                    .replace("%user%", player.getName())
                    .replace("%message%", e.getMessage().toLowerCase())
                    .replace("&", "§")
            );

            // JDA
            if (JdaRegister.isTokenValid()) {
                JdaRegister.getDefaultChannel().sendMessage(Main.getFileConfig().getString("options.message_chat")
                        .replace("%user%", player.getName())
                        .replace("%message%", e.getMessage().toLowerCase())
                        .replace("&", "§")
                ).queue();
            }
        }
    }
}
