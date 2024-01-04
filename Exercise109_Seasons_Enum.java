import java.util.Scanner;

public class Exercise109_Seasons_Enum {
    /*
    Készítsetek programot, mely a beírt, magyar nyelvű hónapról eldönti, hogy az melyik évszakban van.
    Készítsétek el a Month enumot, melyben a hónapok magyar nyelvű megfelelői vannak.
    A program vizsgálja meg switch-case segítségével a konzolról beírt értéket és
    írja ki, hogy az tavasz, nyár, ősz vagy téli évszakba tartozik.
    */

    enum Month {
        JANUÁR, FEBRUÁR, MÁRCIUS, ÁPRILIS, MÁJUS, JÚNIUS, JÚLIUS, AUGUSZTUS, SZEPTEMBER, OKTÓBER, NOVEMBER, DECEMBER
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose a month!");
        String monthInput = sc.next().toUpperCase();
        Month month = Month.valueOf(monthInput);
        int monthIntInput = 0;
        for (int i = 0; i < Month.values().length; i++) {
            if (month == Month.values()[i]) {
                monthIntInput = i;
            }
        }
        String message = Month.values()[monthIntInput] + " van.";

        switch (monthIntInput) {
            case 2, 3, 4:
                message += " Itt a tavasz lehellete.";
                break;
            case 5, 6, 7:
                message += " Nyár van, nyár!";
                break;
            case 8, 9, 10:
                message += " Itt van az ősz, itt van újra.";
                break;
            case 11, 0, 1:
                message += " Megjött a tél!";
        }
        /*
        switch (month) {
            case Month.values()[2], Month.values()[3], Month.values()[4]:
                message += " Itt a tavasz lehellete.";
                break;
            case Month.values()[5], Month.values()[6], Month.values()[7]:
                message += " Nyár van, nyár!";
                break;
            case Month.values()[8], Month.values()[9], Month.values()[10]:
                message += " Itt van az ősz, itt van újra.";
                break;
            case Month.values()[11], Month.values()[0], Month.values()[1]:
                message += " Megjött a tél!";
                break;
        }
        */
        System.out.println(message);
    }
}
