//
//  main.cpp
//  Data Structure
//
//  Created by 허재영 on 2017. 6. 30..
//  Copyright © 2017년 허재영. All rights reserved.
//

#include <iostream>
#include "stack.hpp"
#include "queue.hpp"

using namespace std;

void stack_routine();
void queue_routine();
void tree_routine();
void linked_list_routine();

int main(int argc, const char * argv[]) {
    
    int option = 0;
    
    while(1){
        cout<<"--------------------"<<endl;
        cout<<"원하는 데이터구조를 선택하세요"<<endl;
        cout<<"1. 스택"<<endl;
        cout<<"2. 큐"<<endl;
        cout<<"3. 트리"<<endl;
        cout<<"4. 링크드리스트"<<endl;
        cout<<"5. 종료"<<endl;
        cin>>option;
        
        switch(option){
            case 1:
                stack_routine();
                break;
            case 2:
                queue_routine();
                break;;
            case 3:
                tree_routine();
                break;;
            case 4:
                linked_list_routine();
                break;
            case 5:
                return 0;
            default :
                break;
        }
    }

    return 0;
}


void stack_routine(){
    
    int option = 0;
    int capacity = 0;
    
    cout<<"스택의 크기를 정하세요"<<endl;
    cin>>capacity;
    
    Stack<int> stack(capacity);
    
    while(1){
        cout<<"--------------------"<<endl;
        cout<<"원하는 작업을 선택하세요"<<endl;
        cout<<"1. PUSH"<<endl;
        cout<<"2. POP"<<endl;
        cout<<"3. PRINT"<<endl;
        cout<<"4. 종료"<<endl;
        cin>>option;
        
        switch(option){
            case 1:
                stack.push();
                break;
            case 2:
                stack.pop();
                break;
            case 3:
                stack.print_stack();
                break;
            case 4:
                return;
            default :
                break;
        }
    }
    return;
}


void queue_routine(){
    int option = 0;
    int capacity = 0;
    
    cout<<"큐의 크기를 정하세요"<<endl;
    cin>>capacity;
    
    Queue<int> queue(capacity);
    
    while(1){
        cout<<"--------------------"<<endl;
        cout<<"원하는 작업을 선택하세요"<<endl;
        cout<<"1. PUT"<<endl;
        cout<<"2. GET"<<endl;
        cout<<"3. PRINT"<<endl;
        cout<<"4. 종료"<<endl;
        cin>>option;
        
        switch(option){
            case 1:
                queue.put();
                break;
            case 2:
                queue.get();
                break;
            case 3:
                queue.print_queue();
                break;
            case 4:
                return;
            default :
                break;
        }
    }
    return;

}
void tree_routine(){
    return;
}
void linked_list_routine(){
    return;
}
