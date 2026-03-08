import java.util.ArrayList;
import java.util.List;

public class Library {

    String address;
    private List<Book> books;

    public Library(String address) {
        this.address = address;
        this.books = new ArrayList<>();
    }

    // 静态方法：打印图书馆开放时间（所有图书馆通用）
    public static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    // 实例方法：打印当前图书馆的地址
    public void printAddress() {
        System.out.println(this.address);
    }

    // 向图书馆添加书籍
    public void addBook(Book book) {
        books.add(book);
    }

    // 借阅指定书名的书籍
    public void borrowBook(String bookTitle) {
        for (Book specific_book : books) {
            if (specific_book.getTitle().equals(bookTitle) && !specific_book.isBorrowed()) {
                specific_book.rented();
                System.out.println("You successfully borrowed " + bookTitle);
                return;
            }
        }
        System.out.println("Sorry, " + bookTitle + " is not available to borrow.");
    }

    // 归还指定书名的书籍
    public void returnBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle) && book.isBorrowed()) {
                book.returned();
                System.out.println("You successfully returned " + bookTitle);
                return;
            }
        }
        // 未找到该书籍 或 书籍未被借出
        System.out.println("Sorry, " + bookTitle + " is not a book from this library or was not borrowed.");
    }

    // 打印当前图书馆所有可借阅的书籍
    public void printAvailableBooks() {
        if (books.isEmpty()) {
            System.out.println("No book in catalog");
            return;
        }

        boolean hasAvailableBooks = false;
        for (Book book : books) {
            if (!book.isBorrowed()) {
                System.out.println(book.getTitle());
                hasAvailableBooks = true;
            }
        }

        if (!hasAvailableBooks) {
            System.out.println("No book in catalog");
        }
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lord of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lord of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}