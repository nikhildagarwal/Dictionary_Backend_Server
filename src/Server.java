import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import extractor.ExtractFileContents;
import extractor.TypeArrayExtractor;
import static_type.Type;
import structure.DNode;
import structure.Definition;
import structure.Dictionary;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.*;

public class Server {

    private static Dictionary dict = new Dictionary();
    private static String[] CSVlist = { "A.txt", "B.txt", "C.txt", "D.txt", "E.txt", "F.txt", "G.txt", "H.txt", "I.txt", "J.txt", "K.txt", "L.txt", "M.txt",
                                        "N.txt", "O.txt", "P.txt", "Q.txt", "R.txt", "S.txt", "T.txt", "U.txt", "V.txt", "W.txt", "X.txt", "Y.txt", "Z.txt"};

    /**
     * Initial build method to put all data from CSV files into Dictionary Object
     * @throws FileNotFoundException Exception Handler
     */
    private static void buildDict() throws FileNotFoundException {
        TypeArrayExtractor tae = new TypeArrayExtractor();
        int i = 0;
        for(String name: CSVlist){
            ExtractFileContents extract = new ExtractFileContents("./data/"+name);
            ArrayList<String> fileWords = extract.getWords();
            int j = 0;
            for(String bulk: fileWords){
                if(!bulk.isEmpty()){
                    if(bulk.charAt(0) == '\"'){
                        int l = bulk.length();
                        bulk = bulk.substring(1,l-1);
                    }
                    String[] parts = bulk.replace("(",")").split("\\)");
                    if(parts.length>=3){
                        String word = parts[0].trim().toUpperCase();
                        String typeCode = parts[1].trim();
                        String def = parts[2].trim();
                        tae.setTypes(typeCode);
                        ArrayList<Type> types = tae.getTypes();
                        dict.add(word,def,types,null);
                        j++;
                    }
                }
            }
            i+=j;
        }
        System.out.println("Words in Dictionary: "+ (i));
    }

    /**
     * Handler Class For handling http requests for our server
     */
    static class Handler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestPath = exchange.getRequestURI().getPath();
            requestPath = requestPath.substring(1);
            String[] parts = requestPath.split("/");
            String response;
            if(parts[0].equals("search")){
                try{
                    ArrayList<Definition> returned = dict.getDefinitionList(parts[1].toUpperCase());
                    if(returned == null){
                        response = "null";
                    }else{
                        StringBuilder m = new StringBuilder();
                        for(Definition d : returned){
                            m.append(d.toString()).append("\n\n");
                        }
                        response = "Word: "+parts[1].toUpperCase()+"\n\n"+m;
                    }
                }catch (Exception e){
                    response = "Invalid Directory";
                }
            }else if(parts[0].equals("add")){
                try{
                    response = serverAdd(parts[1]);
                }catch (Exception e){
                    response = "Invalid Directory: UNABLE TO ADD WORD & DEFINITION\n(Make sure URL does not contain / or ? characters)";
                }
            }else if(parts[0].equals("list")){
                try{
                    if(parts.length<2){
                        response = "Must provide a prefix to search for in the dictionary";
                    }else{
                        response = dict.getList(parts[1].toUpperCase()).toString();
                        if(response.isEmpty()){
                            response = "No words found with prefix: "+parts[1];
                        }
                    }
                }catch (Exception e){
                    response = "No words found with prefix: "+parts[1];
                }

            }else{
                response = "Invalid Directory";
            }
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    /**
     * Method to add data given in URL to Dictionary Object
     * If URL data is invalid or syntax is incorrect, handles error and returns "Invalid Directory" message
     * @param requestPath String request Path
     * @return message based on definition added or not
     */
    private static String serverAdd(String requestPath){
        String[] master = requestPath.split("\\+");
        ArrayList<Type> types = new ArrayList<>();
        String[] typeStrings = master[2].split(",");
        for(String ts: typeStrings){
            types.add(Type.getTypeFromString(ts.toLowerCase().trim()));
        }
        if(dict.add(master[0].toUpperCase(),master[1],types,master[3])){
            updateTextFile(master[0],master[1],types,master[3]);
            return master[0]+" & definition added successfully!";
        }
        return master[0]+" already contains given definition";
    }

    /**
     * Updates TEXT files and adds word and definition to file
     * @param word String word
     * @param def String definition
     * @param types List of Type ENUMS
     * @param sentence String Sentence
     */
    private static void updateTextFile(String word, String def, ArrayList<Type> types, String sentence){
        String filePath = "./data/"+ word.substring(0,1).toUpperCase() +".txt";
        try {
            FileWriter fileWriter = new FileWriter(filePath, true);
            StringBuilder sb = new StringBuilder();
            int l = types.size();
            for(int i = 0;i<l;i++){
                if(i+1 == l){
                    sb.append(types.get(i).getString());
                }else{
                    sb.append(types.get(i).getString());
                    sb.append(",");
                }
            }
            String message = word+"("+sb+")"+def+"\n\n";
            fileWriter.append(message);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Start up the server and load Dictionary data structure
     * Creates connection to local host port 8000
     * @param args Input args **NOT USED**
     * @throws IOException Exception handle
     */
    public static void main(String[] args) throws IOException {
        buildDict();
        int port = 8000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        Handler handle = new Handler();
        server.createContext("/",handle);
        server.setExecutor(null);
        server.start();
        System.out.println("Server started on port " + port);
    }
}
