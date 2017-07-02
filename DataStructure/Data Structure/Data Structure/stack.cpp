//
//  stack.cpp
//  Data Structure
//
//  Created by 허재영 on 2017. 7. 1..
//  Copyright © 2017년 허재영. All rights reserved.
//

#include <stdio.h>
#include <iostream>

using namespace std;

template <class T>
class MyStack{
private:
    const int EMPTY = 0;
    T *stack;
    int capacity; // 스택의 크기
    int number_of_data; // 현재 스택의 데이터 개수
    
public:
    MyStack(int capacity){
        cout<<"생성자 실행"<<endl;
        stack = new T[capacity];
        number_of_data = 0;
    }
    ~MyStack(){
        cout<<"소멸자 실행"<<endl;
        delete [] stack;
    }
    
    void pop(){
        if(number_of_data!=EMPTY){
             cout<<"pop : "<<stack[--number_of_data]<<endl;
        }
        else{
            cout<<"Stack is empty!"<<endl;
        }
    }
    
    void push(){
        T data;
        
        cout<<"데이터를 입력하세요 : ";
        cin>>data;
        
        if(number_of_data!=capacity){
            stack[number_of_data] = data;
            cout<<"push : "<<stack[number_of_data++]<<endl;
        }
        else{
            cout<<"Stack is full"<<endl;
        }
    }
    
    void print_stack(){
        for(int i=0;i<number_of_data;i++){
            cout<<i<<" : "<<stack[i]<<endl;
        }
    }
};

