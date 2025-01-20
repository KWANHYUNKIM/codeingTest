import java.util.*;
import java.io.*;

class Node{
    String sounds;
    String name;
    Node(String sounds, String name){
        this.sounds = sounds;
        this.name = name;
    }
}

public class p9536 {
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Node> graph = new LinkedList<>();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            String input[] = br.readLine().split(" ");

            for(int j = 0 ; j < input.length; j++){
                graph.add(new Node(input[j],""));
            }
        }
        String searchQuery = "";
        while(true){
            String input[] = br.readLine().split(" ");
            
            if(input.length == 4){
                searchQuery = input[3];
                break;
            }
            else{
                for(int j = 0 ; j < graph.size(); j++){
                    if(graph.get(j).sounds.equals(input[2])){
                        graph.get(j).name = input[0];
                    }
                }
            }
        }
        boolean check = true;
        for(int i = 0 ; i < graph.size(); i++){
            if(searchQuery.equals(graph.get(i).name)){
                check = true; break;
            }
            else{
                check = false;
            }
        }
        
        if(check){
            for(int i = 0 ; i < graph.size(); i++){
                if(searchQuery.equals(graph.get(i).name)){
                    System.out.print(graph.get(i).sounds + " ");
                }
            }
        }
        else{
            for(int i = 0 ; i < graph.size(); i++){
                if(graph.get(i).name.equals("")){
                    System.out.print(graph.get(i).sounds + " ");
                }
            }
        }
    }
}