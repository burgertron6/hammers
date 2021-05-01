package xyz.grantlmul.hammers;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Hammers implements ModInitializer {
	// compressed cobblestone
	public static final Block COMPRESSED_COBBLESTONE = new Block(FabricBlockSettings.of(Material.STONE).strength(18.0F, 54.0F).breakByTool(FabricToolTags.PICKAXES, 0));

	// le hammers
	public static ToolItem WOODEN_HAMMER = new ToolHammer(ToolMaterials.WOOD, 3, 16.8F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem STONE_HAMMER = new ToolHammer(ToolMaterials.STONE, 3, 16.8F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem IRON_HAMMER = new ToolHammer(ToolMaterials.IRON, 3, 16.8F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem GOLDEN_HAMMER = new ToolHammer(ToolMaterials.GOLD, 3, 16.8F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem DIAMOND_HAMMER = new ToolHammer(ToolMaterials.DIAMOND, 3, 16.8F, new Item.Settings().group(ItemGroup.TOOLS));
	public static ToolItem NETHERITE_HAMMER = new ToolHammer(ToolMaterials.NETHERITE, 3, 16.8F, new Item.Settings().group(ItemGroup.TOOLS));

	@Override
	public void onInitialize() {
		System.out.println("xyz.grantlmul.hammers is initializing");

		// compressed cobblestone
		Registry.register(Registry.BLOCK, new Identifier("hammers", "compressed_cobblestone"), COMPRESSED_COBBLESTONE);
		Registry.register(Registry.ITEM, new Identifier("hammers", "compressed_cobblestone"), new BlockItem(COMPRESSED_COBBLESTONE, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS)));

		// hammers
		Registry.register(Registry.ITEM, new Identifier("hammers", "wooden_hammer"), WOODEN_HAMMER);
		Registry.register(Registry.ITEM, new Identifier("hammers", "stone_hammer"), STONE_HAMMER);
		Registry.register(Registry.ITEM, new Identifier("hammers", "iron_hammer"), IRON_HAMMER);
		Registry.register(Registry.ITEM, new Identifier("hammers", "golden_hammer"), GOLDEN_HAMMER);
		Registry.register(Registry.ITEM, new Identifier("hammers", "diamond_hammer"), DIAMOND_HAMMER);
		Registry.register(Registry.ITEM, new Identifier("hammers", "netherite_hammer"), NETHERITE_HAMMER);


	}
}
