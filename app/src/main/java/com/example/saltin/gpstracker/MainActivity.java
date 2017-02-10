package com.example.saltin.gpstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnShowLocation;
    GPSTracker gps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowLocation = (Button) findViewById(R.id.btnShowLocation);
        btnShowLocation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                gps = new GPSTracker(MainActivity.this);
                if (gps.canGetLocation()) { //gps aktif mi
                    double latitude = gps.getLatitude();
                    double longitude = gps.getLongitude();
                    Toast.makeText(getApplicationContext(), "Bulunduğunuz konum : \nEnlem: " + latitude + "\nBoylam: " + longitude, Toast.LENGTH_LONG).show();
                } else { // konum alınamıyorsa, gps veya network aktif değilse kullanıcya ayarlara gitmeyi sor
                    gps.showSettingAlert();
                }

            }
        });
    }
}
