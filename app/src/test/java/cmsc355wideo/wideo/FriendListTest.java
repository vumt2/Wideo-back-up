package cmsc355wideo.wideo;

import android.content.Intent;
import android.provider.ContactsContract;
import android.test.ActivityUnitTestCase;
import android.test.UiThreadTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class FriendListTest extends ActivityUnitTestCase<MainActivity> {

    public FriendListTest() {
        super(MainActivity.class);
    }

    public void setUp() throws Exception{
        super.setUp();
    }

    @UiThreadTest
    public void testFList() throws Exception{
        final Intent flist = new Intent(Intent.ACTION_PICK,
                ContactsContract.Contacts.CONTENT_URI);
        startActivity(flist, null, null);
    }

    @Override
    public void tearDown() throws Exception {
        super.tearDown();
    }

}