package Labs.Lambda_Expression;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
public class Main
{
    public static void main(String[] args){

        // Consumer
        Consumer<String> printt =   a  -> System.out.println(a);
        printt.accept("burhan");
        System.out.println("*********************");


        // Supplier
        String s = "deneme";
        Supplier<Integer> gett = () -> s.length();
        System.out.println(s + " uzunluk = " + gett.get());
        System.out.println("*********************");


        //Function
        Function<String,Integer> function = (text) -> {
            String[] list = text.split(" ");
            int sum=0;
            for(String tex : list){
                if (tex.length()==3) sum++;
            }
            return sum;
        };

        String metin= "bugün hava çok güz el";
        System.out.println(function.apply(metin));
        System.out.println("*********************");

        // Predicate
        Predicate<Integer> isEven = x -> x%2==0 ? true : false;
        System.out.println(isEven.test(56));
        System.out.println(isEven.test(55));






    }

}



