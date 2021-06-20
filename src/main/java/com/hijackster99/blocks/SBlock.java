package com.hijackster99.blocks;

import com.hijackster99.core.References;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SBlock extends Block{

	public SBlock(String name, Material mat, float hardness, float resistance, ToolType tool, int miningLevel, boolean requiresTool) {
		super(Properties.of(mat).strength(hardness, resistance).harvestTool(tool).harvestLevel(miningLevel));
		if(requiresTool) properties.requiresCorrectToolForDrops();
		setRegistryName(References.MODID, name);
	}
	
}
