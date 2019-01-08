# python3

# import time

def NaiveGCD(a,b):
    max = 1
    for i in range(1,min(a,b)+1):
        if((a%int(i) == 0) and (b%int(i) == 0)):
            max = i;
    
    return max;

def AdvGCD(a, b):
    if(b == 0):
        return a;
    else:
        a = a%b
        if(a>b):
            return AdvGCD(a, b)
        else: 
            return AdvGCD(b, a)

if __name__ == '__main__':
    tokens = input()
    a,b = map(int, tokens.split())
#     start = time.time()
#     print(NaiveGCD(a,b))
#     print(time.time() - start)
#     start = time.time()
    if a > b:
        print(AdvGCD(a, b))
    else:
        print(AdvGCD(b, a))
#     print(time.time() - start)
#     
#     for i in range(2,100):
#         for j in range(102, 200):
#             if(NaiveGCD(i, j) == AdvGCD(i, j)):
#                 print("Ok")
#             else:
#                 print("Wrong Answer")