package lab1;
import java.util.Arrays;

public class lab1 {
    public static void main(String[] args) {
        lab1 lab1 = new lab1();
        lab1.compulsory();
        lab1.homework(args);
    }
    void compulsory() {
        System.out.println("********** compulsory ********** ");
        System.out.println("Hello World!");
        String [] languages =  {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n*=3;
        n+=0b10101;
        n+=0xFF;
        n*=6;
        while (n > 9) {
            int result = 0;
            while (n > 0) {
                result += n % 10;
                n /= 10;
            }
            n = result;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
    void homework(String[] args) {
        System.out.println("********** homework ********** ");
        //validez argumentul
        if (args.length == 0) {
            System.out.println("Niciun argument inserat.");
            return;
        }

        String nStr = args[0];
        int n;

        try {
            n = Integer.parseInt(nStr);
        } catch (NumberFormatException e) {
            System.out.println("Argument nevalid: " + nStr);
            return;
        }
        int[][] latinSquare = new int[n][n];
        long startTime = System.nanoTime();
        //creez latinSquare-ul
        for(int i=0; i<n; ++i) latinSquare[0][i]=i+1;
        for(int i=1; i<n; ++i)
            for(int j=0; j<n; ++j)
                latinSquare[i][j]=latinSquare[(i-1)][(j+1)%n];
        long endTime = System.nanoTime();
        //afisez latinSquare-ul daca n < 30_000;
        if(n<30_000) {
//            for(int i=0; i<n; ++i){
//                for(int j=0; j<n; ++j)
//                    System.out.print(latinSquare[i][j] + " ");
//                System.out.println();
//            }
            printRows(latinSquare);
            printColumns(latinSquare);
        }
        long runningTime = endTime - startTime;
        float runningTimeMs = (float) (runningTime / 1000.0);
        System.out.println("Running time: " + runningTime + "ns");
        System.out.println("Running time: " + runningTimeMs + "ms");
    }

    public static void printRows(int[][] latinSquare){
        System.out.print("Rows: ");
        for(int [] row : latinSquare ){
            System.out.print(Arrays.toString(row));
        }
        System.out.println();
    }

    public  static void printColumns(int [][] latinSquare){
        System.out.print("Columns: ");
        for(int i=0; i< latinSquare.length; ++i){
            int[] col = new int [latinSquare.length];
            for(int j=0; j< latinSquare.length; ++j){
                col[j]=latinSquare[j][i];
            }
            System.out.print(Arrays.toString(col));
        }
        System.out.println();
    }


}
