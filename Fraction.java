/*  ________  ___  ___  _______   ________      
 * |\   ____\|\  \|\  \|\  ___ \ |\   ___  \    
 * \ \  \___|\ \  \\\  \ \   __/|\ \  \\ \  \   
 *  \ \  \    \ \   __  \ \  \_|/_\ \  \\ \  \  
 *   \ \  \____\ \  \ \  \ \  \_|\ \ \  \\ \  \ 
 *    \ \_______\ \__\ \__\ \_______\ \__\\ \__\
 *     \|_______|\|__|\|__|\|_______|\|__| \|__|
 * Fraction.java                                             
 * Used to Add, subtract, multiply, divide, compare, simplify, and do more with fractions!                                         
 * 
 */
public class Fraction {
	//constructors
	private int myNum;
	private int myDenom;
	// sets the fraction to 0/1
	public Fraction() {
		myNum = 0;
		myDenom = 1;
		simplify();
	}
	//creates a simplified fraction using two ints
	public Fraction(int n, int d) {
		myNum = n;
		myDenom = d;
		simplify();
	}
	//takes a decimal and converts it into a fraction
	public Fraction(double db) {
		double decimal = db;
		myDenom = 1;
		//multiply's the decimal and denominator by ten, until you get a whole number. Ex: .125 -> 125/1000.
		do {
			decimal *= 10;
			myDenom *= 10;
		} while(decimal % 1 != 0);
		myNum = (int)decimal;
		//simplify's result
		this.simplify();
	}
	//simplify's the fraction
	private void simplify() {
		//finds the absolute value of the numerator and denominator and takes the smallest number
		int i = Math.min(Math.abs(myNum), Math.abs(myDenom));
		//if the denominator is 0, then displays a divide by zero error message
		if (myDenom == 0) {
			System.out.println("Encountered divide by zero error!");
		}
		//if the smallest number is 0, changes fraction to 0/1 and "stops"
		if (i == 0) {
			myNum = 0;
			myDenom = 1;
			return;
		}
		//finds the gcd 
		while ((myNum % i != 0) || (myDenom % i !=0)) {
			i--;
		}
		//divides the num and denom by the gcd to simplify the fraction
		myNum = myNum / i;
		myDenom = myDenom / i;
	} 								

	//public methods
	//adds two fractions
	public Fraction add(Fraction f) {
		Fraction result = new Fraction();
		//finds the numerator
		result.myNum = this.myNum * f.myDenom + this.myDenom * f.myNum;
		//finds the denominator
		result.myDenom = this.myDenom * f.myDenom;
		//simplify's result
		result.simplify();
		return result;
	}  
	//subtracts two fractions
	public Fraction subtract(Fraction f) {
		Fraction result = new Fraction();
		//finds the numerator
		result.myNum = this.myNum * f.myDenom - this.myDenom * f.myNum;
		//finds the denominator
		result.myDenom = this.myDenom * f.myDenom;
		//simplify's result
		result.simplify();
		return result;	
	}	
	//multiply's two fractions
	public Fraction multiply(Fraction f) {
		Fraction result = new Fraction();
		//finds the numerator
		result.myNum = this.myNum * f.myNum;
		//finds the denominator
		result.myDenom = this.myDenom * f.myDenom;
		//simplify's result
		result.simplify();
		return result;
	}
	//divides two fractions
	public Fraction divide(Fraction f) {
		Fraction result = new Fraction();
		//finds the numerator
		result.myNum = this.myNum * f.myDenom;
		//finds the denominator
		result.myDenom = this.myDenom * f.myNum;
		//simplify's result
		result.simplify();
		return result;
	}
	//converts the fraction to a double
	public double toDouble() {
		double d = ((double)myNum) / myDenom;
		return d;
	}		
	//compares two fractions, -1 if this is smaller, 0 if it's the same, 1 if it's larger
	public int compareTo(Fraction f) {
		int result = 1;
		//if the denominators are the same, it compares the numerators
		if (this.myDenom == f.myDenom) {
			if (this.myNum == f.myNum) {
				result = 0;
			}
			else if (this.myNum < f.myNum) {
				result = -1;
			}
			else if (this.myNum > f.myNum) {
				result = 1;
			}
		//if the denominators are not the same, converts to decimal, and compares.
		}
		else {
			if (this.toDouble() == f.toDouble()) {
				result = 0;
			}
			if (this.toDouble() < f.toDouble()) {
				result = -1;
			}
			if (this.toDouble() > f.toDouble()) {
				result = 1;
			}
		}
		return result;
	}					
	//checks if fractions are equal to each other, and return a boolean value
	public boolean equals(Fraction f) {
		boolean result = false;
		//simplify's fractions
		this.simplify();
		f.simplify();
		//if both the numerator and denominator are the same, it changes the boolean to true
		if (this.myNum == f.myNum && this.myDenom == f.myDenom) {
			result = true;
			return result;
		}
		//if not, the boolean value stays the same
		else {
			return result;
		}
		
	}	
	//checks if a decimal is equal to the fraction
	public boolean equals(double dd) {
		boolean result = false;
		//checks if the doubles are within .00000001 of each other, and sets boolean to true is yes, and false if no.
		if (Math.abs(((double)this.myNum / this.myDenom) - dd) < 0.00000001) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}			
	//checks if a fraction and a fraction entered as ints are equal to each other
	public boolean equals(int n, int d)	{
		//creates Fraction object using ints
		Fraction equal = new Fraction(n,d);
		boolean result = false;
		//simplify's fractions
		this.simplify();
		equal.simplify();
		//if both the numerator and denominator are the same, it changes the boolean to true
		if (this.myNum == equal.myNum && this.myDenom == equal.myDenom) {
			result = true;
			return result;
		//if not, the boolean value stays the same
		} else {
			return result;
		}
	}
	//returns numerator
	public int getNumerator() {
		return myNum;
	}			
	//returns denominator
	public int getDenominator()	{
		//if it is less than 0, changes it so it is positive. (num should get the negative)
		if (myDenom < 0) {
			myDenom = myDenom*-1;
		}
		return myDenom;
	}		
	//prints fraction using the toString method
	public void print()	{
		System.out.println(this.toString());
	}
	//overrides toString so fractions are displayed correctly
	public String toString() {
		String s1;
		if (myDenom < 0) {
			s1 = ((myNum * -1) + "/" + (myDenom * -1));
		} else {
			s1 = (myNum + "/" + myDenom);
		}
		return s1;
	}					     										
}