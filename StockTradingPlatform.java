import java.util.*;
class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Holding {
    Stock stock;
    int quantity;
    double buyPrice;

    Holding(Stock stock, int quantity, double buyPrice) {
        this.stock = stock;
        this.quantity = quantity;
        this.buyPrice = buyPrice;
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        ArrayList<Stock> stockMarket = new ArrayList<>();
        stockMarket.add(new Stock("Apple", 180));
        stockMarket.add(new Stock("Tesla", 1200));
        stockMarket.add(new Stock("Infosys", 1400));

       
        ArrayList<Holding> portfolio = new ArrayList<>();
        double balance = 10000;

        System.out.println("Welcome to the Stock Trading Platform!");
        System.out.println("Your starting balance: ₹" + balance);

        
        while (true) {
            System.out.println("\nAvailable Stocks:");
            for (int i = 0; i < stockMarket.size(); i++) {
                Stock s = stockMarket.get(i);
                System.out.println((i + 1) + ". " + s.name + " - ₹" + s.price);
            }

            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
               
                System.out.print("Enter stock number to buy: ");
                int stockNum = sc.nextInt();
                Stock selected = stockMarket.get(stockNum - 1);

                System.out.print("Enter quantity to buy: ");
                int qty = sc.nextInt();
                double totalCost = selected.price * qty;

                if (totalCost <= balance) {
                    balance -= totalCost;
                    portfolio.add(new Holding(selected, qty, selected.price));
                    System.out.println("✅ Bought " + qty + " shares of " + selected.name);
                } else {
                    System.out.println("❌ Not enough balance!");
                }

            } else if (choice == 2) {
               
                if (portfolio.isEmpty()) {
                    System.out.println("❌ You don't own any stocks yet.");
                    continue;
                }

                System.out.println("Your Holdings:");
                for (int i = 0; i < portfolio.size(); i++) {
                    Holding h = portfolio.get(i);
                    System.out.println((i + 1) + ". " + h.stock.name + " - " + h.quantity + " shares @ ₹" + h.buyPrice);
                }

                System.out.print("Enter holding number to sell: ");
                int holdNum = sc.nextInt();
                Holding sellHolding = portfolio.get(holdNum - 1);

                System.out.print("Enter quantity to sell: ");
                int sellQty = sc.nextInt();

                if (sellQty <= sellHolding.quantity) {
                    double saleAmount = sellQty * sellHolding.stock.price;
                    balance += saleAmount;
                    sellHolding.quantity -= sellQty;
                    System.out.println("✅ Sold " + sellQty + " shares of " + sellHolding.stock.name);

                    if (sellHolding.quantity == 0) {
                        portfolio.remove(holdNum - 1);
                    }
                } else {
                    System.out.println("❌ Not enough shares to sell!");
                }

            } else if (choice == 3) {
                System.out.println("\n--- Your Portfolio ---");
               if (portfolio.isEmpty()) {
                    System.out.println("No holdings yet.");
                } else {
                    for (Holding h : portfolio) {
                        double currentVal = h.stock.price * h.quantity;
                        double invested = h.buyPrice * h.quantity;
                        double profit = currentVal - invested;
                        System.out.println(h.stock.name + " - " + h.quantity + " shares");
                        System.out.println("Buy Price: ₹" + h.buyPrice + ", Current Price: ₹" + h.stock.price);
                        System.out.println("Current Value: ₹" + currentVal + " | Profit/Loss: ₹" + profit + "\n");
                    }
                }
                System.out.println("Available Balance: ₹" + balance);
            } else if (choice == 4) {
                System.out.println("Thank you for using the Stock Trading Platform!");
                break;
            } else {
                System.out.println("❌ Invalid choice. Try again.");
            }
        }
        sc.close();
    }
}