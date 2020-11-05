package messionImpossible;

public class MissionImpossible extends generic_search {
	int m, n, k, c;
	IMF_member[] IMF_members;
	Point Ethan;
	Point Submarine;
	Object[][] Grid;
	String grid = "";
	String r = "";

	public MissionImpossible() {
		genGrid();
		printGrid(Grid);
	}

	public void genGrid() {
		m = (int) (Math.random() * (15 - 5 + 1) + 5);
		n = (int) (Math.random() * (15 - 5 + 1) + 5);
		grid += m + "," + n + ";";
		Grid = new Object[m][n];
		int ex = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
		int ey = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);
		grid += ey + "," + ex + ";";
		IMF_member Ethan = new IMF_member(new Point(ex, ey), "E");
		Grid[ey][ex] = Ethan;
		int sx = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
		int sy = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);
		grid += sy + "," + sx + ";";
		while (ex == sx && ey == sy) {
			sx = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
			sy = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);
		}
		Submarine = new Point(sx, sy);
		Grid[sy][sx] = Submarine;
		k = (int) (Math.random() * (10 - 5 + 1) + 5);
		c = (int) (Math.random() * (k - 1 + 1) + 1);
		r = grid;
		IMF_members = new IMF_member[k];
		String healths = "";
		for (int i = 0; i < k; i++) {
			int x = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
			int y = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);
			Point point = new Point(x, y);
			for (int j = 0; j < k; j++) {
				if ((IMF_members[j] != null)) {
					if ((ex == x && ey == y) || (IMF_members[j].point.x == x) && (IMF_members[j].point.y == y)
							|| (sx == x && sy == y)) {
						x = (int) (Math.random() * ((n - 1) - 0 + 1) + 0);
						y = (int) (Math.random() * ((m - 1) - 0 + 1) + 0);
						point.x = x;
						point.y = y;
						j = 0;
					}
				}
			}
			int h = (int) (Math.random() * (99 - 1 + 1) + 1);
			if (i == (k - 1)) {
				healths += h;
			} else {
				healths += h + ",";
			}

			grid += y + "," + x + ",";
			IMF_members[i] = new IMF_member(point, false, h, "F");
			Grid[y][x] = IMF_members[i];
		}
		grid += ";" + healths + ";" + c;
		System.out.println(grid);
	}

	public void printGrid(Object[][] Grid) {
		for (int i = 0; i < Grid.length; i++) {
			String s = "";
			for (int j = 0; j < Grid[0].length; j++) {
				if (Grid[i][j] != null) {
					try {
						IMF_member m = (IMF_member) Grid[i][j];
						if (m.name == "E") {
							s = "E     |";
						} else {
							if (m.health < 10) {
								s = m.name + "(" + m.health + ")  " + "|";
							} else {
								s = m.name + "(" + m.health + ") " + "|";
							}

						}

						System.out.print(s);
					} catch (Exception e) {
						s = "S     |";
						System.out.print(s);
					}
				} else {
					System.out.print("      |");

				}
			}
			System.out.println();
		}

	}

	public void solve(String grid, String strategy, boolean visualize) {

	}

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		MissionImpossible A = new MissionImpossible();

	}

}
