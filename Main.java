import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class Main{
    public static void main(String[] args) {
        String FileName = "Frases.txt";
        Main MyFileManager = new Main();
        try{
            MyFileManager.createFile(FileName);
            File myFile = new File(FileName);
            if(myFile.exists()){
                try{
                Scanner FileR = new Scanner(myFile);
                while(FileR.hasNextLine()){
                    String myLine = FileR.nextLine();
                    System.out.println(myLine);
                }
                FileR.close();
                }catch(FileNotFoundException exp){
                    System.out.println("El archivo no existe :(");
                    System.out.println(exp.getMessage());
                }  
            }
    
        }catch(IOException e){
            System.out.println("No se pudo escribir el archivo :(");
            System.out.println(e.getMessage());
        }
    }

    public int createFile(String FileName) throws IOException{
        File myFile = new File(FileName);
        if(!myFile.exists()){
            if(!myFile.createNewFile()){
                System.out.println("No se pudo crear el archivo :(");
                return 0;
            }
        }
        FileWriter FW = new FileWriter(myFile, true);
        FW.write("Un hombre inteligente aprende de sus errores, un sabio de los errores de los demas");
        FW.close();
        return 1;
    }
}