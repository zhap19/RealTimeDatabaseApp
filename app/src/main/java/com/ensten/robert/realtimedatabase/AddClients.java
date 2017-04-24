package com.ensten.robert.realtimedatabase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Robert on 05/04/2017.
 */

public class AddClients extends Fragment {

    int[] buttons = {R.id.buscadores, R.id.tarjetas, R.id.sociales, R.id.boca, R.id.localización, R.id.otros};
    String[] toasts = {"Buscadores +1", "Tarjetas +1", "Redes Sociales +1", "Boca a boca +1", "Localización +1", "Otros +1"};


    public AddClients() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1_add_client, container, false);

        for (int i = 0; i < buttons.length; i++) {
            Button buttonNum = (Button) rootView.findViewById(buttons[i]);
            setOnClick(buttonNum, toasts[i]);

        }
        return rootView;
    }

    public void setOnClick(final Button btn, final String str) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast1 = Toast.makeText(getContext(), str, Toast.LENGTH_SHORT);
                toast1.show();
            }
        });
    }
}