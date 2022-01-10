package com.hijackster99.tileentities;

import com.hijackster99.core.References;

import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class Tiles {
	
	@ObjectHolder(References.MODID + ":gravity_filter")
	public static TileEntityType<GravityFilterTile> GRAVITY_FILTER;
	
}
