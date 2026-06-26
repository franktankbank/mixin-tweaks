package org.franktankbank.config;

import dev.isxander.yacl3.config.v2.api.SerialEntry;

public class Config {
    @SerialEntry
    public boolean DisableReverseThirdPerson = true;

    @SerialEntry
    public boolean DisableHeldItemTooltips = true;
}
