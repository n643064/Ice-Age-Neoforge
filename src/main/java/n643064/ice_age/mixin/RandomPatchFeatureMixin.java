package n643064.ice_age.mixin;

import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.RandomPatchFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RandomPatchFeature.class)
public class RandomPatchFeatureMixin
{
    @Inject(method = "place", at = @At("HEAD"), cancellable = true, remap = false)
    private void injected(FeaturePlaceContext<RandomPatchConfiguration> p_160210_, CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(false);
    }
}