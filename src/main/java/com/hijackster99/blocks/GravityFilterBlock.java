package com.hijackster99.blocks;

import com.hijackster99.tileentities.GravityFilterTile;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class GravityFilterBlock extends SBlock {

	public GravityFilterBlock(String name, Material mat, float hardness, float resistance, ToolType tool,
			int miningLevel, boolean requiresTool) {
		super(name, mat, hardness, resistance, tool, miningLevel, requiresTool);
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new GravityFilterTile();
	}

}
