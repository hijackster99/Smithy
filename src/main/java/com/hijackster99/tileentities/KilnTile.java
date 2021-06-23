package com.hijackster99.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

public class KilnTile extends TileEntity implements ICapabilityProvider {

	private ItemStackHandler inventory;
	
	@CapabilityInject(ItemStackHandler.class)
	private static Capability<ItemStackHandler> INV_CAP;
	boolean fired;
	
	public KilnTile() {
		super(Tiles.KILN_TILE);
		this.fired = false;
		this.inventory = new ItemStackHandler(3);
	}
	
	public KilnTile(boolean fired) {
		super(Tiles.KILN_TILE);
		this.fired = fired;
		this.inventory = new ItemStackHandler(3);
	}
	
	@Override
	public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
		return INV_CAP.orEmpty(cap, LazyOptional.of(() -> inventory));
	}

}
