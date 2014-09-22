package com.example.basicintentfile;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;



public class MainActivity extends ActionBarActivity {

	// Your intent can carry a collection of data types as Key Value Pairs. In order for the next activity to query
	// the extra data, you should define a key for these extras and make this key unique (using your package name)
	public final static String EXTRA_MESSAGE = "com.example.BasicIntentFile.MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }
    
    public void ButtonClicked(View view){
	// Method is called when Button View from Main Activity (Screen) is clicked 
    // To match the Android:onClick parameters, Method must be Public, Void, and have a View as the only parameter
    // Need to CMD + SHIFT + O in order to import the appropriate libraries
    // This method will execute when button is clicked
    
    // Now create an intent which will start a new Activity called DisplayMessageActivity
    // Intent is an object that provides runtime binding between separate components (activities)
    // "this" is used because the Activity class is a subclass of context
   Intent intent = new Intent(this, DisplayMessageActivity.class);
    
    // Access the edit_message text from the via R.Java file by id
    EditText editText = (EditText) findViewById(R.id.edit_message);
    String message = editText.getText().toString();
    intent.putExtra(EXTRA_MESSAGE, message);
    	
    }
}
