//
//  linked_list.hpp
//  DataStructure
//
//  Created by 허재영 on 2017. 7. 5..
//  Copyright © 2017년 허재영. All rights reserved.
//

#ifndef linked_list_hpp
#define linked_list_hpp

#include <stdio.h>

template <class T>
class Node{
private:
    T data;
    Node* next;
public:
    Node();
    ~Node();
    
    void setNext(Node* addr);
    void setData(T putData);
    T getData();
    Node* getNext();
};

template <class T>
class LinkedList{
private:
    Node<T> *first = new Node<T>;
    int numberOfList;
public:
    LinkedList(T initialData);
    ~LinkedList();
    
    void add_list();
    void delete_list();
    void show_list();
};

#endif /* linked_list_hpp */
