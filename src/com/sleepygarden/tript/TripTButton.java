/**
 *
 * @author sleepygarden
 *
 */
package com.sleepygarden.tript;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/*
 * A Custom image view which also owns a reference to it's X or O state
 */
public class TripTButton extends ImageView {
	int mark = 0; // 0 is blank, 1 is X, 4 is circle

	public TripTButton(Context context) {
		super(context);
	}

	public TripTButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public TripTButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public void mark(int m) {
		this.mark = m;
	}

}
