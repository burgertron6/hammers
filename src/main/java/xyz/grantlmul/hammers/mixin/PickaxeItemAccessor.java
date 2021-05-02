package xyz.grantlmul.hammers.mixin;

import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.registry.RegistryKey;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

@Mixin(PickaxeItem.class)
public interface PickaxeItemAccessor {
    @Accessor("EFFECTIVE_BLOCKS")
    public static List<RegistryKey<Block>> GetEffectives() {
        throw new AssertionError();
    }
}
