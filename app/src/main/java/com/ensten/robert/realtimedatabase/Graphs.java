package com.ensten.robert.realtimedatabase;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Robert on 10/04/2017.
 */

public class Graphs extends Fragment {

    private TextView tTarjetas, tBuscadores, tRedesSociales, tBoca, tLocalizacion,tOtros;

    String [] data={"0","0","0","0","0","0"};

    DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mBuscadoresRef = mRootRef.child("buscadores");
    DatabaseReference mTarjetasRef = mRootRef.child("tarjetas");
    DatabaseReference mRedesRef = mRootRef.child("redes");
    DatabaseReference mBocaRef = mRootRef.child("boca");
    DatabaseReference mLocalizacionRef = mRootRef.child("localizacion");
    DatabaseReference mOtrosRef = mRootRef.child("otros");
    PieChart pieChart;

    public Graphs() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment2_graph, container, false);

        tBuscadores = (TextView) rootView.findViewById(R.id.textViewBuscadores);
        tTarjetas = (TextView) rootView.findViewById(R.id.textViewTarjetas);
        tRedesSociales = (TextView) rootView.findViewById(R.id.textViewRedesSociales);
        tBoca = (TextView) rootView.findViewById(R.id.textViewBoca);
        tLocalizacion = (TextView) rootView.findViewById(R.id.textViewLocalizacion);
        tOtros = (TextView) rootView.findViewById(R.id.textViewOtros);
        pieChart = (PieChart) rootView.findViewById(R.id.piechartId);



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
                data[0]=text;
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
                data[1]=text;
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
                data[2]=text;
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
                data[3]=text;
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
                data[4]=text;
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
                data[5]=text;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        mRootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                addEntries();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    protected void addEntries(){
        ArrayList<Entry> entries = new ArrayList<>();

        for (int i =0; i<data.length;i++) {

            // turn your data into Entry objects
            entries.add(new BarEntry(Integer.parseInt(data[i]), i));
        }
        PieDataSet dataset = new PieDataSet(entries,"");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Buscadores");
        labels.add("Tarjetas");
        labels.add("Redes Sociales");
        labels.add("Boca a Boca");
        labels.add("Localización");
        labels.add("Otros");

        PieData data = new PieData(labels, dataset);
        dataset.setColors(ColorTemplate.PASTEL_COLORS);
        pieChart.setData(data);
        pieChart.notifyDataSetChanged(); // let the chart know it's data changed
        pieChart.invalidate(); // refresh
        pieChart.notifyDataSetChanged();
    }

}