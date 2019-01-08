# python3

def AdvFibonacci(n):
    fib = [None]*(n+1)
    fib[0] = 0
    fib[1] = 1
    
    for i in range(2,n+1):
        fib[int(i)] = (fib[i-1] + fib[i-2]) % 10
        
    return fib[n]

if __name__ == '__main__':
    n = int(input())
    print(AdvFibonacci(n))