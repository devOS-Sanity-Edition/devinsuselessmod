package devos.pastelwonderland.Base.Organization;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;

import static net.minecraft.block.Blocks.*;

public class BlockInfo {

    public static Block ConcreteBlock() {
        return new Block(FabricBlockSettings.copy(WHITE_CONCRETE));
    }

}
