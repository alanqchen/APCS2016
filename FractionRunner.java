/*Chen Fraction Runner
 * Used to test the methods in the Fraction.java class file
 */
import java.util.Scanner;
public class FractionRunner {
	private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
    	int n;
    	int d;
    	int num;
    	int denom;
    	double db;
    	String addstring;
    	Fraction resultadd = new Fraction();
    	Fraction resultsubtract = new Fraction();
    	Fraction resultmultiply = new Fraction();
    	Fraction resultdivide = new Fraction();
    	double decimal;
    	double decimal2;
    	int resultcompare;
    	boolean equal1;
    	boolean equal2;
    	boolean equal3;
    	System.out.println("Enter first fraction");
    	num = input.nextInt();
    	denom = input.nextInt();
        Fraction frac1 = new Fraction(num,denom);
    	System.out.println("Enter second fraction");
    	num = input.nextInt();
    	n = num;
    	denom = input.nextInt();
    	d = denom;
        Fraction f = new Fraction(num,denom);
        System.out.println("Enter equal decimal to first fractiom");
    	double dd = input.nextDouble();
    	System.out.println("Enter decimal to convert to fraction");
    	db = input.nextDouble();
    	Fraction convert = new Fraction(db);
        System.out.print("For fractions: ");
        System.out.print(frac1 + " ");
        System.out.println(f);
        resultadd = frac1.add(f);
        addstring = resultadd.toString();
        System.out.print("Addition(string): ");
        System.out.println(addstring);
        resultsubtract = frac1.subtract(f);
        System.out.print("Subtraction: ");
        System.out.println(resultsubtract);
        resultmultiply = frac1.multiply(f);
        System.out.print("Multiplication: ");
        System.out.println(resultmultiply);
        resultdivide = frac1.divide(f);
        System.out.print("Division: ");
        System.out.println(resultdivide);
        decimal = frac1.toDouble();
        System.out.print("First fraction to double: ");
        System.out.println(decimal);
        decimal2 = f.toDouble();
        System.out.print("Second fraction to double: ");
        System.out.println(decimal2);
        resultcompare = frac1.compareTo(f);
        System.out.print("Compare result: ");
        System.out.println(resultcompare);
        equal1 = frac1.equals(f);
        equal2 = frac1.equals(dd);
        equal3 = frac1.equals(n,d);
        System.out.print("Equal to results: ");
        System.out.println(equal1 + " " + equal2 + " " + equal3);
        System.out.print("Decimal to fraction: ");
        System.out.println(convert);
        
	}
}
