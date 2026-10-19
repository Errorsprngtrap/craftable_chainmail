package com.cchainmail.cchainmailmod.block;

import com.cchainmail.cchainmailmod.CraftableChainmailMod;

import com.cchainmail.cchainmailmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.AttachedStemBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CraftableChainmailMod.MOD_ID);


    //Register Block Item
    private static  <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties,T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name,function);
        registerBlockItem(name,toReturn);
        return toReturn;
    }

    //Create an item for the block
    private static <T extends Block> void registerBlockItem(String name,DeferredBlock<T> block) {
        ModItems.ITEMS.registerItem(name, properties -> new BlockItem(block.get(),properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

