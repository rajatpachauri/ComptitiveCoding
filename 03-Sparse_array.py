n = int(input())
string = []
for i in range(n):
    string.append(input())

q = int(input())
query_str = []
for i in range(q):
    query_str.append(input())

for i in query_str:
    count = 0
    for j in string:
        if i == j:
            count = count + 1 
        
    print(count)

# import collections

# values = collections.defaultdict(int)
# for _ in range(int(input())):
#     values[input()] += 1
# for _ in range(int(input())):
#     print(values[input()])

# from collections import Counter, defaultdict

# cnt = Counter([input().strip() for _ in range(int(input().strip()))]) 

# for _ in range(int(input().strip())):
#     print(cnt[input().strip()])