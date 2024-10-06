package org.fhipfinger.model;

import java.net.URL;
/**
 * Class WordImage
 * This class represents a WordImage Pair
 * It provides getter and setter methods and a URL validation method
 * @version 2024-10-06
 * @author Florian Hipfinger
 */
public class WordImage {
    private String word;
    private String url;

    /**
     * WordImage constructor
     * @param word a word
     * @param url the url
     */
    public WordImage(String word, String url) {
        setWord(word);
        setUrl(url);
    }

    /**
     * getter for the word attribute
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * setter for the word attribute
     * @param word the word
     * @throws IllegalArgumentException if the word is null or emptyy
     */
    public void setWord(String word) {
        if(word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        this.word = word;
    }

    /**
     * getter for the url
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * setter for the url
     * @param url the url
     * @throws IllegalArgumentException if the url is not valid
     */
    public void setUrl(String url) {
        if(!isValid(url) | url.isEmpty()) {
            throw new IllegalArgumentException("URL cannot be null or empty");
        }
        this.url = url;
    }

    /**
     * isValid method, checks if the url has a proper format
     * @param url the url to check
     * @return either true oder false depending on the validation
     */
    public static boolean isValid(String url) {
        try {
            new URL(url).toURI();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
