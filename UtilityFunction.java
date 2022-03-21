import java.util.*;
public class UtilityFunction{
   final int m = 10;
   final double d = 0.7;
   final double a = 0.5;

   double max=0;
   String smax="";
   
   public static void main(String args[]){
      new UtilityFunction().go();
   }
   
   public void go(){
      getListAsString("",m);
      System.out.println("Optimal path for M="+m+": "+smax+"0...");
      System.out.println("This generates a maximum utility of: "+max);
   }
   public void getListAsString(String s,int n){
      if(n==0){
         ArrayList<Integer> l = new ArrayList<Integer>();
         listFromString(s,l);
         double v = getListUtility (l);
         if(v>max){
            max=v;
            smax = s;
         }
      }
      else{
         for(int i=1;i<=n;i++){
             getListAsString(s+i+",", n-i);
         }
      }
   }
   
   public double getListUtility(ArrayList<Integer> list){
      double sum=0;
      for(int i=0;i<list.size();i++){
         sum += Math.pow(d,i) * Math.pow(list.get(i),a);
      }
      return sum;
   }
   
   public void listFromString(String s,ArrayList<Integer> list){
      int g = s.indexOf(",");
      if(g==-1){
         return;
      }
      try{
        list.add(Integer.parseInt(s.substring(0,g)));
        if(g < s.length()){
           listFromString(s.substring(g+1),list);
        }
      }
      catch(Exception e){
         System.out.println(e);
      } 
   }
}