package org.potato.mycology.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.potato.mycology.MycologyMod;

public class ModItemGroups {
    public static final CreativeModeTab MYCOLOGY_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            ResourceLocation.fromNamespaceAndPath(MycologyMod.MOD_ID, "mycology_tab"),
            FabricItemGroup.builder()
                    .title(Component.translatable("itemGroup.mycology.mycology_tab"))
                    .icon(() -> new ItemStack(ModItems.CHANTERELLE))
                    .displayItems((parameters, output) -> {
                        // Edible mushrooms
                        output.accept(ModItems.CHANTERELLE);
                        output.accept(ModItems.PORCINI);
                        output.accept(ModItems.FIELD_MUSHROOM);
                        output.accept(ModItems.OYSTER_MUSHROOM);
                        output.accept(ModItems.PARASOL_MUSHROOM);
                        output.accept(ModItems.GIANT_PUFFBALL);
                        output.accept(ModItems.BAY_BOLETE);
                        output.accept(ModItems.CHICKEN_OF_THE_WOODS);
                        output.accept(ModItems.HEDGEHOG_MUSHROOM);
                        output.accept(ModItems.WOOD_BLEWIT);
                        output.accept(ModItems.SHAGGY_INK_CAP);
                        output.accept(ModItems.HORN_OF_PLENTY);
                        output.accept(ModItems.BEEFSTEAK_FUNGUS);
                        output.accept(ModItems.SAFFRON_MILK_CAP);
                        output.accept(ModItems.DRYADS_SADDLE);
                        output.accept(ModItems.JELLY_EAR);
                        output.accept(ModItems.LIONS_MANE);

                        // Medicinal mushrooms
                        output.accept(ModItems.TURKEY_TAIL);
                        output.accept(ModItems.BIRCH_POLYPORE);
                        output.accept(ModItems.HOOF_FUNGUS);
                        output.accept(ModItems.ARTISTS_BRACKET);
                        output.accept(ModItems.CHAGA);
                        output.accept(ModItems.REISHI);

                        // Poisonous mushrooms
                        output.accept(ModItems.DEATH_CAP);
                        output.accept(ModItems.DESTROYING_ANGEL);
                        output.accept(ModItems.DEADLY_FIBRECAP);
                        output.accept(ModItems.DEADLY_WEBCAP);
                        output.accept(ModItems.YELLOW_STAINER);
                        output.accept(ModItems.FLY_AGARIC);
                        output.accept(ModItems.PANTHER_CAP);
                        output.accept(ModItems.FALSE_CHANTERELLE);
                    })
                    .build()
    );

    public static void registerItemGroups() {
        MycologyMod.LOGGER.info("Registering item groups for " + MycologyMod.MOD_ID);
    }
}
