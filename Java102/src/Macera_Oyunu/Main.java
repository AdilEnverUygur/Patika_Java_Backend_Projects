package Macera_Oyunu;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Macera_Oyunu.Player");

        Region cave = new Region("Cave", "Food");
        Region forest = new Region("Forest", "Firewood");
        Region river = new Region("River", "Water");
        Region mine = new Region("Mine", "Gems");

        Region[] regions = {cave, forest, river, mine};

        int randomRegionIndex = new Random().nextInt(regions.length);
        Region currentRegion = regions[randomRegionIndex];

        System.out.println("You are in the " + currentRegion.name + " region.");
        System.out.println("You received " + currentRegion.reward + " as a reward.");

        if (currentRegion == mine) {
            Enemy snake = new Enemy("Snake", 12);
            System.out.println("A wild " + snake.name + " appeared!");

            boolean playerFirst = new Random().nextBoolean();
            if (playerFirst) {
                System.out.println("Macera_Oyunu.Player attacks first.");
                player.attack(snake);
            } else {
                System.out.println("Macera_Oyunu.Enemy attacks first.");
                snake.attack(player);
            }

            if (player.health > 0 && snake.health > 0) {
                while (player.health > 0 && snake.health > 0) {
                    player.attack(snake);
                    if (snake.health <= 0) {
                        System.out.println("You defeated the " + snake.name + ".");
                        break;
                    }
                    snake.attack(player);
                }
            }

            if (player.health <= 0) {
                System.out.println("You were defeated by the " + snake.name + ".");
            }

            // Handle item drops
            double dropChance = Math.random();

            if (dropChance < 0.15) {
                System.out.println("You found a Rifle!");
            } else if (dropChance < 0.35) {
                System.out.println("You found a Sword!");
            } else if (dropChance < 0.85) {
                System.out.println("You found a Shield!");
            } else if (dropChance < 0.9) {
                System.out.println("You found 10 Gold!");
            } else if (dropChance < 0.95) {
                System.out.println("You found 5 Gold!");
            } else if (dropChance < 1.0) {
                System.out.println("You found 1 Gold!");
            } else {
                System.out.println("You didn't find anything.");
            }
        }
    }
}
