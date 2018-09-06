package com.papakci.software.dokunogren.Application;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.Nullable;

import com.papakci.software.dokunogren.R;

/**
 * Created by erenpapakci on 27/01/2018.
 */

public class PreferencePage extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        //addPreferencesFromResource(R.xml.prefs);
    }
}
