package com.heptware.android.j3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity  implements KeyEvent.Callback{

    private EditText editText;
    private TextView textView;
    private DataManager dm;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        textView = findViewById(R.id.text_view);

        // set all key value pairs
        dm = DataManager.getInstance();
        final ArrayAdapter<DataManager> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , dm.getList());
        listView = findViewById(R.id.list_item);
        listView.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox(adapter);
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(s);
                getMatch(s);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });

    }


    private void getMatch(CharSequence s) {
        List result = dm.getSearchResult(s);
        ArrayAdapter<DataManager> adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , result);

        listView.setAdapter(adapter);
    }


    // dialog box
    private  void dialogBox(final ArrayAdapter<DataManager> adapter){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Add new Entry");

        Context context = this;
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        final EditText keyInput = new EditText(context);
        keyInput.setHint("Key");
        layout.addView(keyInput); // Notice this is an add method

        final EditText valueInput = new EditText(context);
        valueInput.setHint("Name");
        layout.addView(valueInput); // Another add method

        alertDialog.setView(layout);
        alertDialog.setPositiveButton("Add",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String key = keyInput.getText().toString();
                        String value = valueInput.getText().toString();
                        dm.addToList(key , value);
                        adapter.notifyDataSetChanged();
                    }
                });

        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }
}
