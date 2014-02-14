package com.sleepygarden.tript;

import com.sleepygarden.tript.R;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	// top, left, right, mid, bottom
	TripTButton tl, tm, tr, ml, mm, mr, bl, bm, br;
	Button newGame;
	TextView turnIndicator, winIndicator;
	TripTButton[] btns;
	Drawable x, o;
	boolean xTurn = true; // true is X's turn, false is O's turn

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//our views are all laid out in XML in the "res" folder. In fact, everything that isn't code that _is_ compiled lives in "res"
		//this includes localized strings, images, and our XML layout files
		//tether our instance variables to our XML references.
		tl = (TripTButton) findViewById(R.id.top_left);
		tm = (TripTButton) findViewById(R.id.top_mid);
		tr = (TripTButton) findViewById(R.id.top_right);

		ml = (TripTButton) findViewById(R.id.mid_left);
		mm = (TripTButton) findViewById(R.id.mid_mid);
		mr = (TripTButton) findViewById(R.id.mid_right);

		bl = (TripTButton) findViewById(R.id.bot_left);
		bm = (TripTButton) findViewById(R.id.bot_mid);
		br = (TripTButton) findViewById(R.id.bot_right);

		btns = new TripTButton[] { tl, tm, tr, ml, mm, mr, bl, bm, br };
		
		newGame = (Button) findViewById(R.id.new_game);
		newGame.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				playNewGame();
			}
		});

		x = getResources().getDrawable(R.drawable.red_x);
		o = getResources().getDrawable(R.drawable.green_o);

		turnIndicator = (TextView) findViewById(R.id.turn_tv);
		winIndicator = (TextView) findViewById(R.id.win_tv);

		for (TripTButton b : btns) {
			b.mark(0);
			b.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					TripTButton btn = (TripTButton) v;
					if (xTurn) {
						btn.setImageDrawable(x);
						btn.mark(1);
						turnIndicator.setText("O's turn");
					}
					else {
						btn.setImageDrawable(o);
						btn.mark(4);
						turnIndicator.setText("X's turn");
					}
					btn.setClickable(false);
					checkForWin();
					xTurn = !xTurn;
				}
			});
		}
		
		playNewGame();

	}

	public void playNewGame() {
		for (TripTButton b : btns) {
			b.mark(0);
			b.setImageDrawable(null);
			b.setEnabled(true);
			b.setClickable(true);
		}
		winIndicator.setVisibility(View.GONE);
		xTurn = true;
		turnIndicator.setText("X's turn");
	}
	
	public void checkForWin(){
		// Using some math and the TripTBtn mark values, we can surmise that a sum of 3 can only be brought about by 3 X's and a sum of 12 can only be brought by O's
		boolean gameOver = false;
		
		//X wins
		if (btns[0].mark + btns[1].mark + btns[2].mark == 3){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("X Wins!");
			gameOver=true;
		} 
		else if (btns[3].mark + btns[4].mark + btns[5].mark == 3){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("X Wins!");
			gameOver=true;
		} 
		else if (btns[6].mark + btns[7].mark + btns[8].mark == 3){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("X Wins!");
			gameOver=true;
		} 
		else if (btns[0].mark + btns[3].mark + btns[6].mark == 3){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("X Wins!");
			gameOver=true;
		} 
		else if (btns[1].mark + btns[4].mark + btns[7].mark == 3){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("X Wins!");
			gameOver=true;
		}
		else if (btns[2].mark + btns[5].mark + btns[8].mark == 3){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("X Wins!");
			gameOver=true;
		} 
		else if (btns[0].mark + btns[4].mark + btns[8].mark == 3){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("X Wins!");
			gameOver=true;
		} 
		else if (btns[2].mark + btns[4].mark + btns[6].mark == 3){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("X Wins!");
			gameOver=true;
		} 
		
		
		//O wins
		if (btns[0].mark + btns[1].mark + btns[2].mark == 12){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("O Wins!");
			gameOver=true;
		} 
		else if (btns[3].mark + btns[4].mark + btns[5].mark == 12){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("O Wins!");
			gameOver=true;
		} 
		else if (btns[6].mark + btns[7].mark + btns[8].mark == 12){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("O Wins!");
			gameOver=true;
		} 
		else if (btns[0].mark + btns[3].mark + btns[6].mark == 12){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("O Wins!");
			gameOver=true;
		} 
		else if (btns[1].mark + btns[4].mark + btns[7].mark == 12){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("O Wins!");
			gameOver=true;
		}
		else if (btns[2].mark + btns[5].mark + btns[8].mark == 12){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("O Wins!");
			gameOver=true;
		} 
		else if (btns[0].mark + btns[4].mark + btns[8].mark == 12){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("O Wins!");
			gameOver=true;
		} 
		else if (btns[2].mark + btns[4].mark + btns[6].mark == 12){
			winIndicator.setVisibility(View.VISIBLE);
			winIndicator.setText("O Wins!");
			gameOver=true;
		} 
		
		if(gameOver) {
			for (TripTButton btn : btns) {
				btn.setEnabled(false);
			}
		}
	}

}
