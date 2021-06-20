package com.hijackster99.items.blockitems;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;

public class SBlockItem extends BlockItem{

	public SBlockItem(Block block, ItemGroup group, int stackSize) {
		super(block, new Properties().tab(group).stacksTo(stackSize));
		setRegistryName(block.getRegistryName());
	}

}
