import java.io.*;
import java.util.Random;
import java.util.Scanner;


class Matrix {
    int x;
    int y;
    double matrix[][];

    public Matrix() {
        Random r = new Random();
        this.x = Math.max(r.nextInt(10), 2);
        this.y = Math.max(r.nextInt(10), 2);
        this.matrix = new double[this.x][this.y];
        fill();
    }

    public Matrix(double[][] m) {
        this.x = m.length;
        this.y = m[0].length;
        this.matrix = new double[this.x][this.y];
        for (int i=0; i<this.x; i++) {
            for (int j=0; j<this.y; j++) {
                this.matrix[i][j] = m[i][j];
            }
        }
    }

    private void fill() {
        double n = 100;
        Random r = new Random();
        for (int i=0; i<this.x; i++) {
            for (int j=0; j<this.y; j++) {
                this.matrix[i][j] = r.nextDouble();
            }
        }
    }

    public String toString() {
        String s = "";
        for (int i=0; i<this.x; i++) {
            s += new String(new char[this.y-1]).replace("", "------------");
            s += "\n";
            for (int j=0; j<this.y; j++) {
                s += String.format("%10.8f |", this.matrix[i][j]);
            }
            s += "\n";
        }
        s += new String(new char[this.y-1]).replace("", "------------");
        s += "\n";
        return s;
    }
    public void save() {
        try {
            FileOutputStream file = new FileOutputStream("macierz.bin");
            BufferedOutputStream buf = new BufferedOutputStream(file);
            DataOutputStream writer = new DataOutputStream(buf);
            writer.writeInt(this.x);
            writer.writeInt(this.y);
            for (int i=0; i<this.x; i++) {
                // wiersze
                for (int j=0; j<this.y; j++) {
                    if (j < this.y) {
                        writer.writeDouble(this.matrix[i][j]);
                    }
                }
            }
            buf.close();
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

public class Zad2 {
    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("wczytaj")) {
                try {
                    String label = "Macierz";
                    FileInputStream file = new FileInputStream("macierz.bin");
                    BufferedInputStream buf = new BufferedInputStream(file);
                    DataInputStream reader = new DataInputStream(buf);
                    int x = reader.readInt();
                    int y = reader.readInt();
                    double matrix[][] = new double[x][y];
                    String pattern = "%10.8f, [%d][%d]";
                    double max = 0;
                    int maxRow = 0;
                    int maxCol = 0;
                    String maxPrint = "";
                    double l = 0;
                    for (int i=0; i<x; i++) {
                        for (int j=0; j<y; j++) {
                            l = reader.readDouble();
                            if (l > max) {
                                max = l;
                                maxRow = i;
                                maxCol = j;
                                maxPrint = String.format(pattern, max, maxRow, maxCol);
                            }
                            matrix[i][j] = l;
                        }
                    }
                    Matrix m = new Matrix(matrix);
                    System.out.println(label);
                    System.out.println(m);
                    System.out.println(maxPrint);
                }
                catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            else if (args[0].equals("zapisz")) {
                Matrix m = new Matrix();
                m.save();
                System.out.println(m);
            }
            else {
                System.out.println("ZŁA OPCJA, WYBIERZ `zapisz` lub `wczytaj`");
            }
        }
        else {
            System.out.println("Wybierz opcję: zapisz lub wczytaj.");
        }
    }
}
