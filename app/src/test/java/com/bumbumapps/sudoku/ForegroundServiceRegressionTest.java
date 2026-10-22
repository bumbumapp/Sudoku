package com.bumbumapps.sudoku;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Regression guard: GeneratorService (a JobIntentService job) called startForeground() without a
 * foreground service type, which throws MissingForegroundServiceTypeException on Android 14+.
 */
public class ForegroundServiceRegressionTest {
    @Test
    public void generatorDoesNotStartForeground() throws IOException {
        String code = new String(Files.readAllBytes(Paths.get(
                "src/main/java/com/bumbumapps/sudoku/controller/GeneratorService.java")));
        assertFalse(code.contains("showNotification(gameType, gameDifficulty);"));
    }
}
