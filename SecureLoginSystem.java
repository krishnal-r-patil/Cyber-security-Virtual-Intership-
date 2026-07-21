import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Scanner;

public class SecureLoginSystem {
    static HashMap<String,String> users=new HashMap<>();

    static String hash(String input)throws Exception{
        MessageDigest md=MessageDigest.getInstance("SHA-256");
        byte[] b=md.digest(input.getBytes("UTF-8"));
        StringBuilder sb=new StringBuilder();
        for(byte x:b) sb.append(String.format("%02x",x));
        return sb.toString();
    }

    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("\n1.Register\n2.Login\n3.Exit");
            int ch=sc.nextInt(); sc.nextLine();
            if(ch==1){
                System.out.print("Username: ");
                String u=sc.nextLine();
                System.out.print("Password: ");
                String p=sc.nextLine();
                users.put(u,hash(p));
                System.out.println("Registered Successfully.");
            }else if(ch==2){
                System.out.print("Username: ");
                String u=sc.nextLine();
                System.out.print("Password: ");
                String p=sc.nextLine();
                if(users.containsKey(u)&&users.get(u).equals(hash(p))){
                    System.out.println("Login Successful.");
                    System.out.println("Session Started.");
                    System.out.println("Logout Successful.");
                }else{
                    System.out.println("Invalid Credentials.");
                }
            }else break;
        }
        sc.close();
    }
}
