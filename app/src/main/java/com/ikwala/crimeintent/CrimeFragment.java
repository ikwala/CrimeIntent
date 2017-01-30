package com.ikwala.crimeintent;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import static android.widget.CompoundButton.*;

/**
 * Created by ikwala on 1/30/17.
 */

public class CrimeFragment extends android.support.v4.app.Fragment
{
    private EditText etCrimeTitle;
    private Button btnCrimeDate;
    private CheckBox cbCrimeSolved;

    private Crime crime;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        crime = new Crime();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_crime,container,false);
        etCrimeTitle = (EditText)v.findViewById(R.id.etCrimeTitle);
        etCrimeTitle.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                //No code here
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                crime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s)
            {
                //No text here
            }
        });

        btnCrimeDate = (Button)v.findViewById(R.id.btnCrimeDate);
        btnCrimeDate.setText(crime.getDate().toString());
        btnCrimeDate.setEnabled(false);

        cbCrimeSolved = (CheckBox)v.findViewById(R.id.cbCrimeSolved);
        cbCrimeSolved.setOnCheckedChangeListener(new OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                crime.setSolved(isChecked);
            }
        });


        return v;
    }
}
