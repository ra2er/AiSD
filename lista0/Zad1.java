import java.io.IOException;

public class Zad1 {

    public static void main(String[] args) {
        Matrix m = new Matrix(8, 10);
        m.saveAsText();
        m = null;

        // odczyt macierzy z pliku
        try {
            m = Matrix.fromTextFile();
            System.out.println(m);
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
