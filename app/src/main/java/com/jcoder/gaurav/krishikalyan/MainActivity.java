package com.jcoder.gaurav.krishikalyan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView enText;
    TextView hiText;
    TextView gjText;

    private static final String Locale_Preference = "Locale Preference";
    private static final String Locale_KeyValue = "Saved Locale";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init()
    {
        enText = (TextView)findViewById(R.id.English_text);
        hiText = (TextView)findViewById(R.id.Hindi_text);
        gjText = (TextView)findViewById(R.id.Gujarati_text);
        enText.setOnClickListener(this);
        hiText.setOnClickListener(this);
        gjText.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        String lang = "en";//Default language
        switch (view.getId())
        {
            case R.id.English_text:
                lang = "en";
                break;
            case  R.id.Hindi_text:
                lang = "hi";
                break;
            case R.id.Gujarati_text:
                lang = "gj";
                break;
        }

        changeLocale(lang);//change locale on selection basis
        Intent i = new Intent(MainActivity.this, Login.class);
        startActivity(i);
    }

    //changeLocale method
    //important for changing selected language.
    public void changeLocale(String lang)
    {
        if(lang.equalsIgnoreCase(""))
            return;
        Locale myLocale = new Locale(lang);//set selected Locale
        Locale.setDefault(myLocale);//set new locale as default
        Configuration config = new Configuration();//get Configuration
        config.locale = myLocale;//set config locale as selected locale
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());//update the config
        //updateTexts();
    }

    //save locale method in preferences
    public void saveLocale(String lang)
    {
        editor.putString(Locale_KeyValue, lang);
        editor.commit();
    }

    //get locale method in preferences
    public void landLocale()
    {
        String language = sharedPreferences.getString(Locale_KeyValue,"");
        changeLocale(language);
    }

}
