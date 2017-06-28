#include <stdio.h>

int z_count=0;
int o_count=0;

int main()
{
    int count;
    int i;
    int test;
    
    scanf("%d",&count);
    
    for(i=0;i<count;i++)
    {
        scanf("%d",&test);
        fibonacci(test);
        printf("%d %d\n",z_count, o_count);
        z_count = 0;
        o_count = 0;
    }
    return 0;
}

int fibonacci(int n) {
    if (n==0) {
        z_count++;
        return 0;
    } else if (n==1) {
        o_count++;
        return 1;
    } else {
        int a = n-1;
        int b = n-2;
        return (fibonacci(a) + fibonacci(b));
    }
}
