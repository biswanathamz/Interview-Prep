import java.util.*;
class main{
    public static char processStr(String s, long k) {
        int n = s.length();
        long[] lengths = new long[n];
        long len = 0;

        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                len++;
            }
            else if(ch=='*'){
                if(len > 0) len--;
            }
            else if(ch=='#'){
                len *= 2;
            }
            lengths[i] = len;
        }

        if(k>=len){
            return '.';
        }

        for(int i = (n-1); i>=0 ;i--){
            char ch = s.charAt(i);

            long currLen = lengths[i];

            if (ch >= 'a' && ch <= 'z') {

                if (k == currLen - 1) {
                    return ch;
                }
            }
            else if (ch == '#') {

                long half = currLen / 2;

                k %= half;
            }
            else if (ch == '%') {

                k = currLen - 1 - k;
            }
        }
        return '.';
    }

    public static void main(String args[]){
        System.out.println(processStr("a#b%*",1));
    }
}