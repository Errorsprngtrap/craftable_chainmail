package com.cchainmail.cchainmailmod.tags;

import com.cchainmail.cchainmailmod.CraftableChainmailMod;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {
    public static class  Items{
        //create tag example just below
        //public static final TagKey<Item> TEST_ITEMS = createTag("test_items");


        //that shit create the tags
        private static TagKey<Item> createTag(String name){
            return ItemTags.create(Identifier.fromNamespaceAndPath(CraftableChainmailMod.MOD_ID,name));
        }
    }


}