// const givenArr = [23, 1, 4, 6, 89, 102];
const givenArr2 = [[1, 3], [2, 4], [4, 5]];

console.log(givenArr2[0][0]);

function removeOverlapInterval(arr) {
    console.log(arr);
    let result = []

    let n = arr.length;
    if (n <= 1) {
        return arr;
    }
    result.push(arr[0]);
    for (i = 1; i < n; i++){
        if (arr[i][0] >= arr[i-1][1]) {
            result.push(arr[i]);
        }
    }
    return result;
}

console.log(removeOverlapInterval(givenArr2));