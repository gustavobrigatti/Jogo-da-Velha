package com.example.jogodavelha;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class EscolhaActivity extends Activity {
	
	TextView tvEscolha, tvPlayer1, tvPlayer2;
	ImageButton ibArma1, ibArma2;
	boolean verifica;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_escolha);
		tvEscolha = (TextView) findViewById(R.id.tvJargao);
		tvPlayer1 = (TextView) findViewById(R.id.tvPlayer1);
		tvPlayer2 = (TextView) findViewById(R.id.tvPlayer2);
		ibArma1 = (ImageButton) findViewById(R.id.ibPlayer1);
		ibArma2 = (ImageButton) findViewById(R.id.ibArma2);
		
		Typeface fonte = Typeface.createFromAsset(getAssets(), "viking.TTF");
		tvEscolha.setTypeface(fonte);
		tvPlayer1.setTypeface(fonte);
		tvPlayer2.setTypeface(fonte);
		
		ibArma1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(EscolhaActivity.this, JogoActivity.class);
				verifica = false;
				Bundle bundle = new Bundle();
				bundle.putBoolean("verifica", verifica);
				intent.putExtras(bundle);
				startActivity(intent);
			}  ,                         
		});
		ibArma2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(EscolhaActivity.this, JogoActivity.class);
				verifica = true;
				Bundle bundle = new Bundle();
				bundle.putBoolean("verifica", verifica);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}
}
