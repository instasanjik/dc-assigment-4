package kz.edu.aitu;

import java.util.concurrent.Callable;

public class PalindromeCallable implements Callable<Boolean> {
    private String word;

    public PalindromeCallable(String word) {
        this.word = word;
    }

    @Override
    public Boolean call() throws Exception {
        int i = 0;
        int j = word.length() - 1;
        while (i < j) {
            if (word.charAt(i) != word.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
