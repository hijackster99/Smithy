package com.hijackster99.core;

import net.minecraft.client.renderer.model.IBakedModel;

public class Util {
	
	public static float getMinecraftHardness(float mohsHardness) {
		return mohsHardness/2;
	}
	
	public static int getMiningLevel(float mohsHardness) {
		return 0;
	}
	
}
