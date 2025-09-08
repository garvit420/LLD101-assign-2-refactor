package com.example.game;

/**
 * Decorator that adds a damage boost to a character.
 * Increases the character's damage by the specified amount.
 */
public class DamageBoost extends CharacterDecorator {
    private int damageIncrease;

    public DamageBoost(Character character, int damageIncrease) {
        super(character);
        this.damageIncrease = damageIncrease;
    }

    @Override
    public void attack() {
        System.out.println("Attacking with damage " + getDamage() + " using sprite " + getSprite() + " (Damage boosted!)");
    }

    @Override
    public int getDamage() {
        return character.getDamage() + damageIncrease;
    }
}
