// this is in every kt file but this rewrite is severely broken, if you can assist, please pull request and compare with main or rewrite branch. i'm so fucking sorry. -devin
// if you get a lot of red lines like shown here: https://cdn.discordapp.com/attachments/839722904676991056/843428635217100840/idea64_trv44LotCK.png
// then yeah that seems about right, again, im so so so sorry :C

package devos.pastelwonderland

import devos.pastelwonderland.Base.Blocks
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.fabricmc.loader.api.FabricLoader
import net.minecraft.block.Block
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier

public class PastelWonderland : ModInitializer {
    public val PW_MOD_ID = "pastelwonderland"
    public val VERSION = FabricLoader.getInstance().getModContainer(PW_MOD_ID).get().metadata.version.toString();

    val BLOCKS = FabricItemGroupBuilder.create(Identifier(PW_MOD_ID, "blocks")).icon {
        ItemStack(
            // HOW DO I CALL THE RED BLOCK IN THE BLOCKS CLASS
            Blocks.RED
        )
    }.build()


    override fun onInitialize() {
    // please is there any way at all to call Blocks.init(); in kotlin????? same would go for an Item class?????????
    }
}

//@Suppress("unused")
//fun init() {
//    // This code runs as soon as Minecraft is in a mod-load-ready state.
//    // However, some things (like resources) may still be uninitialized.
//    // Proceed with mild caution.
//
//    println("Hello Fabric world!")
//}
