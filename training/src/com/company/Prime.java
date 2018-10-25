package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Prime {
    int max;
    List<Integer> primes = new ArrayList<>();

    Prime(int max){
        this.max = max;
        float dp = 100 / (float)max;
        float p;
        primes.add(3);
        for(int i = 5; i < max; i += 2){
            p = dp * (float)i;
            System.out.printf("%.2f%%\n", p);
            if (this.isPrime(i)) {
                primes.add(i);
            }
        }
        primes.add(0, 2);
    }

    public boolean isPrime(int a){
        for(Integer p : primes) {
            if((double)p > Math.sqrt((double)a)){
                break;
            }
            if (a % p == 0) {
                return false;
            }
        }
        return true;
    }

    public void getPrimes() {
        for(Integer a : primes){
            System.out.println(a);
        }
    }

    public void writePrimes(String dir, long time) {
        try(FileWriter writer = new FileWriter(dir, false)){
            writer.write("Простые числа до " + max + ":\nВсего " + primes.size()+"(Предп. " + Math.round((double)max/Math.log((double)max)) + ")\n");
            for(int pr = 0; pr < primes.size(); pr++){
                writer.write(String.valueOf(primes.get(pr)));
                writer.append('\n');
            }
            writer.write("Время вычисления: " + time + "мс (" + time/1000 + "c)");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
