package com.bumbumapps.sudoku.ui;

import com.bumbumapps.sudoku.AdsHelper;
import org.secuso.privacyfriendlysudoku.ui.view.R;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/** Rewarded ad for hints; interstitials and banners are handled by AdsHelper (UMP consent + cap). */
public class LoadAds {
    public static RewardedAd rewardedVideoAd;
    private static boolean rewardedLoading;

    public static void loadAds(Context context) {
        if (rewardedVideoAd != null || rewardedLoading || !AdsHelper.canRequestAds(context)) {
            return;
        }
        rewardedLoading = true;
        RewardedAd.load(context.getApplicationContext(), context.getString(R.string.rewarded_id),
                new AdRequest.Builder().build(), new RewardedAdLoadCallback() {
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        rewardedVideoAd = null;
                        rewardedLoading = false;
                    }

                    @Override
                    public void onAdLoaded(@NonNull RewardedAd ad) {
                        rewardedVideoAd = ad;
                        rewardedLoading = false;
                    }
                });
    }
}
