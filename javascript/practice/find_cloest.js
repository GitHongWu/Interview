const A = [20,24,100];
// [1, 4, 10];
const B = [2, 19, 22, 79, 800];
//[2, 15, 20];
const C = [10, 12, 23, 24, 119];
// [10, 12];

function myFun(array, target){
  let cloest = Number.MAX_VALUE;
  for (let i = 0; i < array.length; i++){
    if(cloest > Math.abs(array[i]-target)){
      var result = array[i];
      cloest = Math.abs(array[i]-target);
    }
  }
  return result;
}

console.log(myFun(B, 11));