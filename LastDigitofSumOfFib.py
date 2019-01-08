# Uses python3

def AdvFibonacci(n):
    fib = [None]*(n+1)
    fib[0] = 0
    fib[1] = 1
    
    for i in range(2,n+1):
        fib[int(i)] = fib[i-1] + fib[i-2]
        
    return fib[n]


def get_fibonacci_huge_naive(m):
    
    li = []
    li.append(0)
    li.append(1)
#     for _ in range(n - 1):
#         previous, current = current, previous + current
    found = False
    i = 2
    while(found != True):
        if (AdvFibonacci(i)%m == 0 and AdvFibonacci(i+1)%m == 1):
            found = True
            i = i-1 
            
        else:
            li.append(AdvFibonacci(i)%m) 
        i = i+1
        
    return li

if __name__ == '__main__':
    li = get_fibonacci_huge_naive(10)
    n = int(input())
    sum1 = 0
#     print(len(li))
    for i in range(0,n%len(li)+1):
        sum1 = sum1+li[i]
    
#     print(sum1)
    
    print((int(n/len(li))*sum(li) + sum1)%10)
#     for i in range(1,50):
#         print(AdvFibonacci(i), AdvFibonacci(i)%1000)
