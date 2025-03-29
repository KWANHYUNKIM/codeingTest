import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class p11507{
    
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        boolean checkValue = true;
        HashMap<String,Integer> box = new HashMap<>();
        HashSet<String> check = new HashSet<>();

        box.put("P",box.getOrDefault("P",13));
        box.put("K",box.getOrDefault("K",13));
        box.put("H",box.getOrDefault("H",13));
        box.put("T",box.getOrDefault("T",13));

        for(int i = 0 ; i <  (input.length() / 3); i++){
            StringBuilder sb = new StringBuilder();
            sb.append(input.substring(i * 3, (i * 3) + 3));
            box.put(String.valueOf(input.charAt(i * 3)),box.getOrDefault(String.valueOf(input.charAt(i * 3)),13) - 1);

            if(!check.contains(sb.toString())){
                check.add(sb.toString());
            }
            else{
                checkValue = false;
                break;
            }
        }
        if(checkValue){
            System.out.println(box.get("P") + " " + box.get("K") + " " + box.get("H") +" " + box.get("T"));
        }else{
            System.out.println("GRESKA");
        }
    }
}