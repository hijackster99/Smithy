package com.hijackster99.core;

import java.util.ArrayList;

import com.hijackster99.blocks.GravityFilterBlock;
import com.hijackster99.blocks.MillBlock;
import com.hijackster99.blocks.SBlock;
import com.hijackster99.blocks.SBlockOre;
import com.hijackster99.blocks.SBlocks;
import com.hijackster99.crafting.GravityFilterSerializer;
import com.hijackster99.crafting.MillSerializer;
import com.hijackster99.items.SItem;
import com.hijackster99.items.blockitems.SBlockItem;
import com.hijackster99.tileentities.GravityFilterTile;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(References.MODID)
@Mod.EventBusSubscriber(modid = References.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Smithy {

	static ArrayList<String> oreNames;
	
	public Smithy() {
		oreNames = new ArrayList<String>();
		//Iron
		oreNames.add("hematite");
		oreNames.add("magnetite");
		//Copper
		oreNames.add("chalcopyrite");
		oreNames.add("azurite");
		oreNames.add("malachite");
		oreNames.add("copper");
		//Tin
		oreNames.add("cassiterite");
		//Zinc
		oreNames.add("sphalerite");
		//Coal
		oreNames.add("anthracite");
		oreNames.add("bituminous");
		oreNames.add("subbituminous");
		oreNames.add("lignite");
		//Aluminum
		oreNames.add("bauxite");
		//Silver
		oreNames.add("argentite");
		oreNames.add("silver");
		//Lead
		oreNames.add("galena");
		//Bismuth
		oreNames.add("bismuthinite");
		oreNames.add("bismite");
		//Cadmium
		oreNames.add("greenockite");
		//Nickel
		oreNames.add("pentlandite");
		oreNames.add("garnierite");
		oreNames.add("limonite");
		//Chromium
		oreNames.add("chromite");
		//Titanium
		oreNames.add("ilmenite");
		oreNames.add("rutile");
		//Lithium
		//oreNames.add("spodumene");
		//Tungsten
		oreNames.add("scheelite");
		oreNames.add("wolframite");
		//Uranium
		oreNames.add("uraninite");
	}

	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		//Iron
		SBlockOre hematiteOre = new SBlockOre("hematite_ore", 6f, 10, 10, 60, 0.055f);
		SBlockOre magnetiteOre = new SBlockOre("magnetite_ore", 5.5f, 10, 10, 60, 0.015f);
		//Copper
		SBlockOre chalcopyriteOre = new SBlockOre("chalcopyrite_ore", 3.5f, 10, 40, 80, 0.000017f);
		SBlockOre azuriteOre = new SBlockOre("azurite_ore", 3.5f, 10, 40, 80, 0.000017f);
		SBlockOre malachiteOre = new SBlockOre("malachite_ore", 3.5f, 10, 40, 80, 0.000017f);
		SBlockOre copperOre = new SBlockOre("copper_ore", 3f, 10, 40, 80, 0.000017f);
		//Tin
		SBlockOre cassiteriteOre = new SBlockOre("cassiterite_ore", 6.5f, 10, 30, 60, 0.000005f);
		//Zinc
		SBlockOre sphaleriteOre = new SBlockOre("sphalerite_ore", 3.5f, 10, 10, 60, 0.000017f);
		//Coal
		SBlockOre anthraciteOre = new SBlockOre("anthracite_ore", 3f, 8, 0, 20, 0.000005f);
		SBlockOre bituminousOre = new SBlockOre("bituminous_ore", 2.5f, 12, 20, 40, 0.0001f);
		SBlockOre subbituminousOre = new SBlockOre("subbituminous_ore", 2f, 16, 40, 60, 0.00008f);
		SBlockOre ligniteOre = new SBlockOre("lignite_ore", 1.5f, 20, 60, 90, 0.000015f);
		//Aluminum
		SBlockOre bauxiteOre = new SBlockOre("bauxite_ore", 2f, 12, 10, 60, 0.0823f);
		//Silver
		SBlockOre argentiteOre = new SBlockOre("argentite_ore", 2.5f, 2, 10, 30, 0.00000005f);
		SBlockOre silverOre = new SBlockOre("silver_ore", 3f, 2, 10, 30, 0.000000025f);
		//Lead
		SBlockOre galenaOre = new SBlockOre("galena_ore", 2.5f, 10, 10, 60, 0.000013f);
		//Bismuth
		SBlockOre bismuthiniteOre = new SBlockOre("bismuthinite_ore", 2f, 6, 10, 60, 0.0000001f);
		SBlockOre bismiteOre = new SBlockOre("bismite_ore", 4.5f, 6, 10, 60, 0.0000001f);
		//Cadmium
		SBlockOre greenockiteOre = new SBlockOre("greenockite_ore", 3.5f, 6, 10, 30, 0.0000004f);
		//Nickel
		SBlockOre pentlanditeOre = new SBlockOre("pentlandite_ore", 4f, 8, 10, 30, 0.00003f);
		SBlockOre garnieriteOre = new SBlockOre("garnierite_ore", 4f, 8, 10, 30, 0.00003f);
		SBlockOre limoniteOre = new SBlockOre("limonite_ore", 5f, 8, 10, 60, 0.00003f);
		//Chromium
		SBlockOre chromiteOre = new SBlockOre("chromite_ore", 5.5f, 10, 10, 40, 0.00014f);
		//Titanium
		SBlockOre ilmeniteOre = new SBlockOre("ilmenite_ore", 5.5f, 10, 10, 30, 0.0031f);
		SBlockOre rutileOre = new SBlockOre("rutile_ore", 6.5f, 10, 10, 30, 0.0031f);
		//Lithium
		//SBlockOre spodumeneOre = new SBlockOre("spodumene_ore", 7f, 10, 10, 30, 0.00003f);
		//Tungsten
		SBlockOre scheeliteOre = new SBlockOre("scheelite_ore", 5f, 6, 10, 30, 0.0000008f);
		SBlockOre wolframiteOre = new SBlockOre("wolframite_ore", 4.5f, 6, 10, 30, 0.0000008f);
		//Uranium
		SBlockOre uraniniteOre = new SBlockOre("uraninite_ore", 5.5f, 10, 10, 60, 0.000003f);
		
		//Blocks
		
		SBlock gravityFilter = new GravityFilterBlock("gravity_filter", Material.METAL, 2, 2, ToolType.PICKAXE, 1, true);
		SBlock millBase = new MillBlock("mill_base", Material.STONE, 2, 2, ToolType.PICKAXE, 1, true);
		
		event.getRegistry().registerAll(hematiteOre,
										magnetiteOre,
										chalcopyriteOre,
										azuriteOre,
										malachiteOre,
										copperOre,
										cassiteriteOre,
										sphaleriteOre,
										anthraciteOre,
										bituminousOre,
										subbituminousOre,
										ligniteOre,
										bauxiteOre,
										argentiteOre,
										silverOre,
										galenaOre,
										bismuthiniteOre,
										bismiteOre,
										greenockiteOre,
										pentlanditeOre,
										garnieriteOre,
										limoniteOre,
										chromiteOre,
										ilmeniteOre,
										rutileOre,
										//spodumeneOre,
										scheeliteOre,
										wolframiteOre,
										uraniniteOre,
										gravityFilter,
										millBase);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		//Blocks
		
		//Iron
		SBlockItem hematiteOre = new SBlockItem(SBlocks.ORE.HEMATITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem magnetiteOre = new SBlockItem(SBlocks.ORE.MAGNETITE_ORE, ItemGroup.TAB_MISC, 64);
		//Copper
		SBlockItem chalcopyriteOre = new SBlockItem(SBlocks.ORE.CHALCOPYRITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem azuriteOre = new SBlockItem(SBlocks.ORE.AZURITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem malachiteOre = new SBlockItem(SBlocks.ORE.MALACHITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem copperOre = new SBlockItem(SBlocks.ORE.COPPER_ORE, ItemGroup.TAB_MISC, 64);
		//Tin
		SBlockItem cassiteriteOre = new SBlockItem(SBlocks.ORE.CASSITERITE_ORE, ItemGroup.TAB_MISC, 64);
		//Zinc
		SBlockItem sphaleriteOre = new SBlockItem(SBlocks.ORE.SPHALERITE_ORE, ItemGroup.TAB_MISC, 64);
		//Coal
		SBlockItem anthraciteOre = new SBlockItem(SBlocks.ORE.ANTHRACITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem bituminousOre = new SBlockItem(SBlocks.ORE.BITUMINOUS_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem subbituminousOre = new SBlockItem(SBlocks.ORE.SUBBITUMINOUS_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem ligniteOre = new SBlockItem(SBlocks.ORE.LIGNITE_ORE, ItemGroup.TAB_MISC, 64);
		//Aluminum
		SBlockItem bauxiteOre = new SBlockItem(SBlocks.ORE.BAUXITE_ORE, ItemGroup.TAB_MISC, 64);
		//Silver
		SBlockItem argentiteOre = new SBlockItem(SBlocks.ORE.ARGENTITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem silverOre = new SBlockItem(SBlocks.ORE.SILVER_ORE, ItemGroup.TAB_MISC, 64);
		//Lead
		SBlockItem galenaOre = new SBlockItem(SBlocks.ORE.GALENA_ORE, ItemGroup.TAB_MISC, 64);
		//Bismuth
		SBlockItem bismuthiniteOre = new SBlockItem(SBlocks.ORE.BISMUTHINITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem bismiteOre = new SBlockItem(SBlocks.ORE.BISMITE_ORE, ItemGroup.TAB_MISC, 64);
		//Cadmium
		SBlockItem greenockiteOre = new SBlockItem(SBlocks.ORE.GREENOCKITE_ORE, ItemGroup.TAB_MISC, 64);
		//Nickel
		SBlockItem pentlanditeOre = new SBlockItem(SBlocks.ORE.PENTLANDITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem garnieriteOre = new SBlockItem(SBlocks.ORE.GARNIERITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem limoniteOre = new SBlockItem(SBlocks.ORE.LIMONITE_ORE, ItemGroup.TAB_MISC, 64);
		//Chromium
		SBlockItem chromiteOre = new SBlockItem(SBlocks.ORE.CHROMITE_ORE, ItemGroup.TAB_MISC, 64);
		//Titanium
		SBlockItem ilmeniteOre = new SBlockItem(SBlocks.ORE.ILMENITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem rutileOre = new SBlockItem(SBlocks.ORE.RUTILE_ORE, ItemGroup.TAB_MISC, 64);
		//Lithium
		//SBlockItem spodumeneOre = new SBlockItem(SBlocks.ORE.SPODUMENE_ORE, ItemGroup.TAB_MISC, 64);
		//Tungsten
		SBlockItem scheeliteOre = new SBlockItem(SBlocks.ORE.SCHEELITE_ORE, ItemGroup.TAB_MISC, 64);
		SBlockItem wolframiteOre = new SBlockItem(SBlocks.ORE.WOLFRAMITE_ORE, ItemGroup.TAB_MISC, 64);
		//Uranium
		SBlockItem uraniniteOre = new SBlockItem(SBlocks.ORE.URANINITE_ORE, ItemGroup.TAB_MISC, 64);
		
		//Blocks
		
		SBlockItem gravityFilter = new SBlockItem(SBlocks.GRAVITY_FILTER, ItemGroup.TAB_MISC, 64);
		SBlockItem millBase = new SBlockItem(SBlocks.MILL, ItemGroup.TAB_MISC, 64);
		
		event.getRegistry().registerAll(hematiteOre,
										magnetiteOre,
										chalcopyriteOre,
										azuriteOre,
										malachiteOre,
										copperOre,
										cassiteriteOre,
										sphaleriteOre,
										anthraciteOre,
										bituminousOre,
										subbituminousOre,
										ligniteOre,
										bauxiteOre,
										argentiteOre,
										silverOre,
										galenaOre,
										bismuthiniteOre,
										bismiteOre,
										greenockiteOre,
										pentlanditeOre,
										garnieriteOre,
										limoniteOre,
										chromiteOre,
										ilmeniteOre,
										rutileOre,
										//spodumeneOre,
										scheeliteOre,
										wolframiteOre,
										uraniniteOre,
										gravityFilter,
										millBase);
		

//		//CHUNK
//		
//		for(String name : oreNames) {
//			SItem item = new SItem(ItemGroup.TAB_MISC, 64, name + "_chunk");
//			event.getRegistry().register(item);
//		}
//		
//		//POWDER
//		
//		for(String name : oreNames) {
//			SItem item = new SItem(ItemGroup.TAB_MISC, 64, name + "_powder");
//			event.getRegistry().register(item);
//		}
		
		SItem hematiteChunk = new SItem(ItemGroup.TAB_MISC, 64, "hematite_chunk");
		event.getRegistry().register(hematiteChunk);
		SItem hematitePowder = new SItem(ItemGroup.TAB_MISC, 64, "hematite_powder");
		event.getRegistry().register(hematitePowder);
		SItem hematiteConcentrated = new SItem(ItemGroup.TAB_MISC, 64, "hematite_concentrated");
		event.getRegistry().register(hematiteConcentrated);
		
		SItem pigIronIngot = new SItem(ItemGroup.TAB_MISC, 64, "pig_iron_ingot");
		event.getRegistry().register(pigIronIngot);
	}
	
	@SubscribeEvent
	public static void registerTiles(RegistryEvent.Register<TileEntityType<?>> event) {
		TileEntityType<GravityFilterTile> gravityFilter = TileEntityType.Builder.of(GravityFilterTile::new, SBlocks.GRAVITY_FILTER).build(null);
		gravityFilter.setRegistryName(References.MODID, "gravity_filter");
		event.getRegistry().register(gravityFilter);
		
		TileEntityType<GravityFilterTile> millBase = TileEntityType.Builder.of(GravityFilterTile::new, SBlocks.MILL).build(null);
		millBase.setRegistryName(References.MODID, "mill_base");
		event.getRegistry().register(millBase);
	}
	
	@SubscribeEvent
	public static void registerRecipeSerializers(RegistryEvent.Register<IRecipeSerializer<?>> event) {
		GravityFilterSerializer gravityFilterSer = new GravityFilterSerializer();
		gravityFilterSer.setRegistryName(References.MODID, "gravity_filter_serializer");
		event.getRegistry().register(gravityFilterSer);
		
		MillSerializer millSer = new MillSerializer();
		millSer.setRegistryName(References.MODID, "mill_serializer");
		event.getRegistry().register(millSer);
	}
	
}
