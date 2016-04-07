package customcode;

public class MortgageCalc {
	
	private double principal; 
	private double monthlyRate;
	private double monthTerm;
	private double payment; 
	

	public MortgageCalc() {
		principal = 0;
		monthlyRate = 0;
		monthTerm = 0;
		payment = 0;
	}
	
	
	
	public MortgageCalc(double _principal, double _rate, double _term) {
		principal = _principal;
		monthlyRate = (_rate / 100) / 12;
		monthTerm = _term * 12;
		
	}
	
	public double getMonthlyPayment() {
		
		payment = (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -monthTerm));
		return payment;
	}
	
	

}
