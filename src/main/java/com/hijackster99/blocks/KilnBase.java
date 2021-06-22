package com.hijackster99.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

public class KilnBase extends SBlock {

	boolean fired;
	
	public KilnBase(String name, Material mat, float hardness, float resistance, ToolType tool, int miningLevel,
			boolean requiresTool, boolean fired) {
		super(name, mat, hardness, resistance, tool, miningLevel, requiresTool);
		this.fired = fired;
	}
	
	@Override
	public VoxelShape getOcclusionShape(BlockState p_196247_1_, IBlockReader p_196247_2_, BlockPos p_196247_3_) {
		return VoxelShapes.empty();
	}

}
