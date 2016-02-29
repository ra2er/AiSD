
class DoubleFormatter {

    /**
     * Metoda dzieli liczbę na część całkowitą i ułamkową
     * potrzebną do ustalenia miejsc po przecinku
     * w formatowaniu - dla metody getPrecision().
     */
    public static String[] parse(double value) {
        String stringOfNumber = String.valueOf(value);
        String numberParts[] = stringOfNumber.replace(".", " ").split(" ");
        if (numberParts.length < 2) {
            // dla polskiego kodowania
            numberParts = stringOfNumber.replace(",", " ").split(" ");
        }
        return numberParts;
    }

    /**
     * Metoda podaje szerokość całej liczby zapisanej
     * jako typ String "AAA.BBB" wraz ze znakiem
     * oddzielającym części całkowite od ulamkowych.
     */
    public static int getWidth(double value) {
        String stringOfNumber = String.valueOf(value);
        return stringOfNumber.length();
    }

    public static int getPrecision(double value) {
        String[] parts = parse(value);
        return parts[1].length();
    }

    public static String format(double value) {
        int width = getWidth(value);
        int precision = getPrecision(value);
        String formatter = "%" + String.format("%d.%df", width, precision);
        return formatter;
    }

    public static String formatValue(double value) {
        String formatter = format(value);
        return String.format(formatter, value);
    }
}
