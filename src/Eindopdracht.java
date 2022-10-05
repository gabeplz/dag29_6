
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class Eindopdracht {

    public static void printStuff(){
        //"nee weg t kaatsnet en staak t geweenz9"
        String sas = new String("9znee weg t kaatsnet en staak t geweenz9").toLowerCase(Locale.ROOT);
        String kaas = "";
        int klinkerCount = 0;
        int medeKlinkerCount;

        int charCount;
        int woordCount;


        ArrayList<Character> unreversedStringList = new ArrayList<Character>();
        String[] woordArray;

        //char[] referentieArray = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        ArrayList<Character> referentieArrayList = new ArrayList<Character>(Arrays.<Character>asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5','6','7','8','9','0'));
        ArrayList<Integer> charCounterList;

        charCounterList = fillCharCounterList(sas,referentieArrayList);


        medeKlinkerCount = makeMedeklinkerCount(charCounterList);
        woordCount = maakWoordCount(sas);
        charCount = totalCharCount(charCounterList);


        System.out.println("aantal karakters: "+charCount);
        System.out.println("aantal woorder:   "+woordCount);
        System.out.println("aantal klinkers:  "+medeKlinkerCount);
        reverseAndCompare(sas);


//        for (int i = 0; i < 36; i++){
//            System.out.print('*'+" ");
//        }

        printVerticalStars(charCounterList,referentieArrayList,charCount, woordCount, medeKlinkerCount);
    }



    public static void printVerticalStars(ArrayList<Integer> charCounterList, ArrayList<Character>referentieArrayList,int charCount, int woordCount, int medeklinkerCount){
        int maxStarcount = 0;
        System.out.println(charCounterList.size());

        for (int i = 0; i <= charCounterList.size() -1; i++){
            if (charCounterList.get(i) > maxStarcount){
                maxStarcount = charCounterList.get(i);
            }

        }
        //System.out.println("maxx"+maxStarcount);
        char[][] starTable = new char[charCounterList.size()][maxStarcount]; //char[36][8]  36 for each character, 8 is highest char count with the current sentence
        for (int charIndex = 0; charIndex <= charCounterList.size()-1; charIndex++){
            for (int maxStarCount = 0; maxStarCount <= maxStarcount-1; maxStarCount++) {
                if (maxStarCount < charCounterList.get(charIndex)) {
                    starTable[charIndex][maxStarCount] = '*';
                } else {
                    starTable[charIndex][maxStarCount] = ' ';
                }
            }
        }

//        for (int starCount = 0; starCount <= maxStarcount -1; starCount++) {
//            for (int charIndex = 0; charIndex <= charCounterList.size()-1; charIndex++){
//                System.out.print(starTable[charIndex][starCount]+" ");
//            }
//            System.out.println("");
//        }

       // System.out.println("__________________________________________________________________");

        for (int starCount = maxStarcount -1; starCount >= 0 ; starCount--) {
            for (int charIndex = 0; charIndex <= charCounterList.size()-1; charIndex++){
                System.out.print(starTable[charIndex][starCount]+" ");
            }
            System.out.println("");
        }

        for (int i = 0; i < 36; i++) {
            System.out.print(referentieArrayList.get(i) + " ");
        }
        System.out.println("");

    }


    public static int maakWoordCount(String sas){
        String[] woordList = sas.split(" ");
        System.out.println(woordList.length);
        System.out.println(woordList);
        return woordList.length;
    }

    public static int makeMedeklinkerCount (ArrayList<Integer> charCounterList){
        int newMedeklinkerCount = 0;
        newMedeklinkerCount += charCounterList.get(0) + charCounterList.get(4) + charCounterList.get(8) + charCounterList.get(14) + charCounterList.get(24);
        System.out.println("medeklinkers"+newMedeklinkerCount);
        System.out.println(newMedeklinkerCount);
        return newMedeklinkerCount;
    }

    public static int totalCharCount (ArrayList<Integer> charCounterList){
        int totalCharCount = 0;
        for (int i = 0; i <= charCounterList.size()-1; i++){
            totalCharCount+=charCounterList.get(i);
        }
        return totalCharCount;
    }

    public static ArrayList<Integer> fillCharCounterList(String sas,ArrayList<Character> referentieArrayList){
        ArrayList<Integer> charCounterList = new ArrayList<>(Collections.nCopies(36, 0));
        for(int i = 0; i < sas.length();i++){
            //System.out.println(sas.charAt(i));
            int index = referentieArrayList.indexOf(sas.charAt(i));
            if (index != -1){

                int oldValue = charCounterList.get(index);
                charCounterList.set(index,oldValue+ 1);
            }
        }
        return charCounterList;
    }
    public static void reverseAndCompare(String sas) {
        ArrayList<Character> unreversedStringList = new ArrayList<Character>();
        ArrayList<Character> reverseStringList = new ArrayList<Character>();
        for (int i = 0; i < sas.length(); i++) {
            if (Character.isWhitespace(sas.charAt(i))) {
                continue;
            } else {
                unreversedStringList.add(sas.charAt(i));
            }
        }
        for (int x = sas.length() - 1; x >= 0; x--) {
            if (Character.isWhitespace(sas.charAt(x))) {
                continue;                                   // if whitespace: do nothing
            } else {
                reverseStringList.add(sas.charAt(x));

            }
        }

        //System.out.println(reverseStringList);
        // System.out.println(kaas);
        if (unreversedStringList.equals(reverseStringList)){
            System.out.println("palindroom?"+"       True");
        } else {
            System.out.println("palindroom?"+"       false");
        }
    }
    }

