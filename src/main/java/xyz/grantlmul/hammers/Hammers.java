package xyz.grantlmul.hammers;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Hammers implements ModInitializer {
	// compressed cobblestone
	public static final Block COMPRESSED_COBBLESTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(18.0F, 54.0F));

	// le hammers
	public static ToolItem WOOD_HAMMER;

	@Override
	public void onInitialize() {
		System.out.println("xyz.grantlmul.hammers is initializing");

		// compressed cobblestone
		Registry.register(Registry.BLOCK, new Identifier("hammers", "compressed_cobblestone"), COMPRESSED_COBBLESTONE);
		Registry.register(Registry.ITEM, new Identifier("hammers", "compressed_cobblestone"), new BlockItem(COMPRESSED_COBBLESTONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

	}
}
