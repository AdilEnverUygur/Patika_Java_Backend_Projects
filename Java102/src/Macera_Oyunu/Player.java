package Macera_Oyunu;

import java.util.Random;

public class Player {
    String name;
    int health;

    Player(String name) {
        this.name = name;
        this.health = 100;
    }

    void attack(Enemy enemy) {
        int damage = new Random().nextInt(10) + 1;
        System.out.println(name + " attacks " + enemy.name + " for " + damage + " damage.");
        enemy.health -= damage;
    }
}
