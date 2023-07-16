package test_1;


public class Main {
    public static void main(String[] args) {
        Book[] books = new Book[10];
        books[0] = new ProgrammingBook(1, "Clean Coder", 11000, "Robert C.Martin", "English", "Spring MVCSpring MVC");
        books[1] = new ProgrammingBook(2, "Introduction to Algorithms", 150000, "Robert C.Martin", "English", "Struts");
        books[2] = new ProgrammingBook(3, "Code Complete", 21500, "DreamTech", "English", "Hibernate");
        books[3] = new ProgrammingBook(4, "The Pragmatic Programmer", 505000, "David Thomas", "English", "Hibernate");
        books[4] = new ProgrammingBook(5, "Design Patterns", 11000, "Grady Booch", "English", "Spring MVCSpring MVC");
        books[5] = new FictionBook(6, "Ubik", 164024, "Philip K. Dick", "Fiction 1");
        books[6] = new FictionBook(7, "Dune", 245024, "Frank Herbert", "Fiction 5");
        books[7] = new FictionBook(8, "Labyrinths", 1064024, "Jorge Luis Borges", "Fiction 1");
        books[8] = new FictionBook(9, "1984", 14024, "George Orwell", "Fiction 2");
        books[9] = new FictionBook(10, "Neuromancer", 16024, " William Gibson", "Fiction 1");

        double total = 0;
        for(Book book: books){
            total  += book.getPrice();
        }
        System.out.println("Total price: " + total);

        int countCategory = 0;
        for(Book book: books){
            if (book instanceof FictionBook){
                if (((FictionBook) book).getCategory().equals("Fiction 1")){
                    countCategory++;
                }
            }
        }
        System.out.println("Number of books available category fiction 1 is: " + countCategory);

        int countPrice = 0;
        for(Book book: books){
            if (book.getPrice()<90000){
                countPrice++;
            }
        }
        System.out.println("Number of books available price less 90000 is: " + countPrice);


    }
}
