/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;


/**
 *
 * @author Zvika
 */
public class sourceData {  
    /**
    * read_file_to_String v1.2_S
    * Not ignoring the first line!
    */ 
    public static String read_file_to_String(String file_Loc) {
        String line, text ="";
        File file;
        FileReader File_Reader;
        BufferedReader Buffered_Reader;
        
        try {
            if(file_Loc==null) return null;
            file = new File(file_Loc);
            if(file==null) return null;

            File_Reader = new FileReader(file);
            Buffered_Reader = new BufferedReader(File_Reader);
            
            line = Buffered_Reader.readLine();
            while(line != null){
                text += line + "\n";
                line = Buffered_Reader.readLine();
            }
            Buffered_Reader.close();
            File_Reader.close();
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException ex) { 
            return null;
        }
        return text;       
    }
    
    /**
    * wtire_String_to_file v1.2_S
    */ 
    public static boolean wtire_String_to_file(String file_Loc,String text){
        FileOutputStream file_output_stream;
        PrintWriter print_writer;

        try {    
            file_output_stream = new FileOutputStream(file_Loc);
            print_writer = new PrintWriter(file_output_stream);
            print_writer.write(text);

            print_writer.close();
            file_output_stream.close();

        } catch (IOException ex) {
            return false;
        }
        return true; 
    }
}
