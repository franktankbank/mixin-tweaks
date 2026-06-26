package org.franktankbank.config;

import com.google.gson.GsonBuilder;

import dev.isxander.yacl3.api.YetAnotherConfigLib;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;

import org.franktankbank.MixinTweaks;
import org.franktankbank.config.categories.MainCategory;

public class MixinTweaksConfig {
    private static ConfigClassHandler<Config> HANDLER = ConfigClassHandler.createBuilder(Config.class)
        .id(Identifier.fromNamespaceAndPath("mixin_tweaks", "mixin_tweaks_config"))
        .serializer(config -> GsonConfigSerializerBuilder.create(config)
            .setPath(FabricLoader.getInstance().getConfigDir().resolve("mixin_tweaks.json5"))
            .appendGsonBuilder(GsonBuilder::setPrettyPrinting)
            .setJson5(true)
            .build())
        .build();

    public static void loadConfig() {
        HANDLER.load();
    }

    public static void saveConfig() {
        HANDLER.save();
    }

    public static Config getConfig() {
        return HANDLER.instance();
    }

    public static Screen createGui(Screen parent) {
        try {
            return YetAnotherConfigLib.create(HANDLER, (defaults, config, builder) -> {
                builder.title(Component.literal("MixinTweaks"))
                    .category(new MainCategory(defaults, config).create());
                return builder;
            }).generateScreen(parent);
        } catch (Throwable throwable) {
            MixinTweaks.LOGGER.error("[MixinTweaksConfig] Unable to generate MixinTweaks Screen for YACL Screen.", throwable);
            return null;
        }
    }
}
