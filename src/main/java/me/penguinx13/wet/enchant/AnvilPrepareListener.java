package me.penguinx13.wet.enchant;

import me.penguinx13.wet.book.TransferBookUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class AnvilPrepareListener implements Listener {

    public AnvilPrepareListener(JavaPlugin plugin) {}

    @EventHandler
    public void onPrepare(PrepareAnvilEvent e) {
        ItemStack left = e.getInventory().getFirstItem();
        ItemStack right = e.getInventory().getSecondItem();

        if (left == null || right == null) return;
        if (!TransferBookUtil.isTransferBook(right)) return;
        if (left.getEnchantments().isEmpty()) return;

        long seed = buildSeed(left, right);
        ItemStack result = EnchantTransferService.transfer(left, seed);

        e.setResult(result);
        if (result != null) {
            e.getInventory().setRepairCost(5);
        }
    }

    private long buildSeed(ItemStack left, ItemStack right) {
        int leftHash = left.serialize().hashCode();
        int rightHash = right.serialize().hashCode();

        return ((long) leftHash << 32) ^ rightHash;
    }
}
