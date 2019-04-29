import java.util.Random;

class Solution973 {
    int[][] distances;
    
    public void swap(int a, int b) {
        int[] temp = distances[a];
        distances[a] = distances[b];
        distances[b] = temp;
    }
    
    public boolean isSmallerOrEqual(int a, int b) {
        return (Math.pow(distances[a][0], 2) + Math.pow(distances[a][1], 2)) <= (Math.pow(distances[b][0], 2) + Math.pow(distances[b][1], 2));
    }
    
    public void quickSelect(int start, int end, int k) {
        if(end <= start) return ;
        //First we determine pivot
        Random rand = new Random();
        int pivotIndex = start + rand.nextInt(end-start);
        
        swap(pivotIndex, end);
        int i = start-1;
        for(int j = start; j < end; j++) {
            if(isSmallerOrEqual(j, end)) {
                i++;
                swap(i,j);
            }
        }
        swap(++i, end);
        
        if(i == k) {
            return ;
        } else if ( i < k) {
            quickSelect(i+1, end, k);
        } else {
            quickSelect(start, i-1, k);
        }
    }
    
    public int[][] kClosest(int[][] points, int K) {
        
        if(points == null || points.length == 0) return null;
        if(points.length == 1) return points;
        
        this.distances = points;
        
        quickSelect(0, points.length-1, K);
        
        int[][] answer = new int[K][];
        for(int i = 0; i < K; i++) {
            answer[i] = points[i];
        }
        return answer;
    }
    

}