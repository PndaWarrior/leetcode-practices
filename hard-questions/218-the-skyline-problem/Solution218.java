import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution218 {
    
    class Node {
        int x = 0;
        int height = 0;
        boolean isStart = false;
        int buildingNumber = 0;
        Node(int x, int height, boolean isStart, int buildingNumber){
            this.x = x;
            this.height = height;
            this.isStart = isStart;
            this.buildingNumber = buildingNumber;
        }
        
    }
    
    public void addToAnswer(List<int[]> answer, int x, int height) {
            int[] newAnswerEntry = new int[2];
            newAnswerEntry[0] = x;
            newAnswerEntry[1] = height;
            answer.add(newAnswerEntry);
    }
    
    public void updateAnswer(List<int[]> answer, int x, int height) {
            int[] newAnswerEntry = new int[2];
            newAnswerEntry[0] = x;
            newAnswerEntry[1] = height;
            answer.set(answer.size()-1, newAnswerEntry);
    }
    
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> answer = new ArrayList<int[]>();
        if(buildings == null || buildings.length == 0) return answer;
        
        List<Node> connectingPoints = new ArrayList<Node>();
        Node[] buildingStartPoints = new Node[buildings.length];
        
        //first let's break up the buildings into start points and end points
        //I also need to store the buildingNodes in an array for later when I want to remove the item from priority queue.
        
        for(int i = 0; i < buildings.length; i++) {
            Node startNode = new Node(buildings[i][0], buildings[i][2], true, i );
            Node endNode = new Node(buildings[i][1], buildings[i][2], false, i );
            connectingPoints.add(startNode);
            connectingPoints.add(endNode);
            buildingStartPoints[i] = startNode;
        }
        
        connectingPoints.sort(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if(a.x == b.x) {
                    if(a.isStart){
                        return 1;
                    } else {
                        return -1;
                    }
                }
                return a.x - b.x;
            }
        });
        
        PriorityQueue<Node> buildingsHeap = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node a, Node b) {
                return b.height - a.height;
            }
        });
        
        for(int i = 0; i < connectingPoints.size(); i++) {
            Node currentPoint = connectingPoints.get(i);
            int[] previousAnswerEntry =  (answer.size() > 0) ? answer.get(answer.size()-1) : null;
            if(currentPoint.isStart) {
                buildingsHeap.add(currentPoint);
                Node currentTallest = buildingsHeap.peek();
                if(answer.size() == 0) {
                    addToAnswer(answer, currentPoint.x, currentTallest.height);
                } else if ( previousAnswerEntry[1] < currentTallest.height) {
                    if(previousAnswerEntry[0] == currentPoint.x) {
                        updateAnswer(answer, currentPoint.x, currentTallest.height);
                    } else {
                        addToAnswer(answer, currentPoint.x, currentTallest.height); 
                    }
                }
            } else {
                Node removingStartPoint = buildingStartPoints[currentPoint.buildingNumber];
                buildingsHeap.remove(removingStartPoint);
                if(i+1 >= connectingPoints.size() || connectingPoints.get(i+1).x != currentPoint.x || connectingPoints.get(i+1).height != currentPoint.height) {
                    if(buildingsHeap.size() == 0) {
                        if(previousAnswerEntry[0] == currentPoint.x) {
                            updateAnswer(answer, currentPoint.x, 0);
                        } else {
                            addToAnswer(answer, currentPoint.x, 0);
                        }
                    } else {
                        Node currentTallest = buildingsHeap.peek();
                        if(currentTallest.height < previousAnswerEntry[1]) {
                            if(previousAnswerEntry[0] == currentPoint.x) {
                                updateAnswer(answer, currentPoint.x, currentTallest.height);
                            } else {
                                addToAnswer(answer, currentPoint.x, currentTallest.height);
                            }
                        }
                    }
                }

            }
            
        }
        
        return answer;
        
    }
}