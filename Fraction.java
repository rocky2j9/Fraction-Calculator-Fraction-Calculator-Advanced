public class Fraction {
    private int  numerator,denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator can not be 0");
        }
        else if (denominator < 0) {
                this.numerator = numerator * -1;
                this.denominator = denominator * -1;
        }else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator(){
        return this.denominator;
    }

    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public double toDouble() {
        return (double) this.numerator / this.denominator;
    }

    public static int gcd(int num, int den) {
        if ((num == 0) || (den == 0)) {
            return den + num;
        }else {
            return gcd(den, num % den);
        }
    }

    public void toLowestTerms() {
        int hcf = gcd(this.numerator, this.denominator);
        this.numerator /= Math.abs(hcf);
        this.denominator /= Math.abs(hcf);
    }

    public Fraction add(Fraction other) {
        int fracDen = (this.denominator * other.denominator) / gcd(this.denominator, other.denominator);
        int fracNum = (fracDen / this.denominator * this.numerator) + (fracDen / other.denominator * other.numerator);
        Fraction result = new Fraction(fracNum, fracDen);
        result.toLowestTerms();
        return result;
    }

    public Fraction subtract(Fraction other) {
        int fracDen = (this.denominator * other.denominator) / gcd(this.denominator, other.denominator);
        int fracNum = (fracDen / this.denominator * this.numerator) - (fracDen / other.denominator * other.numerator);
        Fraction result = new Fraction(fracNum, fracDen);
        result.toLowestTerms();
        return result;
    }

    public Fraction multiply(Fraction other) {
        int fracDen = this.denominator * other.denominator;
        int fracNum = this.numerator * other.numerator;
        Fraction result = new Fraction(fracNum, fracDen);
        result.toLowestTerms();
        return result;
    }

    public Fraction divide(Fraction other) {
        if (other.denominator == 0) {
            throw new IllegalArgumentException("The denominator can not be 0");
        }
        int fracDen = this.denominator * other.numerator;
        int fracNum = this.numerator * other.denominator;
        Fraction result = new Fraction(fracNum, fracDen);
        result.toLowestTerms();
        return result;
    }

    public boolean equals(Object other) {
        if (other instanceof Fraction) {
            Fraction otherFrac = (Fraction)other;
            this.toLowestTerms();
            otherFrac.toLowestTerms();
            return (this.numerator == otherFrac.numerator) && (this.denominator == otherFrac.denominator);
        }else {
            throw new IllegalArgumentException("The object is not a fraction");
        }

    }

}






























