package test_2;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMaterial {
    private String id;
    private String name;
    private LocalDate dateOfManufacture;
    private int cost;
    private final ArrayList<Material> materials;
    private final Scanner scanner;
    public ManagerMaterial() {
        materials = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void crateMaterial(){
        materials.add(new CrispyFlour("BCG2022","BCG VN", LocalDate.of(2023, 7 , 10), 40000, 20));
        materials.add(new CrispyFlour("BCG2021","BCG CN", LocalDate.of(2022, 12, 10), 60000, 12));
        materials.add(new CrispyFlour("BCG2023","BCG EU", LocalDate.of(2022,8,10), 45000, 2));
        materials.add(new CrispyFlour("BCG2023","BCG VN", LocalDate.of(2022, 4, 10), 35000, 10));
        materials.add(new CrispyFlour("BCG2023","BCG VN", LocalDate.of(2022, 10,10), 63500, 15));
        materials.add(new Meat("Pork","made in Viet Nam", LocalDate.now(), 150000, 2));
        materials.add(new Meat("Pork","made in China", LocalDate.of(2023, 7, 14), 180000, 1));
        materials.add(new Meat("Beef","made in China", LocalDate.of(2023, 8, 8), 350000, 3));
        materials.add(new Meat("Beef","made in Japan", LocalDate.of(2023, 7, 15), 350000, 0.5));
        materials.add(new Meat("Chicken","made in Japan", LocalDate.of(2023,6,5), 150000, 5));
    }
    public ArrayList<Material> getMaterial(){
        return materials;
    }

    private boolean checkEmpty() {
        return materials.size() != 0;
    }
    public int getSize(){
        return materials.size();
    }

    public void displayMaterial(){
        if (checkEmpty()){
            System.out.println("Material list: ");
            for(Material material : materials){
                System.out.println(material);
            }
        }
        else System.out.println("No materials in the store!!!");
    }


    private void addMaterial(){
        System.out.println("Enter id: ");
        id = scanner.nextLine();
        System.out.println("Enter name material: ");
        name = scanner.nextLine();
        System.out.println("Enter date of manufacture: ");
        dateOfManufacture = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter cost: ");
        cost = Integer.parseInt(scanner.nextLine());
    }

    public void addCrispFlour(){
        int quantity;
        addMaterial();
        System.out.println("Enter quantity crispy flour: ");
        quantity = Integer.parseInt(scanner.nextLine());
        Material material = new CrispyFlour(id,name,dateOfManufacture,cost,quantity);
        materials.add(material);
    }
    public void addMeat(){
        int weight;
        addMaterial();
        System.out.println("Enter weight meat: ");
        weight = Integer.parseInt(scanner.nextLine());
        Material material = new CrispyFlour(id,name,dateOfManufacture,cost,weight);
        materials.add(material);
    }

    public void updateMaterial(){
        int quantity;
        int weight;
        id = scanner.nextLine();
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(id)){
                System.out.println("Enter name: ");
                name = scanner.nextLine();
                materials.get(i).setName(name);
                System.out.println("Enter date of manufacture: ");
                dateOfManufacture = LocalDate.parse(scanner.nextLine());
                materials.get(i).setManufacturingDate(dateOfManufacture);
                System.out.println("Enter cost: ");
                cost = Integer.parseInt(scanner.nextLine());
                materials.get(i).setCost(cost);
                if (materials.get(i) instanceof CrispyFlour){
                    System.out.println("Enter quantity: ");
                    quantity = Integer.parseInt(scanner.nextLine());
                    ((CrispyFlour) materials.get(i)).setQuantity(quantity);
                }
                if (materials.get(i) instanceof Meat){
                    System.out.println("Enter weight: ");
                    weight = Integer.parseInt(scanner.nextLine());
                    ((Meat) materials.get(i)).setWeight(weight);
                }
            }
        }

    }


    public void deleteMaterial(){
        id = scanner.nextLine();
        for (int i = 0; i < materials.size(); i++){
            if (materials.get(i).getId().equals(id)){
                materials.remove(materials.get(i));
                break;
            }
        }
    }



}
