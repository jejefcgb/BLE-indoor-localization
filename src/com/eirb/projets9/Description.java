package com.eirb.projets9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Activité gérant la vue détaillée des talks
 * @author jduban
 *
 */
public class Description extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.description);
		
		TextView title = (TextView) findViewById(R.id.title);
		TextView subtitle = (TextView) findViewById(R.id.subtitle);
		TextView body = (TextView) findViewById(R.id.body);
		TextView speaker = (TextView) findViewById(R.id.speaker);
		LinearLayout button = (LinearLayout) findViewById(R.id.goTo);
		
		String ti,su,st,en,bo,sp;
		
		if((ti = getIntent().getExtras().getString("Title")) != null )
			title.setText(ti);
		if((su = getIntent().getExtras().getString("Subtitle")) != null )
			subtitle.setText("Room " + su);
		if((st = getIntent().getExtras().getString("Start")) != null )
			subtitle.setText(subtitle.getText()+", From "+st);
		if((en = getIntent().getExtras().getString("End")) != null )
			subtitle.setText(subtitle.getText()+" to "+en);
		if((bo = getIntent().getExtras().getString("Body")) != null )
			body.setText(bo);
		if((sp = getIntent().getExtras().getString("Speaker")) != null )
			speaker.setText("Speaker : " + sp);
		
		final String room = su;
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent resultIntent = new Intent();
		    	resultIntent.putExtra("room", room);
		    	Toast.makeText(Description.this, room, Toast.LENGTH_SHORT).show();
		    	setResult(RESULT_OK, resultIntent);
				finish();
			}
		});
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		System.out.println("onKeyDown Option");
		
		
		return super.onKeyDown(keyCode, event);	
	}
}


