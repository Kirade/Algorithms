//
//  linked_list.cpp
//  DataStructure
//
//  Created by 허재영 on 2017. 7. 5..
//  Copyright © 2017년 허재영. All rights reserved.
//

#include "linked_list.hpp"
#include <iostream>

using namespace std;

template <class T>
Node<T>::Node(){
    data = 0;
    next = nullptr;
}

template <class T>
Node<T>::~Node(){
    
}

template <class T>
void Node<T>::setData(T putData){
    data = putData;
}

template <class T>
void Node<T>::setNext(Node* addr){
    next = addr;
}

template <class T>
T Node<T>::getData(){
    return data;
}

template <class T>
Node<T>* Node<T>::getNext(){
    return next;
}

template <class T>
LinkedList<T>::LinkedList(T initialData){
    first->setData(initialData);
    numberOfList = 1;
}

template <class T>
LinkedList<T>::~LinkedList(){
    
}

template <class T>
void LinkedList<T>::add_list(){
    T data;
    Node<T> *newNode = new Node<T>;
    Node<T> *tempNode = new Node<T>;
    
    cout<<"추가할 데이터를 입력하세요 : ";
    cin>>data;

    newNode->setData(data);
    newNode->setNext(nullptr);
    tempNode = first;
    
    while(tempNode->getNext() != nullptr){
        tempNode = tempNode->getNext();
    }

    tempNode->setNext(newNode);
    numberOfList++;
}

template <class T>
void LinkedList<T>::delete_list(){
    int deleteIndex;
    Node<T> *deleteNode = new Node<T>;
    Node<T> *prevNode = new Node<T>;
    
    cout<<"삭제할 인덱스 번호를 입력하세요 : ";
    cin>>deleteIndex;
    
    deleteNode = first;
    
    if(deleteIndex<numberOfList){
        if(deleteIndex == 0){
            first = deleteNode->getNext();
            numberOfList--;
        }
        else{
            for(int i=0; i<deleteIndex;i++){
                prevNode = deleteNode;
                deleteNode = deleteNode->getNext();
            }
            prevNode->setNext(deleteNode->getNext());
            numberOfList--;
        }
    }
    else{
        cout<<"범위를 벗어난 인덱스 입니다."<<endl;
    }
}

template <class T>
void LinkedList<T>::show_list(){
    Node<T> *tempNode = new Node<T>;
    tempNode = first;
    int count = 0;
    
    while(count<numberOfList){
        cout<<count++<<" : "<<tempNode->getData()<<endl;
        if(tempNode->getNext() == nullptr)
            break;
        tempNode = tempNode->getNext();
    }
}

template class LinkedList<int>;
template class LinkedList<char>;

