const Array = [-1, 2, 1, -4];

function myFun(array, target){
  let n = array.length;
  if (n <= 3){
    return array;
  }
  
  let cloest = Number.MAX_VALUE;
  for (let i = 0; i < n; i++){
    // console.log(array[i]);
    for (let j = i+1; j < n; j++){
      // console.log(array[j]);
      for (let k = j+1; k < n; k++){
        console.log(array[i], array[j], array[k]);
        
        let sum = array[i] + array[j] + array[k];
        if(Math.abs(sum-target) < cloest){
          var result = [array[i], array[j], array[k]];
          cloest = Math.abs(sum-target);
        }
      }
    }
  }
  return result;
}

console.log(myFun(Array, 1));