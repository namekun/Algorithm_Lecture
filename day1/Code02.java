package day1;

public class Code02{
    public static void main(String [] args){
        func(4);
    }
    
    public static void func(int k){
        //base case
        if(k<=0) 
            return;
        //Recursive case
        else{
            System.out.println("Hello...");
            func(k-1);
        }
    }
}
