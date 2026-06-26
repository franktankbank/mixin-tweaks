package org.franktankbank.fmt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jspecify.annotations.NonNull;

public record Color(int r, int g, int b) {
    public static final Color DEFAULT = new Color(-1, -1, -1);
    private static final Pattern HEX_PATTERN = Pattern.compile("#?([0-9a-fA-F]{6})");

    public static Color fromHex(@NonNull String hex) {
        Matcher hexMatcher = HEX_PATTERN.matcher(hex.trim());
        if (!hexMatcher.matches()) {
            return Color.DEFAULT;
        }

        int color = Integer.parseInt(hexMatcher.group(1), 16);

        return new Color((color >> 16) & 0xFF, (color >> 8) & 0xFF, color & 0xFF);
    }

    public int asInt() {
        int r = Math.min(this.r, 255);
        int g = Math.min(this.g, 255);
        int b = Math.min(this.b, 255);
        return (r << 16) | (g << 8) | b;
    }
}
