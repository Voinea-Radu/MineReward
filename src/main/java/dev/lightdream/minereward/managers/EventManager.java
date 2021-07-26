package dev.lightdream.minereward.managers;

import dev.lightdream.minereward.Main;
import dev.lightdream.minereward.dto.Reward;
import dev.lightdream.minereward.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class EventManager implements Listener {

    public final Main plugin;

    public EventManager(Main plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerBlockBreak(BlockBreakEvent event) {
        if (!(event.getPlayer().getLocation().getBlockY() <= plugin.getSettings().applicableYLevel)) {
            return;
        }

        for (Reward reward : plugin.getSettings().rewards) {
            if (Utils.checkExecute(reward.chance)) {
                reward.commands.forEach(command -> Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replace("%player%", event.getPlayer().getName())));
                if (!plugin.getSettings().canGetMultipleRewards) {
                    break;
                }
            }
        }
    }


}
