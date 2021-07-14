package com.example.unitconverter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class WeightFragment extends Fragment {


    EditText et1;
    Spinner spinner1;
    Spinner spinner2;

    Button btn1;
    TextView tv1;

    String input1="";
    int spr1=0,spr2=0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weight, container, false);
        btn1 = view.findViewById(R.id.button);
        et1 = view.findViewById(R.id.editText1);
        tv1 = view.findViewById(R.id.textView2);
        spinner1 = view.findViewById(R.id.spinner1);
        spinner2 = view.findViewById(R.id.spinner2);

        ArrayList<String> name = new ArrayList<String>();
        name.add("Select Unit");
        name.add("kilogram");
        name.add("gram");
        name.add("quintal");
        name.add("ton");
        name.add("tola");
        name.add("mg");
        name.add("pound");
        name.add("carrot");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(getContext(),
                R.layout.snipper_item,name);



        spinner1.setAdapter(myAdapter);
        spinner2.setAdapter(myAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i1, long l) {
                spinner1.setSelection(i1);
                spr1=i1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinner2.setSelection(i);
                spr2=i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input1 = et1.getText().toString();

                if(input1.matches("")){
                    Toast.makeText(getContext(),
                            "Please enter values",
                            Toast.LENGTH_SHORT).show();
                }else{
                    if(spr1==0 || spr2==0){
                        Toast.makeText(getContext(),
                                "Select both units",
                                Toast.LENGTH_SHORT).show();
                    }else if(spr1==1 && spr2==1){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KgToG(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KgToQuintal(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KgToTon(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KgToTola(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KgToMg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==7){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KgToPound(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==8){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KgToCarrot(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    //////////////////////////////////////////////////////////////////////

                    else if(spr1==2 && spr2==2){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", GToKg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", GToQuintal(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", GToTon(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", GToTola(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", GToMg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==7){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", GToPound(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==8){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", GToCarrot(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    /////////////////////////////////////////////////////////////

                    else if(spr1==3 && spr2==3){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", QuintalToKg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", QuintalToG(temp));
                        tv1.setText(s+" "+name.get(spr2));                    }else if(spr1==3 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", QuintalToTon(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", QuintalToTola(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", QuintalToMg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==7){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", QuintalToPound(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==8){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", QuintalToCarrot(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    ///////////////////////////////////////////////////////

                    else if(spr1==4 && spr2==4){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TonToKg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TonToG(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TonToQuintal(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TonToTola(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TonToMg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==7){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TonToPound(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==8){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TonToCarrot(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    /////////////////////////////////////////////////////////////////////

                    else if(spr1==5 && spr2==5){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TolaToKg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TolaToG(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TolaToQuintal(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TolaToTon(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TolaToMg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==7){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TolaToPound(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==8){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", TolaToCarrot(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    /////////////////////////////////////////////////

                    else if(spr1==6 && spr2==6){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToKg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToG(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToQuintal(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToTon(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToTola(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==7){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToPound(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==8){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToCarrot(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    /////////////////////////////////////////////////////////////////////////////

                    else if(spr1==7 && spr2==7){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==7 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToKg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==7 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToG(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==7 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToQuintal(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==7 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToTon(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==7 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToTola(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==7 && spr2==7){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToPound(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==7 && spr2==8){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToCarrot(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    /////////////////////////////////////////////////////////////////////

                    else if(spr1==8 && spr2==8){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==8 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToKg(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==8 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToG(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==8 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToQuintal(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==8 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToTon(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==8 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToTola(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==8 && spr2==7){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToPound(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==8 && spr2==8){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MgToCarrot(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }
                }
            }
        });

        return view;
    }

    public static double KgToG(double mass){
        double ans=0;
        ans=(double) mass*1000;
        return ans;
    }

    public static double KgToQuintal(double mass){
        double ans=0;
        ans=(double) mass/100;
        return ans;
    }

    public static double KgToTon(double mass){
        double ans=0;
        ans=(double) mass/907;
        return ans;
    }

    public static double KgToTola(double mass){
        double ans=0;
        ans=(double) mass*85.76;
        return ans;
    }

    public static double KgToMg(double mass){
        double ans=0;
        ans=(double) mass*1000000;
        return ans;
    }

    public static double KgToPound(double mass){
        double ans=0;
        ans=(double) mass*2.20462;
        return ans;
    }

    public static double KgToCarrot(double mass){
        double ans=0;
        ans=(double) mass*7;
        return ans;
    }

    ///////////////////////////////////////////////////////////////////////////////


    public static double GToKg(double mass){
        double ans=0;
        ans=(double) mass/1000;
        return ans;
    }

    public static double GToQuintal(double mass){
        double ans=0;
        ans=(double) mass/100000;
        return ans;
    }

    public static double GToTon(double mass){
        double ans=0;
        ans=(double) mass/907185;
        return ans;
    }

    public static double GToTola(double mass){
        double ans=0;
        ans=(double) mass*11.66 ;
        return ans;
    }

    public static double GToMg(double mass){
        double ans=0;
        ans=(double) mass*1000;
        return ans;
    }

    public static double GToPound(double mass){
        double ans=0;
        ans=(double) mass/454;
        return ans;
    }

    public static double GToCarrot(double mass){
        double ans=0;
        ans=(double) mass*5;
        return ans;
    }

    /////////////////////////////////////////////////////////////////////////////


    public static double QuintalToKg(double mass){
        double ans=0;
        ans=(double) mass*100;
        return ans;
    }

    public static double QuintalToG(double mass){
        double ans=0;
        ans=(double) mass*100000;
        return ans;
    }

    public static double QuintalToTon(double mass){
        double ans=0;
        ans=(double) mass/9.072;
        return ans;
    }

    public static double QuintalToTola(double mass){
        double ans=0;
        ans=(double) mass*0.00023828013278856;
        return ans;
    }

    public static double QuintalToMg(double mass){
        double ans=0;
        ans=(double) mass*100000000;
        return ans;
    }

    public static double QuintalToPound(double mass){
        double ans=0;
        ans=(double) mass*220.462;
        return ans;
    }

    public static double QuintalToCarrot(double mass){
        double ans=0;
        ans=(double) mass*244750;
        return ans;
    }

    ////////////////////////////////////////////////////////////////////doen


    public static double TonToKg(double mass){
        double ans=0;
        ans=(double) mass*907;
        return ans;
    }

    public static double TonToG(double mass){
        double ans=0;
        ans=(double) mass*907185;
        return ans;
    }

    public static double TonToQuintal(double mass){
        double ans=0;
        ans=(double) mass*9.072;
        return ans;
    }

    public static double TonToTola(double mass){
        double ans=0;
        ans=(double) mass*85735.260233307;
        return ans;
    }

    public static double TonToMg(double mass){
        double ans=0;
        ans=(double) mass*907200000;
        return ans;
    }

    public static double TonToPound(double mass){
        double ans=0;
        ans=(double) mass*2000;
        return ans;
    }

    public static double TonToCarrot(double mass){
        double ans=0;
        ans=(double) mass*4536000;
        return ans;
    }

    ////////////////////////////////////////////////////////////////done


    public static double TolaToKg(double mass){
        double ans=0;
        ans=(double) mass*0.01166;
        return ans;
    }

    public static double TolaToG(double mass){
        double ans=0;
        ans=(double) mass*11.6;
        return ans;
    }

    public static double TolaToQuintal(double mass){
        double ans=0;
        ans=(double) mass*0.0001166;
        return ans;
    }

    public static double TolaToTon(double mass){
        double ans=0;
        ans=(double) mass*0.00001166;
        return ans;
    }

    public static double TolaToMg(double mass){
        double ans=0;
        ans=(double) mass*11660;
        return ans;
    }

    public static double TolaToPound(double mass){
        double ans=0;
        ans=(double) mass*0.02570694087;
        return ans;
    }

    public static double TolaToCarrot(double mass){
        double ans=0;
        ans=(double) mass*56.842;
        return ans;
    }

    /////////////////////////////////////////////////////////////////done

    public static double MgToKg(double mass){
        double ans=0;
        ans=(double) mass/1000000;
        return ans;
    }

    public static double MgToG(double mass){
        double ans=0;
        ans=(double) mass/1000;
        return ans;
    }

    public static double MgToQuintal(double mass){
        double ans=0;
        ans=(double) mass/100000000;
        return ans;
    }

    public static double MgToTon(double mass){
        double ans=0;
        ans=(double) mass/907200000;
        return ans;
    }

    public static double MgToTola(double mass){
        double ans=0;
        ans=(double) mass*0.000085763293310463;
        return ans;
    }

    public static double MgToPound(double mass){
        double ans=0;
        ans=(double) mass/453592;
        return ans;
    }

    public static double MgToCarrot(double mass){
        double ans=0;
        ans=(double) mass/200;
        return ans;
    }
}