package com.team5.cocktailturner.ui.main.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.team5.cocktailturner.R;

import java.util.ArrayList;
import java.util.Random;


public class MixCocktailSixthFragment extends Fragment {

    public MixCocktailSixthFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            ArrayList<String> liquidData = bundle.getStringArrayList("liquidData");
            ArrayList<String> randomIngredientsData = bundle.getStringArrayList("randomIngredientsData");
            ArrayList<String> seasoningData = bundle.getStringArrayList("seasoningData");
            //todo remove
            System.out.println("leeel6 " + liquidData);
            System.out.println("leeel6 " + randomIngredientsData);
            System.out.println("leeel6 " + seasoningData);

            Random r = new Random();
            liquidText = liquidData.get(r.nextInt(liquidData.size()));
            r = new Random();
            randomText = randomIngredientsData.get(r.nextInt(randomIngredientsData.size()));
            r = new Random();
            seasoningText = seasoningData.get(r.nextInt(seasoningData.size()));

            System.out.println("liquid: " + liquidText + " random: " +  randomText + " seasoning: " + seasoningText);
        }
        return inflater.inflate(R.layout.fragment_mixcocktail_sixth, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView liquid = (TextView) view.findViewById(R.id.alcoholIngredient);
        TextView random = (TextView) view.findViewById(R.id.randomIngredient);
        TextView seasoning = (TextView) view.findViewById(R.id.seasoningIngredient);

        liquid.setText(liquidText);
        random.setText(randomText);
        seasoning.setText(seasoningText);
    }
}