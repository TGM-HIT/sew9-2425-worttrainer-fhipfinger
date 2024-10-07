package org.fhipfinger.model;

import com.google.gson.Gson;

import java.io.*;

/**
 * class Json implements the Persistence interface and provides load and store methods
 * these methods either transfer a java object into a json file or extract the data of a
 * json file and put it into a java object
 * @version 2024-10-07
 * @author Florian Hipfinger
 */
public class Json implements Persistence {
    /**
     * constructor Json
     */
    public Json() {

    }

    /**
     * load method reads json from a file using gson
     * @param wordTrainer the object where the written data should be inserted to
     */
    @Override
    public void load(WordTrainer wordTrainer) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("wordTrainer.json")) {
            WordTrainer temp = gson.fromJson(reader, WordTrainer.class);
            System.out.println(temp);

            wordTrainer.setWordImageList(temp.getWordImageList());
            wordTrainer.setTotalAttempts(temp.getTotalAttempts());
            wordTrainer.setCorrectAttempts(temp.getCorrectAttempts());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * store method writes java object to json file using gson
     * @param wordTrainer the object that gets written into the json file
     */
    @Override
    public void store(WordTrainer wordTrainer) {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("wordTrainer.json")){
            gson.toJson(wordTrainer, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
