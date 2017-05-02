import java.util.*;
import java.lang.*;

public class Vafle {
	public static void main(String [] args) {
		String s1 = "", s2 = "" ;
		
        	Scanner in = new Scanner(System.in) ;
        	System.out.print("Enter the input bit sequence: ") ;
        	s1 = in.next() ;
        
        	int count = 1, index = 0, i = 0, j=0;
        	int freq[] = new int[s1.length()+1] ;
        
        	for(i = 0; i < s1.length(); i++) {
            		if(i < s1.length()-1 && s1.charAt(i) == s1.charAt(i+1))
                		count++ ;
            		else {
                		freq[index++] = count;
                		//if(max_val < count)
        			//	max_val = count;
                		count = 1 ;
            		}
        	}
        			
        	
        	//max_bits = (Integer.toBinaryString(max_val-1)).length(); ;
        	
        	int temp = 0;
        	for(i = 0; i<freq.length && temp<s1.length(); i++) {
        	
        		if(freq[i]<=2){
        			s2 += (s1.substring(temp,temp+freq[i]));
        			temp += freq[i] ;
        		}
        		else{
        			String value="",flag="",leng="";
        	
        			value += (s1.substring(temp,temp+2));
        			
        			
        			int k=(Integer.toBinaryString(freq[i]-1)).length()-1;
        			
        			for(j=0;j<k;j++)
        				flag += (s1.substring(temp,temp+1));
        				
        			if(flag.charAt(0)=='1')
        				flag += "0";
        			else
        				flag += "1";
        				
        			
        			int l = freq[i]-1 - (int)Math.pow(2,k);
        			int max_bits = k;
        			
        			String intermediate = Integer.toBinaryString(l) ;
        			if(max_bits - intermediate.length() > 0) {
        				int num_zeros = max_bits - intermediate.length() ;
        				System.out.println("No. of 0s - " + num_zeros);
        				String zeros = "0" ;
        				while(num_zeros > 1){
        					zeros += "0" ;
        					num_zeros--;
        				}
        				leng += zeros;
        			}
        			leng += intermediate;
        			
        			
        			s2 += ("[" + value + " " + flag + " " + leng + "] ") ;
        			
        			
        			temp += freq[i] ;
        		}	
        		
        		
        		/*String intermediate = Integer.toBinaryString(freq[i]-1) ;
        		if(max_bits - intermediate.length() > 0) {
        			int num_zeros = max_bits - intermediate.length() ;
        			System.out.println("No. of 0s - "+num_zeros);
        			String zeros = "0" ;
        			while(num_zeros > 1){
        				zeros += "0" ;
        				num_zeros--;
        			}
        			intermediate = zeros + intermediate ;
        		}
        		System.out.println(intermediate);
                	s2 += (s1.substring(temp, temp + 1) + intermediate + " ") ;
            		*/
            		
            		
        	}
        	System.out.println(s2) ;
	}
}
