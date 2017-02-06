package com.ikwala.crimeintent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends Fragment
{
    RecyclerView rvCrimeList;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_crime_list, container, false);

        rvCrimeList = (RecyclerView)v.findViewById(R.id.rvCrimeList);
        rvCrimeList.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }

}
