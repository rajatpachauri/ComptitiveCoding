
if __name__ == '__main__':
    li = [10,5,1]
    n = int(input())
    sum = 0
    for i in li:
        sum = sum + n//i
        n = n%i
    
    print(sum)    