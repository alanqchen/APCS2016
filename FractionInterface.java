// McKeen
// FractionInterface
// Used to insure the proper methods are included in the Fraction assignment

/*INSTRUCTION:
  	Copy this file FractionInterface into your project directory
  	Add the words "implements FractionInterface" to the first line of your 
  	Fraction class so that it reads:
  	
  		public class Fraction implements FractionInterface
  	
  	Compile and make sure that you do not get any errors.
  	
  	Interfaces have two primary purposes:
  	1.  They list all of the methods that are required in a class
  	2.  A variable declared as type FractionInterface can refer to 
  		ANY object that implements the interface -- we will discuss this 
  		more, but it is VERY powerful.
  		
*/

public interface FractionInterface
{
	//private void simplify(); 		//private methods are NOT allowed in an interface
	//private int commonDenom(Fraction f);  //private methods are NOT allowed in an interface

	public Fraction add(Fraction f);   
	public Fraction subtract(Fraction f);
	public Fraction multiply(Fraction f);
	public Fraction divide(Fraction f);
	public double toDouble( );

	public int compareTo(Fraction f);
	
	public boolean equals(Fraction f);	
	public boolean equals(double dd);	
	public boolean equals(int n, int d);	

//accessors
	public int getNumerator();   	//returns numerator
	public int getDenominator();	//returns denominator
	public void print();		//fractions should look like this:  3/4 or 13/23
	public String toString();


}