package org.franktankbank.config.categories;

import org.franktankbank.config.Config;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.OptionDescription;
import net.minecraft.network.chat.Component;

public class MainCategory extends AbstractCategory {
    public MainCategory(Config defaults, Config current) {
        super(defaults, current);
    }

    @Override
    public ConfigCategory create() {
        return ConfigCategory.createBuilder()
            .name(Component.literal("Main"))
            .tooltip(Component.literal("Main Config"))
            .option(Option.<Boolean>createBuilder()
                .name(Component.literal("Disable Reverse Third Person"))
                .description(OptionDescription.of(Component.literal("Hides reverse third person when using F5")))
                .binding(defaults.DisableReverseThirdPerson, () -> current.DisableReverseThirdPerson, newValue -> current.DisableReverseThirdPerson = newValue)
                .controller(this::createBooleanController)
                .build())
            .option(Option.<Boolean>createBuilder()
                .name(Component.literal("Disable Held Item Tooltips"))
                .description(OptionDescription.of(Component.literal("Hides held item tooltips when you switch items")))
                .binding(defaults.DisableHeldItemTooltips, () -> current.DisableHeldItemTooltips, newValue -> current.DisableHeldItemTooltips = newValue)
                .controller(this::createBooleanController)
                .build())
            .build();
    }
}
