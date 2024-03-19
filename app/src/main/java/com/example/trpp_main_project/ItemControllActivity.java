package com.example.trpp_main_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ItemControllActivity extends AppCompatActivity {

    private ArrayList<Integer> imagesArray = new ArrayList<>();
    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<SmartItem> itemList;
    LinearLayout drawerPanel;
    DrawerLayout drawerLayout;

    private int rows = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_controll);


        drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
                recyclerView.bringToFront();
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });

        drawerPanel = findViewById(R.id.drawer_panel);
        Random random = new Random();


        Resources res = getResources();
        imagesArray.add(res.getIdentifier("temperature_svgrepo_com", "drawable", getPackageName()));
        imagesArray.add(res.getIdentifier("ventilation_svgrepo_com", "drawable", getPackageName()));


        recyclerView = findViewById(R.id.center_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>(); // Инициализируйте список элементов
        for (int i = 0; i < rows; i++) {
            itemList.add(new SmartItem("Item " + i, imagesArray.get(random.nextInt(imagesArray.size())))); // Добавьте в список фиктивные элементы
        }

        adapter = new ItemAdapter(itemList); // Создайте адаптер для списка элементов
        recyclerView.setAdapter(adapter);
        recyclerView.getLayoutParams().width = ((View) recyclerView.getParent()).getWidth() - 25;
        recyclerView.bringToFront();
    }

    public void SelectItem(View view){
        Log.e("DEB", "BTN WORK 1");

        OpenSmartItem(view);
    }

    private void OpenSmartItem(View view){
        Log.e("DEB", "BTN WORK 2");

        SmartItem smartItem = null;
        RecyclerView recyclerView = findViewById(R.id.center_layout);
        RecyclerView.ViewHolder viewHolder = recyclerView.findContainingViewHolder(view);
        int position = viewHolder.getAdapterPosition();
        if (position != RecyclerView.NO_POSITION) {
            smartItem = itemList.get(position);
        }
        SeenMenu(smartItem);
    }

    private void SeenMenu(SmartItem smartItem){
        Log.e("DEB", "BTN WORK 3");

        drawerLayout.openDrawer(drawerPanel);
        drawerLayout.bringToFront();
        //Тут нужно выводить инфу
    }
}