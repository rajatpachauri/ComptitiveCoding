#python3

import operator

if __name__ == '__main__':
    tokens = input()
    num, max1 = map(int, tokens.split())
    v  = []
    w = []
    while num>0:
        token = input().split()
        v.append(int(token[0]))
        w.append(int(token[1]))
        num = num-1
        
    pperw = list(map(lambda x,y:x/y, v,w))
    profit = 0
#     print(pperw)
    while(max1>0):
        n1 = max(pperw)
        ind = pperw.index(n1)
        if((max1-w[ind])>=0):
            profit = profit+v[ind]
            max1 = max1-w[ind]
        else:
            profit = profit+pperw[ind]*max1
            break
        pperw.remove(n1)
        
    print('%.4f'%(profit))
    