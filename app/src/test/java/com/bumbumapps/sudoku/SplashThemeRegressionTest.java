package com.bumbumapps.sudoku;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/** Regression guard: SplashActivity (AppCompatActivity) crashed on launch with a platform theme. */
public class SplashThemeRegressionTest {
    @Test
    public void splashThemeIsAppCompat() throws IOException {
        for (String f : new String[]{"src/main/res/values/styles.xml", "src/main/res/values-night/styles.xml"}) {
            String xml = new String(Files.readAllBytes(Paths.get(f)));
            assertTrue(f, xml.contains("<style name=\"SplashTheme\" parent=\"Theme.AppCompat"));
        }
    }
}
