package com.team5.cocktailturner.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.team5.cocktailturner.R;

import java.util.ArrayList;
import java.util.Random;


public class MixCocktailSixthFragment extends Fragment {


    private static String liquidText;

    private static String randomText;

    private static String seasoningText;

    private static ArrayList<String> liquidData;

    private static ArrayList<String> ingredientsData;

    private static ArrayList<String> seasoningData;


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
            ArrayList<String> ingredientsData = bundle.getStringArrayList("ingredientsData");
            ArrayList<String> seasoningData = bundle.getStringArrayList("seasoningData");

            Random random = new Random();
            liquidText = liquidData.get(random.nextInt(liquidData.size()));
            random = new Random();
            randomText = ingredientsData.get(random.nextInt(ingredientsData.size()));
            random = new Random();
            seasoningText = seasoningData.get(random.nextInt(seasoningData.size()));
        }
        return inflater.inflate(R.layout.fragment_mixcocktail_sixth, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView liquid = view.findViewById(R.id.alcoholIngredient);
        TextView random = view.findViewById(R.id.randomIngredient);
        TextView seasoning = view.findViewById(R.id.seasoningIngredient);

        liquid.setText(liquidText);
        random.setText(randomText);
        seasoning.setText(seasoningText);

        Button button = view.findViewById(R.id.playAgainBtn);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Fragment bottleFifthFragment = new BottleFifthFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle arguments = new Bundle();
                arguments.putStringArrayList( "liquidData" , liquidData);
                arguments.putStringArrayList( "ingredientsData" , ingredientsData);
                arguments.putStringArrayList( "seasoningData" , seasoningData);
                bottleFifthFragment.setArguments(arguments);
                transaction.replace(R.id.container, bottleFifthFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}