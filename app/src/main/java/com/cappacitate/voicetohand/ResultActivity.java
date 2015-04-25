package com.cappacitate.voicetohand;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

//package com.wallpaer;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class ResultActivity extends ActionBarActivity {

    public String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get string data
        text = getIntent().getStringExtra("key");

        ((TextView)findViewById(R.id.string_label)).setText(text);

        showImage();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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

    // Show image in Result
    public void showImage() {
        String imageName;
        ImageView image = (ImageView)findViewById(R.id.image_result);
        switch (text) {
            case "hoy":
                image.setImageResource(R.drawable.hoy);
                break;
            case "mañana":
                image.setImageResource(R.drawable.hoy);
                break;
            case "mediodia":
                image.setImageResource(R.drawable.hoy);
                break;
            case "noche":
                image.setImageResource(R.drawable.hoy);
                break;
            case "tarde":
                image.setImageResource(R.drawable.hoy);
                break;
            case "ayer":
                image.setImageResource(R.drawable.ayer);
                break;
            case "si":
                image.setImageResource(R.drawable.si);
                break;
            case "no":
                image.setImageResource(R.drawable.no);
                break;
            default:
                image.setImageResource(R.drawable.noimage1);
        }
    }

}
