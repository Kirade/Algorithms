//
//  main.cpp
//  BJ_2839
//
//  Created by 허재영 on 2017. 7. 3..
//  Copyright © 2017년 허재영. All rights reserved.
//

#include <iostream>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int n,totalBag;
    int five_bag, three_bag;
    
    int max_alpha=9999, max_beta=9999;
    int alpha=0, beta=0;
    int remain;
    
    cin>>n;
    
    //5의 갯수 기준
    for(int i=0;i<=(n/5);i++){
        five_bag = i;
        remain = n-(5*i);
        three_bag = remain/3;
        if(remain%3){
            continue;
        }
        else{
            alpha = five_bag + three_bag;
            if(alpha<max_alpha){
                max_alpha = alpha;
            }
        }
    }
    
    //3의 갯수 기준
    for(int i=0;i<=(n/3);i++){
        three_bag = i;
        remain = n-(3*i);
        five_bag = remain/5;
        if(remain%5){
            continue;
        }
        else{
            beta = five_bag + three_bag;
            if(beta<max_beta){
                max_beta = beta;
            }
        }
    }
    
    if(max_alpha == 9999 && max_beta == 9999){
        totalBag = -1;
    }
    else if(max_alpha <= max_beta){
        totalBag = max_alpha;
    }
    else{
        totalBag = max_beta;
    }
    
    
    cout<<totalBag<<endl;
    
    
    return 0;
}
