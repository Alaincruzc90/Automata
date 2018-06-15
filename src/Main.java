/*
  File Name: Main.java
  
  To Run: 
  > jflex wheels.flex
  > java -jar java-cup-11b.jar yanaliz.cup
  > javac -cp .:java-cup-11b-runtime.jar Main.java
  > java -cp .:java-cup-11b.jar Main test.txt
*/
   
import java.io.*;
import java.net.URL;

public class Main {

    static public void main(String argv[]) {
        /* Start the parser */
        try {
            URL path = ClassLoader.getSystemResource("FINAL.txt");
            if(path==null) {
                throw new Exception("Can't find the file.");
            }
            parser p = new parser(new Lexer(new FileReader(path.getPath())));
            Object result = p.parse().value;
            //String hola = "";
        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
    }
}