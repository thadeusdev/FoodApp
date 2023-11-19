package com.example.foodapp.Helper;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.foodapp.Activity.Domain.FoodDomain;
import com.example.foodapp.Interface.ChangeNumberItemsListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertFood(FoodDomain item) {
        ArrayList<FoodDomain> listFoods = getListCart();
                boolean existAlready=false;
                int n = 0;
                for (int i = 0; i < listFoods.size(); i++) {
                    if (listFoods.get(i).getTitle().equals(item.getTitle())) {
                        existAlready = true;
                        n = i;
                        break;
                    }
                }

                if (existAlready) {
                    listFoods.get(n).setNumberInCart(item.getNumberInCart());
                } else {
                    listFoods.add(item);
                }
                tinyDB.putListObject("CartList", listFoods);
//        Log.d("ManagementCart","Food inserted into the cart");
                Toast.makeText(context,"Added to Your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<FoodDomain> getListCart() {
        return tinyDB.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<FoodDomain> listFoods, int position, ChangeNumberItemsListener changeNumberItemsListener) {
        listFoods.get(position).setNumberInCart(listFoods.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CartList", listFoods);
        changeNumberItemsListener.changed();
    }

    public void minusNumberFood(ArrayList<FoodDomain> listFoods,int position,ChangeNumberItemsListener changeNumberItemsListener) {
        if(listFoods.get(position).getNumberInCart()==1) {
            listFoods.remove(position);
        } else {
            listFoods.get(position).setNumberInCart(listFoods.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CartList",listFoods);
        changeNumberItemsListener.changed();
    }

    public Double getTotalFee(){
        ArrayList<FoodDomain> listFoods=getListCart();
        double fee=0;
        for (int i=0; i<listFoods.size(); i++) {
            fee=fee+(listFoods.get(i).getFee()*listFoods.get(i).getNumberInCart());
        }
        return fee;
    }
}
