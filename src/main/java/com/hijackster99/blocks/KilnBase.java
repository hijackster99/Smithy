package com.hijackster99.blocks;

import com.hijackster99.tileentities.KilnTile;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class KilnBase extends SBlock {

	boolean fired;
	
	public KilnBase(String name, Material mat, float hardness, float resistance, ToolType tool, int miningLevel, boolean requiresTool, boolean fired) {
		super(name, mat, hardness, resistance, tool, miningLevel, requiresTool);
		properties.noOcclusion();
		this.fired = fired;
	}
	
	@Override
	public VoxelShape getOcclusionShape(BlockState p_196247_1_, IBlockReader p_196247_2_, BlockPos p_196247_3_) {
		return VoxelShapes.empty();
	}
	
	@Override
	public VoxelShape getVisualShape(BlockState p_230322_1_, IBlockReader p_230322_2_, BlockPos p_230322_3_, ISelectionContext p_230322_4_) {
		return VoxelShapes.empty();
	}
	
	@Override
	public boolean hasTileEntity(BlockState state) {
		return true;
	}
	
	@Override
	public TileEntity createTileEntity(BlockState state, IBlockReader world) {
		return new KilnTile(fired);
	}

}
