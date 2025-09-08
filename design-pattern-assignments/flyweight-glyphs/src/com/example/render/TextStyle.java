package com.example.render;

public class TextStyle {
    private final String font;
    private final int size;
    private final boolean bold;

    public TextStyle(String font, int size, boolean bold) {
        this.font = font;
        this.size = size;
        this.bold = bold;
    }

    public String getFont() {
        return font;
    }

    public int getSize() {
        return size;
    }

    public boolean isBold() {
        return bold;
    }

    public int getDrawCost() {
        return size + (bold ? 10 : 0);
    }

    // Generate cache key for the factory
    public String getCacheKey() {
        return font + "|" + size + "|" + (bold ? "B" : "");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TextStyle textStyle = (TextStyle) obj;
        return size == textStyle.size &&
               bold == textStyle.bold &&
               font.equals(textStyle.font);
    }

    @Override
    public int hashCode() {
        int result = font.hashCode();
        result = 31 * result + size;
        result = 31 * result + (bold ? 1 : 0);
        return result;
    }
}
