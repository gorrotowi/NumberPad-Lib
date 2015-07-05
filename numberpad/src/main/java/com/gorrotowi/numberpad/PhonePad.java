package com.gorrotowi.numberpad;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gorrotowi.numberpad.listeners.OnPhonePadListener;

/**
 * Created by gorro on 04/07/15.
 */
public class PhonePad extends LinearLayout {

    EditText edtxPhone;
    ImageView imgDelete, imgSend;
    TextView txtCountry, txtOne, txtTwo, txtThree, txtFour, txtFive, txtSix, txtSeven, txtEight, txtNine, txtZero;

    int lengthPhone = 10;

    OnPhonePadListener listener;

    public PhonePad(Context context) {
        super(context);
        init();
    }

    public PhonePad(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PhonePad(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        this.isInEditMode();
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.phone_pad, this, true);

        edtxPhone = (EditText) findViewById(R.id.edtxPhone);
        imgDelete = (ImageView) findViewById(R.id.imgPadDelete);
        imgSend = (ImageView) findViewById(R.id.imgSend);
        txtCountry = (TextView) findViewById(R.id.txtCountryCode);
        txtOne = (TextView) findViewById(R.id.txtPadOne);
        txtTwo = (TextView) findViewById(R.id.txtPadTwo);
        txtThree = (TextView) findViewById(R.id.txtPadThree);
        txtFour = (TextView) findViewById(R.id.txtPadFour);
        txtFive = (TextView) findViewById(R.id.txtPadFive);
        txtSix = (TextView) findViewById(R.id.txtPadSix);
        txtSeven = (TextView) findViewById(R.id.txtPadSeven);
        txtEight = (TextView) findViewById(R.id.txtPadEigth);
        txtNine = (TextView) findViewById(R.id.txtPadNine);
        txtZero = (TextView) findViewById(R.id.txtPadZero);

        imgSend.setVisibility(View.INVISIBLE);
        edtxPhone.setEnabled(false);

        imgSend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.OnPhonePadCListener(txtCountry.getText().toString() + "", edtxPhone.getText().toString() + "");
            }
        });

        imgDelete.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setEnabled(true);
                edtxPhone.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
                edtxPhone.setEnabled(false);
            }
        });

        txtOne.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.one));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        txtTwo.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.two));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        txtThree.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.three));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        txtFour.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.four));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        txtFive.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.five));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        txtSix.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.six));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        txtSeven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.seven));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        txtEight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.eigth));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        txtNine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.nine));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        txtZero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                edtxPhone.setText(edtxPhone.getText().toString() + getContext().getString(R.string.zero));
                edtxPhone.setSelection(edtxPhone.getText().toString().length());
            }
        });

        edtxPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.toString().length() == lengthPhone) {
                    imgSend.setVisibility(View.VISIBLE);
                    imgSend.setTranslationY(0);
                } else {
                    imgSend.setTranslationY(imgSend.getWidth());
                }
            }
        });

    }

    public void setOnPhonePadListener(OnPhonePadListener l) {
        listener = l;
    }

    public void setPhoneLength(int length) {
        lengthPhone = length;
    }

}