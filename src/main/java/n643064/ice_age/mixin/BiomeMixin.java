package n643064.ice_age.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(Biome.class)
public abstract class BiomeMixin
{

    @Inject(method = "getBaseTemperature", at = @At("RETURN"), cancellable = true)
    private void getTemperature(CallbackInfoReturnable<Float> cir)
    {
        float temp = cir.getReturnValue();
        cir.setReturnValue(temp - 2f);
    }

    @Inject(method = "hasPrecipitation", at = @At("HEAD"), cancellable = true)
    private void hasPrecipitation(CallbackInfoReturnable<Boolean> cir)
    {
        cir.setReturnValue(true);
    }
    @Inject(method = "getPrecipitationAt", at = @At("HEAD"), cancellable = true)
    private void getPrecipitation(BlockPos pos, CallbackInfoReturnable<Biome.Precipitation> cir)
    {
        cir.setReturnValue(Biome.Precipitation.SNOW);
    }
    @Inject(method = "getSkyColor", at = @At("HEAD"), cancellable = true)
    private void getSkyColor(CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(0xE6EAFF);
    }
    @Inject(method = "getFoliageColor", at = @At("HEAD"), cancellable = true)
    private void getDefaultFoliageColor(CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(0xa3c2c2);
    }
    @Inject(method = "getGrassColor", at = @At("HEAD"), cancellable = true)
    private void getDefaultGrassColor(double posX, double posZ, CallbackInfoReturnable<Integer> cir)
    {
        cir.setReturnValue(0xa3c2c2);
    }
}