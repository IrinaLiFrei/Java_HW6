package Java_HW6;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Notebook nb1 = new Notebook("Windows", 32, 1.0, "silver", 785.65);
        Notebook nb2 = new Notebook("Windows", 64, 2.0, "red", 1020.80);
        Notebook nb3 = new Notebook("Windows", 16, 0.5, "black", 730.70);
        Notebook nb4 = new Notebook("Linux", 16, 1.0, "silver", 883.50);
        Notebook nb5 = new Notebook("Windows", 32, 0.5, "black", 900.08);
        Notebook nb6 = new Notebook("Linux", 64, 2.0, "black", 920.80);
        Notebook nb7 = new Notebook("Linux", 16, 1.0, "silver", 880.00);
        Notebook nb8 = new Notebook("Windows", 64, 1.0, "silver", 785.90);
        Notebook nb9 = new Notebook("MacOS", 16, 0.5, "white", 990.99);
        Notebook nb10 = new Notebook("MacOS", 64, 2.0, "white", 1350.00);
        Notebook nb11 = new Notebook("MacOS", 32, 1.0, "black", 1050.25);
        Notebook nb12 = new Notebook("MacOS", 16, 0.5, "silver", 636.80);


    Stream<Notebook> filter = Stream.of(nb1, nb2, nb3, nb4, nb5, nb6, nb7, nb8, nb9, nb10, nb11, nb12);

    Notebook.choiceMap.put(1, "");
    Notebook.choiceMap.put(2, 16);
    Notebook.choiceMap.put(3, 0.5);
    Notebook.choiceMap.put(4, "");
    Notebook.choiceMap.put(5, 2000.0);
    
    Notebook.makeChoice();
    Notebook.criteria();
    Notebook.showChoice(filter, Notebook.choiceMap);

    }
}
