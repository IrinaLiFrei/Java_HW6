package Java_HW6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

public class Notebook {
    String operSystem;
    Integer RAM;
    Double HDCapacity;
    String colour;
    Double price;
    public static HashMap<Integer, Object> choiceMap = new HashMap<>();

    public static int choiceNum = 0;
    public static List<Notebook> nbList = new ArrayList<>();
    public static Stream<Notebook> filter;
    

    public Notebook(String operSystem, Integer RAM, Double HDCapacity, String colour, Double price){
        this.operSystem = operSystem.toLowerCase();
        this.RAM = RAM;
        this.HDCapacity = HDCapacity;
        this.colour = colour.toLowerCase();
        this.price = price;
    }


    public static void makeChoice(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number matching the required criteria: \n1 - Operating System \n2 - RAM\n3 - Hard Disc Capacity\n4 - Colour\n5 - Price");
    if(sc.hasNextInt()){
        choiceNum = sc.nextInt();
        criteria();
        if(choiceNum > 5){
            System.out.println("######### You should enter a number from 1 to 5.");
            makeChoice();
        }
        if(choiceNum == 0){
            return;
        }
    }else{
        System.out.println("######### You should enter a number from 1 to 5. Try again.");
        makeChoice();
    }
}

public static void criteria(){

    if(choiceNum == 1){
        Scanner sc1 = new Scanner(System.in);    
        System.out.println("Enter the name of OPERATING SYSTEM. Enter '000' for exit. : ");
        String osName = sc1.nextLine().toLowerCase();
        choiceMap.put(1, osName);
        makeChoice();
    }
    if(choiceNum == 2){   
        Scanner sc2 = new Scanner(System.in);    
        System.out.println("Enter the minimum AMOUNT of RAM (16, 32 or 64). Enter '000' for exit. : ");
        Integer ram = sc2.nextInt();
        choiceMap.put(2, ram);
        makeChoice();
    }
    if(choiceNum == 3){
        Scanner sc3 = new Scanner(System.in).useLocale(Locale.US);    
        System.out.println("Enter the minimum HARD DRIVE SIZE (0.5, 1 or 2 TB). Enter '000' for exit. : ");
        Double hds = sc3.nextDouble();
        choiceMap.put(3, hds);
        makeChoice();
    }
    if(choiceNum == 4){
        Scanner sc4 = new Scanner(System.in);    
        System.out.println("Enter the COLOUR. Enter '000' for exit. :");
        String colo = sc4.nextLine().toLowerCase();
        choiceMap.put(4, colo);
        makeChoice();
    }
    if(choiceNum == 5){
        Scanner sc5 = new Scanner(System.in);    
        System.out.println("Enter the maximum PRICE. Enter '000' for exit. : ");
        Double price = sc5.nextDouble();
        choiceMap.put(5, price);
        makeChoice();
    }
}

public static void showChoice(Stream<Notebook> filt, HashMap<Integer, Object> choiceMap) {

    if(choiceMap.get(1).equals("") && choiceMap.get(4).equals("")){
        filt    .filter(nb -> nb.RAM >= (int) choiceMap.getOrDefault(2, 0))
                .filter(nb -> nb.HDCapacity >= (double) choiceMap.getOrDefault(3, 0.0))
                .filter(nb -> nb.price <= (double) choiceMap.getOrDefault(5, 0.0))
                .forEach(nb -> System.out.println(nb));
    }
    if (choiceMap.get(1).equals("") && !choiceMap.get(4).equals("")){
        filt .filter(nb -> nb.RAM >= (int) choiceMap.getOrDefault(2, 0))
            .filter(nb -> nb.HDCapacity >= (double) choiceMap.getOrDefault(3, 0.0))
            .filter(nb -> nb.colour.equalsIgnoreCase((String) choiceMap.getOrDefault(4, "")))
            .filter(nb -> nb.price <= (double) choiceMap.getOrDefault(5, 0.0))
            .forEach(nb -> System.out.println(nb));
    }
    if(choiceMap.get(4).equals("") && !choiceMap.get(1).equals("")){
        filt    .filter(nb -> nb.operSystem.equalsIgnoreCase((String) choiceMap.getOrDefault(1, "")))
            .filter(nb -> nb.RAM >= (int) choiceMap.getOrDefault(2, 0))
            .filter(nb -> nb.HDCapacity >= (double) choiceMap.getOrDefault(3, 0.0))
            .filter(nb -> nb.price <= (double) choiceMap.getOrDefault(5, 0.0))
            .forEach(nb -> System.out.println(nb));
    } else{
        filt    .filter(nb -> nb.operSystem.equalsIgnoreCase((String) choiceMap.getOrDefault(1, "")))
            .filter(nb -> nb.RAM >= (int) choiceMap.getOrDefault(2, 0))
            .filter(nb -> nb.HDCapacity >= (double) choiceMap.getOrDefault(3, 0.0))
            .filter(nb -> nb.colour.equalsIgnoreCase((String) choiceMap.getOrDefault(4, "")))
            .filter(nb -> nb.price <= (double) choiceMap.getOrDefault(5, 0.0))
            .forEach(nb -> System.out.println(nb));
    }             
}

@Override
public String toString(){
    return "Notebook " + operSystem.toUpperCase() + " " + RAM + "GB, " + HDCapacity + " Tb, " + "colour: "  + colour + ", price: $ " + price;
}

}