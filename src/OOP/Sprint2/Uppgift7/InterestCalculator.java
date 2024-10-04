package OOP.Sprint2.Uppgift7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculator {
    private double initialPrincipalInSEK;
    private double interestRateInPercent;


    public InterestCalculator(double initialPrincipalInSEK, double interestRateInPercent) {
        this.initialPrincipalInSEK = initialPrincipalInSEK;
        this.interestRateInPercent = interestRateInPercent;
    }

    public double calculateYearlyInterest(double currentPrincipalInSEK) {
        double newPrincipal = (1.00+getInterestRateInDecimal()) * currentPrincipalInSEK;
        return new BigDecimal(newPrincipal).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public String createOutputCompoundInterestForYears(int years) {
        return "";
    }

    public double getInterestRateInDecimal() {
        return interestRateInPercent/100.00;
    }

}
