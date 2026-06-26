package org.franktankbank.mixin;

import org.franktankbank.config.MixinTweaksConfig;

import net.minecraft.client.gui.Hud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Hud.class)
public class HudMixin {
    @Inject(
            method = "extractSelectedItemName",
            at = @At("HEAD"),
            cancellable = true
    )
    private void init(CallbackInfo info) {
        if (MixinTweaksConfig.getConfig().DisableHeldItemTooltips) {
            info.cancel();
        }
    }
}
