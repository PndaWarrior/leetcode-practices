/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    var map = new Map();

    var j = 0,
        answer = 0;

    for(var i = 0; i < s.length; i++) {

        while(j < s.length && !map.has(s.charAt(j))) {
            map.set(s.charAt(j), j);
            answer = Math.max(answer , j-i+1);
            ++j;
        }

        map.delete(s.charAt(i));

    }

    return answer;

};
