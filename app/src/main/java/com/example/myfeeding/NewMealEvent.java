package com.example.myfeeding;

public class NewMealEvent {
    private Meal meal;

    public NewMealEvent(Meal meal) {
        this.meal = meal;
    }

    public Meal getMeal() {
        return meal;
    }
}
