package com.hijackster99.crafting;

import com.hijackster99.core.References;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GravityFilterRecipe implements IRecipe<Inventory> {

	public static final IRecipeType<GravityFilterRecipe> GRAVITY_FILTER_RECIPE = IRecipeType.register("gravity_filter_recipe");
	private ResourceLocation id;
	@SuppressWarnings("unused")
	private String group;
	private ItemStack result;
	private Ingredient ingr;
	
	public GravityFilterRecipe(ResourceLocation id, String group, Ingredient ingr, ItemStack result) {
		this.id = id;
		this.group = group;
		this.result = result;
		this.ingr = ingr;
	}
	
	public GravityFilterRecipe() {
		this.id = new ResourceLocation(References.MODID, "");
		this.group = "";
		this.result = ItemStack.EMPTY;
		this.ingr = Ingredient.EMPTY;
	}
	
	@Override
	public boolean matches(Inventory inv, World world) {
		if(ingr.test(inv.getItem(0))) return true;
		return false;
	}

	@Override
	public ItemStack assemble(Inventory inv) {
		inv.removeItem(0, 1);
		inv.setItem(1, result);
		return result;
	}

	@Override
	public boolean canCraftInDimensions(int x, int y) {
		return true;
	}

	@Override
	public ItemStack getResultItem() {
		return result;
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public IRecipeSerializer<?> getSerializer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IRecipeType<?> getType() {
		return GRAVITY_FILTER_RECIPE;
	}

}
