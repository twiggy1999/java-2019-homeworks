package FinalProject.Utils;

import java.lang.reflect.Constructor;

public class CreatureFactory implements Factory {
    /* Factory for class Creature and all its subclasses */
    public <T> T generate(String input) {
        /* For CalabashBrother, the input string has the from of: FinalProject.Creatures.CalabashBrother#3
         *  For others, the input string has the form of: FinalProject.Creatures.Goblin
         * */
        T obj = null;
        try {
            String className;
            String argument;
            if (input.split("#")[0].compareTo("FinalProject.Creatures.CalabashBrother") == 0) {
                className = input.split("#")[0];
                argument = input.split("#")[1];
            } else {
                className = input;
                argument = null;
            }
            Class<T> objClass = (Class<T>) Class.forName(className);

            Constructor<T> constructor;
            if (argument != null) {
                constructor = objClass.getDeclaredConstructor(String.class);
            } else {
                constructor = objClass.getDeclaredConstructor();
            }
            constructor.setAccessible(true);
            if (argument != null) {
                obj = constructor.newInstance(argument);
            } else {
                obj = constructor.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
