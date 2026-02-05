package me.penguinx13.wet.enchant;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.Map;
import java.util.Random;

public class EnchantTransferService {

    private static final Random RANDOM = new Random();

    public static ItemStack transfer(ItemStack sourceItem) {
        return transfer(sourceItem, RANDOM);
    }

    public static ItemStack transfer(ItemStack sourceItem, long seed) {
        return transfer(sourceItem, new Random(seed));
    }

    private static ItemStack transfer(ItemStack sourceItem, Random random) {
        ItemStack result = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta =
                (EnchantmentStorageMeta) result.getItemMeta();

        for (Map.Entry<Enchantment, Integer> entry :
                sourceItem.getEnchantments().entrySet()) {

            Enchantment enchant = entry.getKey();
            int level = entry.getValue();

            int chance = EnchantChanceCalculator.calculateChance(enchant, level);

            if (random.nextInt(100) < chance) {
                meta.addStoredEnchant(enchant, level, true);
            }
        }

        if (meta.getStoredEnchants().isEmpty()) {
            return null;
        }

        result.setItemMeta(meta);
        return result;
    }
}
