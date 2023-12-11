package com.natamus.trampleeverything.util;

import com.natamus.collective.functions.BlockFunctions;
import com.natamus.trampleeverything.config.ConfigHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;

public class Util {
	public static void trampleCheck(Level world, BlockPos pos, Block block) {
		if (block instanceof FarmBlock) {
			pos = pos.above().immutable();
			block = world.getBlockState(pos).getBlock();
		}
		
		if (!isTrampleBlock(block)) {
			return;
		}
		
		if (ConfigHandler._enableTrampledBlockItems) {
			BlockFunctions.dropBlock(world, pos);
		}
		else {
			world.destroyBlock(pos, false);
		}
	}
	
	private static boolean isTrampleBlock(Block block) {
		if (block instanceof SnowLayerBlock) {
			return ConfigHandler.trampleSnow;
		}
		
		// Plant-type blocks
		if (block instanceof BambooSaplingBlock) {
			return ConfigHandler.trampleBambooSaplings;
		}
		if (block instanceof CropBlock) {
			return ConfigHandler.trampleCrops;
		}
		if (block instanceof DeadBushBlock) {
			return ConfigHandler.trampleDeadBushes;
		}
		if (block instanceof DoublePlantBlock) {
			return ConfigHandler.trampleDoublePlants;
		}
		if (block instanceof FlowerBlock) {
			return ConfigHandler.trampleFlowers;
		}
		if (block instanceof FungusBlock) {
			return ConfigHandler.trampleFungi;
		}
		if (block instanceof WaterlilyBlock) {
			return ConfigHandler.trampleLilyPads;
		}
		if (block instanceof MushroomBlock) {
			return ConfigHandler.trampleMushrooms;
		}
		if (block instanceof RootsBlock) {
			return ConfigHandler.trampleNetherRoots;
		}
		if (block instanceof NetherSproutsBlock) {
			return ConfigHandler.trampleNetherSprouts;
		}
		if (block instanceof NetherWartBlock) {
			return ConfigHandler.trampleNetherWart;
		}
		if (block instanceof SaplingBlock) {
			return ConfigHandler.trampleSaplings;
		}
		if (block instanceof SeagrassBlock) {
			return ConfigHandler.trampleSeaGrass;
		}
		if (block instanceof SeaPickleBlock) {
			return ConfigHandler.trampleSeaPickles;
		}
		if (block instanceof StemBlock || block instanceof AttachedStemBlock) {
			return ConfigHandler.trampleStems;
		}
		if (block instanceof SugarCaneBlock) {
			return ConfigHandler.trampleSugarCane;
		}
		if (block instanceof SweetBerryBushBlock) {
			return ConfigHandler.trampleSweetBerryBushes;
		}
		if (block instanceof TallGrassBlock) {
			return ConfigHandler.trampleTallGrass;
		}
		return false;
	}
}
