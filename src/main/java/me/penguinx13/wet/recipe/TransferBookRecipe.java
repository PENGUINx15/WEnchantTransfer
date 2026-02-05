package me.penguinx13.wet.recipe;

import me.penguinx13.wet.book.TransferBookFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class TransferBookRecipe {

    private final JavaPlugin plugin;

    public TransferBookRecipe(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void register() {
        ShapedRecipe recipe = new ShapedRecipe(
                new NamespacedKey(plugin, "transfer_book"),
                TransferBookFactory.create()
        );

        recipe.shape("AEA", "ABA", "AAA");
        recipe.setIngredient('A', Material.AMETHYST_SHARD);
        recipe.setIngredient('E', Material.ECHO_SHARD);
        recipe.setIngredient('B', Material.BOOK);

        Bukkit.addRecipe(recipe);
    }
}
