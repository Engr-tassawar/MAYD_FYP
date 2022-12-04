package Utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import Model.DriverClass;
import Model.Order;

public class Common {
    public static Order getOrderObject(Activity context){
        Intent intent = context.getIntent();
        Order order = (Order) intent.getExtras().getSerializable("orderObject");
        return order;
    }

}