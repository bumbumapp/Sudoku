package com.bumbumapps.sudoku.ui;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

public class LoadAds {
    public static InterstitialAd mInterstitialAd;
    public static RewardedAd rewardedVideoAd;
    public static AdRequest adRequest = new AdRequest.Builder().build();

    public static void loadGoogleInterstitialAd(Context context) {
        if (mInterstitialAd == null) {
            InterstitialAd.load(context, "ca-app-pub-8444865753152507/1135714274", adRequest, new InterstitialAdLoadCallback() {
                @Override
                public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                    mInterstitialAd = interstitialAd;
                }

                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    mInterstitialAd = null;
                }
            });
        }

    }
    public static void loadAds(Context context){

        RewardedAd.load(context, "ca-app-pub-8444865753152507/9205243159",
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            rewardedVideoAd = null;
                            Log.d("LoadAdError",loadAdError.getMessage().toString());
                        }
                        @Override
                        public void onAdLoaded(@NonNull RewardedAd ad) {
                            rewardedVideoAd = ad;
                        }
                    });

    }





}
