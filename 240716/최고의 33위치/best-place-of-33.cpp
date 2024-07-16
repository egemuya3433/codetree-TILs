#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main() {

    int map[20][20];
    int n;
    cin >> n;
    int temp = 0;
    cin.ignore();
    while(temp < n){
        string t;
        getline(cin, t);
        stringstream ss;
        ss.str(t);
        string e;
        int n2 = 0;
        while(ss >> e){
            map[temp][n2] = stoi(e);
            n2++;
        }
        temp++;
    }
    int row = 0;
    int row2 = 0;
    int col = 0;
    int max = 0;
    while(col + 2 < n){
        while(row + 2 < n){
            int num = 0;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    num += map[col + i][row + j];
                }
            }
            if(num > max){
                max = num;
            }
            row++;
        }
        row = row2;
        col++;
    }

    cout << max;
    return 0;
}