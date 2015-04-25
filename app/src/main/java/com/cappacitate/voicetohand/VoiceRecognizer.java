package com.cappacitate.voicetohand;

import android.content.Intent;
import android.speech.RecognizerIntent;

import java.util.ArrayList;

/**
 * Created by ekoo19 on 4/24/15.
 */
public class VoiceRecognizer {

	private Intent intent;
	private String resultText;

	public Intent getIntent(){
		return intent;
	}

	public String getResultMessage(Intent data){
		ArrayList<String> speech = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

		return resultText = speech.get(0);
	}

	public String getWord(Integer w){
		String[] words = this.resultText.split("\\s+");

		return words[w];
	}
	public String getWord(){
		return this.getWord(0);
	}

	public VoiceRecognizer(){
		intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, "es-MX");
	}
}
