package labprogra2.zerustudio.com.tarea1lab2;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Browser;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void search(View view){
        Intent i = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);

        startActivityForResult(i, 0);
    }

    public void login(View view) {
        EditText etPass = (EditText)findViewById(R.id.etPass);
        EditText etName = (EditText)findViewById(R.id.etName);
        TextView etPasValid = (TextView)findViewById(R.id.pasValid);

        String pass = etPass.getText().toString();
        if(pass.equals("Honduras")){
            Intent intent = new Intent(this, Entrada.class);
            intent.putExtra("name", etName.getText().toString());

            etPasValid.setText("");

            startActivity(intent);
        }else{
            etPasValid.setText("El Password no es Valido!!!");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0){
            if(resultCode==RESULT_OK){
                renderContact(data.getData());
            }
        }
    }

    private void renderContact(Uri uri) {
        TextView contactName = (TextView)findViewById(R.id.etName);
        contactName.setText(getName(uri));
    }

    private String getName(Uri uri) {
        String name = null;
        ContentResolver contentResolver = getContentResolver();
        String[] projection = {
            ContactsContract.Contacts.DISPLAY_NAME};
        Cursor c = contentResolver.query(uri, projection, null, null, null);

        if(c.moveToFirst()){
            name = c.getString(0);
        }

        c.close();

        return name;
    }

    public void browse(View view) {
        String link = "http://www.developers.android.com";
        Intent intent = null;
        intent = new Intent(intent.ACTION_VIEW,Uri.parse(link));
        startActivity(intent);
    }
}
