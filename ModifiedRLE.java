import java.util.*;
import java.lang.*;
        
public class ModifiedRLE {
    public static void main(String [] args) {
        String s1 = "" ;
        int i, j, k ;
        
        Scanner in = new Scanner(System.in) ;
        System.out.print("Enter the input bit sequence: ") ;
        s1 = in.next() ;
        
        int count = 1, index = 0 ;
        int freq[] = new int[s1.length()+1];
        
        for(i = 0; i < s1.length(); i++) {
            if(i < s1.length()-1 && s1.charAt(i) == s1.charAt(i+1))
                count++;
            else {
                freq[index++] = count ;
                count = 1 ;
            }        
        }
        
        /*
        for(i = 0; i < freq.length; i++)
            System.out.print(freq[i]) ;
        */
        
        int max_val = 0, max_bits = 0 ;
        for(i = 0; i < freq.length; i++)
            if(max_val < freq[i])
                max_val = freq[i] ;
        
        // System.out.println(max_val + " " + max_ind) ;
        
        int stuffbit = 0, cutoff = 0, t = 0 ;
        stuffbit = (Integer.toBinaryString(max_val)).length() - 1;
        cutoff = (int)Math.pow(2, stuffbit) ;
        String s2 = "" ;
        
        for(i = 0; i < freq.length; i++) {
            int temp = 1 ;
            if(freq[i] >= cutoff) {
                int index_val = t ;
                int num = ((cutoff+1)*(freq[i]/cutoff)) + freq[i]%cutoff ;
                for(j = 0; j < num && t < s1.length(); j++) {
                    if(t == index_val + cutoff*temp - 1) {
                        if(s1.charAt(t) == '0')
                            s2 += '1' ;
                        else
                            s2 += '0' ;
                        temp++ ;
                    } else {
                        s2 += s1.charAt(t) ;
                        t++ ;
                    }
                }
            } else
                for(j = 0; j < freq[i] && t < s1.length(); j++) {
                    s2 += s1.charAt(t) ;
                    t++ ;
                }
        }
        System.out.println(s2) ;
        
        int new_freq[] = new int[s2.length()+1] ;
        index = 0 ;
        count = 1 ;
        for(i = 0; i < s2.length(); i++) {
            if(i < s2.length()-1 && s2.charAt(i) == s2.charAt(i+1))
                count++;
            else {
                new_freq[index++] = count ;
                count = 1 ;
            }
        }
        
        max_val = 0 ;
        max_bits = 0 ;
        for(i = 0; i < new_freq.length; i++)
            if(max_val < new_freq[i])
                max_val = new_freq[i] ;
        max_bits = (int) Math.ceil(Math.log(max_val)/Math.log(2)) ;
 
 /*int temp = 0;
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
   */
        String s3 = "" ;
        int temp = 0 ;
        for(i = 0; i < new_freq.length; i++) {
            if(new_freq[i] > 2) {
            	String intermediate = Integer.toBinaryString(new_freq[i]) ;
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
               s3 += ("[" + s2.substring(temp, temp+3) + " " + intermediate + "]") ;
            } else
                s3 += (s2.substring(temp, temp+new_freq[i]) + " ") ;
            temp += new_freq[i] ;
        }
        System.out.println(s3) ;
    }
}
