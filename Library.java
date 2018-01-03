public class Library {
 
  // Add the missing implementation to this class

  // Instance variables belong to the object of type Library. 
  String address;
  Book[] books = new Book[10000];
  int numberOfBooks = 0;
   
  public Library (String address) {
    this.address = address;
  }
 
  public void addBook (Book b) {
    books[numberOfBooks++] = b; 
    //numberOfBooks++;
  }
  
  public static void printOpeningHours () {
    System.out.println("Libraries are open daily from 9am to 5pm.");
  }
  
  public void printAddress () {
    System.out.println(address);
  }
  
  public void borrowBook(String title) {
    /*
    if (isBookInCatalog(title) == false) {
      System.out.println("Sorry, this book is not in our catalog.");
      return;
    } */
    for (int i = 0; i < numberOfBooks; i++) {
      if (title.equals(books[i].getTitle())) {
        found = true;
        
        if (books[i].isBorrowed()) {
          System.out.println("Sorry, this book is already borrowed.");
        } else {
          System.out.println("You succesfuly borrowed " + title);
          books[i].rented();
        }
        return;
      }
    }
    System.out.println("Sorry, this book is not in our catalog.");
  }
  
  /**
   * check if a book with given title is in the library catalog.
   * 
   * @param title the book title. 
   * @return true if there is a book with the given title, false otherwise.
   * 
   */
  public boolean isBookInCatalog(String title) {
    boolean found = false;
    for (int i = 0; i < numberOfBooks; i++) {
      if (books[i].getTitle().equals(title)) {
        found = true;
        break;
      } 
    }
    
    // if found is true, the book is in the catalog
    return found;
  }
  
  public void returnBook(String title) {
    for (int i = 0; i < numberOfBooks; i++) {
      if (books[i].getTitle().equals(title)) {
           books[i].returned();
      }
    }
  }
  
  public void printAvailableBooks() {
    // print out the books that are not checked-out
    for (int i=0; i< numberOfBooks; i++) {
      if (books[i].isBorrowed() == false) {
        System.out.println(books[i].getTitle());
      }
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

 
    // Try to borrow The Lords of the Rings from both libraries
    System.out.println("Borrowing A Tale of Two Cities:");
    firstLibrary.borrowBook("A Tale of Two Cities");
    firstLibrary.borrowBook("A Tale of Two Cities");
  
    firstLibrary.borrowBook("The Da Vinci Code");
    firstLibrary.borrowBook("Le Petit Prince");
  
    firstLibrary.borrowBook("The Da Vinci Code");
    firstLibrary.borrowBook("Prince");
  
    secondLibrary.borrowBook("A Tale of Two Cities");
    System.out.println();

    // Print the titles of all available books from both libraries
    System.out.println("Books available in the first library:");
    firstLibrary.printAvailableBooks();
    System.out.println();
    System.out.println("Books available in the second library:");
    secondLibrary.printAvailableBooks();
    System.out.println();
 
    // Return The Lords of the Rings to the first library
    System.out.println("Returning The Da Vinci Code:");
    firstLibrary.returnBook("The Da Vinci Code");
    System.out.println();
    // Print the titles of available from the first library
    System.out.println("Books available in the first library:");
    firstLibrary.printAvailableBooks();
  }
}