//
//  queue.cpp
//  DataStructure
//
//  Created by 허재영 on 2017. 7. 2..
//  Copyright © 2017년 허재영. All rights reserved.
//

#include "queue.hpp"
#include <iostream>

using namespace std;

template <class T>
Queue<T>::Queue(int capacity_input){
    capacity = capacity_input;
    queue = new T[capacity];
    front = 0;
    rear = 0;
}

template <class T>
Queue<T>::~Queue(){
    delete [] queue;
}

template <class T>
void Queue<T>::put(){
    T data;
    
    cout<<"데이터를 입력하세요 : ";
    cin>>data;
    
    if(rear<capacity){
        queue[rear++] = data;
    }
    else{
        cout<<"Queue is Full!"<<endl;
    }
}

template <class T>
void Queue<T>::get(){
    T data;
    
    if(front!=rear){
        data = queue[front];
        for(int i=0;i<rear-1;i++){
            queue[i] = queue[i+1];
        }
        rear--;
    }
    else{
        cout<<"Queue is Empty!"<<endl;
    }
}

template <class T>
void Queue<T>::print_queue(){
    for(int i=0;i<rear;i++){
        cout<<i<<" : "<<queue[i]<<endl;
    }
}

template <class T>
Circular_Queue<T>::Circular_Queue(int input_capacity){
    capacity = input_capacity;
    circular_queue = new T[capacity];
    front = 0;
    rear = 0;
    numberOfData = 0;
}

template <class T>
Circular_Queue<T>::~Circular_Queue(){
    delete [] circular_queue;
}

template <class T>
void Circular_Queue<T>::put(){
    T data;
    cout<<"데이터를 입력하세요 : ";
    cin>>data;
    
    front %= capacity;
    
    if(front != rear){
        circular_queue[front++] = data;
        numberOfData++;
    }
    else if(front == rear && numberOfData == 0){
        circular_queue[front++] = data;
        numberOfData++;
    }
    else{
        checkEmptyOrFull();
    }
}

template <class T>
void Circular_Queue<T>::get(){
    T data;
    
    rear %= capacity;
    
    if(front != rear){
        data = circular_queue[rear++];
        cout<<"get : "<<data<<endl;
        numberOfData--;
    }
    else if(front == rear && numberOfData == capacity){
        data = circular_queue[rear++];
        cout<<"get : "<<data<<endl;
        numberOfData--;
    }
    else{
        checkEmptyOrFull();
    }
}

template <class T>
void Circular_Queue<T>::checkEmptyOrFull(){
    if(numberOfData == capacity){
        cout<<"Queue is Full"<<endl;
        return;
    }
    else{
        cout<<"Queue is Empty!"<<endl;
        cout<<front<<" "<<rear<<" "<<numberOfData<<" "<<capacity<<endl;
        return;
    }
}

template <class T>
void Circular_Queue<T>::print_queue(){
    for(int i=0;i<capacity;i++){
        cout<<i<<" : "<<circular_queue[i]<<endl;
    }
}

template class Queue<int>;
template class Queue<char>;
template class Circular_Queue<int>;
template class Circular_Queue<char>;
