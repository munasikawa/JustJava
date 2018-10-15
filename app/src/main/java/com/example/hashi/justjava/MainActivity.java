package com.example.hashi.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


//This app displays an order form to order coffee.

public class MainActivity extends AppCompatActivity {

    int quantity = 2;
    int priceOfCoffee = 5;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }


    //This method is called when the increment button is clicked.

    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);

    }

    //This method is called when the decrement button is clicked.

    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);

    }


    //This method is called when the order button is clicked and displays priceMessage


    public void submitOrder(View view) {

        //This method checks if whipped cream is added

        EditText userName = (EditText) findViewById(R.id.username_view);
        String names = userName.getText().toString();


        CheckBox whippedCreamCheckbox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCreamCheckbox.isChecked();

        //This method checks if chocolate is added

        CheckBox chocolateCheckbox = findViewById(R.id.chocolate_checkbox);
        boolean hasChocolateCheckbox = chocolateCheckbox.isChecked();

        int price = calculatePrice();
        String priceMessage = createOrderSummary(names, price, hasWhippedCream, hasChocolateCheckbox);
        displayMessage(priceMessage);


    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */

    private int calculatePrice() {

        int price = quantity * priceOfCoffee;
        return price;

    }

    /**
     * Creates full order summary.
     *
     * @return full priceMessage
     * @Param price of the order
     * @Param whether user wants Whipped Cream
     * @Param whether user wants Chocolate
     */

    private String createOrderSummary(String addNames, int price, boolean addWhippedCream, boolean addChocolateCheckbox) {

        String priceMessage = "Name: " + addNames;
        priceMessage += "\nAdd Whipped Cream?: " + addWhippedCream;
        priceMessage += "\nAdd Chocolate?: " + addChocolateCheckbox;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nTotal: $" + price;
        priceMessage += "\nThank You!";
        return priceMessage;

    }


    //This method displays the given quantity value on the screen.


    private void displayQuantity(int number) {

        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);

        quantityTextView.setText("" + number);

    }

    /**
     * This method displays the given text on the screen.
     */

    private void displayMessage(String message) {

        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);

        orderSummaryTextView.setText(message);

    }


}
