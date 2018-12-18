/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    if (s == null || s.length < 1) return "";
    var start = 0,
        end = 0;

    for (var i = 0; i < s.length; i ++) {
        var len1 = expandFromCenter(s, i, i);
        var len2 = expandFromCenter(s, i, i+1);

        var len = Math.max(len1, len2);
        if(len > (end - start + 1)) {
          //Remember Javascript is not typed strong, so we have to get the floor if we want the same calculation as java
            start = i - Math.floor((len-1)/2);
            end = i + len/2;
        }
    }
    return s.substring(start, end + 1);

};

var expandFromCenter = function(s, l, r) {
    while(l >= 0 && r < s.length && (s[l] == s[r])) {
        l--;
        r++;
    }
    return r - l - 1;
}
