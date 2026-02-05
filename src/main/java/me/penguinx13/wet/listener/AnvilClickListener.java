package me.penguinx13.wet.listener;

import me.penguinx13.wet.WEnchantTransfer;
import me.penguinx13.wet.book.TransferBookUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.ItemStack;

public class AnvilClickListener implements Listener {

    private final WEnchantTransfer plugin;

    public AnvilClickListener(WEnchantTransfer plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (!(e.getInventory() instanceof AnvilInventory inv)) return;
        if (e.getRawSlot() != 2) return;

        ItemStack left = inv.getFirstItem();
        ItemStack right = inv.getSecondItem();
        ItemStack result = e.getCurrentItem();

        if (left == null || right == null || result == null) return;
        if (TransferBookUtil.isTransferBook(right)) return;


        plugin.getServer().getScheduler().runTask(plugin, () -> {
            inv.setFirstItem(null);
            inv.setSecondItem(null);
        });
    }
}
