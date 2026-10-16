
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman{
    public static void main(String[] args) {

        System.out.println("CAN---YOU---SAVE---HANGMAN---?");
        System.out.println("Guess my word");
        // alle Wörter, die der Computer auswählen könnte
        String[] woerterArray = {
        "Abendessen", "Arbeitsplatz", "Baustelle", "Bildschirm", "Buchstabe",
        "Deutschland", "Einkaufen", "Eisenbahn", "Fahrradweg", "Flughafen",
        "Gartenarbeit", "Geburtstag", "Geheimnis", "Handwerker", "Hauptstadt",
        "Herbstwind", "Informatik", "Kaffeetasse", "Kindergarten", "Krankenhaus",
        "Lebensmittel", "Lieblingslied", "Mannschaft", "Meisterschaft", "Naturwissenschaft",
        "Osterhase", "Parkplatz", "Postkarte", "Regenschirm", "Reiseleitung",
        "Schokolade", "Schreibtisch", "Spielplatz", "Staubsauger", "Taschenlampe",
        "Teilnehmer", "Universitaet", "Unternehmen", "Verkehrsmittel", "Versicherung",
        "Vorstellung", "Waldspaziergang", "Weihnachten", "Weltmeister", "Werkzeugkiste",
        "Winterjacke", "Wochenende", "Waerterbuch", "Zimmermann", "Zusammenarbeit"
        };

        // Wort des Computers mithilfe des woerterArrays zufällig auswählen
        int chooseRandomWord=(int)(Math.random()*50);
        String computerWord=woerterArray[chooseRandomWord];

        Scanner scanLetter=new Scanner(System.in);

        ArrayList<Character> validLetters=new ArrayList<>();
        ArrayList<Character> notValidLetters=new ArrayList<>();

        

        boolean guessed=false;
        int opentries=8;
        guessed = printguessedLettersinrightPosAndTellIfNrGuessed(validLetters, computerWord);

        while (!guessed && opentries>0){
            char currentLetter=(scanLetter.next()).charAt(0);
            if(!proofLetter(currentLetter, computerWord)){
                notValidLetters.add(currentLetter);
                printNotValidLetters(notValidLetters);
                opentries--;
            }else{
                validLetters.add(currentLetter);
                guessed=printguessedLettersinrightPosAndTellIfNrGuessed(validLetters, computerWord);
            }

                                         
        }
        if(!guessed){
            System.out.println("---YOU---LOOSE---");
            // hangman malen:
            System.out.println("                          -----------------------|");
            System.out.println("                          |                      |");
            System.out.println("                        -----                    |");
            System.out.println("                       -     -                   |");
            System.out.println("                        -----                    |");
            System.out.println("                          | /                    |");
            System.out.println("                          |/                     |");
            System.out.println("                         /|                      |");
            System.out.println("                        / |                      |");
            System.out.println("                          |                      |");
            System.out.println("                         / |                     |");
            System.out.println("                        /   |                    |");
            System.out.println("                                           |----------|");
            System.out.println("                                           |          |");
            System.out.println("                                           |----------|");
            System.out.println("My word was: "+ computerWord);
        }else{
            System.out.println("---YOU---WIN---");

            System.out.println("                                                ");
            System.out.println("              *          -----            *        ");
            System.out.println("        *               - *  * -    *               ");
            System.out.println("                *        -----       *             ");
            System.out.println("            *              | /                    ");
            System.out.println("                *          |/              *       ");
            System.out.println("          *               /|                      ");
            System.out.println("                  *      / |          *            ");
            System.out.println("               *           |              *        ");
            System.out.println("           *              / |                  *   ");
            System.out.println("                *        /   |                    ");
            System.out.println("                                     *      ");

        }



    }

    private static boolean proofLetter(char currentLetter, String computerWord) {
        String lowerCaseCompWord=computerWord.toLowerCase();
        for (int i=0; i<computerWord.length(); i++){
            if(currentLetter==lowerCaseCompWord.charAt(i)){
                return true;
            }
        }
        return false;
    }

    private static boolean printguessedLettersinrightPosAndTellIfNrGuessed(ArrayList<Character> validLetters, String computerWord) {
        ArrayList<Character> symbolsToBeSeenOnScreen=new ArrayList<>();
        String lowerCaseCompWord=computerWord.toLowerCase();
        if(validLetters.isEmpty()){
            for (int i=0; i<computerWord.length(); i++){
                symbolsToBeSeenOnScreen.add('_');
            }
        }else{
            for (int i=0; i<computerWord.length(); i++){
                for (int j=0; j<validLetters.size(); j++){
                    if(validLetters.get(j)==lowerCaseCompWord.charAt(i)){
                        symbolsToBeSeenOnScreen.add(computerWord.charAt(i));
                        break;
                    }
                }
                if(symbolsToBeSeenOnScreen.size()<=i){                // wir vergleichen size mit Stelle. 
                    symbolsToBeSeenOnScreen.add('_');
                }
            }
        }
            for(int i=0; i<symbolsToBeSeenOnScreen.size(); i++){
                System.out.print(Character.toChars(symbolsToBeSeenOnScreen.get(i)));
            }
            System.out.println("");

            for (int i=0; i<symbolsToBeSeenOnScreen.size(); i++){
                if(symbolsToBeSeenOnScreen.get(i)=='_'){
                    return false;
                }
            }
            return true;
    }

    private static void printNotValidLetters(ArrayList<Character> notValidLetters) {
        System.out.print("incorrect letters :");
        for(int i=0; i<notValidLetters.size(); i++){
            System.out.print(Character.toChars(notValidLetters.get(i)));
        }
        System.out.println();
    }
}