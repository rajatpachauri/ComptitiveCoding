# Uses python3

def AdvFibonacci(n):
    fib = [None]*(n+1)
    fib[0] = 0
    fib[1] = 1
    
    for i in range(2,n+1):
        fib[int(i)] = fib[i-1] + fib[i-2]
        
    return fib[n]


def get_fibonacci_huge_naive(n, m):
    
    li = []
    li.append(0)
    li.append(1)
#     for _ in range(n - 1):
#         previous, current = current, previous + current
    found = False
    i = 2
    while(found != True and i<=n):
        if (AdvFibonacci(i)%m == 0 and AdvFibonacci(i+1)%m == 1):
            found = True
            i = i-1 
            
        else:
            li.append(AdvFibonacci(i)%m) 
        i = i+1
        
    return li[n%i]

if __name__ == '__main__':
    tokens = input();
    n, m = map(int, tokens.split())
    print(get_fibonacci_huge_naive(n, m))
# 
#     for i in range(1,50):
#         print(AdvFibonacci(i), AdvFibonacci(i)%1000)
