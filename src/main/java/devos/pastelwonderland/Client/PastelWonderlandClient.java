package devos.pastelwonderland.Client;

import devos.pastelwonderland.Entities.Mallards.MallardRenderer;
import devos.pastelwonderland.PastelWonderland;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;

@Environment(EnvType.CLIENT)
public class PastelWonderlandClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.INSTANCE.register(PastelWonderland.MALLARD, (dispatcher, context) ->
                new MallardRenderer(dispatcher)
        );
    }
}