package com.example.englishtonepali;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class NepaliToEnglish extends AppCompatActivity {

    private ListView lstDictionary;
    private Map<String,String> dictionary;

    private static final String[] words={"Eta aaunus", "Come here"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nepali_to_english);

        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary = new HashMap<>();

        for (int i = 0; i< words.length; i +=2) {
            dictionary.put(words[i], words[i +1]);
        }

        ArrayAdapter adapter = new ArrayAdapter<>(
                this,
            android.R.layout.simple_list_item_1, new ArrayList<String>(dictionary.keySet())

        );
        lstDictionary.setAdapter(adapter);

        lstDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString();
                String meaning = dictionary.get(key);

                Intent intent = new Intent(NepaliToEnglish.this,MeaningActivity.class);
                intent.putExtra("meaning", meaning);
                startActivity(intent);
            }
        });

    }
}
