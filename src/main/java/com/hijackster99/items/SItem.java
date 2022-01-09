package com.hijackster99.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class SItem extends Item {
	
	public SItem(ItemGroup group, int stackSize, String name) {
		super(new Properties().tab(group).stacksTo(stackSize));
		setRegistryName(name);
	}
	
}
