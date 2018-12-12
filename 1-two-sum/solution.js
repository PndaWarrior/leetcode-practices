/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function(nums, target) {

    var map = new Map();

    for(var i = 0; i < nums.length; i++) {
        var answer = target - nums[i];
        if(map.has(answer)) {
            return [map.get(answer), i];
        }
        map.set(nums[i], i);
    }

};
