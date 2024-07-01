import java.util.ArrayList;

public class LexicographicPermutations
{

    public static String findNthPermutation(int numDigits, int permutationIndex)
    {
        ArrayList<Integer> digits = new ArrayList<>();
        for (int i = 0; i <= numDigits; i++) digits.add(i);

        permutationIndex--;
        StringBuilder permutation = new StringBuilder();

        while (!digits.isEmpty())
        {
            int factorial = factorial(digits.size() - 1);
            int index = permutationIndex/factorial;
            permutation.append(digits.remove(index));
            permutationIndex %= factorial;
        }

        return permutation.toString();
    }

    private static int factorial(int n)
    {
        if (n <= 1) return 1;
        int result = 1;
        for (int i = 1; i <= n; i++) result *= i;
        return result;
    }

    public static void main(String[] args)
    {
        int numDigits = 9;
        int permutationIndex = 1000000;
        String result = findNthPermutation(numDigits, permutationIndex);
        System.out.println("The " + permutationIndex + "th permutation of digits 0 to " + numDigits + " is: " + result);
    }
}
