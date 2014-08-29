package com.yambacode.solutions.euler60.newapp;

import com.yambacode.math.Primes;
import com.yambacode.solutions.AbstractEulerSolver;
import com.yambacode.solutions.EulerRunner;

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

        //populate prime clubs of size 2 to 5
        List<PrimeClub> result = populate(primeClubs, primes, 1);

        //group size 5 clubs by sum
        Map<Long, List<PrimeClub>> collect = result.stream()
                .filter(club -> club.size() == 5)
                .collect(Collectors.groupingBy(PrimeClub::sum));

        //return smallest sum
        return collect.keySet().stream().sorted().findFirst().get().toString();
    }

    public List<PrimeClub> populate(List<PrimeClub> clubs, List<Long> primes, int count) {
        if (count == 5) {
            return clubs;
        }
        return populate(clubs.stream()
                .map(club -> updateClub(club, primes))
                .filter(club -> club != null)
                .collect(Collectors.toList())
                , primes, ++count);
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
