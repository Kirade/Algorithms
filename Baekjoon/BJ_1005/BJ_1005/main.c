//
//  main.c
//  BJ_1005
//
//  Created by 허재영 on 2017. 6. 28..
//  Copyright © 2017년 허재영. All rights reserved.
//

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void acm_craft();

int main(int argc, const char * argv[]) {
    
    int test_case = 0;
    
    scanf("%d",&test_case);
    
    for(int i=0;i<test_case;i++){
        acm_craft();
    }
    
    return 0;
}

void acm_craft(){
    
    int number_of_buildings = 0;
    int number_of_rules = 0;
    int *build_duration;
    
    // 건물 개수, 건물 건설 규칙 개수 입력
    scanf("%d %d",&number_of_buildings, &number_of_rules);
    
    build_duration = (int*)malloc(sizeof(int)*number_of_buildings);
    
    // 시간 입력
    for(int i=0; i<=number_of_buildings; i++)
        scanf("%d",&build_duration[i]);
    
    
    return;
}
