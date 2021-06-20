package com.hijackster99.blocks;

import com.hijackster99.core.Util;

import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SBlockOre extends SBlock {

	int minHeight, maxHeight;
	int veinSize;
	float rarity;
	
	public SBlockOre(String name, float mohs, int veinSize, int minHeight, int maxHeight, float rarity) {
		super(name, Material.STONE, Util.getMinecraftHardness(mohs), Util.getMinecraftHardness(mohs), ToolType.PICKAXE, Util.getMiningLevel(mohs), true);
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.veinSize = veinSize;
		this.rarity = rarity;
	}

}
