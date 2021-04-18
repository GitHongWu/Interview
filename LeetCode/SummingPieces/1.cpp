#include <cmath>
#include <cstdio>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

long long powers[1000003];
const int MOD = 1000000007;
int main() {
	/* Enter your code here. Read input from STDIN. Print output to STDOUT */
	powers[0] = 1;
	for (int i = 1; i<1000003; i++)
    // for (int i = 1; i<10; i++)
	{
		powers[i] = (2 * powers[i - 1]) % MOD;
        // cout << powers[i] << " ";
        // cout << pow(2, i) << " ";
    }
    // cout << powers[1000002];

    int N;
	cin >> N;
	long long result = 0;
	for (int i = 0; i<N; i++)
	{
		long long num;
		cin >> num;
		long long mult = ((powers[i + 1] + powers[i] - 1)*powers[N - 1 - i] - powers[i] + MOD) % MOD;
        // cout << (powers[i + 1] + powers[i] - 1)*powers[N - 1 - i] - powers[i] + MOD << " ";
        result += num*(mult) % MOD;
        cout << result << " ";
        result = result % MOD;
        // 28 477 392 161 421 245 50 530 889 750 16 545 303 898 785 162 279 677 664 126 149 814 360 334 681 473 293 267 120
	}
	cout << result;

	return 0;
}