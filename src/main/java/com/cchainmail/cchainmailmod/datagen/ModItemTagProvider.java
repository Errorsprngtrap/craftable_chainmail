package com.cchainmail.cchainmailmod.datagen;

import com.cchainmail.cchainmailmod.CraftableChainmailMod;
import com.cchainmail.cchainmailmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, CraftableChainmailMod.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        //do add tag do teh same as block so tag .add ect
        tag(ItemTags.REPAIRS_CHAIN_ARMOR)
                .remove(Items.IRON_INGOT)
                .add(ModItems.CHAINMAIL.get());
    }
}
