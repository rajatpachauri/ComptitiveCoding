# python3

# import time

def NaiveFibonacci(n):
    if n<= 1:
        return n
    
    return NaiveFibonacci(n-1) + NaiveFibonacci(n-2)

def AdvFibonacci(n):
    fib = [None]*(n+1)
    if n<=1:
        return n;
    
    fib[0] = 0
    fib[1] = 1
    
    for i in range(2,n+1):
        fib[int(i)] = fib[i-1] + fib[i-2]
        
    return fib[n]

if __name__ == '__main__':
    n = int(input())
#     start = time.time()
#     print(NaiveFibonacci(n))
#     print(time.time() - start)
#     start = time.time()
    print(AdvFibonacci(n))
#     print(time.time() - start)
#     for i in range(1,40):
#         if(NaiveFibonacci(int(i)) != AdvFibonacci(int(i))):
#             print("Wrong Answer")
#         else:
#             print("Ok")