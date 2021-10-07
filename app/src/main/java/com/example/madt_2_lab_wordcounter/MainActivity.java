package com.example.madt_2_lab_wordcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.madt_2_lab_wordcounter.utilis.TextCounter;

public class MainActivity extends AppCompatActivity {
    Spinner spCounterSelection;
    EditText txtEnteredText;
    TextView tvCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spCounterSelection = (Spinner) findViewById(R.id.spCounterSelection);
        this.txtEnteredText = findViewById(R.id.txtEnteredText);
        this.tvCount = findViewById(R.id.tvCount);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.selection_options_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spCounterSelection.setAdapter(adapter);
    }

    public void onBtnClick(View view) {
        Spinner mySpinner = (Spinner) findViewById(R.id.spCounterSelection);
        String text = mySpinner.getSelectedItem().toString();

        String phrase = this.txtEnteredText.getText().toString();
        boolean phraseIsEmpty = phrase.isEmpty();

        if (!phraseIsEmpty) {
            if (text.equals("Words")) {
                int wordsCount = TextCounter.getWordsCount(phrase);
                String formattedResult = String.valueOf(wordsCount);
                this.tvCount.setText(formattedResult);
            } else if (text.equals("Chars")) {
                int charsCount = TextCounter.getCharCount(phrase);
                String formattedResult = String.valueOf(charsCount);
                this.tvCount.setText(formattedResult);
            }
        } else {
            Toast.makeText(this, "There is empty input", Toast.LENGTH_LONG).show();
        }
    }
}