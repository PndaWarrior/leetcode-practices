class Solution200 {

	public void findNearbyLand(char[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid[x].length || grid[x][y] == '0')
			return;

		grid[x][y] = '0';

		findNearbyLand(grid, x, y + 1);
		findNearbyLand(grid, x, y - 1);
		findNearbyLand(grid, x + 1, y);
		findNearbyLand(grid, x - 1, y);
	}

	public int numIslands(char[][] grid) {
		int answer = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					answer++;
					findNearbyLand(grid, i, j);
				}

			}
		}

		return answer;
	}
}