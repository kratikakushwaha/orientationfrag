package com.example.orientationfrag;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class Fragment1 extends Fragment {

EditText e1;
Button btn;
Set inter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_fragment1, container, false);

        e1=v.findViewById(R.id.edtxt);
        btn=v.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inter.send(e1.getText().toString());
            }
        });

        setRetainInstance(true);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
         inter= (Set) context;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String onsave=e1.getText().toString();
        outState.putString("name",onsave);
    }


    public interface Set
    {
        void send(String str);

    }

}
