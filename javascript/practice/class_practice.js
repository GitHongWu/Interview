// function solution(givenNum, givenArr) {
//     console.log("function");
//     return 50;
// }

// console.log(solution(50, 50));

class Car {
    constructor(name, id) {
        this.name = name;
        this.id = id;
    }

    print() {
        console.log(this.name + " : " + this.id);    
    }
}

const car = new Car("H", 0);
car.print();