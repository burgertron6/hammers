package xyz.grantlmul.hammers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

import java.util.Set;
import java.util.function.Consumer;

public class ToolHammer extends PickaxeItem {
    protected ToolHammer(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, (LivingEntity)miner, (Consumer)((e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            }));
        }

        HitResult block = raycast(world, (PlayerEntity) miner, RaycastContext.FluidHandling.NONE);
        int direction = Util.GetCardinalDirection(miner);
        Vec3d blockPos = block.getPos();
        world.breakBlock(new BlockPos(blockPos.x, blockPos.y+1, blockPos.z), true, miner);

        return true;
    }
}
