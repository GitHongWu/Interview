const A = [20,24,100];
// [1, 4, 10];
const B = [2, 19, 22, 79, 800];
//[2, 15, 20];
const C = [10, 12, 23, 24, 119];
// [10, 12];

function myFun(a, b, c){
  let result = [];
  let temp = Number.MAX_VALUE;
  for(let i = 0; i < a.length; i++){
    for(let j = 0; j < b.length; j++){
      for(let k = 0; k < c.length; k++){
        let max = Math.abs(a[i]-b[j]) + Math.abs(b[j]-c[k]) + Math.abs(c[k]-a[i]);
        if(max < temp){
          result.push([a[i], b[j], c[k]]);
          temp = max;
        }
      }
    }
  }

  return result[result.length - 1];
}

console.log("Evens");
console.log(myFun(A, B, C));