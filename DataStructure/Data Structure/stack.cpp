//
//  stack.cpp
//  Data Structure
//
//  Created by 허재영 on 2017. 7. 2..
//  Copyright © 2017년 허재영. All rights reserved.
//

#include "stack.hpp"
#include <iostream>

using namespace std;

template<class T>
void MyStack<T>::somefunction(){
    cout<<"do something"<<endl;
    return;
}

template<class T>
MyStack<T>::MyStack(int capacity){
    stack = new T[capacity];
    number_of_data = 0;
}

template<class T>
MyStack<T>::~MyStack(){
    delete[] stack;
}

template<class T>
void MyStack<T>::pop(){
    if(number_of_data!=0){
        cout<<"pop : "<<stack[--number_of_data]<<endl;
    }
    else{
        cout<<"Stack is empty!"<<endl;
    }
}

template<class T>
void MyStack<T>::push(){
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

template<class T>
void MyStack<T>::print_stack(){
    for(int i=0;i<number_of_data;i++){
        cout<<i<<" : "<<stack[i]<<endl;
    }
}

