package com.cappacitate.voicetohand;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

	private static final int RECOGNIZE_SPEECH_ACTIVITY = 1;
	public VoiceRecognizer VC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		VC = new VoiceRecognizer();
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
			case RECOGNIZE_SPEECH_ACTIVITY:

				String result = VC.getResultMessage(data);
				Toast.makeText(this,result,Toast.LENGTH_LONG).show();

				//para palabras individuales
				//String sample = VC.getWord(0);
				break;
		}
		super.onActivityResult(requestCode, resultCode, data);
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


			try{
				startActivityForResult(VC.getIntent(), RECOGNIZE_SPEECH_ACTIVITY);
			}catch (ActivityNotFoundException a){
				Toast.makeText(getApplicationContext(),
						"¡Opps! Tú dispositivo no soporta Speech to Text",
						Toast.LENGTH_SHORT).show();
			}
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
