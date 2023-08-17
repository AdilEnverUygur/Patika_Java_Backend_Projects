package Macera_Oyunu;

import java.util.Random;

public class Enemy {
    String name;
    int health;

    Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    void attack(Player player) {
        int damage = new Random().nextInt(10) + 1;
        System.out.println(name + " attacks " + player.name + " for " + damage + " damage.");
        player.health -= damage;
    }
}
