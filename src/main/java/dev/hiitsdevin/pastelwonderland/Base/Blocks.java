package dev.hiitsdevin.pastelwonderland.Base;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;


import static dev.hiitsdevin.pastelwonderland.PastelWonderland.MOD_ID;
import static dev.hiitsdevin.pastelwonderland.PastelWonderland.BLOCKS;
//Copy these block settings
import static net.minecraft.block.Blocks.WHITE_CONCRETE;
import static net.minecraft.block.Blocks.WHITE_CONCRETE_POWDER;
import static net.minecraft.block.Blocks.DIRT;
import static net.minecraft.block.Blocks.GRASS_BLOCK;
import static net.minecraft.block.Blocks.STONE;
import static net.minecraft.block.Blocks.SAND;
import static net.minecraft.block.Blocks.OAK_LOG;
import static net.minecraft.block.Blocks.OAK_LEAVES;

public class Blocks {

    //Full blocks
    public static final Block RED = register("red", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block DARK_RED = register("dark_red", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block BLUE = register("blue", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block GREEN = register("green", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block BLACK = register("black", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block WHITE = register("white", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block GRAY = register("gray", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block MAGENTA = register("magenta", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block PURPLE = register("purple", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block ORANGE = register("orange", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block YELLOW = register("yellow", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));
    public static final Block BROWN = register("brown", new Block(FabricBlockSettings.copy(WHITE_CONCRETE)));

    //Powder Blocks
    public static final Block RED_POWDER = register("red_powder", new ConcretePowderBlock(RED, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block DARK_RED_POWDER = register("dark_red_powder", new ConcretePowderBlock(DARK_RED, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block ORANGE_POWDER = register("orange_powder", new ConcretePowderBlock(ORANGE, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block YELLOW_POWDER = register("yellow_powder", new ConcretePowderBlock(YELLOW, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block GREEN_POWDER = register("green_powder", new ConcretePowderBlock(GREEN, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block BLUE_POWDER = register("blue_powder", new ConcretePowderBlock(BLUE, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block PURPLE_POWDER = register("purple_powder", new ConcretePowderBlock(PURPLE, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block MAGENTA_POWDER = register("magenta_powder", new ConcretePowderBlock(MAGENTA, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block GRAY_POWDER = register("gray_powder", new ConcretePowderBlock(GRAY, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block BLACK_POWDER = register("black_powder", new ConcretePowderBlock(BLACK, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block BROWN_POWDER = register("brown_powder", new ConcretePowderBlock(BROWN, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));
    public static final Block WHITE_POWDER = register("white_powder", new ConcretePowderBlock(WHITE, FabricBlockSettings.copy(WHITE_CONCRETE_POWDER)));

    //Nature Blocks
    public static final Block PASTEL_DIRT = register("dirt", new Block(FabricBlockSettings.copy(DIRT)));
    public static final Block PASTEL_GRASS = register("grass", new GrassBlock(FabricBlockSettings.copy(GRASS_BLOCK)));
    public static final Block PASTEL_STONE = register("stone", new Block(FabricBlockSettings.copy(STONE)));
    public static final Block PASTEL_SAND = register("sand", new SandBlock(14269048, FabricBlockSettings.copy(SAND)));
    public static final Block PASTEL_LOG = register("log", new PillarBlock(FabricBlockSettings.copy(OAK_LOG)));
    public static final Block BLUE_LEAVES = register("blue_leaves", Leaves());
    public static final Block RED_LEAVES = register("red_leaves", Leaves());
    public static final Block YELLOW_LEAVES = register("yellow_leaves", Leaves());
    public static final Block GREEN_LEAVES = register("green_leaves", Leaves());

    //Functions
    private static Block register(String name, Block block) {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), new BlockItem(block, new Item.Settings().group(BLOCKS)));
        return Registry.register(Registry.BLOCK, new Identifier(MOD_ID, name), block);
    }
    public static LeavesBlock Leaves() {
        return new LeavesBlock(FabricBlockSettings.copy(OAK_LEAVES).nonOpaque().blockVision(Blocks::never).suffocates(Blocks::never));
    }
    public static boolean never(BlockState blockState, BlockView blockView, BlockPos blockPos) {
        return false;
    }
    public static void init() {

    }
}
