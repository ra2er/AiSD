import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Matrix {

    int rows; // liczba wierszy
    int cols; // liczba kolumn
    double matrix[][];

    /**
     * Domyślny konstruktor ustawia wartość wierszy
     * i kolumn w przedziale (2, 10) oraz wypełnia 
     * macierz losowymi liczbami.
     */
    public Matrix() {
        Random r = new Random();
        this.rows = Math.max(r.nextInt(10), 2);
        this.cols = Math.max(r.nextInt(10), 2);
        this.matrix = new double[this.rows][this.cols];
        fill();
    }

    /**
     * Konstruktor przyjmuje wartość wierszy u kolumn,
     * potem wypełnia je liczbami typu double.
     */
    public Matrix(int rows, int cols) {
        Random r = new Random();
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[this.rows][this.cols];
        fill();
    }

    /**
     * Konstruktor tworzący instancję klasy matrix
     * z dowolnej dwuwymiarowej tablicy.
     */
    public Matrix(double[][] m) {
        this.rows = m.length;
        this.cols = m[0].length;
        this.matrix = new double[this.rows][this.cols];
        for (int i=0; i<this.rows; i++) {
            for (int j=0; j<this.cols; j++) {
                this.matrix[i][j] = m[i][j];
            }
        }
    }

    private void fill() {
        double n = 100;
        Random r = new Random();
        for (int i=0; i<this.rows; i++) {
            for (int j=0; j<this.cols; j++) {
                this.matrix[i][j] = r.nextDouble();
            }
        }
    }

    public String toString() {
        int colsWidth[] = new int[this.cols];
        for (int i=0; i<colsWidth.length; i++){
            colsWidth[i] = 0;
        }
        for (int i=0; i<this.rows; i++) {
            for (int j=0; j<this.cols; j++) {
                int width = DoubleFormatter.getWidth(this.matrix[i][j]);
                if (width > colsWidth[j]) {
                    colsWidth[j] = width;
                }
            }
        }
        int rowWidth = 0;
        for (int cw: colsWidth) {
            rowWidth += cw;
        }
        rowWidth += 1; // dla pierwszej kolumny dodajemy "|"
        rowWidth += this.cols; // dla pozostałych kolumn dodajemy "|"
        String s = new String(new char[rowWidth]).replace("", "=") + "\n";
        for (int i=0; i<this.rows; i++) {
            for (int j=0; j<this.cols; j++) {
                int precision = DoubleFormatter.getPrecision(this.matrix[i][j]);
                String formatter = "%" + String.format("%d.%df|", colsWidth[j], precision);
                if (j == 0) {
                    formatter = "| " + formatter;
                }
                s += String.format(formatter, this.matrix[i][j]);
            }
            if (i != this.rows - 1){
                s += "\n" + new String(new char[rowWidth]).replace("", "-") + "\n";
            }
        }
        s += "\n" + new String(new char[rowWidth]).replace("", "=");
        return s;
    }

    public void saveAsText() {
        try {
            FileWriter file = new FileWriter("matrix.txt");
            PrintWriter out = new PrintWriter(file);
            out.println("Macierz");
            out.println(this.rows);
            out.println(this.cols);
            for (int i=0; i<this.rows; i++) {
                String line = "";
                for (int j=0; j<this.cols; j++) {
                    if (j < this.cols) {
                        line += String.format("%s ", DoubleFormatter.formatValue(this.matrix[i][j]));
                    }
                }
                out.println(line);
            }
            out.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Matrix fromTextFile() throws IOException {
        try {
            FileReader file = new FileReader("matrix.txt");
            BufferedReader in = new BufferedReader(file);
            String label = in.readLine();
            Scanner s = new Scanner(in.readLine());
            int rows = s.nextInt();
            s = new Scanner(in.readLine());
            int cols = s.nextInt();
            double matrix[][] = new double[rows][cols];
            int i = 0;
            int j = 0;
            for (String line; (line=in.readLine()) != null;) {
                s = new Scanner(line);
                while (s.hasNextDouble()) {
                    double l = s.nextDouble();
                    matrix[i][j] = l;
                    j++;
                }
                j = 0;
                i++;
            }
            return new Matrix(matrix);
        }
        catch (IOException e) {
            throw e;
        }
    }
}
