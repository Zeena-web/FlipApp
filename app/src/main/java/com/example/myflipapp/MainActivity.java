package com.example.myflipapp;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.myflipapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    private ClipboardManager clipboardManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);
        clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        binding.buttonFlip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String originalText = binding.editText.getText().toString();
            String flippedText=flipText(originalText);
            binding.textViewFlipped.setText(getString(R.string.flipped_text) + "\n \n" + flippedText);
                Toast.makeText(MainActivity.this, "Text copied", Toast.LENGTH_SHORT).show();
            }
        });
        binding.buttonCopy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textToCopy=binding.textViewFlipped.getText().toString().replace(getString(R.string.flipped_text)+"","");
                ClipData clip=ClipData.newPlainText("Copied Text" , textToCopy);
                clipboardManager.setPrimaryClip(clip);
                Toast.makeText(MainActivity.this, "Text copied", Toast.LENGTH_SHORT).show();
            }
        });
        binding.buttonCut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textToCut = binding.editText.getText().toString();
                ClipData clip = ClipData.newPlainText("Cut Text", textToCut);
                clipboardManager.setPrimaryClip(clip);
                binding.editText.setText("");
            }
        });

    }

    private String flipText(String originalText) {
        StringBuilder flipped=new StringBuilder(originalText);
        return flipped.reverse().toString();
    }
}