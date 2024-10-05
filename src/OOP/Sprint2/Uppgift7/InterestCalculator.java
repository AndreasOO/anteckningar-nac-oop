package OOP.Sprint2.Uppgift7;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculator {
    private final double initialPrincipalInSEK;
    private double interestRateInPercent;


    public InterestCalculator(double initialPrincipalInSEK, double interestRateInPercent) {
        this.initialPrincipalInSEK = initialPrincipalInSEK;
        this.interestRateInPercent = interestRateInPercent;
    }

    public double calculateYearlyInterest(double currentPrincipalInSEK) {
        double newPrincipal = (1.00+getInterestRateInDecimal()) * currentPrincipalInSEK;
        return new BigDecimal(newPrincipal).setScale(4, RoundingMode.HALF_DOWN).doubleValue();
    }

    public String createOutputCompoundInterestForYears(int years) {
        double currentPrincipalInSEK = initialPrincipalInSEK;
        StringBuilder sb = new StringBuilder();
        sb.append("Year\t\tAmount\n");
        sb.append("------------------\n");
        for (int i = 0; i <= years; i++) {
            sb.append(String.format("%d\t\t\t%.2f\n", i, currentPrincipalInSEK));
            currentPrincipalInSEK = calculateYearlyInterest(currentPrincipalInSEK);
        }
        return sb.toString();
    }

    public double getInterestRateInDecimal() {
        return interestRateInPercent/100.00;
    }

}
