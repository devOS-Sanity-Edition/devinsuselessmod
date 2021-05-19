// 🦀 CRAB IN THE CODE 🦀
// live laugh taze
// wait why do i hear a taser coming towards me-

package devos.pastelwonderland;

import devos.pastelwonderland.Base.*;
import devos.pastelwonderland.Entities.Mallards.MallardEntity;
import devos.pastelwonderland.Base.Blocks;
import devos.pastelwonderland.Base.Items;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class PastelWonderland implements ModInitializer {
    public static final String MOD_ID = "pastelwonderland";
    public static final String VERSION = FabricLoader.getInstance().getModContainer(MOD_ID).get().getMetadata().getVersion().toString();


    public static final EntityType<MallardEntity> MALLARD = Registry.register(
            Registry.ENTITY_TYPE,
            new Identifier("pastelwonderland", "mallard"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, MallardEntity::new).dimensions(EntityDimensions.changing(0.5f, 0.75f)).build()
    );


    public static final ItemGroup BLOCKS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "blocks")).icon(() -> new ItemStack(Blocks.RED)).build();
    public static final ItemGroup FOODS = FabricItemGroupBuilder.create(new Identifier(MOD_ID, "foods")).icon(() -> new ItemStack(Items.MALLARD_COOKED)).build();

    // maybe one day, tater will be a thing here again, no promises.
    // it's been months since this but i dont think im adding back tater. i still feel heavily discouraged after the first time. i'm sorry.

    @Override
    public final void onInitialize() {
        Blocks.init();
        Items.init();

        FabricDefaultAttributeRegistry.register(MALLARD, MallardEntity.createMobAttributes());
    }
}
