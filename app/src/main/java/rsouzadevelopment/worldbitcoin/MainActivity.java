package rsouzadevelopment.worldbitcoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    private AdView adView;
    private Button btnInterstitial;
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adView = (AdView)findViewById(R.id.adsBanner);
        btnInterstitial = (Button)findViewById(R.id.btnInterstitial);
       // AdRequest adRequest = new AdRequest.Builder().build();

        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        adRequestBuilder.addTestDevice("E55055C0FE9E6D3887092F8E99820AB1");
        adView.loadAd(adRequestBuilder.build());

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.IdAdMobIntersticial));

        loadInterstitial();

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                loadInterstitial();
            }
        });
        
        btnInterstitial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interstitialAd.show();
            }
        });

    }


    @Override
    protected void onPause() {

        if(adView!=null){
            adView.pause();
        }
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        if(adView!=null){
            adView.destroy();
        }
            super.onDestroy();

    }


    @Override
    protected void onResume() {
        super.onResume();
        if(adView!=null){
          adView.resume();
        }
    }



    private void loadInterstitial(){
            //AdRequest adRequest = new AdRequest.Builder().build();

        AdRequest.Builder adRequestBuilder = new AdRequest.Builder();
        adRequestBuilder.addTestDevice("E55055C0FE9E6D3887092F8E99820AB1");
            interstitialAd.loadAd(adRequestBuilder.build());
    }
}
