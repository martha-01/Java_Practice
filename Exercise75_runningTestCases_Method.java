import java.util.Arrays;
import java.util.List;

public class Exercise75_runningTestCases_Method {
    /*
    Készítsetek teszteset futási összesítő alkalmazást. A futási eredményeket az alábbi formában tároljuk le egy ArrayList-ben vagy konzolról beolvasva kapjuk.
    Minden teszteset futás egy 4 számjegyű számmal kezdődik, majd egy:
    1-es ha PASS,
    X ha SKIP, valamint
    0 ha FAILED.
    Egy példa adat tehát: 00171 A feladat, hogy számoljuk össze:
        a)	Összesen hány teszteset került futtatásra?
        b)	Mennyi volt PASS? SKIP? FAILED?
        c)	Jelenítsük meg az adatokat százalékos formában is
    */
    public static void main(String[] args) {
        List<String> executionResultList = Arrays.asList("00171", "00181", "00190", "00200", "0021X", "00220");
        int totalNumberOfTestCases = 0;
        int numberOf1s = 0;
        int numberOfXs = 0;
        int numberOf0s = 0;
        for (String execution : executionResultList) {
            totalNumberOfTestCases++;
            char executionResult = execution.charAt(4);
            switch(executionResult) {
                case '1':
                    numberOf1s++;
                    break;
                case 'X':
                    numberOfXs++;
                    break;
                case '0':
                    numberOf0s++;
            }
        }
        System.out.println("The total number of test-cases run: " + totalNumberOfTestCases);
        System.out.println("The number of test cases that passed: " + numberOf1s + ", that is " + (float)numberOf1s / totalNumberOfTestCases * 100 + "% of all test-cases");
        System.out.println("The number of test cases that failed: " + numberOf0s + ", that is " + (float)numberOf0s / totalNumberOfTestCases * 100 + "% of all test-cases");
        System.out.println("The number of test cases that skipped: " + numberOfXs + ", that is " + (float)numberOfXs / totalNumberOfTestCases * 100 + "% of all test-cases");
    }
}
