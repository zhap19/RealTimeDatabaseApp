package com.ensten.robert.realtimedatabase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.ensten.robert.realtimedatabase.R.id.buscadores;

/**
 * Created by Robert on 05/04/2017.
 */

public class AddClients extends Fragment {

    //int[] buttons = {R.id.buscadores, R.id.tarjetas, R.id.sociales, R.id.boca, R.id.localización, R.id.otros};
    //String[] toasts = {"Buscadores +1", "Tarjetas +1", "Redes Sociales +1","Boca a boca +1", "Localización +1", "Otros +1"};

    private Button btnBuscadores, btnTarjetas, btnLocalizacion, btnRedes, btnBoca, btnOtros;

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mBuscadoresRef = mRootRef.child("buscadores");
    DatabaseReference mTarjetasRef = mRootRef.child("tarjetas");
    DatabaseReference mRedesRef = mRootRef.child("redes");
    DatabaseReference mBocaRef = mRootRef.child("boca");
    DatabaseReference mLocalizacionRef = mRootRef.child("localizacion");
    DatabaseReference mOtrosRef = mRootRef.child("otros");
    String[] auxStrings={"buscador","tarjeta","redes","boca","localizacion","otros"};

    public AddClients() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1_add_client, container, false);

        for (int i = 0;i<auxStrings.length;i++){
            auxStrings[i] = "0";
        }

        /*for (int i = 0; i < buttons.length; i++) {
            Button buttonNum = (Button) rootView.findViewById(buttons[i]);
            setOnClick(buttonNum, toasts[i]);

        }*/

        btnBuscadores = (Button) rootView.findViewById(buscadores);
        btnBoca = (Button) rootView.findViewById(R.id.boca);
        btnLocalizacion = (Button) rootView.findViewById(R.id.localización);
        btnRedes = (Button) rootView.findViewById(R.id.sociales);
        btnTarjetas = (Button) rootView.findViewById(R.id.tarjetas);
        btnOtros = (Button) rootView.findViewById(R.id.otros);


        return rootView;
    }

    /*public void setOnClick(final Button btn, final String str) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast1 = Toast.makeText(getContext(), str, Toast.LENGTH_SHORT);
                toast1.show();
            }
        });
    }*/

    @Override
    public void onStart(){
        super.onStart();

        mBuscadoresRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                auxStrings[0]=text;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnBuscadores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(auxStrings[0]);
                String total = ""+(numero+1);
                mBuscadoresRef.setValue(total);

                Toast toast1 = Toast.makeText(getContext(), "Buscadores: "+(Integer.parseInt(auxStrings[0])+1), Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        mTarjetasRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                auxStrings[1]=text;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnTarjetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(auxStrings[1]);
                String total = ""+(numero+1);
                mTarjetasRef.setValue(total);

                Toast toast1 = Toast.makeText(getContext(), "Tarjetas: "+(Integer.parseInt(auxStrings[1])+1), Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        mRedesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                auxStrings[2]=text;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnRedes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(auxStrings[2]);
                String total = ""+(numero+1);
                mRedesRef.setValue(total);

                Toast toast1 = Toast.makeText(getContext(), "Redes Sociales: "+(Integer.parseInt(auxStrings[2])+1), Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        mBocaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                auxStrings[3]=text;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnBoca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(auxStrings[3]);
                String total = ""+(numero+1);
                mBocaRef.setValue(total);

                Toast toast1 = Toast.makeText(getContext(), "Boca a boca: "+(Integer.parseInt(auxStrings[3])+1), Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        mLocalizacionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                auxStrings[4]=text;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnLocalizacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(auxStrings[4]);
                String total = ""+(numero+1);
                mLocalizacionRef.setValue(total);

                Toast toast1 = Toast.makeText(getContext(), "Localizacion: "+(Integer.parseInt(auxStrings[4])+1), Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

        mOtrosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                auxStrings[5]=text;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnOtros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numero = Integer.parseInt(auxStrings[5]);
                String total = ""+(numero+1);
                mOtrosRef.setValue(total);

                Toast toast1 = Toast.makeText(getContext(), "Otros: "+(Integer.parseInt(auxStrings[5])+1), Toast.LENGTH_SHORT);
                toast1.show();
            }
        });

    }
}