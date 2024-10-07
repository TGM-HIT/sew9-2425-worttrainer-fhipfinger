package org.fhipfinger.model;

import java.util.List;
import java.util.Random;

/**
 * WordTrainer class
 * This class has a list of wordImages and provides getter and setter as well as some other methods
 * @version 2024-10-06
 * @author Florian Hipfinger
 */
public class WordTrainer {
    List<WordImage> wordImageList;
    int currentPair = -1;
    int totalAttempts;
    int correctAttempts;
    private Persistence storage = new Json();

    /**
     * WordTrainer constructor
     */
    public WordTrainer() {
        storage.load(this);
    }

    /**
     * getter for wordImageList
     * @return wordImageList
     */
    public List<WordImage> getWordImageList() {
        return wordImageList;
    }

    /**
     * setter for wordImageList
     * @param wordImageList the wordImageList
     * @throws IllegalArgumentException when the wordImageList is null or empty
     */
    public void setWordImageList(List<WordImage> wordImageList) {
        if(wordImageList == null || wordImageList.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty or null");
        }
            this.wordImageList = wordImageList;
    }

    /**
     * getter for totalAttempts
     * @return totalAttempts
     */
    public int getTotalAttempts() {
        return totalAttempts;
    }

    /**
     * setter for totalAttempts
     * @param totalAttempts the totalAttempts
     * @throws IllegalArgumentException when the given value is smaller than 1
     */
    public void setTotalAttempts(int totalAttempts) {
        if(totalAttempts < 0) {
            throw new IllegalArgumentException("totalAttempts needs to be greater than 0");
        }
        this.totalAttempts = totalAttempts;
    }

    /**
     * getter for Correct attempts
     * @return the correctAttempts
     */
    public int getCorrectAttempts() {
        return correctAttempts;
    }

    /**
     * setter for CorrectAttempts
     * @param correctAttempts the correctAttempts
     * @throws IllegalArgumentException when the given value is smaller than 1
     */
    public void setCorrectAttempts(int correctAttempts) {
        if(correctAttempts < 0) {
            throw new IllegalArgumentException("correctAttempts need to be greater than 0");
        }
        this.correctAttempts = correctAttempts;
    }

    /**
     * this method returns a random WordImage pair
     * @return random WordImage pair
     */
    public WordImage getRandomWordImage() {
        int i;
        do {
            i = new Random().nextInt(wordImageList.size());
        } while(i == currentPair);
        currentPair = i;
        return wordImageList.get(currentPair);
    }

    /**
     * this method checks if the given name matches the current pairs name
     * @param input the name of the picture
     * @return either true or false depending on the right answer
     */
    public boolean checkInput(String input) {
        totalAttempts++;
        boolean correct = wordImageList.get(currentPair).getWord().equalsIgnoreCase(input);
        if(correct) {
            correctAttempts++;
        }
        return correct;
    }

    /**
     * load method loads a wordTrainer from a file
     */
    public void load() {
        this.storage.load(this);
    }

    /**
     * store method loads a wordTrainer from a file
     */
    public void store() {
        this.storage.store(this);
    }
}
