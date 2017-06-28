//
//  main.c
//  BJ_1004
//
//  Created by 허재영 on 2017. 6. 28..
//  Copyright © 2017년 허재영. All rights reserved.
//

#include <stdio.h>
#include <math.h>

void little_prince();

int main(int argc, const char * argv[]) {
    
    int count = 0; // 테스트 케이스 개수
    
    scanf("%d",&count);
    
    while(count>0){
        little_prince();
        count--;
    }
    
    return 0;
}

void little_prince(){
    
    int x1,y1,x2,y2;
    int number_of_circle;
    int cx, cy, r;
    int result = 0;
    
    // 시작, 끝 좌표 입력
    scanf("%d %d %d %d",&x1,&y1,&x2,&y2);
    
    // 행성계의 개수 입력
    scanf("%d",&number_of_circle);
    
    while(number_of_circle>0){
        
        double s_dist = 0.0;
        double d_dist = 0.0;
        
        // 행성계 각각의 좌표 입력
        scanf("%d %d %d",&cx,&cy,&r);
        
        // 시작점, 끝점까지의 거리 계산
        s_dist = (double)sqrt(pow(x1-cx,2)+pow(y1-cy,2));
        d_dist = (double)sqrt(pow(x2-cx,2)+pow(y2-cy,2));
        
       // printf("%f %f\n",s_dist,d_dist);
        
        //출발점과 도착점이 해당 원 안에 존재한다.
        if(s_dist<r && d_dist<r){
            // 경계선 지날 필요 없음 +0
        }
        
        //출발점과 도착점이 해당 원 밖에 존재한다.
        if(s_dist>r && d_dist>r){
            // 경계선 지날 필요 없음 +0
        }
        
        
        // 출발점이 안쪽, 도착점이 바깥쪽
        if(s_dist<r && d_dist>r){
            //카운트 증가
            result++;

        }
        
        // 출발점이 바깥쪽, 도착점이 안쪽
        if(s_dist>r && d_dist<r){
            //카운트 증가
            result++;
        }
        
        // 카운트 조절
        number_of_circle--;
    }
    
    // 진입하는 행성계의 개수 출력
    printf("%d\n",result);
    
    return;
}

/*
풀이 방법
 - 출발지 좌표와, 도착지 좌표의 위치가 원의 둘레 안에 포함되어 있는지 여부를 체크하면 된다. 
 - 만약에 포함되어 있다면 포함되어 있는 원의 갯수만큼 정답의 카운트가 올라간다.

 : 위에 풀이는 부족한 풀이, 원 안에 두 점 모두가 있는 경우와 같은 생각을 해봐야함
 - 해결방법으로 한 원에 대해서 검증할 때에, 두 시작점과 끝점이 동일한 원에 있는지 여부를 체크한다.
 - 같은 원이라면 +0, 다른원이라면 +1,
*/
