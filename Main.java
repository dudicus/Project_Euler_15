import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int gridSize;
        int middleIndex;
        BigInteger pathCount;
        double longestRow;
        ArrayList<ArrayList<BigInteger>> pascalTri;
        ArrayList<BigInteger> pascalTriRow;

        {
            gridSize = 20;
            longestRow = 1;
            pascalTri = new ArrayList<>();
            pascalTri.add(new ArrayList<>());
            pascalTri.get(0).add(BigInteger.ONE);
        }

        for(int i = 0; i < gridSize * 2; i++) {

            pascalTriRow = new ArrayList<>();

            for(int j = 0; j <= i + 1; j++) {
                if(j == 0 || j == i + 1) {
                    pascalTriRow.add(BigInteger.ONE);
                } else {
                    pascalTriRow.add(pascalTri.get(i).get(j - 1).add(pascalTri.get(i).get(j)));
                }
            }

            pascalTri.add(pascalTriRow);
            longestRow = pascalTriRow.size();
        }

        Double middleIndexDouble = Math.floor(longestRow / 2);

        middleIndex = middleIndexDouble.intValue();

        pathCount = pascalTri.get(pascalTri.size() - 1).get(middleIndex);

        System.out.println("pascal triangle: ");
        pascalTri.forEach(System.out::println);
        System.out.println();

        System.out.printf("The total number of lattice paths for a %dx%d grid is %d%n", gridSize, gridSize, pathCount);
    }
}
