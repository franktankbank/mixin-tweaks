package org.franktankbank.config.categories;

import org.franktankbank.config.Config;
import org.franktankbank.fmt.Colors;

import dev.isxander.yacl3.api.ConfigCategory;
import dev.isxander.yacl3.api.Option;
import dev.isxander.yacl3.api.controller.BooleanControllerBuilder;
import net.minecraft.network.chat.Component;

abstract class AbstractCategory {
    protected Config defaults;
    protected Config current;

    protected AbstractCategory(Config defaults, Config current) {
        this.defaults = defaults;
        this.current = current;
    }

    public abstract ConfigCategory create();

    public BooleanControllerBuilder createBooleanController(Option<Boolean> opt) {
        return BooleanControllerBuilder.create(opt).formatValue(b -> b
            ? Component.literal("ON").withColor(Colors.GREEN_RGB)
            : Component.literal("OFF").withColor(Colors.RED_RGB));
    }
}
