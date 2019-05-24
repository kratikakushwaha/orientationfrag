package com.example.orientationfrag;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment2 extends Fragment {


    TextView t;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment2, container, false);
        t = v.findViewById(R.id.txtv);
        if (savedInstanceState == null) {
        }
        else

            {
            t.setText(savedInstanceState.getString("name"));

        }


        setRetainInstance(true);
        return v;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String onsave = t.getText().toString();
        outState.putString("name", onsave);


    }


    public void bridge(String str) {
        t.setText(str);
    }
}
