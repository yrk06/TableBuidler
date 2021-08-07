import java.io.*;

public class Main {
    BufferedReader csvParser;

    public static void main(String kargs[]){
        
        String inFile = "in.csv";
        String outFile = "out.txt";

        for(int p = 0; p<kargs.length;p++){
            if(kargs[p].equals("-i")){
                try{
                    inFile = kargs[p+1];
                } catch(IndexOutOfBoundsException e){
                    System.out.println("Value for argument -i missing");
                    return;
                }
            }
            if(kargs[p].equals("-o")){
                try{
                    outFile = kargs[p+1];
                } catch(IndexOutOfBoundsException e){
                    System.out.println("Value for argument -o missing");
                    return;
                }
            }
        }

        BufferedReader csvStream;
        TableRenderer tr = new TableRenderer();
        try{
            csvStream = new BufferedReader(new FileReader(inFile));
        } catch(FileNotFoundException e){
            System.out.println("Input file was not found");
            return;
        }
        try {
            String header = csvStream.readLine();
            tr.setHeader((Object[])header.split(","));


            String row;
            while ((row = csvStream.readLine()) != null) {
                String[] data = row.split(",");
                // do something with the data
                tr.addRow((Object[])data);
            }
            csvStream.close();

            BufferedWriter out = new BufferedWriter(new FileWriter(outFile,false));
            out.write(tr.build());
            out.close();
        }catch(IOException e){
            System.out.println("There was an error while reading/saving the files");
            e.printStackTrace();
        }
        System.out.print(tr.build());
        

    }
}
