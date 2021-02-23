const arrayList = [4, 6, 7, 34, 90, 43, 22, 10];

function myFun(input, array){
  // array = array.sort(function(a, b){return b-a});
  console.log(array);
  let n = array.length;
  
  if (n <= 3){
    return array;
  }
  
  let diffArr = [];
  let map = new Map();
  for (let i = 0; i < n; i++){
    let diff = Math.abs(array[i] - input);
    diffArr.push(diff);
    map.set(diff, array[i]);
  }
  diffArr.sort(function(a, b){return a-b});
  
  let result = [];
  for(let j = 0; j < 3; j++){
    result.push(map.get(diffArr[j]));
  }
  
  return result;
}

console.log(myFun(4, arrayList));