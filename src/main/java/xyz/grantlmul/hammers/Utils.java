package xyz.grantlmul.hammers;

import net.fabricmc.fabric.api.tag.FabricItemTags;
import net.fabricmc.fabric.impl.tool.attribute.ToolManagerImpl;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Utils {
    // true if mined
    static boolean MineIfAble(BlockPos pos, World world, ToolMaterial material, LivingEntity miner) {
        BlockState block = world.getBlockState(pos);
        ToolManagerImpl.Entry entry = ToolManagerImpl.entry(world.getBlockState(pos).getBlock());
        if (material.getMiningLevel() >= entry.getMiningLevel(FabricItemTags.PICKAXES) && ((AbstractBlock.AbstractBlockState)block).getHardness(world, pos) > 0) {
            world.breakBlock(pos, true, miner);
        }
        return false;
    }
}
