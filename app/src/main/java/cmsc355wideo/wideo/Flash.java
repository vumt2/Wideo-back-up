package cmsc355wideo.wideo;

import com.google.android.gms.common.api.GoogleApiClient;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class Flash extends AppCompatActivity {
    CameraManager myCameraManager;
    String myCameraId;
    ImageButton myTorchOnOffButton;
    Boolean isTorchOn;
    MediaPlayer mp;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        isTorchOn = false;
        Log.d("Flash", "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);

        Button buttonOn = (Button) findViewById(R.id.buttonON);
        Button buttonOff = (Button) findViewById(R.id.buttonOFF);
        Button buttonAuto = (Button) findViewById(R.id.buttonAUTO);

        Boolean isFlashAvailable = getApplicationContext().getPackageManager()
                .hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);

        if (!isFlashAvailable) {

            AlertDialog alert = new AlertDialog.Builder(Flash.this)
                    .create();
            alert.setTitle("Error !!");
            alert.setMessage("Your device doesn't support flash light!");
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // closing the application
                            finish();
                            System.exit(0);
                    }
                });
            alert.show();
            return;
        }

        buttonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTorchOn) {
                    turnOnFlashLight();
                    isTorchOn = true;
                }
            }

        });
        buttonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isTorchOn) {
                    turnOffFlashLight();
                    isTorchOn = false;
                }
            }
        });
        Button buttonHome = (Button) findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Flash.this, "Back to Home", Toast.LENGTH_SHORT).show();
                Intent home = new Intent(Flash.this, cmsc355wideo.wideo.MainActivity.class);
                startActivity(home);
            }
        });





    }

    public void turnOnFlashLight() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myCameraManager.setTorchMode(myCameraId, true);


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public void turnOffFlashLight() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                myCameraManager.setTorchMode(myCameraId, false);



            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (isTorchOn) {
            turnOffFlashLight();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isTorchOn) {
            turnOffFlashLight();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isTorchOn) {
            turnOnFlashLight();
        }
    }
}



