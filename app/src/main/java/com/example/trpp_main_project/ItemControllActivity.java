package com.example.trpp_main_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ItemControllActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<SmartItem> itemList; // Замените тип данных на свой

    private int rows = 12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_controll);

        recyclerView = findViewById(R.id.center_layout);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>(); // Инициализируйте список элементов
        for (int i = 0; i < rows; i++) {
            itemList.add(new SmartItem("Item " + i)); // Добавьте в список фиктивные элементы
        }

        adapter = new ItemAdapter(itemList); // Создайте адаптер для списка элементов
        recyclerView.setAdapter(adapter);
    }
}