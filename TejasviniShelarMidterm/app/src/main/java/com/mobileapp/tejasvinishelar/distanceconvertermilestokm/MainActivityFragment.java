package com.mobileapp.tejasvinishelar.distanceconvertermilestokm;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    Button distanceConvertButton;
    TextView kilometerText;
    EditText milesText;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView =  inflater.inflate(R.layout.fragment_main, container, false);

        distanceConvertButton=(Button) fragmentView.findViewById(R.id.button);
        kilometerText =(TextView) fragmentView.findViewById(R.id.textView2);
        milesText = (EditText)fragmentView.findViewById(R.id.editText2);

        distanceConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Double usd = Double.parseDouble(milesText.getText().toString());
                    Double result = usd * 1.609;
                    kilometerText.setText("Kilometer : "+Double.toString(result));
                }catch (Exception e){

                }
            }
        });


        return fragmentView;
    }
}
