//
//  queue.hpp
//  DataStructure
//
//  Created by 허재영 on 2017. 7. 2..
//  Copyright © 2017년 허재영. All rights reserved.
//

#ifndef queue_hpp
#define queue_hpp

#include <stdio.h>

template <class T>
class Queue{
private:
    T *queue;
    int capacity; // 큐의 크기
    int front; 
    int rear;
public:
    Queue(int capacity);
    ~Queue();
    
    void put();
    void get();
    void print_queue();
};

#endif /* queue_hpp */
