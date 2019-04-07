N, q = list(map(int, input().rstrip().split()))
seqList = [[] for _ in range(N)]
lastAnswer = 0
seq = []
while q>0:
    seq.append(list(map(int, input().rstrip().split())))
    q = q-1

for i in seq:
    if i[0] == 1:
        x = i[1]
        y = i[2]
        seqList[(x ^ lastAnswer)%N].append(y)
    
    elif i[0] == 2:
        x = i[1]
        y = i[2]
        lastAnswer = seqList[(x ^ lastAnswer)%N][y%len(seqList[(x ^ lastAnswer)%N])]
        print(lastAnswer)