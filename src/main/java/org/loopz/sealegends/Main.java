package org.loopz.sealegends;

import org.bukkit.plugin.java.JavaPlugin;
import org.loopz.sealegends.managers.Config;

public class Main extends JavaPlugin {

    private Config developer;

    @Override
    public void onEnable() {
        this.developer = new Config(this, "developer");
        this.developer.reloadConfig();
    }

    @Override
    public void onDisable() {
        this.developer.saveConfig();
    }

    public static Main getPlugin() {
        return getPlugin(Main.class);
    }

}
