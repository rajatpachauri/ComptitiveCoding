if __name__ == '__main__':
    bnn = input().split()
    money = int(bnn[0])
    keyboard = list(map(int, input().strip().split()))
    usb = list(map(int, input().strip().split()))

    keyboard = sorted(keyboard, reverse = True)
    usb = (sorted(usb))

    max = -1;
    for i in keyboard:
        for j in usb:
            if(i+j > money): 
                break
            if(i+j > max):
                max = i+j

    print(max)