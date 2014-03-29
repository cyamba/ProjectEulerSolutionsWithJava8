package com.seewhy.solutions.euler60.newapp;

import com.seewhy.common.io.Printer;
import com.seewhy.math.Primes;
import com.seewhy.solutions.AbstractEulerSolver;
import com.seewhy.solutions.EulerRunner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by cbyamba on 2014-03-29.
 */
public class PrPaSe extends AbstractEulerSolver {


    public static void main(String... args) {
        EulerRunner.runEulerSolvers(new PrPaSe());
    }

    @Override
    public String doSolve() {
        List<Long> primes = Primes.generatePrimesAsList(10000);

        //populate prime clubs with one member
        List<PrimeClub> primeClubs = primes.stream()
                .map(p -> new PrimeClub().add(p))
                .collect(Collectors.toList());

        Printer.print(primeClubs.toArray());

        //populate prime clubs of size 2 to 5
        List<PrimeClub> result = primeClubs.stream()
                .map(club -> updateClub(club, primes)) //2
                .filter(club -> club != null)
                .collect(Collectors.toList())
                .stream()
                .map(club -> updateClub(club, primes)) //3
                .filter(club -> club != null)
                .collect(Collectors.toList())
                .stream()
                .map(club -> updateClub(club, primes)) //4
                .filter(club -> club != null)
                .collect(Collectors.toList())
                .stream()
                .map(club -> updateClub(club, primes))//5
                .filter(club -> club != null)
                .collect(Collectors.toList());


        Printer.print("populated prime clubs");
        Printer.print(primeClubs.toArray());


        //group size 5 clubs by sum
        Map<Long, List<PrimeClub>> collect = result.stream()
                .filter(club -> club.size() == 5)
                .collect(Collectors.groupingBy(PrimeClub::sum));

        //return smallest sum
        return collect.keySet().stream().sorted().findFirst().get().toString();
    }

    public PrimeClub updateClub(PrimeClub club, List<Long> primes) {
        int size = club.size();
        for (Long p : primes) {
            PrimeClub updated = club.add(p);
            if (updated.size() > size) {
                return updated;
            }
        }
        return null;
    }

    /**
     * side effects on primeClub collection
     *
     * @param prime
     * @param primeClubs
     */
    public void addPrimeToClubs(Long prime, List<PrimeClub> primeClubs) {
        primeClubs.stream().map(club -> club.add(prime));
    }


}
