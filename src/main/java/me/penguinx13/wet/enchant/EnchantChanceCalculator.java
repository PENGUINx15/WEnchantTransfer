package me.penguinx13.wet.enchant;

import org.bukkit.enchantments.Enchantment;

public class EnchantChanceCalculator {

    public static int calculateChance(Enchantment enchant, int level) {
        int baseChance;

        switch (enchant.getRarity()) {
            case COMMON -> baseChance = 90;
            case UNCOMMON -> baseChance = 70;
            case RARE -> baseChance = 45;
            case VERY_RARE -> baseChance = 25;
            default -> baseChance = 50;
        }

        int penalty = (level - 1) * 5;
        int result = baseChance - penalty;

        return Math.max(result, 10);
    }
}
