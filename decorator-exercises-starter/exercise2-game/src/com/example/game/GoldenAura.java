package com.example.game;

/**
 * Decorator that gives a character a golden aura effect.
 * Changes the sprite and provides small buffs to both speed and damage.
 */
public class GoldenAura extends CharacterDecorator {
    private static final int SPEED_BUFF = 2;
    private static final int DAMAGE_BUFF = 5;
    private static final String AURA_SPRITE = "golden_aura.png";

    public GoldenAura(Character character) {
        super(character);
    }

    @Override
    public void move() {
        System.out.println("✨ Golden aura shimmers ✨");
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite() + " (Golden aura active!)");
    }

    @Override
    public void attack() {
        System.out.println("✨ Golden aura flares ✨");
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite() + " (Golden aura power!)");
    }

    @Override
    public int getSpeed() {
        return character.getSpeed() + SPEED_BUFF;
    }

    @Override
    public int getDamage() {
        return character.getDamage() + DAMAGE_BUFF;
    }

    @Override
    public String getSprite() {
        return AURA_SPRITE;
    }
}
