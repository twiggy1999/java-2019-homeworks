package FinalProject.Controller;

import FinalProject.Creatures.Creature;

public interface CharacterController {
    boolean step(Creature creature); /* Make a single step move, return true if success, false if fail */
}
