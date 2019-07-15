/**
 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {

    //NOTE, remember that in the fat arrow function we must return the result or else we get nothing back
    return s.trim().split(" ").filter( (str) => {return str !== ""} ).reverse().join(" ");

};
