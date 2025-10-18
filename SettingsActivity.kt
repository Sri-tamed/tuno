package com.example.smartdigits;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.*;

public class SettingsActivity extends AppCompatActivity {

    EditText ipInput, portInput;
    Button enterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ipInput = findViewById(R.id.ipInput);
        portInput = findViewById(R.id.portInput);
        enterBtn = findViewById(R.id.enterBtn);

        enterBtn.setOnClickListener(v -> {
            String ip = ipInput.getText().toString().trim();
            String port = portInput.getText().toString().trim();

            if (ip.isEmpty() || port.isEmpty()) {
                Toast.makeText(this, "Please enter both IP and port", Toast.LENGTH_SHORT).show();
                return;
            }

            String url = "http://" + ip + ":" + port;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });
    }
}
