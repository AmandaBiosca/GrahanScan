import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestGrahanScan {

	public static final double EPSILON = 0.000001;

	public TestGrahanScan() {
	}

	private ConvexHullSolver getConvexHullSolver() {
		return new GrahanScan();
	}

	// ordena pela coordenada x
	// se empatar, ordena pela coordenada y
	private void sortByXY(List<Coordinate> points) {
		Collections.sort(points, new Comparator<Coordinate>() {

			// devolve -1 se c1 < c2, 1 se c1 > c2 ou 0 se c1 = c2
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				if (c1.getX() < c2.getX() - EPSILON) {
					return -1;
				}

				if (c1.getX() > c2.getX() + EPSILON) {
					return 1;
				}

				if (c1.getY() < c2.getY() - EPSILON) {
					return -1;
				}

				if (c1.getY() > c2.getY() + EPSILON) {
					return 1;
				}

				return 0;
			}
		});
	}

	public void applyTestCase(String testCaseFileName)
			throws FileNotFoundException, DequeEmptyException {
		System.out.println("Iniciando o test case do arquivo: "+ testCaseFileName);
		Scanner in = new Scanner(new File(testCaseFileName));
		List<Coordinate> points = new LinkedList<Coordinate>();
		int nPointsInInput = in.nextInt();

		for (int i = 0; i < nPointsInInput; i++) {
			points.add(new Coordinate(in.nextDouble(), in.nextDouble()));
		}

		List<Coordinate> correctConvexHull = new LinkedList<Coordinate>();
		int nPointsInConvexHull = in.nextInt();

		for (int i = 0; i < nPointsInConvexHull; i++) {
			correctConvexHull.add(new Coordinate(in.nextDouble(), in
					.nextDouble()));
		}

		in.close();
		ConvexHullSolver solver = getConvexHullSolver();
		List<Coordinate> computedConvexHull = solver.findConvexHull(points);
		sortByXY(computedConvexHull);
		sortByXY(correctConvexHull);

		if (computedConvexHull.size() != correctConvexHull.size()) {
			throw new RuntimeException(
					"Problemas com o tamanho do fecho convexo");
		}

		Iterator<Coordinate> it = correctConvexHull.iterator();
		for (Coordinate c1 : computedConvexHull) {
			Coordinate c2 = it.next();

			if (!c1.equals(c2)) {
				throw new RuntimeException("Saida incorreta");
			}
		}
		
		System.out.println("Teste realizado com sucesso");
	}
	
	public static void main(String[] args) throws FileNotFoundException, DequeEmptyException {
		TestGrahanScan test = new TestGrahanScan();
		test.applyTestCase("src/testCase1.txt");
		
		// construa mais arquivos de teste!!!
		// test.applyTestCase("src/testCase2.txt");
		// test.applyTestCase("src/testCase3.txt");
		// ...
	}
}
