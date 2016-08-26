package com.example.gavingaughranext.tripassistant;

import android.media.MediaPlayer;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class CountryInformationActivity extends FragmentActivity
        implements  GoogleMap.OnMapClickListener,
        GoogleMap.OnMapLongClickListener,
        GoogleMap.OnMarkerClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;
    MediaPlayer mp = null;

    private ImageView imageView;
    private TextView capitalText, mainLangText, learnHeading, helloText, goodbyeText, thankYouText, timeText, whereText;

    //Create seven markers for seven locations
    private Marker mFrance;
    private Marker mUSA;
    private Marker mUK;
    private Marker mNetherlands;
    private Marker mGermany;

    private ImageButton phraseButton, phraseButton2, phraseButton3, phraseButton4, phraseButton5;

    //Create an array of the seven national anthems
    String nationalAnthems[] = {
            "National Anthem: The Deutschlandlied",
            "National Anthem: The Star Spangled Banner",
            "National Anthem: God Save The Queen",
            "National Anthem: La Marseillaise",
            "National Anthem: Het Wilhelmus"
    };

    String usaArray[] = {
            "Capital: Washington DC",
            "Main Lang: English",
            "Second Lang: Spanish",
            "Learn the language:",
            "Hello: Hola",
            "Goodbye: Adios",
            "Thank you: Gracias",
            "What time is it?: Que hora es?",
            "Where is ...?: Dónde está ...?"
    };

    String ukArray[] = {
            "Capital: London",
            "Main Lang: English",
            "Second Lang: Polish",
            "Learn the language:",
            "Hello: Cześć",
            "Goodbye: Do widzenia",
            "Thank you: Dziękuję Ci",
            "What time is it?: Która godzina?",
            "Where is ...?: Gdzie jest ...?"
    };

    String netherlandsArray[] = {
            "Capital: Amsterdam",
            "Main Lang: Dutch",
            "Second Lang: English",
            "Learn the language:",
            "Hello: Hallo",
            "Goodbye: Vaarwel",
            "Thank you: Dank je",
            "What time is it?: Hoe laat is het?",
            "Where is ...?: Waar is ...?"
    };

    String germanyArray[] = {
            "Capital: Berlin",
            "Main Lang: German",
            "Second Lang: English",
            "Learn the language:",
            "Hello: Hallo",
            "Goodbye: Auf Wiedersehen",
            "Thank you: Vielen Dank",
            "What time is it?: Wie spät ist es?",
            "Where is ...?: Wo ist ...?"
    };

    String franceArray[] = {
            "Capital: Paris",
            "Main Lang: French",
            "Second Lang: English",
            "Learn the language:",
            "Hello: Bonjour",
            "Goodbye: Au Revoir",
            "Thank you: Je vous remercie",
            "What time is it?: Quelle heure est-il?",
            "Where is ...?: Où se trouve ...?"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_maps);
        setContentView(R.layout.activity_country_information);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        imageView = (ImageView) findViewById(R.id.flagImage);
        capitalText = (TextView) findViewById(R.id.capitalText);
        mainLangText = (TextView) findViewById(R.id.language1Text);
        learnHeading = (TextView) findViewById(R.id.learnTextHeading);
        helloText = (TextView) findViewById(R.id.phrase1Text);
        goodbyeText = (TextView) findViewById(R.id.phrase2Text);
        thankYouText = (TextView) findViewById(R.id.phrase3Text);
        timeText = (TextView) findViewById(R.id.phrase4Text);
        whereText = (TextView) findViewById(R.id.phrase5Text);
        phraseButton = (ImageButton) findViewById(R.id.imageButton);
        phraseButton2 = (ImageButton) findViewById(R.id.imageButton2);
        phraseButton3 = (ImageButton) findViewById(R.id.imageButton3);
        phraseButton4 = (ImageButton) findViewById(R.id.imageButton4);
        phraseButton5 = (ImageButton) findViewById(R.id.imageButton5);

        //Initially I hide all columns until a country has been chosen
        imageView.setVisibility(View.INVISIBLE);
        capitalText.setVisibility(View.INVISIBLE);
        mainLangText.setVisibility(View.INVISIBLE);
        learnHeading.setVisibility(View.INVISIBLE);
        helloText.setVisibility(View.INVISIBLE);
        goodbyeText.setVisibility(View.INVISIBLE);
        thankYouText.setVisibility(View.INVISIBLE);
        timeText.setVisibility(View.INVISIBLE);
        whereText.setVisibility(View.INVISIBLE);
        phraseButton.setVisibility(View.INVISIBLE);
        phraseButton2.setVisibility(View.INVISIBLE);
        phraseButton3.setVisibility(View.INVISIBLE);
        phraseButton4.setVisibility(View.INVISIBLE);
        phraseButton5.setVisibility(View.INVISIBLE);

        }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12));
        mMap.getUiSettings().setZoomControlsEnabled(true);

        mMap.setOnMarkerClickListener(this);

        // Add the Lat an dLong of the seven locations
        LatLng france = new LatLng(48.8, 2.3);
        LatLng germany = new LatLng(52.5, 13.4);
        LatLng netherlands = new LatLng(52.23, 4.55);
        LatLng uk = new LatLng(52.35, -1.1);
        LatLng usa = new LatLng(37, -95.7);

        mFrance = mMap.addMarker(new MarkerOptions().position(france).title("FRANCE").snippet(nationalAnthems[3]));
        mGermany = mMap.addMarker(new MarkerOptions().position(germany).title("GERMANY").snippet(nationalAnthems[0]));
        mNetherlands = mMap.addMarker(new MarkerOptions().position(netherlands).title("NETHERLANDS").snippet(nationalAnthems[4]));
        mUK = mMap.addMarker(new MarkerOptions().position(uk).title("UK").snippet(nationalAnthems[2]));
        mUSA = mMap.addMarker(new MarkerOptions().position(usa).title("USA").snippet(nationalAnthems[1]));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(netherlands));
        mMap.animateCamera( CameraUpdateFactory.zoomTo( 3.0f ) );
    }

    @Override
    public void onMapClick(LatLng latLng) {

    }

    @Override
    public void onMapLongClick(LatLng latLng) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        imageView.setVisibility(View.VISIBLE);
        capitalText.setVisibility(View.VISIBLE);
        mainLangText.setVisibility(View.VISIBLE);
        learnHeading.setVisibility(View.VISIBLE);
        helloText.setVisibility(View.VISIBLE);
        goodbyeText.setVisibility(View.VISIBLE);
        thankYouText.setVisibility(View.VISIBLE);
        timeText.setVisibility(View.VISIBLE);
        whereText.setVisibility(View.VISIBLE);
        phraseButton.setVisibility(View.VISIBLE);
        phraseButton2.setVisibility(View.VISIBLE);
        phraseButton3.setVisibility(View.VISIBLE);
        phraseButton4.setVisibility(View.VISIBLE);
        phraseButton5.setVisibility(View.VISIBLE);

        if (marker.equals(mFrance)) {
            if (mp != null) {
                mp.reset();
                mp.release();
            }
            mp = MediaPlayer.create(getApplicationContext(), R.raw.france);
            mp.start();

            imageView.setImageResource(R.drawable.france);
            capitalText.setText(franceArray[0]);
            mainLangText.setText(franceArray[1] + ", " + franceArray[2]);
            learnHeading.setText(franceArray[3]);
            helloText.setText(franceArray[4]);
            goodbyeText.setText(franceArray[5]);
            thankYouText.setText(franceArray[6]);
            timeText.setText(franceArray[7]);
            whereText.setText(franceArray[8]);

            ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.bonjour);
                    mp.start();
                }
            });
            ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.au_revoir);
                    mp.start();
                }
            });
            ImageButton ib3 = (ImageButton) findViewById(R.id.imageButton3);
            ib3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.je_vous_remercie);
                    mp.start();
                }
            });
            ImageButton ib4 = (ImageButton) findViewById(R.id.imageButton4);
            ib4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.o_se_trouve);
                    mp.start();
                }
            });
            ImageButton ib5 = (ImageButton) findViewById(R.id.imageButton5);
            ib5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.quelle_heure_est_il);
                    mp.start();
                }
            });

        }else if(marker.equals(mGermany)){
            if (mp != null) {
                mp.reset();
                mp.release();
            }
            mp = MediaPlayer.create(getApplicationContext(), R.raw.germany);
            mp.start();

            imageView.setImageResource(R.drawable.germany);
            capitalText.setText(germanyArray[0]);
            mainLangText.setText(germanyArray[1] + ", " + germanyArray[2]);
            learnHeading.setText(germanyArray[3]);
            helloText.setText(germanyArray[4]);
            goodbyeText.setText(germanyArray[5]);
            thankYouText.setText(germanyArray[6]);
            timeText.setText(germanyArray[7]);
            whereText.setText(germanyArray[8]);

            ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.hallo);
                    mp.start();
                }
            });
            ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.auf_wiedersehen);
                    mp.start();
                }
            });
            ImageButton ib3 = (ImageButton) findViewById(R.id.imageButton3);
            ib3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.vielen_dank);
                    mp.start();
                }
            });
            ImageButton ib4 = (ImageButton) findViewById(R.id.imageButton4);
            ib4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.wo_ist);
                    mp.start();
                }
            });
            ImageButton ib5 = (ImageButton) findViewById(R.id.imageButton5);
            ib5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.wie_spt_ist_es);
                    mp.start();
                }
            });

        }else if(marker.equals(mNetherlands)){
            if (mp != null) {
                mp.reset();
                mp.release();
            }
            mp = MediaPlayer.create(getApplicationContext(), R.raw.netherlands);
            mp.start();

            imageView.setImageResource(R.drawable.netherlands);
            capitalText.setText(netherlandsArray[0]);
            mainLangText.setText(netherlandsArray[1] + ", " + netherlandsArray[2]);
            learnHeading.setText(netherlandsArray[3]);
            helloText.setText(netherlandsArray[4]);
            goodbyeText.setText(netherlandsArray[5]);
            thankYouText.setText(netherlandsArray[6]);
            timeText.setText(netherlandsArray[7]);
            whereText.setText(netherlandsArray[8]);

            ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.hallo);
                    mp.start();
                }
            });
            ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.vaarwel);
                    mp.start();
                }
            });
            ImageButton ib3 = (ImageButton) findViewById(R.id.imageButton3);
            ib3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.dank_je);
                    mp.start();
                }
            });
            ImageButton ib4 = (ImageButton) findViewById(R.id.imageButton4);
            ib4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.waar_is);
                    mp.start();
                }
            });

            ImageButton ib5 = (ImageButton) findViewById(R.id.imageButton5);
            ib5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.hoe_laat_is_het);
                    mp.start();
                }
            });

        }else if(marker.equals(mUK)){
            if (mp != null) {
                mp.reset();
                mp.release();
            }
            mp = MediaPlayer.create(getApplicationContext(), R.raw.uk);
            mp.start();

            imageView.setImageResource(R.drawable.uk);
            capitalText.setText(ukArray[0]);
            mainLangText.setText(ukArray[1] + ", " + ukArray[2]);
            learnHeading.setText(ukArray[3]);
            helloText.setText(ukArray[4]);
            goodbyeText.setText(ukArray[5]);
            thankYouText.setText(ukArray[6]);
            timeText.setText(ukArray[7]);
            whereText.setText(ukArray[8]);

            ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.cze);
                    mp.start();
                }
            });
            ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.do_widzenia);
                    mp.start();
                }
            });
            ImageButton ib3 = (ImageButton) findViewById(R.id.imageButton3);
            ib3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.dzikuj_ci);
                    mp.start();
                }
            });
            ImageButton ib4 = (ImageButton) findViewById(R.id.imageButton4);
            ib4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.gdzie_jest);
                    mp.start();
                }
            });
            ImageButton ib5 = (ImageButton) findViewById(R.id.imageButton5);
            ib5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.ktra_godzina);
                    mp.start();
                }
            });

        }else if(marker.equals(mUSA)) {
            if (mp != null) {
                mp.reset();
                mp.release();
            }
            mp = MediaPlayer.create(getApplicationContext(), R.raw.usa);
            mp.start();

            imageView.setImageResource(R.drawable.usa);
            capitalText.setText(usaArray[0]);
            mainLangText.setText(usaArray[1] + ", " + usaArray[2]);
            learnHeading.setText(usaArray[3]);
            helloText.setText(usaArray[4]);
            goodbyeText.setText(usaArray[5]);
            thankYouText.setText(usaArray[6]);
            timeText.setText(usaArray[7]);
            whereText.setText(usaArray[8]);

            ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
            ib.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.hola);
                    mp.start();
                }
            });
            ImageButton ib2 = (ImageButton) findViewById(R.id.imageButton2);
            ib2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.adios);
                    mp.start();
                }
            });
            ImageButton ib3 = (ImageButton) findViewById(R.id.imageButton3);
            ib3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.gracias);
                    mp.start();
                }
            });
            ImageButton ib4 = (ImageButton) findViewById(R.id.imageButton4);
            ib4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.dnde_est);
                    mp.start();
                }
            });
            ImageButton ib5 = (ImageButton) findViewById(R.id.imageButton5);
            ib5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mp != null) {
                        mp.reset();
                        mp.release();
                    }
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.que_hora_es);
                    mp.start();
                }
            });

        }
        return false;
    }
}
