//
//  main.c
//  BJ_1002
//
//  Created by 허재영 on 2016. 9. 11..
//  Copyright © 2016년 허재영. All rights reserved.
//

#include <stdio.h>
#include <math.h>

int main(int argc, const char * argv[]) {
    
    FILE *fp;
    int count = 0,i =0 ;
    int x1, y1, x2,y2,r1,r2;
    int c_dist = 0;
    int r_dist = 0;
    
    fp = fopen("/Users/Jay/Desktop/Source/Algorithms/BJ_1002/input.txt","r");
    
    fscanf(fp,"%d\n",&count);
    
    for(i=0;i<count;i++){
        
        fscanf(fp,"%d %d %d %d %d %d\n",&x1,&y1,&r1,&x2,&y2,&r2);
        c_dist = sqrt(pow((x2-x1),2) + pow((y2-y1),2));
        r_dist = r1 + r2;
        
        if(c_dist==0 && r1!=r2){
            printf("0\n");
            continue;
        }
        if(c_dist==0 && r1==r2){
            printf("-1\n");
            continue;
        }
        
        if(c_dist < r_dist){
            printf("2\n");
            continue;
        }
        else if(c_dist == r_dist){
            printf("1\n");
            continue;
        }
        else{
            continue;
        }
        
    }
    
    printf("End of program\n");
    return 0;
}
