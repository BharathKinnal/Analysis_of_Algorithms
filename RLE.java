import java.util.*;

public class RLE {
	public static void main(String [] args) {
		String s1 = "", s2 = "" ;
		
        	Scanner in = new Scanner(System.in) ;
        	System.out.print("Enter the input bit sequence: ") ;
        	s1 = in.next() ;
        
        	int count = 1,max_val=0, index = 0, i = 0, max_bits=0;
        	int freq[] = new int[s1.length()+1] ;
        
        	for(i = 0; i < s1.length(); i++) {
            		if(i < s1.length()-1 && s1.charAt(i) == s1.charAt(i+1))
                		count++ ;
            		else {
                		freq[index++] = count;
                		if(max_val < count)
        				max_val = count;
                		count = 1 ;
            		}
        	}
        	/*
        	int max_bits = 0 ;
        	for(i = 0; i < freq.length; i++)
        	*/	
        			
        	max_bits = (Integer.toBinaryString(max_val-1)).length(); ;
        	
        	int temp = 0;
        	for(i = 0; i<freq.length && temp<s1.length(); i++) {
        		//freq[i]-=1;
        		String intermediate = Integer.toBinaryString(freq[i]-1) ;
        		//System.out.println(intermediate.length());
        		if(max_bits - intermediate.length() > 0) {
        			int num_zeros = max_bits - intermediate.length() ;
        			//num_zeros++;
        			System.out.println("No. of 0s - "+num_zeros);
        			String zeros = "0" ;
        			while(num_zeros > 1){
        				zeros += "0" ;
        				num_zeros--;
        			}
        			//if(intermediate.length() + 1 == max_bits) 
        			//	zeros += "0";
        			intermediate = zeros + intermediate ;
        		}
        		System.out.println(intermediate);
                	s2 += (s1.substring(temp, temp + 1) + intermediate + " ") ;
            		temp += freq[i] ;
        	}
        	System.out.println(s2) ;
	}
}
