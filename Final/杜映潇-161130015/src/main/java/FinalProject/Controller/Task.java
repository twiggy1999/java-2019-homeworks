package FinalProject.Controller;

import FinalProject.Creatures.Creature;
import FinalProject.WorldMap.World;


public class Task implements Runnable {
    Creature creature;
    World world;
    CharacterController controller;

    public Task(Creature creature, World world) {
        this.creature = creature;
        this.world = world;
        controller = CreatureController.getInstance(world);
    }

    @Override
    public void run() {
        controller.step(creature);
    }

    public Creature getCreature() {
        return creature;
    }
}
