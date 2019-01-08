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
    tokens = input().split()
    m,n = map(int, tokens)
    sum1 = 0
    for i in range(0,n%len(li)+1):
        sum1 = sum1+li[i]
    
#     print(sum1)

    n1 = int(int(n/len(li))*sum(li) + sum1)
#     print(n1)
    sum2 = 0
    for i in range(0,m%len(li)):
        sum2 = sum2+li[i]
    
#     print(sum2)
    m1 = int(int(m/len(li))*sum(li) + sum2)
#     print(m1)
    print((n1 - m1)%10)
#     for i in range(1,50):
#         print(AdvFibonacci(i), AdvFibonacci(i)%1000)
