const str = 'abc';
console.log(str.split('').reduce(function (x, y) { return x + y + y; }, [])) // 'aabbcc'

var arr = [1, 3, 5, 7, 9];
console.log(arr.reduce(function (x, y) { return x * 10 + y; }, 0));

var a = arr.reduce(function (res, current, index, array) {
    return res.concat([current, current]);
}, []);
console.log(a);
