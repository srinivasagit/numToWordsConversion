package numToWordsConversion;

//import java.util.Scanner;

public class NumberToWord
    {
	String number;
    public NumberToWord(String n) {
		// TODO Auto-generated constructor stub
    	this.number=n;
	}

	String NumberToWord1 ()
            {
            String twodigitword="";
            String word="";
            String[] HTLC = {"", "Hundred", "Thousand", "Lakh", "Crore"}; //H-hundread , T-Thousand, ..
            int split[]={0,2, 3, 5, 7,9};
            String[] temp=new String[split.length];
            boolean addzero=true;
            int len1=number.length();
            if (len1>split[split.length-1]) { System.out.println("Error. Maximum Allowed digits "+ split[split.length-1]);
            System.exit(0);
            }
            for (int l=1 ; l<split.length; l++ )
            if (number.length()==split[l] ) addzero=false;
            if (addzero==true) number="0"+number;
            int len=number.length();
            int j=0;
            //spliting & putting numbers in temp array.
            while (split[j]<len)
            {
                int beg=len-split[j+1];
                int end=beg+split[j+1]-split[j];
                temp[j]=number.substring(beg , end);
                j=j+1;
            }
             
            for (int k=0;k<j;k++)
            {
                twodigitword=ConvertOnesTwos(temp[k]);
                if (k>=1){
                if (twodigitword.trim().length()!=0) word=twodigitword+" " +HTLC[k] +" "+word;
                }
                else word=twodigitword ;
                }
               return (word);
            }
     
    private static String ConvertOnesTwos(String t)
    {
        final String[] ones ={"", "One", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve","Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        final String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty","Ninety"};
     
    String word="";
    int num=Integer.parseInt(t);
    if (num%10==0) word=tens[num/10]+" "+word ;
    else if (num<20) word=ones[num]+" "+word ;
    else
    {
        word=tens[(num-(num%10))/10]+word ;
        word=word+" "+ones[num%10] ;
    }
    return word;
    }
 
    public static void main (String args[])
    {
     
    if (args.length!=1)
    {
      System.out.println("Invalid Arguments");
      System.exit(0);
    }
     
    String number_str = args[0];
     
    NumberToWord x = new NumberToWord(number_str);
    String inWords = x.NumberToWord1();
//    String inWords= NumberToWord1(number_str) ;
    if (inWords.trim().length()==0) {inWords="Zero";}
    inWords=inWords + " Only.";
     
    System.out.println("Given Number : " + number_str);
    System.out.println("InWords :" + inWords);
}
 
}
