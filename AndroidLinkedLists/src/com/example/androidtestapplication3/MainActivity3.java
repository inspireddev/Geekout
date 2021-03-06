package com.example.androidtestapplication3;

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


public class MainActivity3 extends ActionBarActivity {
	public final static String EXTRA_MESSAGE = "com.example.myapp.MESSAGE";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity3);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity3, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_main_activity3, container, false);
            return rootView;
        }
    }
    
    public void sendMessage(View view)
    {
    	// button clicked
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	EditText editText = (EditText) findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	
    	MyLinkedList list = new MyLinkedList();
    	
    	// take input, split into char array, and output.
    	for (char c:message.toCharArray()){
    		list.add(c);
    	}
    	
    	intent.putExtra(EXTRA_MESSAGE, list.toString());
    	startActivity(intent);
    	
    }
   
}