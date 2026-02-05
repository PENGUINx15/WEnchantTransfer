package me.penguinx13.wet.book;

import me.penguinx13.wet.WEnchantTransfer;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

public class TransferBookUtil {

    public static boolean isTransferBook(ItemStack item) {
        if (item == null || item.getType() != Material.BOOK) return false;
        if (!item.hasItemMeta()) return false;

        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(
                WEnchantTransfer.getInstance(),
                TransferBookFactory.KEY
        );

        return meta.getPersistentDataContainer().has(
                key, PersistentDataType.BYTE
        );
    }
}
