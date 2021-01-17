package com.example.myfeeding;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class AddMealFragment extends Fragment {
    private Meal meal;
    private List<Meal> meals;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        meals = JSONReader.get_meals_from_file(getContext(), "all_food.json");
        return inflater.inflate(R.layout.fragment_add_meal, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        CalendarView calendarView = view.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener((calendarView1, year, month, day) -> {
            //meal.setDate(year, month, day);
        });

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EventBus.getDefault().post(new NewMealEvent(meal));

                NavHostFragment.findNavController(AddMealFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        RecyclerView rvContacts = view.findViewById(R.id.list);
        MealsAdapter adapter = new MealsAdapter(meals);
        rvContacts.setAdapter(adapter);
        rvContacts.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}