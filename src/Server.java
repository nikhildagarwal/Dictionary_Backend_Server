import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;
import extractor.ExtractFileContents;
import extractor.TypeArrayExtractor;
import static_type.Type;
import structure.Definition;
import structure.Dictionary;

import java.io.*;
import java.net.InetSocketAddress;
import java.util.*;

public class Server {

    private static Dictionary dict = new Dictionary();
    private static String[] CSVlist = { "A.csv",
                                "B.csv",
                                "C.csv",
                                "D.csv",
                                "E.csv",
                                "F.csv",
                                "G.csv",
                                "H.csv",
                                "I.csv",
                                "J.csv",
                                "K.csv",
                                "L.csv",
                                "M.csv",
                                "N.csv",
                                "O.csv",
                                "P.csv",
                                "Q.csv",
                                "R.csv",
                                "S.csv",
                                "T.csv",
                                "U.csv",
                                "V.csv",
                                "W.csv",
                                "X.csv",
                                "Y.csv",
                                "Z.csv"};

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

    static class Handler implements HttpHandler {
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestPath = exchange.getRequestURI().getPath();
            requestPath = requestPath.substring(1).toUpperCase();
            String[] parts = requestPath.split("/");
            String response;
            if(parts[0].equals("SEARCH")){
                try{
                    ArrayList<Definition> returned = dict.getDefinitionList(parts[1]);
                    if(returned == null){
                        response = "null";
                    }else{
                        response = returned.toString();
                    }
                }catch (Exception e){
                    response = "Directory Under Development";
                }
            }else{
                response = "Directory Under Development";
            }
            exchange.sendResponseHeaders(200, response.length());
            OutputStream os = exchange.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

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
