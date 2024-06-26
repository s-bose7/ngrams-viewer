package com.ngram.app;

import static com.ngram.app.utils.Utils.*;

import org.slf4j.LoggerFactory;

import com.ngram.app.browser.NgordnetServer;
import com.ngram.app.services.NGramMap;


public class Main {
    static {
        LoggerFactory.getLogger(Main.class).info("\033[1;38mChanging text color to white");
    }

    public static void main(String[] args) {
        NgordnetServer hns = new NgordnetServer();

        NGramMap ngm = new NGramMap(TOP_14337_WORDS_FILE, TOTAL_COUNTS_FILE);

        hns.startUp();
        hns.register("history", new HistoryHandler(ngm));
        hns.register("historytext", new HistoryTextHandler(ngm));

        System.out.println("Finished server startup! Visit http://localhost:4567/ngordnet_2a.html");
    }
}
