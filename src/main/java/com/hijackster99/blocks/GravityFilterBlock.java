package com.hijackster99.blocks;

import com.hijackster99.tileentities.GravityFilterTile;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class GravityFilterBlock extends SBlock {

	BooleanProperty property;
	
	public GravityFilterBlock(String name, Material mat, float hardness, float resistance, ToolType tool,
			int miningLevel, boolean requiresTool) {
		super(name, mat, hardness, resistance, tool, miningLevel, requiresTool);
		this.registerDefaultState(this.stateDefinition.any().setValue(property, true));
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new GravityFilterTile();
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		if(property == null) property = BooleanProperty.create("water");
		builder.add(property);
	}
	
	@Override
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		return defaultBlockState().setValue(property, false);
	}

}
