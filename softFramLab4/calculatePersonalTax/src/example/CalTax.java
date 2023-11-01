package example;

//细节：注意更改server-config
public class CalTax {
    public String CalTax(String wages){
        double tax = 0.0;
        double income = Double.parseDouble(wages);
        double taxableIncome = income - 5000.0; // 减免5000元
        int taxBracket = 0;
        double[] taxRates = {0.03, 0.1, 0.2, 0.25, 0.3, 0.35, 0.45};
        double[] taxDeductions = {0, 2520.0, 16920.0, 31920.0, 51920.0, 71920.0, 151920.0};

        if (taxableIncome > 0) {
            while (taxBracket < 7 && taxableIncome > taxDeductions[taxBracket]) {
                taxableIncome -= taxDeductions[taxBracket];
                taxBracket++;
            }

            if (taxBracket == 7) {
                tax = taxableIncome * taxRates[6];
            } else {
                tax = taxableIncome * taxRates[taxBracket - 1];
            }
        }

        return String.valueOf(tax);
    }
}
