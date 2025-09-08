package com.example.render;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {
    private static final Map<String, TextStyle> cache = new HashMap<>();

    public static TextStyle getTextStyle(String font, int size, boolean bold) {
        String key = font + "|" + size + "|" + (bold ? "B" : "");
        
        // Check if the style is already cached
        TextStyle style = cache.get(key);
        if (style == null) {
            // Create new style and cache it
            style = new TextStyle(font, size, bold);
            cache.put(key, style);
        }
        
        return style;
    }

    // For testing purposes - to verify caching works
    public static int getCacheSize() {
        return cache.size();
    }

    // For testing purposes - to clear cache if needed
    public static void clearCache() {
        cache.clear();
    }
}
