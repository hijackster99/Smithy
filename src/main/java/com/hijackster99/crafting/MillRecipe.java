package com.hijackster99.crafting;

import com.hijackster99.core.References;

import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class MillRecipe implements IRecipe<Inventory>{

	public static final IRecipeType<MillRecipe> MILL_RECIPE = IRecipeType.register("mill_recipe");
	private ResourceLocation id;
	private String group;
	private Ingredient ingr;
	private ItemStack result;
	
	public MillRecipe(ResourceLocation id, String group, Ingredient ingr, ItemStack result) {
		this.id = id;
		this.group = group;
		this.ingr = ingr;
		this.result = result;
	}
	
	public MillRecipe() {
		this.id = new ResourceLocation(References.MODID, "");
		this.group = "";
		this.ingr = Ingredient.EMPTY;
		this.result = ItemStack.EMPTY;
	}
	
	@Override
	public boolean matches(Inventory inv, World world) {
		if(ingr.test(inv.getItem(1)) || ingr.test(inv.getItem(0))) return true;
		return false;
	}

	@Override
	public ItemStack assemble(Inventory inv) {
		inv.removeItem(1, 1);
		inv.setItem(2, result);
		return result;
	}

	@Override
	public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
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
		return MillSerializer.MILL_SERIALIZER;
	}

	@Override
	public IRecipeType<?> getType() {
		return MILL_RECIPE;
	}
	
	@Override
	public String getGroup() {
		return group;
	}
	
	@Override
	public NonNullList<Ingredient> getIngredients() {
		NonNullList<Ingredient> ingrs = NonNullList.create();
		ingrs.add(ingr);
		return ingrs;
	}

}
