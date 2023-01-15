package Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import Model.DriverClass;
import Model.Order;

public class Common {
    public static Order TempOrder;
    public static Order getOrderObject(Activity context){
        Intent intent = context.getIntent();
        return (Order) intent.getExtras().getSerializable("orderObject");


    }

    public static void sendOrderObjectToNextActivity(Intent intent,Order order){
        intent.putExtra("orderObject", order);
    }

    public static Order getRawOrder(){
        //returns and order object for testing any UI.
        Order mOrder = new Order();
        mOrder.price="9999/_";
        mOrder.CustomerId="1111-111-11-111";
        mOrder.ServiceProviderType="model.Driver";
        mOrder.date="11-11-1111";
        mOrder.ServiceProviderName="XYZ";
        mOrder.address="Street ABC, XYZ Colony, City A , Country XYZ";
        mOrder.description="XYZ description";
        return mOrder;
    }

    public static enum OrderStatus{
        OnGoing,
        Cancelled,
        Completed
    }

}