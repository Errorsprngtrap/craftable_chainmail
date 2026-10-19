package com.cchainmail.cchainmailmod.item;

import com.cchainmail.cchainmailmod.CraftableChainmailMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(CraftableChainmailMod.MOD_ID);


    public static final DeferredItem<Item> CHAINMAIL = ITEMS.registerSimpleItem(
      "chainmail"
    );

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
