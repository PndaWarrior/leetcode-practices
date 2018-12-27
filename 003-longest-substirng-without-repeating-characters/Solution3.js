/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {

    var map = new Map();
    var result = 0;

    for (var i = 0, j = 0; j < s.length; j++) {
        if (map.has(s.charAt(j))) {
            i = Math.max(map.get(s.charAt(j))+1, i);
        }
        result = Math.max(result, j-i+1);
        map.set(s.charAt(j), j);
    }

    return result

};
