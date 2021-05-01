package xyz.grantlmul.hammers;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.function.Consumer;

import static net.minecraft.util.math.Direction.NORTH;
import static net.minecraft.util.math.Direction.SOUTH;

public class ToolHammer extends PickaxeItem {
    protected ToolHammer(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, (LivingEntity) miner, (Consumer<LivingEntity>) ((e) -> {
                miner.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            }));
        }
        Direction direction = miner.getHorizontalFacing();
        System.out.println(direction);
        Utils.MineIfAble(pos.up(), world, getMaterial(), miner);
        Utils.MineIfAble(pos.down(), world, getMaterial(), miner);

        if (direction == NORTH || direction == SOUTH) {
            BlockPos px = new BlockPos(pos.getX()+1,pos.getY(),pos.getZ());
            BlockPos mx = new BlockPos(pos.getX()-1,pos.getY(),pos.getZ());

            Utils.MineIfAble(px.up(), world, getMaterial(), miner);
            Utils.MineIfAble(px, world, getMaterial(), miner);
            Utils.MineIfAble(px.down(), world, getMaterial(), miner);

            Utils.MineIfAble(mx.up(), world, getMaterial(), miner);
            Utils.MineIfAble(mx, world, getMaterial(), miner);
            Utils.MineIfAble(mx.down(), world, getMaterial(), miner);

        } else {
            BlockPos pz = new BlockPos(pos.getX(),pos.getY(),pos.getZ()+1);
            BlockPos mz = new BlockPos(pos.getX(),pos.getY(),pos.getZ()-1);

            Utils.MineIfAble(pz.up(), world, getMaterial(), miner);
            Utils.MineIfAble(pz, world, getMaterial(), miner);
            Utils.MineIfAble(pz.down(), world, getMaterial(), miner);

            Utils.MineIfAble(mz.up(), world, getMaterial(), miner);
            Utils.MineIfAble(mz, world, getMaterial(), miner);
            Utils.MineIfAble(mz.down(), world, getMaterial(), miner);
        }


        return true;
    }
}
