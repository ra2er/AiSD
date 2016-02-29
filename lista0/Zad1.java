import java.io.IOException;

public class Zad1 {

    public static void main(String[] args) {
        Matrix m = new Matrix(4, 5);
        m.saveAsText();
        m = null;

        // odczyt macierzy z pliku
        try {
            m = Matrix.fromTextFile();
            MatrixMaxValue max = m.max();
            System.out.println(m);
            System.out.println(String.format("Maksymalna wartość: %s", max));
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
