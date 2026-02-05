package me.penguinx13.wet.book;

import me.penguinx13.wet.WEnchantTransfer;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;

public class TransferBookFactory {

    public static final String KEY = "transfer_book";

    public static ItemStack create() {
        ItemStack book = new ItemStack(Material.BOOK);
        ItemMeta meta = book.getItemMeta();

        meta.displayName(Component.text("§bКнига переноса"));
        meta.lore(List.of(
                Component.text("§7Переносит зачарования"),
                Component.text("§7с предмета с определенным шансом."),
                Component.text("§cПредмет будет уничтожен")
        ));

        meta.setCustomModelData(1001);

        NamespacedKey key = new NamespacedKey(
                WEnchantTransfer.getInstance(), KEY
        );

        meta.getPersistentDataContainer().set(
                key, PersistentDataType.BYTE, (byte) 1
        );

        book.setItemMeta(meta);
        return book;
    }
}
