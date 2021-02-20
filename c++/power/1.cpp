#include <iostream>
#include <math.h>
using namespace std;

int power(int a, int b){
    if(b == 0){
        return 1;
    }
    if (b == 1){
        return a;
    }
    a = a * power(a, b - 1);
    return a;
}

int main(){
    int base = 10;
    int exp = 0;
    cout << pow(base, exp) << endl;
    cout << power(base, exp);
    
    return 0;
}