n,m = list(map(int, input().rstrip().split()))
arr = [0]*n
for _ in range(m):
        a,b,c = list(map(int, input().split()))
        a = a-1
        b = b-1
        arr[a] = c +arr[a]
        if b+1<n:
                arr[b+1] = -c +arr[b+1]
#     for i in range(a-1,b):
#         arr[i] = arr[i]+c

max = 0
for _ in range(1,n):
        arr[_] = arr[_] + arr[_-1]
        if arr[_] > max:
                max = arr[_]

print(max)