package com.cchainmail.cchainmailmod.datagen;

import com.cchainmail.cchainmailmod.CraftableChainmailMod;
import com.cchainmail.cchainmailmod.item.ModItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.data.PackOutput;

public class ModModelProviders extends ModelProvider {

    public ModModelProviders(PackOutput output) {
        super(output, CraftableChainmailMod.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        //items
        itemModels.generateFlatItem(ModItems.CHAINMAIL.get(), ModelTemplates.FLAT_ITEM);

        //blocks
    }
}
