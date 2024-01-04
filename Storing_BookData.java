import java.time.LocalDate;
import java.util.*;
public class Exercise150_Storing_BookData {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> bookList = new ArrayList<>();
        System.out.println("Do you want to (continue to) add a new book? ('Yes'/'No')");
        String goOn = scan.next();
        while (goOn.equals("Yes")) {
            bookList.add(getBookData());
            System.out.println("Do you want to (continue to) add a new book? ('Yes'/'No')");
            goOn = scan.next();
        }
        for (String bookListItem: bookList) {
            System.out.println(" - " + bookListItem);
        }
    }

//Making a long String-variable ('bookData'), comprising the Title + Author + Genre + Publication date + Quantity of the specific book:
    public static String getBookData() {
        enum Genre {
            FICTION, NON_FICTION, MISTERY, NOVEL, DRAMA, SHORT_STORY, PROSE, AUTOBIOGRAPHY, POETRY
        };

        Scanner scan = new Scanner(System.in);
        System.out.println("What's the title of the book?");
        String title = scan.nextLine();
        System.out.println("Who's the author of the book?");
        String author = scan.nextLine();
        System.out.println("What are the genres of the book?");
        String genre = scan.nextLine().toUpperCase();
//        Genre genreOfTheBook = Genre.genre;
        System.out.println("How many copies do we have?");
        int quantity = scan.nextInt();
        System.out.println("When was the book published? ('yyyy/mm/dd' for day/month/year)");
        String[] publicationDate_StringArray = scan.next().split("/");
        LocalDate publicationDate = LocalDate.of(Integer.parseInt(publicationDate_StringArray[0]), Integer.parseInt(publicationDate_StringArray[1]), Integer.parseInt(publicationDate_StringArray[2]));

        String bookData = title + "-" + author + "-" + genre + "-" + publicationDate.getYear() + "-" + quantity;
        return bookData;
    }
}
