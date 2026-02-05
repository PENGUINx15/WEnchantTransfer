package me.penguinx13.wet;

import me.penguinx13.wet.enchant.AnvilPrepareListener;
import me.penguinx13.wet.listener.AnvilClickListener;
import me.penguinx13.wet.recipe.TransferBookRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public final class WEnchantTransfer extends JavaPlugin {

    private static WEnchantTransfer instance;

    @Override
    public void onEnable() {
        instance = this;

        new TransferBookRecipe(this).register();

        getServer().getPluginManager().registerEvents(
                new AnvilPrepareListener(), this
        );
        getServer().getPluginManager().registerEvents(
                new AnvilClickListener(), this
        );
    }

    public static WEnchantTransfer getInstance() {
        return instance;
    }
}
