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

import com.team5.cocktailturner.R;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RandomIngredientSecondFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RandomIngredientSecondFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static ArrayList<String> liquidData;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RandomIngredientSecondFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment IngredientSecondFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RandomIngredientSecondFragment newInstance(String param1, String param2) {
        RandomIngredientSecondFragment fragment = new RandomIngredientSecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            liquidData = bundle.getStringArrayList("liquidData");
            //todo remove
            System.out.println("leeel2 " + liquidData);
        }
        return inflater.inflate(R.layout.fragment_randomingredient_second, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button button = (Button) view.findViewById(R.id.random_ingredient_next_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
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