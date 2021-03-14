package com.company;

import com.company.controllers.PreciousController;
import com.company.enteties.Precious;
import com.company.enteties.TaskArray;
import com.company.repositories.interfaces.IPreciousRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class StonesFrontEnd
{
    private final PreciousController controller;
    private final Scanner scanner;

    public StonesFrontEnd(IPreciousRepository preciousRepository){
        controller = new PreciousController(preciousRepository);
        scanner = new Scanner(System.in);
    }


    public void start()
    {
        while (true)
        {
            System.out.println();
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Get all stones");
            System.out.println("2. Get stone by id");
            System.out.println("3. Add stone");
            System.out.println("4. Create necklace");
            System.out.println("0. Exit");
            System.out.println();

            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    getAllPreciousMenu();
                }else if(option == 2){
                    getPreciousByIdMenu();
                }else if(option == 3){
                    createPreciousMenu();
                }else if (option == 4){
                    createNecklaceMenu();
                }
                else {
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*********");

        }

    }

    public void getAllPreciousMenu() {
        String response = controller.getAllPrecious();
        System.out.println(response);
    }

    public void getPreciousByIdMenu() {
        System.out.println("Please enter id");

        int id = scanner.nextInt();
        Precious precious = controller.getPrecious(id);
        System.out.println((precious == null ? "Stone was not found!" : precious.toString()));
    }

    public void createPreciousMenu() {
        System.out.println("Please enter name");
        String name = scanner.next();
        System.out.println("Please enter weight");
        int weight = scanner.nextInt();
        System.out.println("Please enter cost");
        int cost = scanner.nextInt();
        System.out.println("Is it precious? (true/false)");
        boolean precious = scanner.nextBoolean();

        String response = controller.createPrecious(name, weight, cost, precious);
        System.out.println(response);
    }

    public void createNecklaceMenu() {
        TaskArray<Precious> taskArrays = new TaskArray<>();
        while (true){
            System.out.println();
            System.out.println("Welcome to necklace creation");
            System.out.println("Select option:");
            System.out.println("1. Add stone to the necklace");
            System.out.println("2. Go back");
            System.out.println("3. Start again");
            System.out.println("4. My necklace");
            System.out.println("0. Finish");
            System.out.println();

            try {
                System.out.print("Enter option (1-6): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    addStoneToNecklaceMenu(taskArrays);
                } else if (option == 2) {
                    taskArrays.array.remove(taskArrays.array.size()-1);
                    System.out.println("Successfully removed last stone!");
                } else if(option == 3){
                    taskArrays.array.clear();
                    System.out.println("Successfully removed necklace");
                } else if(option == 4){
                    myNecklace(taskArrays);
                }

                else {
                    System.out.println(controller.calculateNecklace(taskArrays.array));
                    myNecklace(taskArrays);
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                scanner.next(); // to ignore incorrect input
            }

            System.out.println("*********");
        }
    }

    public void addStoneToNecklaceMenu(TaskArray<Precious> taskArrays){
        getAllPreciousMenu();
        System.out.println("Choose id of stones from the list: ");

        int choice = scanner.nextInt();
        taskArrays.array.add(controller.getPrecious(choice));
    }

    public void myNecklace(TaskArray<Precious> taskArray){
        System.out.println("Your necklace consist of: ");
        for(int i = 0; i < taskArray.array.size(); i++){
            System.out.println(taskArray.array.get(i).getName() + ", ");
        }
    }
}