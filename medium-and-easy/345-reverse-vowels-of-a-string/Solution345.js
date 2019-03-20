/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    var array = s.split('');
    let front = 0, back = s.length - 1;
    const set = new Set(['a','e','i','o','u','A','E','I','O','U']);

    while(front < back) {
        while(front < back && !set.has(array[front])) front++;
        while(front < back && !set.has(array[back])) back--;

        [array[front], array[back] ] = [array[back], array[front]];
        front++;
        back--;

    }

    return array.join("");

};
