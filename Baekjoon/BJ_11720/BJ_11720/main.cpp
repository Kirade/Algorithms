//
//  main.cpp
//  BJ_11720
//
//  Created by 허재영 on 2017. 7. 3..
//  Copyright © 2017년 허재영. All rights reserved.
//

#include <iostream>
#include <string>

using namespace std;

int main(int argc, const char * argv[]) {
    
    int number_of_digits;
    int number;
    int total=0;
    
    cin>>number_of_digits;
    cin>>number;
    
    for(int i=number_of_digits;i>0;i--){
        
        total += number/(i-1)*10;
    }
    
    
    return 0;
    
}
