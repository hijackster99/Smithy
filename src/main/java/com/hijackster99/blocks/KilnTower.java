package com.hijackster99.blocks;

import com.hijackster99.tileentities.KilnTile;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.tags.Tag;
import net.minecraft.tags.TagCollectionManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;

public class KilnTower extends SBlock {

	boolean fired;
	
	public KilnTower(String name, Material mat, float hardness, float resistance, ToolType tool, int miningLevel, boolean requiresTool, boolean fired) {
		super(name, mat, hardness, resistance, tool, miningLevel, requiresTool);
		this.fired = fired;
	}

	@Override
	public VoxelShape getShape(BlockState p_220053_1_, IBlockReader p_220053_2_, BlockPos p_220053_3_, ISelectionContext p_220053_4_) {
		return VoxelShapes.box(0.25, 0, 0.25, 0.75, 1, 0.75);
	}
	
	@Override
	public ActionResultType use(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult ray) {
		if(ray.getDirection() == Direction.UP) {
			if(!player.isCrouching()) {
				if(fired) {
					
				}else {
					Tag<Item> tag = (Tag<Item>) TagCollectionManager.getInstance().getItems().getTag(new ResourceLocation("minecraft:logs_that_burn"));
					if(tag.contains(player.getItemInHand(hand).getItem())) {
						TileEntity te = world.getBlockEntity(pos);
						if(te instanceof KilnTile) {
							LazyOptional<IItemHandler> opt = te.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
							if(opt.isPresent()) {
								IItemHandler inv = opt.orElse(null);
								inv.insertItem(0, player.getItemInHand(hand), false);
							}
						}
					}
				}
			}
		}
	}
	
}
