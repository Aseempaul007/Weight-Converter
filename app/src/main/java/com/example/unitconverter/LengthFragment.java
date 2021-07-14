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

public class LengthFragment extends Fragment {

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

        View view = inflater.inflate(R.layout.fragment_length, container, false);

        btn1 = view.findViewById(R.id.button);
        et1 = view.findViewById(R.id.editText1);
        tv1 = view.findViewById(R.id.textView2);
        spinner1 = view.findViewById(R.id.spinner1);
        spinner2 = view.findViewById(R.id.spinner2);

        ArrayList<String> name = new ArrayList<String>();
        name.add("Select Unit");
        name.add("feet");
        name.add("inch");
        name.add("centimeter");
        name.add("meter");
        name.add("milimeter");
        name.add("kilometer");

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
                        String s = String.format("%.2f", feetToInch(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", feetToCm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", feetToM(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", feetToMm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==1 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", feetToKm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    //////////////////////////////////////////////////////////////////////

                    else if(spr1==2 && spr2==2){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", InchToFeet(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", InchToCm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", InchToM(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", InchToMm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==2 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", InchToKm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    /////////////////////////////////////////////////////////////

                    else if(spr1==3 && spr2==3){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", CmToFeet(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", CmToInch(temp));
                        tv1.setText(s+" "+name.get(spr2));                    }else if(spr1==3 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", CmToM(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", CmToMm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==3 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", CmToKm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    ///////////////////////////////////////////////////////

                    else if(spr1==4 && spr2==4){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MToFeet(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MToInch(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MToCm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MToMm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==4 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MToKm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    /////////////////////////////////////////////////////////////////////

                    else if(spr1==5 && spr2==5){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MmToFeet(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MmToInch(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MmToCm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MmToM(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==5 && spr2==6){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", MmToKm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }

                    /////////////////////////////////////////////////

                    else if(spr1==6 && spr2==6){
                        tv1.setText(et1.getText().toString()+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==1){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KmToFeet(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==2){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KmToInch(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==3){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KmToCm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==4){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KmToM(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }else if(spr1==6 && spr2==5){
                        double temp = Double.parseDouble(et1.getText().toString());
                        String s = String.format("%.2f", KmToMm(temp));
                        tv1.setText(s+" "+name.get(spr2));
                    }
                }
            }
        });


        return view;
    }

    public static double feetToInch(double num){
        double ans=0;
        ans=(double) num*12;
        return ans;
    }

    public static double feetToCm(double num){
        double ans=0;
        ans=(double) num*30.48;
        return ans;
    }

    public static double feetToM(double num){
        double ans=0;
        ans=(double) num/3.281;
        return ans;
    }

    public static double feetToMm(double num){
        double ans=0;
        ans=(double) num*305;
        return ans;
    }

    public static double feetToKm(double num){
        double ans=0;
        ans=(double) num/305;
        return ans;
    }

    ///////////////////////////////////////////////////////////////////////////////


    public static double InchToFeet(double num){
        double ans=0;
        ans=(double) num/12;
        return ans;
    }

    public static double InchToCm(double num){
        double ans=0;
        ans=(double) num*2.54;
        return ans;
    }

    public static double InchToM(double num){
        double ans=0;
        ans=(double) num/39.37;
        return ans;
    }

    public static double InchToMm(double num){
        double ans=0;
        ans=(double) num*25.4;
        return ans;
    }

    public static double InchToKm(double num){
        double ans=0;
        ans=(double) num/39370;
        return ans;
    }

    /////////////////////////////////////////////////////////////////////////////


    public static double CmToFeet(double num){
        double ans=0;
        ans=(double) num/30.48;
        return ans;
    }

    public static double CmToInch(double num){
        double ans=0;
        ans=(double) num/2.54;
        return ans;
    }

    public static double CmToM(double num){
        double ans=0;
        ans=(double) num/100;
        return ans;
    }

    public static double CmToMm(double num){
        double ans=0;
        ans=(double) num*10;
        return ans;
    }

    public static double CmToKm(double num){
        double ans=0;
        ans=(double) num/100000;
        return ans;
    }

    ////////////////////////////////////////////////////////////////////


    public static double MToFeet(double num){
        double ans=0;
        ans=(double) num*3.281;
        return ans;
    }

    public static double MToInch(double num){
        double ans=0;
        ans=(double) num*39.37;
        return ans;
    }

    public static double MToCm(double num){
        double ans=0;
        ans=(double) num/100;
        return ans;
    }

    public static double MToMm(double num){
        double ans=0;
        ans=(double) num*1000;
        return ans;
    }

    public static double MToKm(double num){
        double ans=0;
        ans=(double) num/1000;
        return ans;
    }

    ////////////////////////////////////////////////////////////////


    public static double MmToFeet(double num){
        double ans=0;
        ans=(double) num/305;
        return ans;
    }

    public static double MmToInch(double num){
        double ans=0;
        ans=(double) num/25.4   ;
        return ans;
    }

    public static double MmToCm(double num){
        double ans=0;
        ans=(double) num/10;
        return ans;
    }

    public static double MmToM(double num){
        double ans=0;
        ans=(double) num/1000;
        return ans;
    }

    public static double MmToKm(double num){
        double ans=0;
        ans=(double) num/1000000;
        return ans;
    }

    /////////////////////////////////////////////////////////////////

    public static double KmToFeet(double num){
        double ans=0;
        ans=(double) num/305;
        return ans;
    }

    public static double KmToInch(double num){
        double ans=0;
        ans=(double) num/25.4   ;
        return ans;
    }

    public static double KmToCm(double num){
        double ans=0;
        ans=(double) num/10;
        return ans;
    }

    public static double KmToM(double num){
        double ans=0;
        ans=(double) num/1000;
        return ans;
    }

    public static double KmToMm(double num){
        double ans=0;
        ans=(double) num/1000000;
        return ans;
    }
}