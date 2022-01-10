package com.hijackster99.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;

public class GravityFilterSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<GravityFilterRecipe> {

	@SuppressWarnings("deprecation")
	@Override
	public GravityFilterRecipe fromJson(ResourceLocation loc, JsonObject json) {
		String group = JSONUtils.getAsString(json, "group", "");
		
		JsonElement ingrJson = JSONUtils.getAsJsonObject(json, "ingredient");
		Ingredient ingr = Ingredient.fromJson(ingrJson);
		
		ItemStack result;
		if(!json.has("result")) {
			result = ItemStack.EMPTY;
		}else if(json.get("result").isJsonObject()) {
			result = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "result"));
		}else {
			result = new ItemStack(Registry.ITEM.get(new ResourceLocation(JSONUtils.getAsString(json, "result"))));
		}
		
		return new GravityFilterRecipe(loc, group, ingr, result);
	}

	@Override
	public GravityFilterRecipe fromNetwork(ResourceLocation p_199426_1_, PacketBuffer p_199426_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void toNetwork(PacketBuffer p_199427_1_, GravityFilterRecipe p_199427_2_) {
		// TODO Auto-generated method stub
		
	}

}
