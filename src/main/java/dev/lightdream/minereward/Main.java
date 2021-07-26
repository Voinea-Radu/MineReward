package dev.lightdream.minereward;

import dev.lightdream.minereward.dto.Config;
import dev.lightdream.minereward.dto.Messages;
import dev.lightdream.minereward.utils.FileManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class Main extends JavaPlugin {

    //Settings
    public final static String PROJECT_NAME = "MineReward";

    //Managers
    private FileManager fileManager;

    //DTO
    private Config settings;
    private Messages messages;

    @Override
    public void onEnable() {

        //Managers
        fileManager = new FileManager(this, FileManager.PersistType.YAML);

        //Config
        settings = fileManager.load(Config.class);
        messages = fileManager.load(Messages.class);

    }

    @Override
    public void onDisable() {
    }
}
