package devos.pastelwonderland.Base;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static devos.pastelwonderland.PastelWonderland.FOODS;
import static devos.pastelwonderland.PastelWonderland.MOD_ID;

public class Items {
    public static final Item MALLARD_RAW = foodRegister("raw_mallard", 2, 1.5f);
    public static final Item MALLARD_COOKED = foodRegister("cooked_mallard", 4, 3f);
    public static final Item VANILLA_MOCHI = foodRegister("vanilla_mochi", 3, 1.5f);
    public static final Item CHOCOLATE_MOCHI = foodRegister("chocolate_mochi", 3, 1.5f);
    public static final Item COTTON_CANDY_MOCHI = foodRegister("cotton_candy_mochi", 3, 1.5f);
    public static final Item STRAWBERRY_MOCHI = foodRegister("strawberry_mochi", 3, 1.5f);
    public static final Item COTTON_CANDY = foodRegister("rainbow_cotton_candy", 2, 0.5f);
    public static final Item COTTON_CANDY_ICE_CREAM = foodRegister("cotton_candy_ice_cream", 2, 0.5f);
    public static final Item CHOCOLATE_ICE_CREAM = foodRegister("chocolate_ice_cream", 2, 0.5f);
    public static final Item VANILLA_ICE_CREAM = foodRegister("vanilla_ice_cream", 2, 0.5f);
    public static final Item STRAWBERRY_ICE_CREAM = foodRegister("strawberry_ice_cream", 2, 0.5f);


    //Functions
    private static Item foodRegister(String name, int hunger, float saturation) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), new Item(new Item.Settings().group(FOODS).food(new FoodComponent.Builder().hunger(hunger).saturationModifier(saturation).build())));
    }
    private static Item register(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(MOD_ID, name), item);
    }
    public static void init() {

    }
}
