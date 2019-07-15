/**
 * @param {number[][]} stones
 * @return {number}
 */

class UnionFind {
    constructor() {
        this.parents = [];
        this.movesCount = 0;
    }

    find(x) {

        let rootParent = x;
        while (rootParent != this.parents[rootParent]) {
            rootParent = this.parents[rootParent];
        }

        let temp,
            current = x;

        while (current != this.parents[current]) {
            temp = this.parents[current];
            this.parents[current] = rootParent;
            current = temp;
        }
        return rootParent;
    }

    union(a, b) {
        let rootA = this.find(a);
        let rootB = this.find(b);
        this.parents[rootB] = rootA;
    }

    test() {
        console.log(`just a test function`);
    }

}


var removeStones = function(stones) {

    let uf = new UnionFind();

    let maxRow = -1,
        maxCol = -1;

    stones.forEach(function(stone) {
        maxRow = Math.max(stone[0] + 1, maxRow);
        maxCol = Math.max(stone[1] + 1, maxCol);
    });

    for (var i = 0; i < maxRow + maxCol; i++) {
        uf.parents[i] = i;
    }

    stones.forEach((stone) => {
        uf.union(stone[0], stone[1] + maxRow);
    });

    let parentsSeen = new Set();

    stones.forEach((stone) => {
        parentsSeen.add(uf.find(stone[0]));
    })

    return stones.length - parentsSeen.size;

};
