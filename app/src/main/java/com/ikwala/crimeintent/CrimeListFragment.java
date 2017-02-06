package com.ikwala.crimeintent;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends Fragment
{
    RecyclerView rvCrimeList;
    CrimeAdaptor crimeAdaptor;


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
        List<Crime> crimeList = CrimeLab.get(getActivity()).getCrimeList();
        crimeAdaptor = new CrimeAdaptor(crimeList);
        rvCrimeList.setAdapter(crimeAdaptor);

        return v;
    }

    private class CrimeHolder extends RecyclerView.ViewHolder
    {
        Crime crime;
        private TextView tvCrimeTitle;
        private TextView tvCrimeDate;

        public CrimeHolder(LayoutInflater inflater, ViewGroup parent)
        {
            super(inflater.inflate(R.layout.item_crime_list, parent, false));

            tvCrimeDate = (TextView)itemView.findViewById(R.id.tvCrimeDate);
            tvCrimeTitle = (TextView)itemView.findViewById(R.id.tvCrimeTitle);
        }

        public void bind(Crime crime)
        {
            this.crime = crime;
            tvCrimeTitle.setText(crime.getTitle());
            tvCrimeDate.setText(crime.getDate().toString());
        }
    }

    private class CrimeAdaptor extends RecyclerView.Adapter<CrimeHolder>
    {
        private List<Crime> crimeList;

        public CrimeAdaptor(List<Crime> crimeList)
        {
            this.crimeList = crimeList;
        }

        @Override
        public CrimeHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            LayoutInflater inflater = LayoutInflater.from(getActivity());

            return new CrimeHolder(inflater,parent);
        }

        @Override
        public void onBindViewHolder(CrimeHolder holder, int position)
        {
            Crime crime = crimeList.get(position);
            holder.bind(crime);
        }

        @Override
        public int getItemCount()
        {
            return crimeList.size();
        }
    }

}
