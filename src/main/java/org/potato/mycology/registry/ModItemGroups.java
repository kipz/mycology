package org.potato.mycology.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.potato.mycology.MycologyMod;
import org.potato.mycology.item.mushroom.MushroomItem;
import net.minecraft.world.item.Items;

public class ModItemGroups {
    public static final CreativeModeTab MYCOLOGY_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, "mycology_tab"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.mycology.mycology_tab"))
                    .icon(() -> new ItemStack(Items.RED_MUSHROOM)) // Fallback icon
                    .displayItems((parameters, output) -> {
                        // Automatically add all registered mushroom items from our mod
                        for (Item item : BuiltInRegistries.ITEM) {
                            if (item instanceof MushroomItem) {
                                ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
                                if (itemId.getNamespace().equals(MycologyMod.MOD_ID)) {
                                    output.accept(item);
                                }
                            }
                        }
                    })
                    .build()
    );

    public static void registerItemGroups() {
        MycologyMod.LOGGER.info("Registering item groups for " + MycologyMod.MOD_ID);
    }
}
