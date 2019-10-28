package ui;
import model.Reciclamos;
import java.util.Scanner;
public class Main {
    private Reciclamos reciclamos;
    private Scanner input;
    private Scanner input2;
    
    public static void main(String[] args) {
        Main obj = new Main();
        boolean x = true;
        while(x) {
            System.out.println("Menu \n1. Create a waste \n2. Generate a report of the registered wastes \n3. Create a product");
            System.out.println("4. Get the information of a waste given the name or the product id \n5. Display a list of the registered products");
            System.out.println("6. Calculate the harm effect of a waste \n7. Determine if a biodegradable or recyclable waste is usable");
            System.out.println("8. Display a list of the wastes sorted by harmful effect");
            int option = obj.input.nextInt();
            switch(option) {
                case 1:
                    obj.reciclamos = new Reciclamos();
                    obj.createWaste();
                    break;
            }
        }
    }

    public Main() {
        input = new Scanner(System.in);
        input2 = new Scanner(System.in);
    }

    public void createWaste() {
        boolean x = true;
        while(x) {
            System.out.println("What type of waste want to create? \n1. Biodegradable \n2. Inert \n3. Recyclable \n4. Stop creating");
            int option = input.nextInt();
            switch(option) {
                case 1:
                    System.out.println("Write the waste id");
                    String id = input2.nextLine();
                    System.out.println("Write the waste name");
                    String name = input2.nextLine();
                    System.out.println("Write the waste source");
                    String source = input2.nextLine();
                    System.out.println("Write the waste color");
                    String color = input2.nextLine();
                    System.out.println("Write the waste decomposition time");
                    int decompositionTime = input.nextInt();
                    System.out.println("Write if the waste is suitable for composting");
                    boolean composting = input.nextBoolean();
                    System.out.println(composting);
                    reciclamos.addWaste(id, name, source, color, decompositionTime, composting);
                    break;
                case 2:
                    System.out.println("Write the waste id");
                    id = input2.nextLine();
                    System.out.println("Write the waste name");
                    name = input2.nextLine();
                    System.out.println("Write the waste source");
                    source = input2.nextLine();
                    System.out.println("Write the waste color");
                    color = input2.nextLine();
                    System.out.println("Write the waste decomposition time");
                    decompositionTime = input.nextInt();
                    System.out.println("Write an advice of how to reduce the use of this waste");
                    String advice = input2.nextLine();
                    reciclamos.addWaste(id, name, source, color, decompositionTime, advice);
                    break;
                case 3:
                    System.out.println("Write the waste id");
                    id = input2.nextLine();
                    System.out.println("Write the waste name");
                    name = input2.nextLine();
                    System.out.println("Write the waste source");
                    source = input2.nextLine();
                    System.out.println("Write the waste color");
                    color = input2.nextLine();
                    System.out.println("Write the waste decomposition time");
                    decompositionTime = input.nextInt();
                    System.out.println("Write the type of this recyclable waste");
                    String type = input2.nextLine();
                    System.out.println("Write the description of how to dispose this waste");
                    String description = input2.nextLine();
                    reciclamos.addWaste(id, name, source, color, decompositionTime, type, description);
                    break;
                case 4:
                    x = false;
                    break;
                default:
                    System.out.println("ERROR! Write a valid option");
                    break;
            }
        }
    }
}