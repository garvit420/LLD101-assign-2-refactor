package com.example.game;

/**
 * Starter demo using only the base character.
 * TODOs guide you to implement decorators and compose them.
 */
public class GameDemo {
    public static void main(String[] args) {
        Character base = new BaseCharacter();

        System.out.println("--- Base ---");
        base.move();
        base.attack();

        // === DECORATOR PATTERN IMPLEMENTATION ===
        
        // Scenario 1: Base + SpeedBoost + DamageBoost
        System.out.println("\n--- Base + SpeedBoost + DamageBoost ---");
        Character buffed = new DamageBoost(new SpeedBoost(base, 3), 15);
        System.out.println("Speed: " + buffed.getSpeed() + ", Damage: " + buffed.getDamage() + ", Sprite: " + buffed.getSprite());
        buffed.move();
        buffed.attack();
        
        // Scenario 2: Add GoldenAura (sprite change + buffs)
        System.out.println("\n--- Add GoldenAura ---");
        Character shiny = new GoldenAura(buffed);
        System.out.println("Speed: " + shiny.getSpeed() + ", Damage: " + shiny.getDamage() + ", Sprite: " + shiny.getSprite());
        shiny.move();
        shiny.attack();
        
        // Scenario 3: Remove GoldenAura by recomposing (rebuild chain without it)
        System.out.println("\n--- Remove GoldenAura (recomposition) ---");
        Character withoutAura = buffed; // removal by recomposition
        System.out.println("Speed: " + withoutAura.getSpeed() + ", Damage: " + withoutAura.getDamage() + ", Sprite: " + withoutAura.getSprite());
        withoutAura.move();
        withoutAura.attack();
        
        // Additional demonstration: Multiple stacking
        System.out.println("\n--- Multiple SpeedBoosts ---");
        Character fastCharacter = new SpeedBoost(new SpeedBoost(base, 5), 10);
        System.out.println("Speed: " + fastCharacter.getSpeed() + ", Damage: " + fastCharacter.getDamage() + ", Sprite: " + fastCharacter.getSprite());
        fastCharacter.move();
    }
}
