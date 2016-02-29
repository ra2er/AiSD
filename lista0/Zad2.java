import java.io.*;
import java.util.Random;
import java.util.Scanner;


public class Zad2 {

    public static void main(String[] args) {
        Matrix m = new Matrix(4, 5);
        m.saveAsBin();
        m = null;

        // odczyt macierzy z pliku
        try {
            m = Matrix.fromBinFile();
            MatrixMaxValue max = m.max();
            System.out.println(m);
            System.out.println(String.format("Maksymalna wartość: %s", max));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
