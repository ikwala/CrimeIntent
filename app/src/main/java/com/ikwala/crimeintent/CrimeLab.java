package com.ikwala.crimeintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ikwala on 2/6/17.
 */
public class CrimeLab
{
    private static CrimeLab crimeLab;

    private List<Crime> crimeList;


    private CrimeLab(Context context)
    {
        crimeList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
        {
            Crime crime = new Crime();
            crime.setTitle("Crime # " + i);
            crime.setSolved(i % 2 == 0);
            crimeList.add(crime);
        }
    }

    public static CrimeLab get(Context context)
    {
        if (crimeLab == null)
        {
            crimeLab = new CrimeLab(context);
        }

        return crimeLab;

    }

    public List<Crime> getCrimeList()
    {
        return crimeList;
    }

    public Crime getCrime(UUID id)
    {
        for (Crime crime : crimeList)
        {
            if (crime.getId().equals(id))
            {
                return crime;
            }
        }

        return null;
    }
}
