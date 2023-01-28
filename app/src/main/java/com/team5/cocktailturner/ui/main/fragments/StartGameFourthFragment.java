package com.team5.cocktailturner.ui.main.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.team5.cocktailturner.R;

import java.util.ArrayList;

public class StartGameFourthFragment extends Fragment {

    private static ArrayList<String> liquidData;

    private static ArrayList<String> ingredientsData;

    private static ArrayList<String> seasoningData;


    public StartGameFourthFragment() {
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
            liquidData = bundle.getStringArrayList("liquidData");
            ingredientsData = bundle.getStringArrayList("ingredientsData");
            seasoningData = bundle.getStringArrayList("seasoningData");
        }
        return inflater.inflate(R.layout.fragment_startgame_fourth, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button button = view.findViewById(R.id.start_game_button);
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
