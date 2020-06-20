package fr.jiibay.discordminecraft.Listeners;

import fr.jiibay.discordminecraft.Main;
import fr.jiibay.discordminecraft.Managers.JdaRegister;
import net.dv8tion.jda.api.entities.TextChannel;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoin implements Listener {

    @EventHandler
    public void onJoinPlayer(PlayerJoinEvent e){

        Player player = e.getPlayer();

        if (Main.getFileConfig().getBoolean("options.join", true)){

            if (Main.getFileConfig().getString("options.message_join").isEmpty()){
                Main.getMain().getLogger().info("Error : No find message for message_join");
                return;
            }

            // MINECRAFT
            e.setJoinMessage(Main.getFileConfig().getString("options.message_join")
                    .replace("%user%", player.getName())
                    .replace("&", "§"));
            // JDA
            if (JdaRegister.isTokenValid()) {
                JdaRegister.getDefaultChannel().sendMessage(Main.getFileConfig().getString("options.message_join")
                        .replace("%user%", player.getName())
                        .replace("&", "§")
                ).queue();
            }
        }
    }
}
