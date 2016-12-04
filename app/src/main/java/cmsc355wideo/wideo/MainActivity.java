package cmsc355wideo.wideo;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;
    public static final int PICK_MEDIA = 1;
    public static final int PICK_CONTACT = 2;
    public static final int SHARE_VIDEO = 3;
    public static final int DELETE_VIDEO = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonRecord = (Button) findViewById(R.id.button);
        Button buttonGallery = (Button) findViewById(R.id.button2);
        Button buttonSettings = (Button) findViewById(R.id.button3);
        Button buttonQuit = (Button) findViewById(R.id.button4);
        Button buttonFriends = (Button) findViewById(R.id.button5);
        Button button_maps = (Button) findViewById(R.id.button6);
        Button button_share = (Button) findViewById(R.id.sharebutton);
        Button deleteButton = (Button) findViewById(R.id.buttonDelete);

        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Confirm Exit");
                dialogBuilder.setMessage("Do you want to exit?");
                dialogBuilder.setCancelable(true);

                dialogBuilder.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(MainActivity.this,
                                        "Exitting app", Toast.LENGTH_SHORT).show();
                                finish();
                                System.exit(0);
                            }
                        });

                dialogBuilder.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });
        buttonRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Launching Camera function",
                        Toast.LENGTH_SHORT).show();
                Intent camera = new Intent(MainActivity.this, cmsc355wideo.wideo.CameraActivity.class);
                startActivity(camera);
            }
        });
        buttonFriends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening Friend List", Toast.LENGTH_SHORT).show();
                Intent flist = new Intent(Intent.ACTION_PICK,
                        ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(flist, PICK_CONTACT);
            }
        });
        buttonGallery.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP_MR1)
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Opening Video Gallery",
                        Toast.LENGTH_SHORT).show();
                Intent gallery = new Intent();
                gallery.setType("video/*");
                gallery.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(gallery, "Select"), PICK_MEDIA);
            }
        });
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Open Settings", Toast.LENGTH_SHORT).show();
                Intent settings = new Intent(MainActivity.this, cmsc355wideo.wideo.Settings.class);
                startActivity(settings);
            }
        });
        button_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Open Map", Toast.LENGTH_SHORT).show();
                Intent maps = new Intent(MainActivity.this, cmsc355wideo.wideo.MapsActivity.class);
                startActivity(maps);
            }
        });
        button_share.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Choose video to share",
                        Toast.LENGTH_SHORT).show();
                Intent videoToShare = new Intent();
                videoToShare.setType("video/*");
                videoToShare.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(videoToShare, "Select"), SHARE_VIDEO);

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Choose Video to Delete",
                        Toast.LENGTH_SHORT).show();
                Intent delete = new Intent();
                delete.setType("video/*");
                delete.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(delete, "Select"), DELETE_VIDEO);
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_CONTACT) {
            if (resultCode == RESULT_OK) {
                Uri contactUri = data.getData();
                Cursor cs = managedQuery(contactUri, null, null, null, null);
                if (cs.moveToFirst()) {
                    String contactId =
                            cs.getString(cs.getColumnIndexOrThrow(ContactsContract.Contacts._ID));
                    String hasPhoneNo = cs.getString(
                            cs.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER));
                    if (hasPhoneNo.equalsIgnoreCase("1")) {
                        Cursor phoneCursor = getContentResolver().query(
                                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=" + contactId,
                                null, null);
                        phoneCursor.moveToFirst();
                        String phoneNumber = phoneCursor.getString(
                                phoneCursor.getColumnIndex("data1"));
                        String contactName = cs.getString(
                                cs.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        SmsManager smsMan = SmsManager.getDefault();
                        smsMan.sendTextMessage(phoneNumber, null, "Join me in WideoApp", null, null);
                        Toast.makeText(this, "Invitation sent to contact: " + contactName + "\n" + phoneNumber,
                                Toast.LENGTH_LONG).show();
                    }
                }
            }
        }

        if (requestCode == PICK_MEDIA) {
            if (resultCode == RESULT_OK) {
                Uri videoUri = data.getData();
                Intent playVideo = new Intent(Intent.ACTION_VIEW);
                playVideo.setType("video/*");
                playVideo.setData(videoUri);
                Toast.makeText(this, "Playing Video", Toast.LENGTH_LONG).show();
                startActivity(playVideo);
            }
        }

        if (requestCode == SHARE_VIDEO) {
            if (resultCode == RESULT_OK) {
                Uri vidUri = data.getData();
                Intent ShareIntent = new Intent(Intent.ACTION_SEND);
                ShareIntent.setType("video/*");
                ShareIntent.putExtra(Intent.EXTRA_STREAM, vidUri);
                startActivity(Intent.createChooser(ShareIntent, getResources().getText(R.string.send_to)));
            }
        }
        if (requestCode == DELETE_VIDEO) {
            if (resultCode == RESULT_OK) {
                Uri rmUri = data.getData();
                File rmVideo = new File(String.valueOf(rmUri));
                rmVideo.delete();
                Toast.makeText(MainActivity.this, "Deleted video",
                        Toast.LENGTH_SHORT).show();
            }

        }

    }
}
