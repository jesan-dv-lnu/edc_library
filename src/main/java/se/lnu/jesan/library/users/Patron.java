package se.lnu.jesan.library.users;

public class Patron extends User {
    private int borrowedBooksCount;

    public Patron(String name, String userId) {
        super(name, userId);
        this.borrowedBooksCount = 0;
    }

    public int getBorrowedBooksCount() {
        return borrowedBooksCount;
    }

    public void borrowBook() {
        borrowedBooksCount++;
        System.out.println(super.getName() + " borrowed a book. Total books borrowed: " + borrowedBooksCount);
    }

    public void returnBook() {
        if (borrowedBooksCount > 0) {
            borrowedBooksCount--;
            System.out.println(super.getName() + " returned a book. Total books borrowed: " + borrowedBooksCount);
        } else {
            System.out.println("No books to return.");
        }
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Borrowed Books: " + borrowedBooksCount);
    }
}