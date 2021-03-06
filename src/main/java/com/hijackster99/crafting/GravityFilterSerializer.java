package com.hijackster99.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hijackster99.core.References;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipe;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.registries.ForgeRegistryEntry;
import net.minecraftforge.registries.ObjectHolder;

public class GravityFilterSerializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<GravityFilterRecipe> {

	@ObjectHolder(References.MODID + ":gravity_filter_serializer")
	public static IRecipeSerializer<?> GRAVITY_FILTER_SERIALIZER;
	
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
	public GravityFilterRecipe fromNetwork(ResourceLocation loc, PacketBuffer buffer) {
		int groupLength = buffer.readInt();
		String group = new String(buffer.readByteArray(groupLength));
		Ingredient ingr = Ingredient.fromNetwork(buffer);
		ItemStack result = buffer.readItem();
		
		return new GravityFilterRecipe(loc, group, ingr, result);
	}

	@Override
	public void toNetwork(PacketBuffer buffer, GravityFilterRecipe recipe) {
		buffer.writeInt(recipe.getGroup().getBytes().length);
		buffer.writeByteArray(recipe.getGroup().getBytes());
		recipe.getIngredients().get(0).toNetwork(buffer);
		buffer.writeItem(recipe.getResultItem());
		
	}

}
