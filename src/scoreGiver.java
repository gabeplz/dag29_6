public class scoreGiver {

    public static Character giveScore(int scoreNumber){
        if (scoreNumber >= 80){
            return 'A';
        } else if (scoreNumber >= 60) {
            return 'B';
        } else if (scoreNumber >= 50){
            return 'C';
        } else if (scoreNumber >= 45){
            return 'D';
        } else if (scoreNumber >= 25){
            return 'E';
        } else {
            return 'F';
        }
    }

    public static void switchOpdracht(String browser){
        switch (browser){
            case "Edge":
                System.out.println("je gebruikt edge");
                break;
            case "chrome":
            case "firefox":
            case "opera":
                System.out.println("je hebt een moderne browser");
                break;
            case "IE":
                System.out.println("why");
            default:
                System.out.println("je hebt een niet ondersteunde browser");
        }
    }

    public static void tafels(){
        int x = 10;
        System.out.print("* | ");
        for (int a = 1; a <= x; a++){
            System.out.print(a + " ");
        }
        System.out.println("");
        System.out.println("-------------------");
        for (int i = 1; i <= x; i++){
            System.out.print(i+"|");
            for (int y = 1; y <= x; y++){
                System.out.print(i*y+ " ");
            }
            System.out.println(" ");
        }
    }


    public static void loops(){
        int i = 0;
        int[] list = new int [5];
        while (i < 5){
            list [i] = i +2;
            i++;

        }
        System.out.println(list[4]);
        int c = 0;
        int[] list2 = new int [5];

        do {
            list2 [c] = c +2;
            c++;
        } while (c < 5);
        System.out.println(list2[4]);



    }


}
