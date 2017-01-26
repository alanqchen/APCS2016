
public class ProperFraction extends Fraction {
	public ProperFraction() {
		super();
	}
	public ProperFraction(int n, int d) {
		super(n,d);
	}
	public int getWhole() {
		int whole;
		if(this.getDenominator() != 0) {
			whole = (this.getNumerator() / this.getDenominator());
		}
		else {
			whole = 0;
		}
		return whole;
	}
	public int getRemainder() {
		int remain;
		remain = (this.getNumerator() % this.getDenominator());
		return remain;
	}
	public void print() {
		System.out.println(this.toString());
	}
	public String toString() {
		String s1;
		if(this.getWhole() == 0) {
			s1 = super.toString();
		}
		else {
			if (this.getNumerator() % this.getDenominator() == 0) {
				s1 = this.getWhole() + " ";
			}
			else {
				s1 = this.getWhole() + " " + Math.abs(this.getRemainder()) + "/" + this.getDenominator();
			}
		}
		return s1;
	}
}
