class ProfitLoss {
    public static void main(String[] args) {
        double CostPrice = 129;
        double SellingPrice = 191;

        double Profit = SellingPrice - CostPrice;
        double ProfitPercentage = (Profit / CostPrice)*100;

        System.out.printf("The Cost Price is INR " + CostPrice + "and Selling Price is INR " + sellingPrice +
                          "The Profit is INR " + Profit + "and the Profit Percentage is " + ProfitPercentage);
    }
}
