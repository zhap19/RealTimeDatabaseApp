package com.ensten.robert.realtimedatabase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Robert on 10/04/2017.
 */

public class Graphs extends Fragment {

    private TextView tTarjetas, tBuscadores, tRedesSociales, tBoca, tLocalizacion,tOtros;


    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mBuscadoresRef = mRootRef.child("buscadores");
    DatabaseReference mTarjetasRef = mRootRef.child("tarjetas");
    DatabaseReference mRedesRef = mRootRef.child("redes");
    DatabaseReference mBocaRef = mRootRef.child("boca");
    DatabaseReference mLocalizacionRef = mRootRef.child("localizacion");
    DatabaseReference mOtrosRef = mRootRef.child("otros");

    public Graphs() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2_graph, container, false);

        tBuscadores =(TextView) rootView.findViewById(R.id.textViewBuscadores);
        tTarjetas =(TextView) rootView.findViewById(R.id.textViewTarjetas);
        tRedesSociales =(TextView) rootView.findViewById(R.id.textViewRedesSociales);
        tBoca =(TextView) rootView.findViewById(R.id.textViewBoca);
        tLocalizacion =(TextView) rootView.findViewById(R.id.textViewLocalizacion);
        tOtros =(TextView) rootView.findViewById(R.id.textViewOtros);

        

        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        mBuscadoresRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                tBuscadores.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mTarjetasRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                tTarjetas.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mRedesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                tRedesSociales.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mBocaRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                tBoca.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mLocalizacionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                tLocalizacion.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mOtrosRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                tOtros.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}