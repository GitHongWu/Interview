#include <iostream>
using namespace std;

// UTILITY FUNCTIONS
// Function to print an array
void printArray(int A[], int size)
{
    // cout << endl << "print: " << endl;
    for (int i = 0; i < size; i++)
        cout << A[i] << " ";
}

void merge(int arr[], int l, int m, int r)
{
    int i = 0;
    int j = 0;
    int l_index = l;
    int r_index = m+1;
    int temp[r-l+1];    //error, but compileable, should not static allocate with non-contant
    int left_size = m-l+1;
    int right_size = r-m;
    int temp_counter = 0;
    
    // cout << endl << endl;
    // cout << "size: " << r-l+1 << endl;
    // cout << "left size: " << left_size << endl;
    // cout << "right size: " << right_size << endl;

    while(i < left_size && j < right_size){
        if(arr[l_index+i]<arr[r_index+j]){
            cout << "A";
            temp[temp_counter] = arr[l_index+i];
            i++;
        }
        else{
            cout << "B";
            temp[temp_counter] = arr[r_index+j];
            j++;
        }
        temp_counter++;
    }

    // copy remaining
    while(i < left_size){
        cout << "b";
        temp[temp_counter] = arr[l_index+i];
        i++;
        temp_counter++;
    }
    while(j < right_size){
        cout << "c";
        temp[temp_counter] = arr[r_index+j];
        j++;
        temp_counter++;
    }
    // printArray(temp, r-l+1);

    //replace temp[] to arr[]
    int another_counter = 0;
    for(l; l <= r; l++){
        arr[l] = temp[another_counter];
        another_counter++;
    }
    // printArray(arr, 3);
}

void mergeSort(int arr[], int l, int r)
{
    if(l >= r){
        return;
    }
    int m = (l+r-1)/2;
    mergeSort(arr,l,m);
    mergeSort(arr,m+1,r);
    merge(arr,l,m,r);
}

// Driver code
int main()
{
    int arr[] = { 12, 11, 13, 5, 6, 7 };
    // int arr[] = {3,1,2};
    int arr_size = sizeof(arr) / sizeof(arr[0]);
    cout << "Array size: " << arr_size << endl;
 
    cout << "Given array is \n";
    printArray(arr, arr_size);
 
    mergeSort(arr, 0, arr_size - 1);
 
    cout << "\nSorted array is \n";
    printArray(arr, arr_size);
    return 0;
}