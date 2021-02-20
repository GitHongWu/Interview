// 给出两个有序的整数数组 A和 B，请将数组B 合并到数组A 中，变成一个有序的数组
// 注意：
// 可以假设A 数组有足够的空间存放B 数组的元素， A和B 中初始的元素数目分别为m 和n

#include <iostream>
using namespace std;

class Solution {
public:
    void merge(int A[], int m, int B[], int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int temp[m + n];
        
        while(i<m && j<n){
            if(A[i] < B[j]){
                temp[k] = A[i];
                i++;
            }
            else{
                temp[k] = B[j];
                j++;
            }
            k++;
        }
        
        while(i < m){
            temp[k] = A[i];
            i++;
            k++;
        }
        
        while(j < n){
            temp[k] = B[j];
            j++;
            k++;
        }
        
        for (int a =0; a < m+n; a++){
            A[a] = temp[a];
        }
    }

    void merge2(int A[], int m, int B[], int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n-1;
        
        while(i>=0 && j>=0){
            if(A[i] < B[j]){
                A[k] = B[j];
                j--;
            }
            else{
                A[k] = A[i];
                i--;
            }
            k--;
        }
        
        while(i >= 0){
            A[k] = A[i];
            i--;
            k--;
        }
        
        while(j >= 0){
            A[k] = B[j];
            j--;
            k--;
        }
    }
};

int main(){

    int A[] = {5, 6, 7, 11, 12, 13, 0, 0, 0};
    int B[] = {1, 2, 3};

    Solution s;
    s.merge2(A, 6, B, 3);

    for (int i = 0; i < 3 + 6;i++){
        cout << A[i] << " ";
    }

    return 0;
}