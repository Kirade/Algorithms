//
//  stack.hpp
//  Data Structure
//
//  Created by 허재영 on 2017. 7. 2..
//  Copyright © 2017년 허재영. All rights reserved.
//

#ifndef stack_hpp
#define stack_hpp

#include <stdio.h>

template <class T>
class Stack{
private:
    //const int EMPTY = 0;
    T *stack;
    int capacity; // 스택의 크기
    int number_of_data; // 현재 스택의 데이터 개수
    
public:
    Stack(int capacity);
    ~Stack();
    
    void pop();
    void push();
    void print_stack();
};

#endif /* stack_hpp */
