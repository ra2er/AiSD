public class MatrixMaxValue {

    int row;
    int col;
    double value;

    public String toString() {
        return new String(String.format("%s, [%d][%d]", DoubleFormatter.formatValue(this.value), this.row, this.col));
    }

    public boolean isLte(double value) {
        return value >= this.value;
    }

    public MatrixMaxValue(double value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}
