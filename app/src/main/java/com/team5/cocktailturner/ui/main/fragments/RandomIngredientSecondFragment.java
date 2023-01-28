package com.team5.cocktailturner.ui.main.fragments;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.team5.cocktailturner.R;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;

public class RandomIngredientSecondFragment extends Fragment {


    private static ArrayList<String> liquidData;

    public RandomIngredientSecondFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            liquidData = bundle.getStringArrayList("liquidData");
        }
        return inflater.inflate(R.layout.fragment_randomingredient_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button button = (Button) view.findViewById(R.id.random_ingredient_next_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editField = (EditText) view.findViewById(R.id.randomIngredient1);
                String editText = "";
                editText = editField.getText().toString();
                if (editText.matches("")) {
                    Toast.makeText(getActivity(),
                            "first ingredient is required",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                Resources r = getResources();
                String name = getActivity().getPackageName();
                ArrayList<String> randomIngredientsData = new ArrayList<>();
                for (int i = 1; i< 7; i++) {
                    EditText randomIngredient = view.findViewById(r.getIdentifier("randomIngredient" + i, "id", name));
                    String randomIngredientText = String.valueOf(randomIngredient.getText());
                    if (StringUtils.isNotEmpty(randomIngredientText)) {
                        randomIngredientsData.add(randomIngredientText);
                    }
                }

                Fragment seasoningThirdFragment = new SeasoningThirdFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle arguments = new Bundle();
                arguments.putStringArrayList( "liquidData" , liquidData);
                arguments.putStringArrayList( "randomIngredientsData" , randomIngredientsData);
                seasoningThirdFragment.setArguments(arguments);
                transaction.replace(R.id.container, seasoningThirdFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}