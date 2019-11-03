package com.Ochoa_PA4;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;



public class DuplicateCounter {

    private HashMap<String, Integer> wordCounter;
    private Integer count;

    public DuplicateCounter(){
      wordCounter = new HashMap<String, Integer>();
    }

    public void count(String dataFile) throws IOException{

        try{

            FileInputStream fileByteStream = null;
            Scanner inFS = null;
            fileByteStream = new FileInputStream(dataFile);
            inFS = new Scanner(fileByteStream);

            while (inFS.hasNext()) {

                String str = inFS.next();
                count = wordCounter.get(str);

               // System.out.println(count);

                if(count == null){
                    count = 1;
                }else{
                    count += 1;
                }
                wordCounter.put(str, count);
            }
            /*
            for(String s: wordCounter.keySet()){
                String key = s.toString();
                String value = wordCounter.get(s).toString();
                System.out.println(key + " appears " + value + " times ");
            }
            */
                inFS.close();
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    public void write(String outputFile) throws FileNotFoundException {

       try{
           FileOutputStream fileByteStr = null;
           PrintWriter outFS = null;
           fileByteStr = new FileOutputStream(outputFile);
           outFS = new PrintWriter(fileByteStr);

           for(String s : wordCounter.keySet()){
               String key = s.toString();
               String value = wordCounter.get(s).toString();
               outFS.println(key + " appears " + value + " times ");
           }
                outFS.close();

       }catch (FileNotFoundException e){
           System.out.println("File not found");
       }
    }
}
