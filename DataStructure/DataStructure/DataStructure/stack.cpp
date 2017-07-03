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
Stack<T>::Stack(int capacity){
    stack = new T[capacity];
    number_of_data = 0;
}

template<class T>
Stack<T>::~Stack(){
    delete[] stack;
}

template<class T>
void Stack<T>::pop(){
    if(number_of_data!=0){
        cout<<"pop : "<<stack[--number_of_data]<<endl;
    }
    else{
        cout<<"Stack is empty!"<<endl;
    }
}

template<class T>
void Stack<T>::push(){
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
void Stack<T>::print_stack(){
    for(int i=0;i<number_of_data;i++){
        cout<<i<<" : "<<stack[i]<<endl;
    }
}

template class Stack<char>;
template class Stack<int>;

// stackoverflow.com/a/312402/700926
// 템플릿 클래스를 사용하는 경우, 헤더파일에서 선언 후 , cpp 파일에서 정의 하는 경우 템플릿 클래스에 어떤
// 형태의 자료가 들어갈 지 모르기 때문에, 가능한 자료형들을 미리 정의해 두어야 한다.
// 여기에서는 char, int 정의해 두었다.
// 이렇게 해두지 않으면 링커 에러 발생

