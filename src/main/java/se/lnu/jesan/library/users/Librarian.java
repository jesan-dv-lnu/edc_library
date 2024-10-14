package se.lnu.jesan.library.users;

public class Librarian extends User {

    public Librarian(String name, String userId) {
        super(name, userId);
    }

    public void addBook(String bookTitle) {
        System.out.println(super.getName() + " added the book: " + bookTitle);
    }

    public void managePatron(Patron patron) {
        System.out.println(super.getName() + " is managing patron: " + patron.getName());
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Role: Librarian");
    }
}
