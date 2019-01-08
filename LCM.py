# python3

# import time

def NaiveLCM(a,b):
    m = 0
    for i in range(max(a,b), a*b+1):
        if((int(i)%a == 0) and (int(i)%b == 0)):
            m = i
            break
            
    return m

# def GCD(a,b):
#     if a == b:
#         return a
#     
#     if a > b:
#         return GCD(a - b, b)
#     else:
#         return GCD(a, b - a)

def AdvGCD(a, b):
    if(b == 0):
        return a;
    else:
        a = a%b
        if(a>b):
            return AdvGCD(a, b)
        else: 
            return AdvGCD(b, a)
    
def AdvLCM(a,b):
    mul = a*b
    ans = mul//AdvGCD(a, b)
    
    return ans

if __name__ == '__main__':
    tokens = input().split()
    a = int(tokens[0])
    b = int(tokens[1])
#     start = time.time()
#     print(NaiveLCM(a, b))
#     print(time.time() - start)
#     start = time.time()
    print(int(AdvLCM(a, b)))
#     print(time.time() - start)
    