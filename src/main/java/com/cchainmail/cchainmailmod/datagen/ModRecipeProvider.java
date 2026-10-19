package com.cchainmail.cchainmailmod.datagen;

import com.cchainmail.cchainmailmod.CraftableChainmailMod;
import com.cchainmail.cchainmailmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new ModRecipeProvider(provider,recipeOutput);
        }

        @Override
        public String getName() {
            return "Template Mod Recipes";
        }
    }
    @Override
    protected void buildRecipes() {
        shaped(RecipeCategory.MISC, ModItems.CHAINMAIL)
                .pattern("CC ")
                .pattern("CC ")
                .define('C', Items.IRON_NUGGET)
                .unlockedBy("has_item", has(Items.IRON_NUGGET))
                .save(output);

        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.CHAINMAIL)
                .unlockedBy("has_item", has(ModItems.CHAINMAIL))
                .save(output);

        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET)
                .pattern("CCC")
                .pattern("C C")
                .define('C', ModItems.CHAINMAIL)
                .unlockedBy("has_item", has(ModItems.CHAINMAIL))
                .save(output);

        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                .pattern("CCC")
                .pattern("C C")
                .pattern("C C")
                .define('C', ModItems.CHAINMAIL)
                .unlockedBy("has_item", has(ModItems.CHAINMAIL))
                .save(output);

        shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                .pattern("C C")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CHAINMAIL)
                .unlockedBy("has_item", has(ModItems.CHAINMAIL))
                .save(output);
    }

    @Override
    protected <T extends AbstractCookingRecipe> void oreCooking(AbstractCookingRecipe.Factory<T> factory, List<ItemLike> smeltables, RecipeCategory craftingCategory, CookingBookCategory cookingCategory, ItemLike result, float experience, int cookingTime, String group, String fromDesc) {
        for(ItemLike item : smeltables) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(item), craftingCategory, cookingCategory, result, experience, cookingTime, factory)
                    .group(group)
                    .unlockedBy(getHasName(item), this.has(item))
                    .save(this.output, CraftableChainmailMod.MOD_ID + ":" + getItemName(result) + fromDesc + "_" + getItemName(item));
        }
    }
}
