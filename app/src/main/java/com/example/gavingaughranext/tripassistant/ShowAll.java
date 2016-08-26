package com.example.gavingaughranext.tripassistant;

/**
 * Created by gavin.gaughran.ext on 29/03/2016.
 */
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class ShowAll extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showall_currency);
        WebView w1=(WebView)findViewById(R.id.webView);
        w1.loadUrl("view-source:http://www.floatrates.com/daily/eur.xml");
    }
}
