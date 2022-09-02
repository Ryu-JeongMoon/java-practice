package org.designpattern.structure.flyweight._02_after;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {

    private static final Map<String, Font> CACHE = new HashMap<>();

    public Font getFont(String font) {
        if (CACHE.containsKey(font)) {
            return CACHE.get(font);
        } else {
            String[] split = font.split(":");
            Font newFont = new Font(split[0], Integer.parseInt(split[1]));
            CACHE.put(font, newFont);
            return newFont;
        }
    }
}
