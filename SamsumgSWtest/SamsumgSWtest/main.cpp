#include <iostream>
#include <cstring>
using namespace std;

long long d[101][100];

long long go(int n){
    
    long long result = 0;
    
    
    for(int i=1;i<=9;i++)
        d[1][i] = 1;
    
    for(int i=2; i<=n; i++){
        for(int k=0; k<=9; k++){
            if(k == 0)
                d[i][k] = d[i-1][k+1];
            
            else if(k == 9)
                d[i][k] = d[i-1][k-1];
            else
                d[i][k] = d[i-1][k-1] + d[i-1][k+1];
            
            d[i][k] %= 1000000000;
        }
    }
    
    for(int k=0; k<=9; k++){
        d[n][k] %= 1000000000;
        
        result += d[n][k];
    }
    
    return result%1000000000;
}

int main(){
    
    int n;
    cin >> n;
    memset(d,0,sizeof(d));
    cout << go(n);
    
    
    return 0;
}
