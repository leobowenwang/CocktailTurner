package com.team5.cocktailturner.ui.main.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.team5.cocktailturner.R;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SeasoningThirdFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeasoningThirdFragment extends Fragment {


    private static ArrayList<String> liquidData;

    private static ArrayList<String> ingredientsData;


    public SeasoningThirdFragment() {
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
        }
        return inflater.inflate(R.layout.fragment_seasoning_third, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Button button = view.findViewById(R.id.seasoning_next_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText editField = view.findViewById(R.id.seasoning1);
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
                ArrayList<String> seasoningData = new ArrayList<>();
                for (int i = 1; i< 7; i++) {
                    EditText seasoning = view.findViewById(r.getIdentifier("seasoning" + i, "id", name));
                    String seasoningText = String.valueOf(seasoning.getText());
                    if (StringUtils.isNotEmpty(seasoningText)) {
                        seasoningData.add(seasoningText);
                    }
                }

                Fragment startGameFourthFragment = new StartGameFourthFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                Bundle arguments = new Bundle();
                arguments.putStringArrayList( "liquidData" , liquidData);
                arguments.putStringArrayList( "ingredientsData" , ingredientsData);
                arguments.putStringArrayList( "seasoningData" , seasoningData);
                startGameFourthFragment.setArguments(arguments);
                transaction.replace(R.id.container, startGameFourthFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}