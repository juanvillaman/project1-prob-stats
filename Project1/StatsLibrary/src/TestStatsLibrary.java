/*
 * This is a tester class for the StatsLibrary, using print statements to showcase the use of various different formulas
 * 
 * @author Juan Villaman
 */
public class TestStatsLibrary {
  public static void main(String[] args){

    StatsLibrary stats = new StatsLibrary();
    int[] sampleData = {2, 3, 4, 7, 5, 5, 9, 9, 9};
    

    System.out.println("Welcome to my Stats Library. Below are many different formulas calculated using random numbers and probabilities");

    System.out.println();

    System.out.println("Mean: " + stats.getMean(sampleData));
    System.out.println("Median: " + stats.getMedian(sampleData));
    System.out.println("Mode: " + stats.getMode(sampleData));
    
    System.out.println();

    System.out.println("Factorial (7!): " + stats.factorial(7));
    System.out.println("Long Factorial (12!): " + stats.longFactorial(12));
    System.out.println("BigInteger Factorial (22!): " + stats.bigFactorial(22));

    System.out.println();

    System.out.println("Standard Deviation: " + stats.getStdDeviation(sampleData));

    System.out.println();

    System.out.println("Combination (5C2): " + stats.getCombination(5, 2));
    System.out.println("Long Combination (10C4): " + stats.longCombination(10, 6));
    System.out.println("Big Combination (20C5): " + stats.bigCombination(20, 5));

    System.out.println();

    System.out.println("Permutation (5P2): " + stats.getPermutation(5, 2));
    System.out.println("Long Permutation (10P4): " + stats.longPermutation(10, 4));
    System.out.println("Big Permutation (20P5): " + stats.bigPermutation(20, 5));

    System.out.println();

    System.out.println("Conditional Probability P(A | B): " + stats.conditionalProbability(0.9, 0.4));

    System.out.println();

    System.out.println("Check Independence: " + stats.checkIndependence(0.5, 0.6, 0.4));
  
    System.out.println();

    System.out.println("Multiplicative Law: " + stats.multiplicativeLaw(0.7, 0.3, 0.1));
    System.out.println("Additive Law: " + stats.additiveLaw(0.6, 0.3, 0.2));

    System.out.println();

    System.out.println("Bayes' Theorem: " + stats.bayesTheorem(0.8, 0.4, 0.5));

    System.out.println();

    System.out.println("Binomial Distribution: " + stats.binomialDistribution(5, 3, 0.6));
    System.out.println("Binomial Variance: " + stats.binomialVariance(5, 0.6));
    System.out.println("Expected Value of Binomial: " + stats.expectedBinomial(5, 0.6));

    System.out.println();

    System.out.println("Geometric Distribution: " + stats.geometricDistribution(3, 0.6));
    System.out.println("Geometric Variance: " + stats.geometricVariance(0.6));
    System.out.println("Expected Value of Geometric: " + stats.expectedGeometric(0.6));

    System.out.println();

    System.out.println("Hypergeometric Distribution: " + stats.hypergeometricDistribution(30, 10, 5, 2));
    System.out.println("Hypergeometric Variance: " + stats.hypergeometricVariance(30, 5, 10));
    System.out.println("Expected Value of Hypergeometric: " + stats.expectedHyperGeometric(5, 10, 30));

    System.out.println();

    System.out.println("Negative Binomial Distribution: " + stats.negativeBinomialDist(3, 4, 0.6));
    System.out.println("Negative Binomial Variance: " + stats.negativeBinomialVariance(4, 0.6));
    System.out.println("Expected Value of Negative Binomial: " + stats.expectedNegativeBinomial(4, 0.6));
  }
}
