package devos.pastelwonderland.Mixin;

import devos.pastelwonderland.Base.Blocks;
import net.minecraft.block.Block;
import net.minecraft.world.gen.feature.Feature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Feature.class)
public class IsSoilMixin {
    @Inject(method="isSoil", at=@At("HEAD"), cancellable = true)
    private static void isSoil(Block block, CallbackInfoReturnable<Boolean> cir) {
        if (block == Blocks.RED) {
            cir.setReturnValue(true);
        }
    }
}
