package com.ngram.app.test;

import com.ngram.app.browser.NgordnetQuery;
import com.ngram.app.HistoryTextHandler;
import com.ngram.app.services.NGramMap;

import org.junit.jupiter.api.Test;
import java.util.List;

import static com.ngram.app.utils.Utils.*;
import static com.google.common.truth.Truth.assertThat;


public class HistoryTextHandlerTest {
    @Test
    public void testHandle() {
        NGramMap ngm = new NGramMap(SHORT_WORDS_FILE, TOTAL_COUNTS_FILE);
        HistoryTextHandler handler = new HistoryTextHandler(ngm);
        NgordnetQuery query = new NgordnetQuery(List.of("request", "airport"), 2006, 2007, 0);
        String actual = handler.handle(query);
        String expected = """
                request: {2006=2.44740192927834E-5, 2007=2.464488338318067E-5}
                airport: {2007=6.2068176510855946E-6}
                """;
        assertThat(actual).isEqualTo(expected);
    }
}