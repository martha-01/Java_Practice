import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
public class Storing_BookData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> bookList = new ArrayList<>();

//*************      ASKING FOR THE FIRST 3 BOOKS:      *************

        for (int i = 0; i < 3; i++) {
            System.out.println("Book " + (i+1) + ": ");
            System.out.println("Please, provide the data about your book. Answer the following questions:");
            bookList.add(getBookData());
            System.out.println("-------------------------------------------------------------------------------");
        }
        System.out.println("-------------------------------------------------------------------------------");

//*************      ASKING FOR MORE BOOKS:      *************

        System.out.println("Do you want to (continue to) add a new book? ('Yes'/'No')");
        String goOn = scan.next().toLowerCase();
        boolean toBeContinued = true;
        if (goOn.toLowerCase().equals("no"))
            toBeContinued = false;
        while (toBeContinued) {
            bookList.add(getBookData());
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println("Do you want to (continue to) add a new book? ('Yes'/'No')");
            goOn = scan.next().toLowerCase();
            if (goOn.toLowerCase().equals("no"))
                toBeContinued = false;
        }

//*************      DISPLAYING BOOK-LIST:      *************

        displayBookList(bookList);

//*************      FINDING A BOOK, ACCORDING TO BOOK-TITLE:      *************

        System.out.println("What is the title of the book you are looking for?");
        String wantedBook = scan.nextLine();
        findBook(bookList, wantedBook);

//*************      UPDATING BOOK-LIST:      *************

        System.out.println("What is the title of the book you want to add?");
        String newTitle = scan.nextLine();
        System.out.println("How many copies do you want to add?");
        int numberOfNewCopies = scan.nextInt();
        updateBookList(bookList, newTitle, numberOfNewCopies);
        displayBookList(bookList);

//*************      WRITING TO FILE:      *************

        writeToFile(bookList);
    }

//Making a long String-variable ('bookData'), comprising the Title + Author + Genre + Publication date + Quantity of the specific book:
    public static String getBookData() {
        enum Genre {
            FICTION, NON_FICTION, MISTERY, NOVEL, DRAMA, PROSE, AUTOBIOGRAPHY, POETRY, TALE
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("What's the title of the book?");
        String title = scan.nextLine();
        System.out.println("Who's the author of the book?");
        String author = scan.nextLine();
        System.out.println("What is the genre of the book?");
        String genreAsString = scan.nextLine().toUpperCase();
        Genre genre = null;
        try {
            genre = Genre.valueOf(genreAsString);
        } catch (Exception e) {
            System.out.println("Sorry! The genre you provided does not exist in out list.");
        }
        System.out.println("How many copies do we have?");
        int quantity = scan.nextInt();
        System.out.println("When was the book published? ('yyyy-mm-dd' for year-month-day)");
        String publicationDate_String = scan.next();
        LocalDate publicationDate = null;
        try {
            publicationDate = LocalDate.parse(publicationDate_String);
        } catch (Exception e) {
            System.out.println("Sorry! The date format is not correct.");
        }
        String bookData = title + "-" + author + "-" + genre + "-" + publicationDate.getYear() + "-" + quantity;
        return bookData;
    }
    public static void displayBookList(List<String> listOfBooks) {
        System.out.println("\nHere's the list of books: ");
        for (String bookitem : listOfBooks) {
            System.out.println(" - " + bookitem);
        }
    }
    public static void findBook(List<String> listOfBooks, String bookTitle) {
        String foundBook = "";
        for ( int i = 0; i < listOfBooks.size(); i=i+1) {
            if (listOfBooks.get(i).contains(bookTitle)) {
//    OR:   if (listOfBooks.startsWith(bookTitle)) {
                foundBook = listOfBooks.get(i);
            }
        }
        if (!foundBook.isEmpty()) {
            System.out.println(foundBook);
        } else {
            System.out.println("Sorry! The book you are looking for was not found.");
        }
    }
    public static void updateBookList(List<String> listOfBooks, String title, int quantity) {
        for (String bookItem: listOfBooks) {
            if (bookItem.startsWith(title)) {
                String[] itemData = bookItem.split("-");
                bookItem = itemData[0] + "-" + itemData[1] + "-" + itemData[2] + "-" + itemData[3] + "-" + (itemData[4] + quantity);
            }
        }
    }

    public static void writeToFile(List<String> listOfItems) {
        try {
            for (String item : listOfItems) {
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/Resources/books.txt", true));
                bw.append(item + System.lineSeparator());
                bw.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
