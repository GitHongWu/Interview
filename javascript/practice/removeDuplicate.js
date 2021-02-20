function myFun(s) {
    let result = 'z';   // z is place holder
    for (let i = 0; i < s.length; i++) {
        for (let j = 0; j < result.length; j++) {
            if (s[i] == result[j]) {
                // console.log(i + " turn: break");
                break;
            }
            // console.log(j, result.length);
            if (j == result.length - 1) {
                result += s[i];
            }
        }
    }
    return result;
}

let ArrayInt = [1, 3, 3, 2, 4, 5];
// ArrayString = 'aabbbcee';
ArrayString = 'bbb';
// ArrayString = ArrayString.replace(ArrayString[0],'');
console.log(myFun(ArrayString));
// console.log(myFun(s));