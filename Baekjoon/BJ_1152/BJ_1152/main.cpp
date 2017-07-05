//
//  main.cpp
//  BJ_1152
//
//  Created by 허재영 on 2017. 7. 3..
//  Copyright © 2017년 허재영. All rights reserved.
//
#include <iostream>
#include <string>
#include <cstring>

using namespace std;

int main(int argc, const char * argv[]) {
    
    string data;
    
    int blank_count=0;
    int character_count=0;
    int word_count=0;
    
    getline(cin,data);
    
    char str[2000000];
    
    strcpy(str,data.c_str());
    
    for(int i=0;i<strlen(str);i++){
        if(str[i] == ' '){
            if(character_count>0){
                //이전 단어 존재
                word_count++;
                character_count=0;
            }
            else{
                //단어 없었어
            }
            blank_count++;
        }
        else{
            if(i==(strlen(str)-1))
                word_count++;
            
            character_count++;
        }
    }
    cout<<word_count<<endl;
    
    return 0;
}
