 package com.example.jogodavelha;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JogoActivity extends Activity {
	
	TextView tvJogadorDaVez, tvGanhador, tvVitP1, tvVitP2, tvEmpates;
	ImageView ivJogadorDaVez, im1, im2, im3, im4, im5, im6, im7, im8, im9;
	Button btnJogarNovamente, btnReiniciar;
	boolean verifica, verificaQuemComecou;
	int[][] matriz;
	int soma1, soma2, soma3, soma4, soma5, soma6, soma7, soma8, iContador = 0, iVitP1 = 0, iVitP2 = 0, iEmpates = 0;
;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jogo);
		Intent intent = getIntent();
	    Bundle bundle = intent.getExtras();
	    verifica = bundle.getBoolean("verifica");
	    verificaQuemComecou = verifica;
	    matriz  = new int[3][3];
        
        tvJogadorDaVez = (TextView) findViewById(R.id.tvJogadorDaVez);
        ivJogadorDaVez = (ImageView) findViewById(R.id.ivJogadorDaVez);
        tvGanhador = (TextView) findViewById(R.id.tvGanhador);
        tvVitP1 = (TextView) findViewById(R.id.tvVitoriasP1);
        tvVitP2 = (TextView) findViewById(R.id.tvVitoriasP2);
        tvEmpates = (TextView) findViewById(R.id.tvEmpates);
        btnJogarNovamente = (Button) findViewById(R.id.btnJogarNovamente);
        btnReiniciar = (Button) findViewById(R.id.btnReiniciar);
        im1 = (ImageView) findViewById(R.id.img00);
		im2 = (ImageView) findViewById(R.id.img01);
		im3 = (ImageView) findViewById(R.id.img02);
		im4 = (ImageView) findViewById(R.id.img10);
		im5 = (ImageView) findViewById(R.id.img11);
		im6 = (ImageView) findViewById(R.id.img12);
		im7 = (ImageView) findViewById(R.id.img20);
		im8 = (ImageView) findViewById(R.id.img21);
		im9 = (ImageView) findViewById(R.id.img22);
        
        Typeface fonte = Typeface.createFromAsset(getAssets(), "viking.TTF");
        
        tvJogadorDaVez.setTypeface(fonte);
        tvGanhador.setTypeface(fonte);
        tvVitP1.setTypeface(fonte);
        tvVitP2.setTypeface(fonte);
        tvEmpates.setTypeface(fonte);
        tvGanhador.setText(null);
        btnJogarNovamente.setEnabled(false);
        
        if(verifica == false){
        	ivJogadorDaVez.setBackgroundResource(R.drawable.arma1mini);
        }else{
        	ivJogadorDaVez.setBackgroundResource(R.drawable.arma2mini);
        }
        
        btnJogarNovamente.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				liberaTabela();
				verificaQuemComecou();
				btnJogarNovamente.setEnabled(false);
			}
		});
        btnReiniciar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				iVitP1 = 0;
				iVitP2 = 0;
				iEmpates = 0;
				colocaTexto();
				liberaTabela();
				verificaQuemComecou();
				btnJogarNovamente.setEnabled(false);
			}
		});
	}
	
	public void verificaquadrado(View v){
		switch (v.getId()) {
		case R.id.img00:
			if(verifica == false){
				im1.setBackgroundResource(R.drawable.quadrado1arma1);
				matriz [0][0] = 4;
			}else{
				im1.setBackgroundResource(R.drawable.quadrado1arma2);
				matriz [0][0] = 3;
			}
			im1.setEnabled(false);
			break;
		case R.id.img01:
			if(verifica == false){
				im2.setBackgroundResource(R.drawable.quadrado2arma1);
				matriz [0][1] = 4;
			}else{
				im2.setBackgroundResource(R.drawable.quadrado2arma2);
				matriz [0][1] = 3;
			}
			im2.setEnabled(false);
			break;
		case R.id.img02:
			if(verifica == false){
				im3.setBackgroundResource(R.drawable.quadrado1arma1);
				matriz [0][2] = 4;
			}else{
				im3.setBackgroundResource(R.drawable.quadrado1arma2);
				matriz [0][2] = 3;
			}
			im3.setEnabled(false);
			break;
		case R.id.img10:
			if(verifica == false){
				im4.setBackgroundResource(R.drawable.quadrado2arma1);
				matriz [1][0] = 4;
			}else{
				im4.setBackgroundResource(R.drawable.quadrado2arma2);
				matriz [1][0] = 3;
			}
			im4.setEnabled(false);
			break;
		case R.id.img11:
			if(verifica == false){
				im5.setBackgroundResource(R.drawable.quadrado1arma1);
				matriz [1][1] = 4;
			}else{
				im5.setBackgroundResource(R.drawable.quadrado1arma2);
				matriz [1][1] = 3;
			}
			im5.setEnabled(false);
			break;
		case R.id.img12:
			if(verifica == false){
				im6.setBackgroundResource(R.drawable.quadrado2arma1);
				matriz [1][2] = 4;
			}else{
				im6.setBackgroundResource(R.drawable.quadrado2arma2);
				matriz [1][2] = 3;
			}
			im6.setEnabled(false);
			break;
		case R.id.img20:
			if(verifica == false){
				im7.setBackgroundResource(R.drawable.quadrado1arma1);
				matriz [2][0] = 4;
			}else{
				im7.setBackgroundResource(R.drawable.quadrado1arma2);
				matriz [2][0] = 3;
			}
			im7.setEnabled(false);
			break;
		case R.id.img21:
			if(verifica == false){
				im8.setBackgroundResource(R.drawable.quadrado2arma1);
				matriz [2][1] = 4;
			}else{
				im8.setBackgroundResource(R.drawable.quadrado2arma2);
				matriz [2][1] = 3;
			}
			im8.setEnabled(false);
			break;
		case R.id.img22:
			if(verifica == false){
				im9.setBackgroundResource(R.drawable.quadrado1arma1);
				matriz [2][2] = 4;
			}else{
				im9.setBackgroundResource(R.drawable.quadrado1arma2);
				matriz [2][2] = 3;
			}
			im9.setEnabled(false);
			break;
		}
		verificaQuemJoga();
		verificaGanhador();
	}
	public void verificaQuemJoga(){
		if(verifica == false){
			verifica = true;
			ivJogadorDaVez.setBackgroundResource(R.drawable.arma2mini);
		}else{
			verifica = false;
			ivJogadorDaVez.setBackgroundResource(R.drawable.arma1mini);
		}
	}
	public void verificaGanhador(){
		iContador++;
		soma1 = matriz[0][0] + matriz[0][1] + matriz[0][2];
		soma2 = matriz[1][0] + matriz[1][1] + matriz[1][2];
		soma3 = matriz[2][0] + matriz[2][1] + matriz[2][2];
		soma4 = matriz[0][0] + matriz[1][0] + matriz[2][0];
		soma5 = matriz[0][1] + matriz[1][1] + matriz[2][1];
		soma6 = matriz[0][2] + matriz[1][2] + matriz[2][2];
		soma7 = matriz[0][0] + matriz[1][1] + matriz[2][2];
		soma8 = matriz[0][2] + matriz[1][1] + matriz[2][0];
		if(soma1 == 12 || soma2 == 12 ||soma3 == 12 ||soma4 == 12 ||soma5 == 12 ||soma6 == 12 ||soma7 == 12 ||soma8 == 12){
			tvGanhador.setText("Player 1 Venceu !!");
			iVitP1++;
			bloqueiaTabela();
		}else if(soma1 == 9 || soma2 == 9 ||soma3 == 9 ||soma4 == 9 ||soma5 == 9 ||soma6 == 9 ||soma7 == 9 ||soma8 == 9){
			tvGanhador.setText("Player 2 Venceu !!");
			iVitP2++;
			bloqueiaTabela();
		}else if(iContador == 9){
			tvGanhador.setText("Deu velha !!");
			iEmpates++;
			bloqueiaTabela();
		}
	}
	public void colocaTexto(){
		tvVitP1.setText("Vitórias Player 1: "+iVitP1);
		tvVitP2.setText("Vitórias Player 2: "+iVitP2);
		tvEmpates.setText("Empates: "+iEmpates);
	}
	public void liberaTabela(){
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matriz[i][j] = 0;
			}
		}
		iContador = 0;
		tvGanhador.setText(null);
		im1.setEnabled(true);
		im2.setEnabled(true);
		im3.setEnabled(true);
		im4.setEnabled(true);
		im5.setEnabled(true);
		im6.setEnabled(true);
		im7.setEnabled(true);
		im8.setEnabled(true);
		im9.setEnabled(true);
		im1.setBackgroundResource(R.drawable.quadrado1);
		im2.setBackgroundResource(R.drawable.quadrado2);
		im3.setBackgroundResource(R.drawable.quadrado1);
		im4.setBackgroundResource(R.drawable.quadrado2);
		im5.setBackgroundResource(R.drawable.quadrado1);
		im6.setBackgroundResource(R.drawable.quadrado2);
		im7.setBackgroundResource(R.drawable.quadrado1);
		im8.setBackgroundResource(R.drawable.quadrado2);
		im9.setBackgroundResource(R.drawable.quadrado1);
	}
	public void bloqueiaTabela(){
		colocaTexto();
		btnJogarNovamente.setEnabled(true);
		im1.setEnabled(false);
		im2.setEnabled(false);
		im3.setEnabled(false);
		im4.setEnabled(false);
		im5.setEnabled(false);
		im6.setEnabled(false);
		im7.setEnabled(false);
		im8.setEnabled(false);
		im9.setEnabled(false);
	}
	public void verificaQuemComecou(){
		if(verificaQuemComecou == false){
			ivJogadorDaVez.setBackgroundResource(R.drawable.arma1mini);
			verifica = false;
		}else{
			ivJogadorDaVez.setBackgroundResource(R.drawable.arma2mini);
			verifica = true;
		}
	}
}
