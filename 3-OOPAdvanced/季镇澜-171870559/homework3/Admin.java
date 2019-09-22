package homework3;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Scanner;

import static java.lang.System.out;

public class Admin {
    public static void main(String args[]) throws IOException, InterruptedException {
        Checkerboard theboard = new Checkerboard();
        while (true) {
            Elder theElder = new Elder(theboard);
            Snake theSnake = new Snake(theboard);
            theElder.arrange();
            theSnake.arrange();
            theboard.print();
            System.out.print("输入[Y/n]继续……");
            char input=(char)System.in.read();
            if (input == 'n')
                break;
            else {
                theboard.clear();
            }
        }
    }
}

