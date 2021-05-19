package devos.pastelwonderland.Entities.Mallards;

import devos.pastelwonderland.Entities.Mallards.Models.MallardModel;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import static devos.pastelwonderland.PastelWonderland.MOD_ID;

// the amount of shit i have to make for a fucking mob is  a n n o y i n g  m e  -Devin
// Lol, saaaame -Zenith
public class MallardRenderer extends MobEntityRenderer<MallardEntity, MallardModel> {
    public MallardRenderer(EntityRenderDispatcher entityRenderDispatcher) {
        super(entityRenderDispatcher, new MallardModel(), 0.25f);
    }

    @Override
    public Identifier getTexture(MallardEntity entity) {
        if (!entity.getEntityWorld().getRegistryKey().getValue().getPath().equals("pastel_dim")) {
            if (!entity.isBaby()) {
                if (entity.getVariant() == 1) {
                    return new Identifier(MOD_ID, "textures/entity/mallard/mallard.png");
                } else {
                    return new Identifier(MOD_ID, "textures/entity/mallard/mallady.png");
                }
            } else {
                return new Identifier(MOD_ID, "textures/entity/mallard/mababy.png");
            }
        } else {
            if (!entity.isBaby()) {
                if (entity.getVariant() == 1) {
                    return new Identifier(MOD_ID, "textures/entity/mallard/pallard.png");
                } else {
                    return new Identifier(MOD_ID, "textures/entity/mallard/pallady.png");
                }
            } else {
                return new Identifier(MOD_ID, "textures/entity/mallard/pababy.png");
            }
        }
    }

    protected float getAnimationProgress(MallardEntity entity, float f) {
        float g = MathHelper.lerp(f, entity.prevFlapProgress, entity.flapProgress);
        float h = MathHelper.lerp(f, entity.prevMaxWingDeviation, entity.maxWingDeviation);
        return (MathHelper.sin(g) + 1.0F) * h;
    }
}


