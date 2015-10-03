package com.example.asavarikarandikar.justjava;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends ActionBarActivity {

    int quantity=0;
    String customerName="Sanika Kulkarni";
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public int calculatePrice(int x){
        int pricePerCup=5;
        int y=x*pricePerCup;
        return y;

    }
public String createSummary(int p){
    String summary="Name:" + customerName ;
    summary=summary+ "\n Quantity:" + quantity;
    summary=summary+ "\n Total:" + p;
    summary=summary+"\n Thank You!";
    return summary;
}
    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {

       int price=calculatePrice(quantity);
       String s=createSummary(price);
        //String priceMessage=" Total $: " + price ;
        //priceMessage=  priceMessage + "\n Thank You!";
        displayMessage(s);

    }
    public void increment(View view){

        quantity=quantity+1;
        display(quantity);
    }

    public void decrement(View view){

               //String no="please enter valid number";
                quantity=quantity-1;
                if(quantity<= -1){
                    //display(no);
                    quantity=0;
                }
        display(quantity);

    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.order_summary_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given quantity value on the screen.
     */

     private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(
                R.id.text0);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
        ImageView img=(ImageView) findViewById(R.id.img2);
    }


}
