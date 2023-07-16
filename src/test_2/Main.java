package test_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int choiceMaterial;
        ManagerMaterial managerMaterial = new ManagerMaterial();
        managerMaterial.crateMaterial();


        do {
            System.out.println("Menu: ");
            System.out.println("1. Display material: ");
            System.out.println("2. Add material: ");
            System.out.println("3. Update material: ");
            System.out.println("4. Delete material: ");
            System.out.println("0. Exit: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("1. Display material: ");
                    managerMaterial.displayMaterial();
                    break;
                case 2:
                    System.out.println("2. Add material: ");
                    do {
                        System.out.println("2.1. Enter 1 to add crispy flour: ");
                        System.out.println("2.2. Enter 2 to add meat: ");
                        System.out.println("0. Exit.");
                        choiceMaterial = Integer.parseInt(scanner.nextLine());
                        switch (choiceMaterial) {
                            case 1:
                                managerMaterial.addCrispFlour();
                                break;
                            case 2:
                                managerMaterial.addMeat();
                                break;
                        }
                    } while (choiceMaterial != 0);
                case 3:
                    managerMaterial.displayMaterial();
                    System.out.println("Enter id to update: ");
                    managerMaterial.updateMaterial();break;
                case 4:
                    managerMaterial.displayMaterial();
                    System.out.println("Enter id to delete: ");
                    managerMaterial.deleteMaterial();break;
            }
        } while (choice != 0);

       for(Material element: managerMaterial.getMaterial()){
           if (element instanceof CrispyFlour){
               System.out.println("Amount crispyFlour no discount yet: " + element.getAmount());
               System.out.println("Amount crispyFlour discounted: " + ((CrispyFlour) element).getRealMoney());
           }
           else {
               if (element instanceof Meat){
                   System.out.println("Amount meat no discount yet: " + element.getAmount());
                   System.out.println("Amount meat discounted: " + ((Meat) element).getRealMoney());
               }
           }
           System.out.println();
       }

    }
}
