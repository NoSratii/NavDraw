package com.example.umangburman.navdrawerwithnavcomponent;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.Locale;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SecondFragment extends Fragment {

    RadioButton rd_fa;
    RadioButton rd_en;
    Button select;
    Context context;


    private static boolean updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Resources resources = context.getResources();
        Configuration configuration = resources.getConfiguration();
        configuration.locale = locale;

        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        return true;
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.second_fragment, container, false);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rd_fa = view.findViewById(R.id.btn_fa);
        rd_en = view.findViewById(R.id.btn_en);
        select = view.findViewById(R.id.btn_select);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (rd_fa.isChecked()){

                    rd_en.setEnabled(false);
                    String languageToLoad  = "fa";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    view.getContext().getResources().updateConfiguration(config,view.getContext().getResources().getDisplayMetrics());
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);


                }else if (rd_en.isChecked()){
                    rd_fa.setEnabled(false);
                    String languageToLoad  = "en";
                    Locale locale = new Locale(languageToLoad);
                    Locale.setDefault(locale);
                    Configuration config = new Configuration();
                    config.locale = locale;
                    view.getContext().getResources().updateConfiguration(config,view.getContext().getResources().getDisplayMetrics());
                    Intent intent = new Intent(view.getContext(), MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }

            }
        });
    }
}
