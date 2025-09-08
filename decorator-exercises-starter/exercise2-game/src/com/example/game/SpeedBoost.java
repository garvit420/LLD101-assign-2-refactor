package com.example.game;

/**
 * Decorator that adds a speed boost to a character.
 * Increases the character's speed by the specified amount.
 */
public class SpeedBoost extends CharacterDecorator {
    private int speedIncrease;

    public SpeedBoost(Character character, int speedIncrease) {
        super(character);
        this.speedIncrease = speedIncrease;
    }

    @Override
    public void move() {
        System.out.println("Moving at speed " + getSpeed() + " with sprite " + getSprite() + " (Speed boosted!)");
    }

    @Override
    public int getSpeed() {
        return character.getSpeed() + speedIncrease;
    }
}
