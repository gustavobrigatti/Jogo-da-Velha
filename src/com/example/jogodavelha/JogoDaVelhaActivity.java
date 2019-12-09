package com.example.jogodavelha;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class JogoDaVelhaActivity extends Activity {

	Button btnIniciar, btnInstru;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogo_da_velha);
		
		btnIniciar = (Button) findViewById(R.id.btnIniciar);
		btnInstru = (Button) findViewById(R.id.btnInstru);
		
		btnIniciar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamarNiveis();
			}
		});
		btnInstru.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				chamarInstru();
			}
		});
	}
	private void chamarNiveis(){
		startActivity(new Intent(this, EscolhaActivity.class));
	}
	private void chamarInstru(){
		startActivity(new Intent(this, InstruActivity.class));
	}
}
