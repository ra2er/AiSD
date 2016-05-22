public class Number implements Comparable {
  public int value;

  public Number(int value) {
    this.value = value;
  }

  public int compareTo(Comparable other) {
   return this.value==((Number)other).value?0:this.value>((Number)other).value?1:-1;
  }

  public String toString() {
    return ((Integer)this.value).toString();
  }

  public boolean equals(Number other) {
    return this.value == other.value;
  }
}
