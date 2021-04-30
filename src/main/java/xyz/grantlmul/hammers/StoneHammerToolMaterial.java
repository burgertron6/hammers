package xyz.grantlmul.hammers;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class StoneHammerToolMaterial implements ToolMaterial {
    @Override
    public int getMiningLevel() {
        return 1;
    }

    @Override
    public int getDurability() {
        return 1179;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 4.0F;
    }

    @Override
    public float getAttackDamage() {
        return 1.0F;
    }

    @Override
    public int getEnchantability() {
        return 5;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
