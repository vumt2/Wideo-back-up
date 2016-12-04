package cmsc355wideo.wideo;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Quality extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality);

        Button buttonQuality = (Button) findViewById(R.id.button720);
        Button buttonFlash = (Button) findViewById(R.id.button1080);
        Button buttonStorage = (Button) findViewById(R.id.button4k);
        Button buttonHome = (Button) findViewById(R.id.buttonHome);
        buttonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Quality.this, "Back to Home", Toast.LENGTH_SHORT).show();
                Intent home = new Intent(Quality.this, cmsc355wideo.wideo.MainActivity.class);
                startActivity(home);
            }
        });
    }

}
