/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gmsts
 */

import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.io.*;
import java.util.Scanner;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
//import java.nio.file.Files;
import java.io.RandomAccessFile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.util.List;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;





public class main {
   
    public static void main (String[]args) throws FileNotFoundException, IOException {
         Scanner sc=new Scanner(System.in);
         try {
            File file = new File("C:\\test.txt");
	    /*If file gets created then the createNewFile() 
	    * method would return true or if the file is 
	    * already present it would return false
	    */
            boolean fileBool = file.createNewFile();
	    if (fileBool){
	        System.out.println("to arxeio  dhmioyrgithike");
	    }
	    else{
	        System.out.println("yparxei hdh arxeio me ayto to onoma");
	    }
    	} catch (IOException e) {
    		System.out.println("paroysiastike Exception:");
	        e.printStackTrace();
	}

         
         
         
         
         
     //     List<String> List = new ArrayList<String>();
        //eisagwgh stoixeiwn mesw scanner me analogo mhnyma
        System.out.println("dwse onoma tragoydioy ");
      String  name=sc.nextLine();
       System.out.println("dwse aritst ");
      String artist= sc.nextLine();
         System.out.println("dwse album ");
         String album= sc.nextLine();
          System.out.println("dwse twrinh hmerominia ");// prepei na baloyme entolh gia thn hmeromhnia eisagwghs stoi systhma 
          String releasedDate= sc.nextLine();
           System.out.println("dwse typo tragoydioy ");
           String type= sc.nextLine();
            System.out.println("dwse diarkeia tragoydioy ");
            int duration=sc.nextInt();
             System.out.println("dwse tyxaio integer ");
             int songID =sc.nextInt();
             
       Song s=new Song( name,artist, album, releasedDate,type,duration, songID);
       
        List<Object> List = new ArrayList<Object>();
        List.add(s.getSongName());
        List.add(s.getArtist());        
        List.add(s.getAlbum());
        List.add(s.getReleasedDate());
        List.add(s.getType());
        List.add(s.getDuration());
        List.add(s.getSongID());
        
       
        // to teleytaio int den exei shmasia ti tha einai
        // prepei na apothikeyontai se arraylists se kapoio fakelo
        
        // o fakelos tha dhmioyrgithei me entolh file.mkdir kai file.renameTo gia style(ypothetw)
        // me ena for pernaw ta stoixeia poy eisagei o xrhsths se arraylists me methodo
        
       // theloyme ena kanoniko fakelo oxi text
       //PREPEI NA BRW TROPO NA APOTHIKEYEIS TA ARRAYLIST KAPOY KAI NA EXEIS PROSBASH SE AYTA
     //  File.mkdir();
       
      /** try{
         BufferedOutputStream arxeio=new BufferedOutputStream(new FileOutputStream("test.txt"));
           long arxeioSize=arxeio.length();
           arxeio.seek(arxeioSize);  //o protzektoras tha paei sto telos toy arxeioy
          // xreiazetai na balw tis methodoys read.byte se for analoga to length toy kathe stoixeioy gia na trexei
           
           arxeio.writeUTF(name); //xreiazomai tropo otan dhmioyrgw antikeimena songs na 
           arxeio.writeUTF(artist);
           arxeio.writeUTF(album);
           arxeio.writeUTF(releasedDate);
           arxeio.writeUTF(type);
           arxeio.writeInt(duration);
           arxeio.writeInt(songID);
       }**/
      
      
      // TROPOS ME RANDOMACCESSFILE
     /** try{
        RandomAccessFile arxeio=new randomAccessFile(new File("test.txt"),rw);
           long arxeioSize=arxeio.length();
           arxeio.seek(arxeioSize);  //o protzektoras tha paei sto telos toy arxeioy
          // xreiazetai na balw tis methodoys read.byte se for analoga to length toy kathe stoixeioy gia na trexei
           
           arxeio.writeUTF(name); //xreiazomai tropo otan dhmioyrgw antikeimena songs na 
           arxeio.writeUTF(artist);
           arxeio.writeUTF(album);
           arxeio.writeUTF(releasedDate);
           arxeio.writeUTF(type);
           arxeio.writeInt(duration);
           arxeio.writeInt(songID);
       }**/
     
     
     //TROPOS ME FILEOUTPUT KAI FILEWRITER
      try{
         BufferedOutputStream arxeio=new BufferedOutputStream(new FileOutputStream("test.txt"));
         //  long arxeioSize=arxeio.length();
        //   arxeio.seek(arxeioSize);  //o protzektoras tha paei sto telos toy arxeioy
          // xreiazetai na balw tis methodoys read.byte se for analoga to length toy kathe stoixeioy gia na trexei
         
         arxeio.write(songID);
         arxeio.write(duration);
          
         
         
         
         arxeio.flush();
                                 //na apothikeyontai sto test1.txt ws arraylist
         //..... synexise to idio kai me ta ypoloipa stoixeia
    } catch(IOException e) {
           e.getStackTrace();
           System.err.println("paroysiasthke error sto anoigma toy arxeioy, termatizetai");
           System.exit(1);
  
       }
      
      
      try {
          BufferedWriter arxeio= new BufferedWriter(new FileWriter("test.txt"));
          arxeio.write(name);
          arxeio.write(artist);
          arxeio.write(album);
          arxeio.write(releasedDate);
          arxeio.write(type);
          
          arxeio.flush();
       
        
    } catch(IOException e) {
        e.getStackTrace();
        System.err.println("paroysiasthke error sto anoigma toy arxeioy, termatizetai");
        System.exit(1);
        
    }
    
}
}
