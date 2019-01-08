# python3
input()
tokens = input().split()
first = 0
second = 0
i = 0; j=0
while(i<len(tokens)):
    if int(tokens[i]) > int(tokens[first]):
        first = i
    i = i+1
   
if first == 0 and len(tokens) > 1:
    second = first + 1;
    
while(j<len(tokens)):
    if int(tokens[j]) > int(tokens[second]) and j != first:
        second = j
    j = j+1    

print(int(tokens[first])*int(tokens[second]))

