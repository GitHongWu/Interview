let map = new Map();
map.set(1, "1");
map.set(2, "2");
map.set(3, [1, 2, 3]);

//1
map.forEach(logMapElements);

function logMapElements(value, key, map) {
    console.log(`m[${key}] = ${value}`);
}

//2
for (const [key, value] of map.entries()) {
    console.log(key, value);
}

