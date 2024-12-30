/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author user
 */
import javax.swing.*;

public class SijitsuIceCreamStoreJOption {

    public static void main(String[] args) {

        boolean main = true;

        while (main) {

            // Prompt user if they want to shop
            String trap = JOptionPane.showInputDialog("Welcome to Sijitsu's Ice Cream Store! \nDo you want to go shopping? (yes/no)");
            if (trap.equalsIgnoreCase("no")) {
                break; // Exit if the user doesn't want to shop
            }

            double totalcost = 0.00;
            String[] product = {
                    "[1] Chocolate     - $1.50",
                    "[2] Vanilla       - $1.90",
                    "[3] Bubblegum     - $2.10",
                    "[4] Strawberry    - $2.00",
                    "[5] Mango         - $2.50"
            };
            double[] prices = {1.50, 1.90, 2.10, 2.00, 2.50};
            StringBuilder rer = new StringBuilder(); // To keep track of selected items

            while (trap.equalsIgnoreCase("yes")) {

                // Display product selection menu with aligned formatting
                String sel = JOptionPane.showInputDialog("Please select a product: \n" +
                        String.join("\n", product));

                int select = Integer.parseInt(sel);
                double price = 0;
                String productName = "";

                // Handle selection based on user input
                switch (select) {
                    case 1:
                        price = prices[0];
                        productName = "Chocolate";
                        break;
                    case 2:
                        price = prices[1];
                        productName = "Vanilla";
                        break;
                    case 3:
                        price = prices[2];
                        productName = "Bubblegum";
                        break;
                    case 4:
                        price = prices[3];
                        productName = "Strawberry";
                        break;
                    case 5:
                        price = prices[4];
                        productName = "Mango";
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
                        continue;
                }

                // Ask for quantity
                String quant = JOptionPane.showInputDialog("You selected " + productName + " for $ " + price + "\nEnter quantity:");
                int quantity = Integer.parseInt(quant);
                double subtotal = price * quantity;
                totalcost += subtotal;
                rer.append(String.format("%-15s%-10d$%-10.2f\n", productName, quantity, price)); // Format product line

                JOptionPane.showMessageDialog(null, String.format("Subtotal: %-10d * $%-10.2f = $%-10.2f", quantity, price, subtotal));

                // Ask if user wants to order another item
                trap = JOptionPane.showInputDialog("Do you want to order another item? (yes/no)");

            }

            // Voucher code and payment process
            String code = JOptionPane.showInputDialog("You selected:\n" + rer + "\nTotal: $ " + totalcost +
                    "\nDo you have a voucher? (Enter code or 'no')");

            double discount = 0;
            if (code.equalsIgnoreCase("SirJamieUnoLang")) {
                discount = totalcost * 0.15;
                totalcost -= discount;
            } else if (code.equalsIgnoreCase("Special")) {
                discount = totalcost * 0.12;
                totalcost -= discount;
            } else if (code.equalsIgnoreCase("10%Offnow")) {
                discount = totalcost * 0.10;
                totalcost -= discount;
            } else if (code.equalsIgnoreCase("Done 50%")) {
                discount = totalcost * 0.50;
                totalcost -= discount;
            }
            if (discount > 0) {
                JOptionPane.showMessageDialog(null, String.format("Discount: $%-10.2f\nTotal: $%-10.2f", discount, totalcost));
            }

            // Ask for payment
            double payment = 0;
            int attempts = 0;
            while (attempts < 3) {
                String payStr = JOptionPane.showInputDialog("Please enter the amount of money to pay: ");
                payment = Double.parseDouble(payStr);

                if (payment < totalcost) {
                    JOptionPane.showMessageDialog(null, String.format("Insufficient funds. You need at least $%-10.2f more.", (totalcost - payment)));
                    attempts++;
                } else {
                    double change = payment - totalcost;
                    JOptionPane.showMessageDialog(null, String.format("Payment accepted. Your change is $%-10.2f\nThank you for shopping with us!", change));
                    break;
                }
            }

            // If payment failed after 3 attempts
            if (attempts == 3) {
                JOptionPane.showMessageDialog(null, "Sorry, the order has been void due to many failed attempts. Please reorder.");
            }

            // Ask if user wants to continue shopping
            main = JOptionPane.showConfirmDialog(null, "Do you want to continue shopping?", "Continue Shopping", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        }
    }
}